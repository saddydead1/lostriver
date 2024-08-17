package su.sonoma.lostriver

import com.mojang.logging.LogUtils
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.RenderType
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
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
import su.sonoma.lostriver.biome.feature.ModFeature
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


        ModFeature.FEATURES!!.register(modEventBus)
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

        CustomPortalBuilder.beginPortal()
            .frameBlock(ModBlocks.PORTAL.get())
            .destDimID(ResourceLocation("lostriver:b4546"))
            .tintColor(0, 66, 184)
            .registerPortal()

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
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.BLOOD_GRASS.get(),
                RenderType.cutout()
            )
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.BLOOD_MOSS.get(),
                RenderType.cutout()
            )
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.DOUBLEKELP.get(),
                RenderType.cutout()
            )
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.VEINED.get(),
                RenderType.cutout()
            )
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.PAPYRUS.get(),
                RenderType.cutout()
            )
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.BLUEPALM.get(),
                RenderType.cutout()
            )
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.BASKET.get(),
                RenderType.cutout()
            )
            ItemBlockRenderTypes.setRenderLayer(
                ModBlocks.YELLOWGRASS.get(),
                RenderType.cutout()
            )
        }
    }

    val EXAMPLE_TAB: RegistryObject<CreativeModeTab> = CREATIVE_MODE_TABS.register("tab") {
        CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon { ModItems.PEEPER.get().defaultInstance }
            .title(Component.translatable(MODID + ".subtab"))
            .displayItems { parameters: ItemDisplayParameters?, output: CreativeModeTab.Output ->
                output.accept(ModItems.PORTAL.get())
               output.accept(ModItems.PEEPER.get())
                output.accept(ModItems.COOKED_PEEPER.get())
                output.accept(ModItems.BOOMERANG.get())
                output.accept(ModItems.COOKED_BOOMERANG.get())
                output.accept(ModItems.BLADDER.get())
                output.accept(ModItems.COOKED_BLADDERFISH.get())
                output.accept(ModItems.WATER.get())
                output.accept(ModItems.KNIFE.get())
                output.accept(ModItems.TOOTH.get())
                output.accept(ModItems.SILICONE.get())
                output.accept(ModItems.WIRINGKIT.get())
                output.accept(ModItems.FIBERMESH.get())
                output.accept(ModItems.BATTERY.get())
                output.accept(ModItems.POWERCELL.get())
                output.accept(ModItems.LUBRICANT.get())
                output.accept(ModItems.TITAN.get())
                output.accept(ModItems.COPPER.get())
                output.accept(ModItems.LEAD.get())
                output.accept(ModItems.GOLD.get())
                output.accept(ModItems.SILVER.get())
                output.accept(ModItems.QUARTZ.get())
                output.accept(ModItems.TITANINGOT.get())
                output.accept(ModItems.EMALEDGLASS.get())
                output.accept(ModItems.LIMESTONE.get())
                output.accept(ModItems.SANDSTONE.get())
                output.accept(ModItems.CORAL.get())
                output.accept(ModItems.MUSHROOM.get())
                output.accept(ModItems.MUSHROOMSTEW.get())
                output.accept(ModItems.SAND.get())
                output.accept(ModItems.PURPLEBLOCK.get())
                output.accept(ModItems.ROYALBLOCK.get())
                output.accept(ModItems.KELP_SAND.get())
                output.accept(ModItems.BLOOD_SAND.get())
                output.accept(ModItems.ACIDMUSHROOM.get())
                output.accept(ModItems.DOUBLEKELP.get())
                output.accept(ModItems.BLUEPALM.get())
                output.accept(ModItems.YELLOWGRASS.get())
                output.accept(ModItems.BASKET.get())
                output.accept(ModItems.PAPYRUS.get())
                output.accept(ModItems.VEINED.get())
                output.accept(ModItems.SAFESHALLOWMOSS.get())
                output.accept(ModItems.ROYALMOSS.get())
                output.accept(ModItems.PURPLEMOSS.get())
                output.accept(ModItems.GREENCOVERMOSS.get())
                output.accept(ModItems.BLOOD_MOSS.get())
                output.accept(ModItems.BLOOD_GRASS.get())
                output.accept(ModItems.REAPER_FRAGMENT.get())
                output.accept(ModItems.REAPER_HELMET.get())
                output.accept(ModItems.REBREATHER.get())
                output.accept(ModItems.FINS.get())
                output.accept(ModItems.OXYGENTANK.get())
                output.accept(ModItems.HIGHOXYGENTANK.get())
                output.accept(ModItems.SEAMOTHFRAGMENT.get())
                output.accept(ModItems.SEAMOTHBLUEPRINT.get())
                output.accept(ModItems.SEAMOTH.get())
            }.build()
    }

}
