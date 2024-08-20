package su.sonoma.lostriver.biome.feature.custom

import com.mojang.serialization.Codec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.KelpBlock
import net.minecraft.world.level.levelgen.Heightmap
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
import su.sonoma.lostriver.block.ModBlocks

class BloodKelpFeature(p_66219_: Codec<NoneFeatureConfiguration?>?) :
    Feature<NoneFeatureConfiguration?>(p_66219_) {
    override fun place(p_159956_: FeaturePlaceContext<NoneFeatureConfiguration?>): Boolean {
        var i = 0
        val worldgenlevel = p_159956_.level()
        val blockpos = p_159956_.origin()
        val randomsource = p_159956_.random()
        val j = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR, blockpos.x, blockpos.z)
        var blockpos1 = BlockPos(blockpos.x, j, blockpos.z)
        if (worldgenlevel.getBlockState(blockpos1).`is`(Blocks.WATER)) {
            val blockstate = ModBlocks.BLOOD_KELP.get().defaultBlockState()
            val blockstate1 = ModBlocks.BLOOD_KELP_PLANT.get().defaultBlockState()
            val k = 1 + randomsource.nextInt(10)

            for (l in 0..k) {
                if (worldgenlevel.getBlockState(blockpos1)
                        .`is`(Blocks.WATER) && worldgenlevel.getBlockState(blockpos1.above()).`is`(
                        Blocks.WATER
                    ) && blockstate1.canSurvive(worldgenlevel, blockpos1)
                ) {
                    if (l == k) {
                        worldgenlevel.setBlock(
                            blockpos1,
                            blockstate.setValue(KelpBlock.AGE, randomsource.nextInt(4) + 20),
                            2
                        )
                        ++i
                    } else {
                        worldgenlevel.setBlock(blockpos1, blockstate1, 2)
                    }
                } else if (l > 0) {
                    val blockpos2 = blockpos1.below()
                    if (blockstate.canSurvive(
                            worldgenlevel,
                            blockpos2
                        ) && !worldgenlevel.getBlockState(blockpos2.below()).`is`(
                            ModBlocks.BLOOD_KELP.get()
                        )
                    ) {
                        worldgenlevel.setBlock(
                            blockpos2,
                            blockstate.setValue(KelpBlock.AGE, randomsource.nextInt(4) + 20),
                            2
                        )
                        ++i
                    }
                    break
                }

                blockpos1 = blockpos1.above()
            }
        }

        return i > 0
    }
}