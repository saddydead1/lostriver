package su.sonoma.lostriver.biome.feature.custom

import com.mojang.serialization.Codec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.Heightmap
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import su.sonoma.lostriver.block.ModBlocks

class BloodBiomeFeature(p_66768_: Codec<ProbabilityFeatureConfiguration>) :
    Feature<ProbabilityFeatureConfiguration>(p_66768_) {
    override fun place(p_160318_: FeaturePlaceContext<ProbabilityFeatureConfiguration?>): Boolean {
        val blockstate = ModBlocks.SAND.get().defaultBlockState()
        val blockstate1 = ModBlocks.BLOOD_SAND.get().defaultBlockState()
        val blockstate3 = Blocks.STONE.defaultBlockState()

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

                        worldgenlevel.setBlock(blockpos, blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.north(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.south(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.east(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.west(), blockstate3, 2)

                        worldgenlevel.setBlock(blockpos.above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.north().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.south().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.east().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.west().above(), blockstate, 2)

                        worldgenlevel.setBlock(blockpos.above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.north().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.south().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.east().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.west().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.north().above().north(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.south().south().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.east().above().east(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.west().above().west(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.north().above().west(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.north().above().east(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.south().above().west(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.south().above().east(), blockstate, 2)

                        worldgenlevel.setBlock(blockpos.above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.north().above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.south().above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.east().above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.west().above().above(), blockstate3, 2)

                        worldgenlevel.setBlock(blockpos.above().above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.north().above().above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.south().above().above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.east().above().above().above(), blockstate3, 2)
                        worldgenlevel.setBlock(blockpos.west().above().above().above(), blockstate3, 2)

                        worldgenlevel.setBlock(blockpos.above().above().above().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.north().above().above().above().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.south().above().above().above().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.east().above().above().above().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.west().above().above().above().above(), blockstate1, 2)
                        worldgenlevel.setBlock(blockpos.north().above().north().above().above().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.south().south().above().above().above().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.east().above().east().above().above().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.west().above().west().above().above().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.north().above().west().above().above().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.north().above().east().above().above().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.south().above().west().above().above().above(), blockstate, 2)
                        worldgenlevel.setBlock(blockpos.south().above().east().above().above().above(), blockstate, 2)
                    }
                }

                flag = true
            }
        }

        return flag
    }
}