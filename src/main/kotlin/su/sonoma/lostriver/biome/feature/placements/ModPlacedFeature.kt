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
    val BLOODSAND: ResourceKey<PlacedFeature> = registerKey("blood_sand_place")
    val KELPSAND: ResourceKey<PlacedFeature> = registerKey("kelp_sand_place")
    val ACIDMUSHROOM: ResourceKey<PlacedFeature> = registerKey("acidmushroom_place")

    val SAFESHALLOWMOSS: ResourceKey<PlacedFeature> = registerKey("safeshallowmoss_place")
    val PURPLEMOSS: ResourceKey<PlacedFeature> = registerKey("purplemoss_place")
    val ROYALMOSS: ResourceKey<PlacedFeature> = registerKey("royalmoss_place")
    val GREENCOVERMOSS: ResourceKey<PlacedFeature> = registerKey("greencovermoss_place")
    val VEINED: ResourceKey<PlacedFeature> = registerKey("veined_place")
    val BLUEPALM: ResourceKey<PlacedFeature> = registerKey("bluepalm_place")
    val YELLOWGRASS: ResourceKey<PlacedFeature> = registerKey("yellowgrass_place")

    val SAFESHALLOW: ResourceKey<PlacedFeature> = registerKey("ssafeshallow_place")
    val TABLECORAL: ResourceKey<PlacedFeature> = registerKey("tablecoral_place")
    val CORALTUBE: ResourceKey<PlacedFeature> = registerKey("coraltube_place")
    val BLOODSTOLB: ResourceKey<PlacedFeature> = registerKey("bloodstolb_place")

    val MUSHROOM: ResourceKey<PlacedFeature> = registerKey("mushroom_place")

    val LIMESTONE: ResourceKey<PlacedFeature> = registerKey("limestone")
    val SANDSTONE: ResourceKey<PlacedFeature> = registerKey("sandstone")
    val QUARTZ: ResourceKey<PlacedFeature> = registerKey("quartz")
    val LITHIUM: ResourceKey<PlacedFeature> = registerKey("lithium")

    val BLOOD_KELP: ResourceKey<PlacedFeature> = registerKey("blood_kelp")

    private fun placement(p_195234_: Int): List<PlacementModifier> {
        return java.util.List.of(
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_TOP_SOLID,
            CountPlacement.of(p_195234_),
            BiomeFilter.biome()
        )
    }

    private fun placementKelp(): List<PlacementModifier> {
        return java.util.List.of(
            NoiseBasedCountPlacement.of(80, 80.0, 0.0),
            InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP_TOP_SOLID,
            BiomeFilter.biome()
        )
    }

    fun bootstrap(p: BootstapContext<PlacedFeature>) {
        val holdergetter = p.lookup(Registries.CONFIGURED_FEATURE)

        val reference = holdergetter.getOrThrow(ModFeatureConfigured.BLOOD_GRASS)
        val reference1 = holdergetter.getOrThrow(ModFeatureConfigured.BLOOD_MOSS)
        val reference2 = holdergetter.getOrThrow(ModFeatureConfigured.DOUBLEKELP)
        val reference3 = holdergetter.getOrThrow(ModFeatureConfigured.BLOODSAND)
        val reference5 = holdergetter.getOrThrow(ModFeatureConfigured.KELPSAND)
        val reference8 = holdergetter.getOrThrow(ModFeatureConfigured.ACIDMUSHROOM)
        val reference9 = holdergetter.getOrThrow(ModFeatureConfigured.GREENCOVERMOSS)
        val reference10 = holdergetter.getOrThrow(ModFeatureConfigured.PURPLEMOSS)
        val reference11 = holdergetter.getOrThrow(ModFeatureConfigured.SAFESHALLOWMOSS)
        val reference12 = holdergetter.getOrThrow(ModFeatureConfigured.ROYALMOSS)
        val reference13 = holdergetter.getOrThrow(ModFeatureConfigured.VEINED)
        val reference18 = holdergetter.getOrThrow(ModFeatureConfigured.BLUEPALM)
        val reference19 = holdergetter.getOrThrow(ModFeatureConfigured.YELLOWGRASS)

        val reference14 = holdergetter.getOrThrow(ModFeatureConfigured.SAFESHALLOW)
        val reference15 = holdergetter.getOrThrow(ModFeatureConfigured.CORALTUBE)
        val reference21 = holdergetter.getOrThrow(ModFeatureConfigured.TABLECORAL)
        val reference16 = holdergetter.getOrThrow(ModFeatureConfigured.BLOODSTOLB)

        val reference4 = holdergetter.getOrThrow(ModFeatureConfigured.LIMESTONE)
        val reference6 = holdergetter.getOrThrow(ModFeatureConfigured.SANDSTONE)
        val reference7 = holdergetter.getOrThrow(ModFeatureConfigured.QUARTZ)
        val reference20 = holdergetter.getOrThrow(ModFeatureConfigured.LITHIUM)

        val reference22 = holdergetter.getOrThrow(ModFeatureConfigured.BLOOD_KELP)

        val reference17 = holdergetter.getOrThrow(ModFeatureConfigured.MUSHROOM)

        register(p, BLOOD_GRASS, reference, placement(80))
        register(p, BLOOD_MOSS, reference1, placement(80))
        register(p, BLOODSAND, reference3, placement(90))
        register(p, KELPSAND, reference5, placement(95))
        register(p, DOUBLEKELP, reference2, placement(20))
        register(p, ACIDMUSHROOM, reference8, placement(30))
        register(p, BLUEPALM, reference18, placement(90))
        register(p, YELLOWGRASS, reference19, placement(90))

        register(p, BLOOD_KELP, reference22, placementKelp())

        register(p, SAFESHALLOW, reference14, placement(90))
        register(p, TABLECORAL, reference21, placement(90))
        register(p, CORALTUBE, reference15, placement(20))
        register(p, BLOODSTOLB, reference16, placement(5))

        register(p, MUSHROOM, reference17, placement(1))

        register(p, GREENCOVERMOSS, reference9, placement(90))
        register(p, PURPLEMOSS, reference10, placement(90))
        register(p, VEINED, reference13, placement(90))
        register(p, ROYALMOSS, reference12, placement(90))
        register(p, SAFESHALLOWMOSS, reference11, placement(60))

        register(p, LIMESTONE, reference4, placement(80))
        register(p, SANDSTONE, reference6, placement(80))
        register(p, QUARTZ, reference7, placement(50))
        register(p, LITHIUM, reference20, placement(50))
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