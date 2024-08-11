package su.sonoma.lostriver.biome.feature.custom

import com.mojang.serialization.Codec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.Heightmap
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import su.sonoma.lostriver.block.ModBlocks

class SafeShallowFeature(p_66768_: Codec<ProbabilityFeatureConfiguration>) :
    Feature<ProbabilityFeatureConfiguration>(p_66768_) {
    override fun place(p_160318_: FeaturePlaceContext<ProbabilityFeatureConfiguration?>): Boolean {
        val blockstate = ModBlocks.PURPLEBLOCK.get().defaultBlockState()
        val blockstate1 = ModBlocks.BASKET.get().defaultBlockState()
        val blockstate2 = ModBlocks.PAPYRUS.get().defaultBlockState()
        val blockstate3 = ModBlocks.ROYALBLOCK.get().defaultBlockState()
        val blockstate4 = ModBlocks.ACIDMUSHROOM.get().defaultBlockState()

        var flag = false
        val randomsource = p_160318_.random()
        val worldgenlevel = p_160318_.level()
        val blockpos = p_160318_.origin()
        val probabilityfeatureconfiguration = p_160318_.config()
        val i = randomsource.nextInt(8) - randomsource.nextInt(8)
        val j = randomsource.nextInt(8) - randomsource.nextInt(8)
        val k = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR, blockpos.x + i, blockpos.z + j)
        val blockpos1 = BlockPos(blockpos.x + i, k, blockpos.z + j)
        if (worldgenlevel.getBlockState(blockpos1).`is`(Blocks.WATER)) {
            val flag1 = randomsource.nextDouble() < probabilityfeatureconfiguration!!.probability.toDouble()
            if (blockstate.canSurvive(worldgenlevel, blockpos1)) {
                if (flag1) {
                    val blockpos2 = blockpos1.above()

                    if (worldgenlevel.getBlockState(blockpos2).`is`(Blocks.WATER)) {

                        worldgenlevel.setBlock(blockpos.below(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.below().north(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.below().south(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.below().east(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.below().west(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.below().east().north(), blockstate3, 2)

                        worldgenlevel.setBlock(blockpos.below().above(), blockstate2, 2)
                        worldgenlevel.setBlock(blockpos.below().north().above(), blockstate2, 2)
                        worldgenlevel.setBlock(blockpos.below().south().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.below().west().above(), blockstate4, 2)
                        worldgenlevel.setBlock(blockpos.below().east().north().above(), blockstate1, 2)

                    }
                }

                flag = true
            }
        }

        return flag
    }
}