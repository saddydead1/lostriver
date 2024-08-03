package su.sonoma.subcraftica

import com.mojang.logging.LogUtils
import net.minecraft.client.Minecraft
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import org.slf4j.Logger
import su.sonoma.subcraftica.entity.ModEntity
import su.sonoma.subcraftica.event.Sounds
import su.sonoma.subcraftica.item.ModItems
import thedarkcolour.kotlinforforge.forge.MOD_BUS as modEventBus

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Subcraftica.MODID)
object Subcraftica {
    const val MODID: String = "subcraftica"

    val LOGGER: Logger = LogUtils.getLogger()

    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)

    init {
        modEventBus.addListener { event: FMLCommonSetupEvent -> this.commonSetup(event) }

        ModItems.ITEMS.register(modEventBus)
        Sounds.SOUNDS.register(modEventBus)
        ModEntity.ENTITY_TYPES.register(modEventBus)

        CREATIVE_MODE_TABS.register(modEventBus)

        MinecraftForge.EVENT_BUS.register(this)


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP")
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT))

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT))

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber)

        Config.items.forEach { item: Item -> LOGGER.info("ITEM >> {}", item.toString()) }
    }


    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent?) {
        LOGGER.info("HELLO from server starting")
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
    object ClientModEvents {
        @SubscribeEvent
        fun onClientSetup(event: FMLClientSetupEvent?) {
            LOGGER.info("HELLO FROM CLIENT SETUP")
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().user.name)
        }
    }

    val EXAMPLE_TAB: RegistryObject<CreativeModeTab> = CREATIVE_MODE_TABS.register("example_tab") {
        CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon { ModItems.PEEPER.get().defaultInstance }
            .title(Component.translatable(MODID + ".subtab"))
            .displayItems { parameters: ItemDisplayParameters?, output: CreativeModeTab.Output ->
               output.accept(ModItems.PEEPER.get())
            }.build()
    }

}
