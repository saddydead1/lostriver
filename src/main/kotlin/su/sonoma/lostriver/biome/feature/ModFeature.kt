package su.sonoma.lostriver.biome.feature

import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.biome.feature.custom.*


object ModFeature {
    val FEATURES: DeferredRegister<Feature<*>>? = DeferredRegister.create(ForgeRegistries.FEATURES, MODID)

    val BLOOD_GRASS: RegistryObject<BloodGrassFeature>? = register("blood_grass", BloodGrassFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOODSAND: RegistryObject<BloodSandFeature>? = register("blood_sand", BloodSandFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOODKELP_MOSS: RegistryObject<BloodKelpMossFeature>? = register("bloodkelp_moss", BloodKelpMossFeature(ProbabilityFeatureConfiguration.CODEC))
    val KELPSAND: RegistryObject<KelpSandFeature>? = register("kelp_sand", KelpSandFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOOD_MOSS: RegistryObject<BloodMossFeature>? = register("blood_moss", BloodMossFeature(ProbabilityFeatureConfiguration.CODEC))
    val DOUBLEKELP: RegistryObject<DoubleKelpFeature>? = register("double_kelp", DoubleKelpFeature(ProbabilityFeatureConfiguration.CODEC))
    val YELLOWGRASS: RegistryObject<YellowGrassFeature>? = register("yellowgrass", YellowGrassFeature(ProbabilityFeatureConfiguration.CODEC))
    val ACIDMUSHROOM: RegistryObject<AcidMushroomFeature>? = register("acidmushroom", AcidMushroomFeature(ProbabilityFeatureConfiguration.CODEC))
    val SAFESHALLOWMOSS: RegistryObject<SafeShallowMossFeature>? = register("safeshallowmoss", SafeShallowMossFeature(ProbabilityFeatureConfiguration.CODEC))

    val SAFESHALLOW: RegistryObject<SafeShallowFeature>? = register("ssafeshallow", SafeShallowFeature(ProbabilityFeatureConfiguration.CODEC))
    val TABLECORAL: RegistryObject<TableCoralFeature>? = register("tablecoral", TableCoralFeature(ProbabilityFeatureConfiguration.CODEC))
    val CORALTUBE: RegistryObject<CoralTubeFeature>? = register("coraltube", CoralTubeFeature(ProbabilityFeatureConfiguration.CODEC))
    val BLOODSTOLB: RegistryObject<BloodBiomeFeature>? = register("bloodstolb", BloodBiomeFeature(ProbabilityFeatureConfiguration.CODEC))

    val MUSHROOM: RegistryObject<MushroomFeature>? = register("mushroom", MushroomFeature(ProbabilityFeatureConfiguration.CODEC))

    val BLOOD_KELP: RegistryObject<BloodKelpFeature>? = register("blood_kelp", BloodKelpFeature(NoneFeatureConfiguration.CODEC))

    fun <C : FeatureConfiguration?, F : Feature<C>?> register(name: String, p: F): RegistryObject<F>? {
        return FEATURES?.register(name) {p}
    }

}
