package su.sonoma.lostriver.biome.feature.placements

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.biome.feature.ModFeature
import su.sonoma.lostriver.block.ModBlocks


object ModFeatureConfigured {
    val BLOOD_GRASS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("blood_grass")
    val BLOODSAND: ResourceKey<ConfiguredFeature<*, *>> = registerKey("blood_sand")
    val KELPSAND: ResourceKey<ConfiguredFeature<*, *>> = registerKey("kelp_sand")
    val BLOOD_MOSS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("blood_moss")
    val BLOODKELP_MOSS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("bloodkelp_moss")
    val DOUBLEKELP: ResourceKey<ConfiguredFeature<*, *>> = registerKey("double_kelp")
    val ACIDMUSHROOM: ResourceKey<ConfiguredFeature<*, *>> = registerKey("acidmushroom")
    val PURPLEMOSS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("purplemoss")
    val GREENCOVERMOSS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("greencovermoss")
    val ROYALMOSS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("royalmoss")
    val SAFESHALLOWMOSS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("safeshallowmoss")
    val VEINED: ResourceKey<ConfiguredFeature<*, *>> = registerKey("veined")
    val BLUEPALM: ResourceKey<ConfiguredFeature<*, *>> = registerKey("bluepalm")
    val YELLOWGRASS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("yellowgrass")

    val SAFESHALLOW: ResourceKey<ConfiguredFeature<*, *>> = registerKey("ssafe_shallow")
    val TABLECORAL: ResourceKey<ConfiguredFeature<*, *>> = registerKey("table_coral")
    val CORALTUBE: ResourceKey<ConfiguredFeature<*, *>> = registerKey("coraltube")
    val BLOODSTOLB: ResourceKey<ConfiguredFeature<*, *>> = registerKey("bloodstolb")

    val MUSHROOM: ResourceKey<ConfiguredFeature<*, *>> = registerKey("mushroom")

    val LIMESTONE: ResourceKey<ConfiguredFeature<*, *>> = registerKey("limestone")
    val SANDSTONE: ResourceKey<ConfiguredFeature<*, *>> = registerKey("sandstone")
    val QUARTZ: ResourceKey<ConfiguredFeature<*, *>> = registerKey("quartz")
    val LITHIUM: ResourceKey<ConfiguredFeature<*, *>> = registerKey("lithium")

    val BLOOD_KELP: ResourceKey<ConfiguredFeature<*, *>> = registerKey("blood_kelp")

    fun bootstrap(p: BootstapContext<ConfiguredFeature<*, *>>) {
        register(
            p,
            BLOOD_GRASS,
            ModFeature.BLOOD_GRASS!!.get(),
            ProbabilityFeatureConfiguration(0.3f)
        )
        register(
            p,
            BLOOD_KELP,
            ModFeature.BLOOD_KELP!!.get(),
            null
        )
        register(
            p,
            YELLOWGRASS,
            ModFeature.YELLOWGRASS!!.get(),
            ProbabilityFeatureConfiguration(0.3f)
        )
        register(
            p,
            BLOOD_MOSS,
            ModFeature.BLOOD_MOSS!!.get(),
            ProbabilityFeatureConfiguration(0.3f)
        )
        register(
            p,
            BLOODKELP_MOSS,
            ModFeature.BLOODKELP_MOSS!!.get(),
            ProbabilityFeatureConfiguration(0.1f)
        )
        register(
            p,
            DOUBLEKELP,
            ModFeature.DOUBLEKELP!!.get(),
            ProbabilityFeatureConfiguration(0.2f)
        )
        register(
            p,
            MUSHROOM,
            ModFeature.MUSHROOM!!.get(),
            ProbabilityFeatureConfiguration(1f)
        )
        register(
            p,
            ACIDMUSHROOM,
            ModFeature.ACIDMUSHROOM!!.get(),
            ProbabilityFeatureConfiguration(0.1f)
        )
        register(
            p,
            BLOODSAND,
            ModFeature.BLOODSAND!!.get(),
            ProbabilityFeatureConfiguration(0.5f)
        )
        register(
            p,
            KELPSAND,
            ModFeature.KELPSAND!!.get(),
            ProbabilityFeatureConfiguration(0.9f)
        )
        register(
            p,
            SAFESHALLOW,
            ModFeature.SAFESHALLOW!!.get(),
            ProbabilityFeatureConfiguration(0.5f)
        )
        register(
            p,
            TABLECORAL,
            ModFeature.TABLECORAL!!.get(),
            ProbabilityFeatureConfiguration(0.5f)
        )
        register(
            p,
            CORALTUBE,
            ModFeature.CORALTUBE!!.get(),
            ProbabilityFeatureConfiguration(0.5f)
        )
        register(
            p,
            BLOODSTOLB,
            ModFeature.BLOODSTOLB!!.get(),
            ProbabilityFeatureConfiguration(0.1f)
        )
        register(
            p,
            LIMESTONE,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LIMESTONE.get()))
        )
        register(
            p,
            SANDSTONE,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SANDSTONE.get()))
        )
        register(
            p,
            LITHIUM,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LITHIUM.get()))
        )
        register(
            p,
            QUARTZ,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.QUARTZ.get()))
        )
        register(
            p,
            PURPLEMOSS,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PURPLEMOSS.get()))
        )
        register(
            p,
            ROYALMOSS,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ROYALMOSS.get()))
        )
        register(
            p,
            VEINED,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VEINED.get()))
        )
        register(
            p,
            BLUEPALM,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEPALM.get()))
        )
        register(
            p,
            GREENCOVERMOSS,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREENCOVERMOSS.get()))
        )
        register(
            p,
            SAFESHALLOWMOSS,
            ModFeature.SAFESHALLOWMOSS!!.get(),
            ProbabilityFeatureConfiguration(0.3f)
        )
    }

    fun registerKey(name: String?): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation(MODID, name)
        )
    }

    private fun <FC : FeatureConfiguration?, F : Feature<FC>?> register(
        context: BootstapContext<ConfiguredFeature<*, *>>,
        key: ResourceKey<ConfiguredFeature<*, *>>, feature: F, configuration: FC,
    ) {
        context.register(key, ConfiguredFeature(feature, configuration))
    }
}