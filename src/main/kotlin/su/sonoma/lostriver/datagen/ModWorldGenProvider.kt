package su.sonoma.lostriver.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.biome.ModBiomes
import su.sonoma.lostriver.biome.feature.placements.ModFeatureConfigured
import su.sonoma.lostriver.biome.feature.placements.ModPlacedFeature
import su.sonoma.lostriver.dimension.B4546
import java.util.concurrent.CompletableFuture


class ModWorldGenProvider(
    output: PackOutput,
    registries: CompletableFuture<HolderLookup.Provider>,
) : DatapackBuiltinEntriesProvider(output, registries, BUILDER, setOf(MODID)) {

    companion object {
        val BUILDER: RegistrySetBuilder = RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, B4546::bootstapType)
            .add(Registries.LEVEL_STEM, B4546::bootstrapStem)
            .add(Registries.BIOME, ModBiomes::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, ModFeatureConfigured::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeature::bootstrap)
    }
}
