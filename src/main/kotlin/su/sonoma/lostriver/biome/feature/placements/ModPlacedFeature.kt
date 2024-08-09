package su.sonoma.lostriver.biome.feature.placements

import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.*
import su.sonoma.lostriver.Lostriver.MODID


object ModPlacedFeature {
    val BLOOD_GRASS: ResourceKey<PlacedFeature> = registerKey("blood_grass_place")
    val BLOOD_MOSS: ResourceKey<PlacedFeature> = registerKey("blood_moss_place")
    val DOUBLEKELP: ResourceKey<PlacedFeature> = registerKey("double_kelp_place")

    private fun seagrassPlacement(p_195234_: Int): List<PlacementModifier> {
        return java.util.List.of(
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_TOP_SOLID,
            CountPlacement.of(p_195234_),
            BiomeFilter.biome()
        )
    }

    fun bootstrap(p: BootstapContext<PlacedFeature>) {
        val holdergetter = p.lookup(Registries.CONFIGURED_FEATURE)
        val reference = holdergetter.getOrThrow(ModFeatureConfigured.BLOOD_GRASS)
        val reference1 = holdergetter.getOrThrow(ModFeatureConfigured.BLOOD_MOSS)
        val reference2 = holdergetter.getOrThrow(ModFeatureConfigured.DOUBLEKELP)
        register(p, BLOOD_GRASS, reference, seagrassPlacement(80))
        register(p, BLOOD_MOSS, reference1, seagrassPlacement(80))
        register(p, DOUBLEKELP, reference2, seagrassPlacement(20))

    }

    private fun registerKey(name: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation(MODID, name))
    }

    private fun register(
        context: BootstapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        configuration: Holder<ConfiguredFeature<*, *>>,
        modifiers: List<PlacementModifier>,
    ) {
        context.register(key, PlacedFeature(configuration, java.util.List.copyOf(modifiers)))
    }

}