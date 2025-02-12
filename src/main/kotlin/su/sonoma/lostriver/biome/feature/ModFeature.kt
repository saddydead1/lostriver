package su.sonoma.lostriver.biome.feature

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import net.neoforged.neoforge.registries.DeferredRegister
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.biome.feature.custom.*
import java.util.function.Supplier


object ModFeature {
    val FEATURES: DeferredRegister<Feature<*>> = DeferredRegister.create(BuiltInRegistries.FEATURE, MODID)

    val BLOOD_GRASS: Supplier<BloodGrassFeature>? = register("blood_grass", BloodGrassFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOODSAND: Supplier<BloodSandFeature>? = register("blood_sand", BloodSandFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOODKELP_MOSS: Supplier<BloodKelpMossFeature>? = register("bloodkelp_moss", BloodKelpMossFeature(ProbabilityFeatureConfiguration.CODEC))
    val KELPSAND: Supplier<KelpSandFeature>? = register("kelp_sand", KelpSandFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOOD_MOSS: Supplier<BloodMossFeature>? = register("blood_moss", BloodMossFeature(ProbabilityFeatureConfiguration.CODEC))
    val DOUBLEKELP: Supplier<DoubleKelpFeature>? = register("double_kelp", DoubleKelpFeature(ProbabilityFeatureConfiguration.CODEC))
    val YELLOWGRASS: Supplier<YellowGrassFeature>? = register("yellowgrass", YellowGrassFeature(ProbabilityFeatureConfiguration.CODEC))
    val ACIDMUSHROOM: Supplier<AcidMushroomFeature>? = register("acidmushroom", AcidMushroomFeature(ProbabilityFeatureConfiguration.CODEC))
    val DEEPACIDMUSHROOM: Supplier<DeepAcidMushroomFeature>? = register("deepacidmushroom", DeepAcidMushroomFeature(ProbabilityFeatureConfiguration.CODEC))
    val SAFESHALLOWMOSS: Supplier<SafeShallowMossFeature>? = register("safeshallowmoss", SafeShallowMossFeature(ProbabilityFeatureConfiguration.CODEC))

    val SAFESHALLOW: Supplier<SafeShallowFeature>? = register("ssafeshallow", SafeShallowFeature(ProbabilityFeatureConfiguration.CODEC))
    val TABLECORAL: Supplier<TableCoralFeature>? = register("tablecoral", TableCoralFeature(ProbabilityFeatureConfiguration.CODEC))
    val CORALTUBE: Supplier<CoralTubeFeature>? = register("coraltube", CoralTubeFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOODSTOLB: Supplier<BloodBiomeFeature>? = register("bloodstolb", BloodBiomeFeature(ProbabilityFeatureConfiguration.CODEC))

    val MUSHROOM: Supplier<MushroomFeature>? = register("mushroom", MushroomFeature(ProbabilityFeatureConfiguration.CODEC))

    val BLOOD_KELP: Supplier<BloodKelpFeature>? = register("blood_kelp", BloodKelpFeature(NoneFeatureConfiguration.CODEC))

    fun <C : FeatureConfiguration?, F : Feature<C>?> register(name: String, p: F): Supplier<F>? {
        return FEATURES.register(name, Supplier {p} )
    }

}
