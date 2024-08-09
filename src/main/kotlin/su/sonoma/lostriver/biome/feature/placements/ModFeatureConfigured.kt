package su.sonoma.lostriver.biome.feature.placements

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.features.AquaticFeatures
import net.minecraft.data.worldgen.features.FeatureUtils
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.random.SimpleWeightedRandomList
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.SeagrassFeature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.biome.feature.ModFeature
import su.sonoma.lostriver.biome.feature.ModSeaGrassFeature
import su.sonoma.lostriver.block.ModBlocks


object ModFeatureConfigured {
    val BLOOD_GRASS: ResourceKey<ConfiguredFeature<*, *>> = registerKey("blood_grass")

    fun bootstrap(p: BootstapContext<ConfiguredFeature<*, *>>) {
//        register<SimpleBlockConfiguration, Feature<SimpleBlockConfiguration>>(
//            p, BLOOD_GRASS, Feature.SIMPLE_BLOCK, SimpleBlockConfiguration(
//                WeightedStateProvider(SimpleWeightedRandomList.builder<BlockState?>()
//                    .add(ModBlocks.BLOOD_GRASS.get().defaultBlockState(), 100000000)))
//        )
        register<ProbabilityFeatureConfiguration, ModSeaGrassFeature>(
            p,
            BLOOD_GRASS,
            ModFeature.BLOOD_GRASS!!.get(),
            ProbabilityFeatureConfiguration(0.3f)
        )
    }

    fun registerKey(name: String?): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create<ConfiguredFeature<*, *>>(
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