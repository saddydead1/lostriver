package su.sonoma.subcraftica.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.dimension.DimensionType
import net.minecraft.world.level.dimension.LevelStem
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import net.minecraftforge.common.world.BiomeModifier
import net.minecraftforge.registries.ForgeRegistries
import su.sonoma.subcraftica.Subcraftica.MODID
import su.sonoma.subcraftica.dimension.B4546
import java.util.Set
import java.util.concurrent.CompletableFuture


class ModWorldGenProvider(
    output: PackOutput,
    registries: CompletableFuture<HolderLookup.Provider>,
) : DatapackBuiltinEntriesProvider(output, registries, BUILDER, setOf(MODID)) {

    companion object {
        val BUILDER: RegistrySetBuilder = RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, B4546::bootstapType)
            .add(Registries.LEVEL_STEM, B4546::bootstrapStem)
    }
}
