package su.sonoma.lostriver

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
import su.sonoma.lostriver.block.ModBlocks
import su.sonoma.lostriver.entity.ModEntity
import su.sonoma.lostriver.event.Sounds
import su.sonoma.lostriver.item.ModItems
import thedarkcolour.kotlinforforge.forge.MOD_BUS as modEventBus

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Lostriver.MODID)
object Lostriver {
    const val MODID: String = "lostriver"

    val LOGGER: Logger = LogUtils.getLogger()

    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)

    init {
        modEventBus.addListener { event: FMLCommonSetupEvent -> this.commonSetup(event) }

        ModBlocks.BLOCKS.register(modEventBus)
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

    val EXAMPLE_TAB: RegistryObject<CreativeModeTab> = CREATIVE_MODE_TABS.register("tab") {
        CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon { ModItems.PEEPER.get().defaultInstance }
            .title(Component.translatable(MODID + ".subtab"))
            .displayItems { parameters: ItemDisplayParameters?, output: CreativeModeTab.Output ->
               output.accept(ModItems.PEEPER.get())
                output.accept(ModItems.BOOMERANG.get())
                output.accept(ModItems.KNIFE.get())
                output.accept(ModItems.SAND.get())
            }.build()
    }

}
