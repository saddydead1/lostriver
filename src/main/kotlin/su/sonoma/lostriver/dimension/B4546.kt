package su.sonoma.lostriver.dimension

import com.mojang.datafixers.util.Pair
import net.minecraft.core.Holder
import net.minecraft.core.HolderOwner
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.util.valueproviders.ConstantInt
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.biome.Climate
import net.minecraft.world.level.biome.Climate.ParameterList
import net.minecraft.world.level.biome.MultiNoiseBiomeSource
import net.minecraft.world.level.dimension.BuiltinDimensionTypes
import net.minecraft.world.level.dimension.DimensionType
import net.minecraft.world.level.dimension.LevelStem
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings
import su.sonoma.lostriver.Lostriver.MODID
import java.util.*


object B4546 {

    val B4546_KEY: ResourceKey<LevelStem?> = ResourceKey.create(
        Registries.LEVEL_STEM ,
        ResourceLocation(MODID, "b4546")
    )

    val B4546_LEVEL_KEY: ResourceKey<Level> = ResourceKey.create(
        Registries.DIMENSION,
        ResourceLocation(MODID, "b4546")
    )

    val B4546_TYPE: ResourceKey<DimensionType> = ResourceKey.create(
        Registries.DIMENSION_TYPE,
        ResourceLocation(MODID, "b4546")
    )

    val B4546_NOISE_SETTINGS: ResourceKey<NoiseGeneratorSettings> = ResourceKey.create(
        Registries.NOISE_SETTINGS,
        ResourceLocation(MODID, "b4546")
    )

    fun bootstapType(context: BootstapContext<DimensionType>) {
        context.register(B4546_TYPE, DimensionType(
            OptionalLong.of(12000),
            false,
            false,
            false,
            false,
            1.0,
            true,
            false,
            0,
            256,
            256,
            BlockTags.INFINIBURN_OVERWORLD,
            BuiltinDimensionTypes.OVERWORLD_EFFECTS,
            1.0f,
            DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)
        ))

    }

    fun bootstrapStem(context: BootstapContext<LevelStem?>) {
        val biomeRegistry = context.lookup(Registries.BIOME)
        val dimTypes = context.lookup(Registries.DIMENSION_TYPE)
        val noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS)

        val noiseBasedChunkGenerator = NoiseBasedChunkGenerator(
            MultiNoiseBiomeSource.createFromList(
                ParameterList(listOf(
                    Pair.of(
                        Climate.parameters(
                            0.3F,
                            0.6F,
                            0.1F,
                            0.1F,
                            0.0F,
                            0.0F,
                            0.0F),
                        biomeRegistry.getOrThrow(Biomes.DEEP_OCEAN)
                        ),
                        Pair.of(
                        Climate.parameters(
                            0.3F,
                            0.6F,
                            2F,
                            0.1F,
                            0.0F,
                            0.0F,
                            0.0F),
                    biomeRegistry.getOrThrow(Biomes.DESERT)
                )
            )
                )
            ),
            Holder.Reference.createStandAlone(object: HolderOwner<NoiseGeneratorSettings> {
                override fun canSerializeIn(p_255875_: HolderOwner<NoiseGeneratorSettings>): Boolean {
                    return true
                }
            }, B4546_NOISE_SETTINGS),
        )

        val stem = LevelStem(dimTypes.getOrThrow(B4546_TYPE), noiseBasedChunkGenerator)

        context.register(B4546_KEY, stem)
    }
}