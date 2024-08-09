package su.sonoma.lostriver.biome

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.placement.AquaticPlacements
import net.minecraft.data.worldgen.placement.VegetationPlacements
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.*
import net.minecraft.world.level.biome.Biome.BiomeBuilder
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData
import net.minecraft.world.level.levelgen.GenerationStep
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.biome.feature.placements.ModFeatureConfigured
import su.sonoma.lostriver.biome.feature.placements.ModPlacedFeature
import su.sonoma.lostriver.entity.ModEntity


object ModBiomes {
    val SAFE_SHALLOWS: ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME,
        ResourceLocation(MODID, "safe_shallows")
    )

    val KELP_FOREST: ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME,
        ResourceLocation(MODID, "kelp_forest")
    )

    val BLOOD_KELP: ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME,
        ResourceLocation(MODID, "blood_kelp")
    )

    val DUNES: ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME,
        ResourceLocation(MODID, "dunes")
    )

    fun bootstrap(context: BootstapContext<Biome>) {
        context.register(SAFE_SHALLOWS, testBiome(context))
        context.register(KELP_FOREST, kelp(context))
        context.register(BLOOD_KELP, blood_kelp(context))
        context.register(DUNES, dunes(context))
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
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.PEEPER.get(), 50, 1, 15))
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.BOOMERANG.get(), 50, 1, 15))


        val biomeBuilder =
            BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
            )
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addExtraGold(biomeBuilder)
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SAVANNA)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeature.DOUBLEKELP)

        return BiomeBuilder()
            .hasPrecipitation(false)
            .downfall(0f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .specialEffects(
                BiomeSpecialEffects.Builder()
                    .waterColor(3847130)
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

    fun dunes(context: BootstapContext<Biome>): Biome {
        val spawnBuilder = MobSpawnSettings.Builder()
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.BOOMERANG.get(), 50, 1, 10))

        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.REAPER.get(), 50, 1, 1))


        val biomeBuilder =
            BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
            )
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addExtraGold(biomeBuilder)
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
                    .waterColor(16351261)
                    .waterFogColor(163512611)
                    .skyColor(27571)
                    .grassColorOverride(16351261)
                    .foliageColorOverride(5373696)
                    .fogColor(16351261)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                    .build()
            )
            .build()
    }

    fun blood_kelp(context: BootstapContext<Biome>): Biome {
        val spawnBuilder = MobSpawnSettings.Builder()
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.PEEPER.get(), 50, 1, 15))
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.BOOMERANG.get(), 50, 1, 15))


        val biomeBuilder =
            BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
            )
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addExtraGold(biomeBuilder)
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SAVANNA)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeature.BLOOD_GRASS)
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeature.BLOOD_MOSS)


        return BiomeBuilder()
            .hasPrecipitation(false)
            .downfall(0f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .specialEffects(
                BiomeSpecialEffects.Builder()
                    .waterColor(3949738)
                    .waterFogColor(59110)
                    .skyColor(27571)
                    .grassColorOverride(11546150)
                    .foliageColorOverride(11546150)
                    .fogColor(59110)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                    .build()
            )
            .build()
    }

    fun kelp(context: BootstapContext<Biome>): Biome {
        val spawnBuilder = MobSpawnSettings.Builder()
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.PEEPER.get(), 25, 1, 15))
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.BOOMERANG.get(), 25, 1, 15))

        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, SpawnerData(ModEntity.STALKER.get(), 50, 1, 5))


        val biomeBuilder =
            BiomeGenerationSettings.Builder(
                context.lookup(Registries.PLACED_FEATURE),
                context.lookup(Registries.CONFIGURED_CARVER)
            )
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder)
        BiomeDefaultFeatures.addExtraGold(biomeBuilder)
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder)
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder)
        BiomeDefaultFeatures.addLukeWarmKelp(biomeBuilder)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SAVANNA)
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.KELP_COLD)

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_COLD)
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM)
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_DEEP_WARM)
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL)

        return BiomeBuilder()
            .hasPrecipitation(false)
            .downfall(0f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .mobSpawnSettings(spawnBuilder.build())
            .specialEffects(
                BiomeSpecialEffects.Builder()
                    .waterColor(6192150)
                    .waterFogColor(6192150)
                    .skyColor(27571)
                    .grassColorOverride(6192150)
                    .foliageColorOverride(6192150)
                    .fogColor(59110)
                    .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                    .build()
            )
            .build()
    }

}