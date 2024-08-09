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
    val DOUBLEKELP: ResourceKey<ConfiguredFeature<*, *>> = registerKey("double_kelp")
    val LIMESTONE: ResourceKey<ConfiguredFeature<*, *>> = registerKey("limestone")

    fun bootstrap(p: BootstapContext<ConfiguredFeature<*, *>>) {
        register(
            p,
            BLOOD_GRASS,
            ModFeature.BLOOD_GRASS!!.get(),
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
            DOUBLEKELP,
            ModFeature.DOUBLEKELP!!.get(),
            ProbabilityFeatureConfiguration(0.2f)
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
            ProbabilityFeatureConfiguration(0.5f)
        )
        register(
            p,
            LIMESTONE,
            Feature.SIMPLE_BLOCK,
            SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LIMESTONE.get()))
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