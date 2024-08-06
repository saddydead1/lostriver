package su.sonoma.lostriver.biome.surface

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.placement.VegetationPlacements
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.*
import net.minecraft.world.level.biome.Biome.BiomeBuilder
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData
import net.minecraft.world.level.levelgen.GenerationStep
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.ModEntity


object ModBiomes {
    val SAFE_SHALLOWS: ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME,
        ResourceLocation(MODID, "safe_shallows")
    )

    val ISLANDS: ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME,
        ResourceLocation(MODID, "islands")
    )

    fun bootstrap(context: BootstapContext<Biome>) {
        context.register(SAFE_SHALLOWS, testBiome(context))
        context.register(ISLANDS, islands(context))
    }

    fun globalOverworldGeneration(builder: BiomeGenerationSettings.Builder?) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder)
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder)
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder)
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder)
        BiomeDefaultFeatures.addDefaultSprings(builder)
        BiomeDefaultFeatures.addSurfaceFreezing(builder)
    }

    fun testBiome(context: BootstapContext<Biome>): Biome {
        val spawnBuilder = MobSpawnSettings.Builder()
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, SpawnerData(ModEntity.PEEPER.get(), 50, 10, 30))
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, SpawnerData(ModEntity.BOOMERANG.get(), 50, 10, 20))


        val biomeBuilder =
            BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
            )
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addExtraGold(biomeBuilder)
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder)
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SAVANNA)

        return BiomeBuilder()
            .hasPrecipitation(false)
            .downfall(0f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .specialEffects(
                BiomeSpecialEffects.Builder()
                    .waterColor(3386879)
                    .waterFogColor(59110)
                    .skyColor(27571)
                    .grassColorOverride(6749952)
                    .foliageColorOverride(5373696)
                    .fogColor(59110)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                    .build()
            )
            .build()
    }

    fun islands(context: BootstapContext<Biome>): Biome {
        val spawnBuilder = MobSpawnSettings.Builder()
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, SpawnerData(ModEntity.PEEPER.get(), 50, 10, 30))
        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, SpawnerData(ModEntity.BOOMERANG.get(), 50, 10, 20))


        val biomeBuilder =
            BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
            )

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addExtraGold(biomeBuilder)
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder)
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SAVANNA)

        return BiomeBuilder()
            .hasPrecipitation(false)
            .downfall(0f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .specialEffects(
                BiomeSpecialEffects.Builder()
                    .waterColor(3386879)
                    .waterFogColor(59110)
                    .skyColor(27571)
                    .grassColorOverride(6749952)
                    .foliageColorOverride(5373696)
                    .fogColor(59110)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                    .build()
            )
            .build()
    }
}