package su.sonoma.lostriver.biome.feature

import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.SeagrassFeature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID


object ModFeature {
    val FEATURES: DeferredRegister<Feature<*>>? = DeferredRegister.create(ForgeRegistries.FEATURES, MODID)

    val BLOOD_GRASS: RegistryObject<ModSeaGrassFeature>? = register("blood_grass", ModSeaGrassFeature(ProbabilityFeatureConfiguration.CODEC))
    fun <C : FeatureConfiguration?, F : Feature<C>?> register(name: String, p: F): RegistryObject<F>? {
        return FEATURES?.register(name) {p}
    }

}
