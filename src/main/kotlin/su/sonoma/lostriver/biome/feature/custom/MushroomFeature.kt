package su.sonoma.lostriver.biome.feature.custom

import com.mojang.serialization.Codec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SlabBlock
import net.minecraft.world.level.levelgen.Heightmap
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration
import su.sonoma.lostriver.block.ModBlocks

class MushroomFeature(p_66768_: Codec<ProbabilityFeatureConfiguration>) :
    Feature<ProbabilityFeatureConfiguration>(p_66768_) {
    override fun place(p_160318_: FeaturePlaceContext<ProbabilityFeatureConfiguration?>): Boolean {
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

            val blockstate = ModBlocks.MUSHROOMSTEW.get().defaultBlockState()
            val blockstate1 = ModBlocks.MUSHROOM.get().defaultBlockState().setValue(SlabBlock.WATERLOGGED, true)

            if (flag1) {
                val blockpos2 = blockpos1.above()
                if (worldgenlevel.getBlockState(blockpos2).`is`(Blocks.WATER)) {

                    val foot: List<BlockPos> = listOf(
                        blockpos.east(),
                        blockpos.north(),
                        blockpos.south(),
                        blockpos.west(),
                        blockpos.west().south(),
                        blockpos.west().north(),
                        blockpos.above(),
                        blockpos.west()
                    )

                    for (pos in foot) {
                        worldgenlevel.setBlock(pos, blockstate, 2)
                    }

                    var cursor = blockpos.above().above()

                    val segments = randomsource.nextInt(2, 6)

                    repeat(segments) {
                        val height = randomsource.nextInt(3, 5)
                        val hat: List<BlockPos> = listOf(
                            cursor.above(height - 1).north(),
                            cursor.above(height - 1).south(),
                            cursor.above(height - 1).west(),
                            cursor.above(height - 1).east(),
                            cursor.above(height - 1).north().west(),
                            cursor.above(height - 1).north().east(),
                            cursor.above(height - 1).south().west(),
                            cursor.above(height - 1).south().east(),
                        )

                        repeat(height) { i ->
                            worldgenlevel.setBlock(cursor.above(i), blockstate, 2)
                        }

                        val listikCount = randomsource.nextInt(1, 4)

                        repeat(listikCount) { i ->
                            val listikSide = randomsource.nextInt(1, 4)
                            val listikHeight = randomsource.nextInt(0, height - 1)

                            when (listikSide) {
                                1 -> worldgenlevel.setBlock(cursor.above(listikHeight).north(), blockstate1, 2)
                                2 -> worldgenlevel.setBlock(cursor.above(listikHeight).south(), blockstate1, 2)
                                3 -> worldgenlevel.setBlock(cursor.above(listikHeight).west(), blockstate1, 2)
                                4 -> worldgenlevel.setBlock(cursor.above(listikHeight).east(), blockstate1, 2)
                            }
                        }

                        for (pos in hat) {
                            worldgenlevel.setBlock(pos, blockstate1, 2)
                        }

                        cursor = cursor.above(height)
                    }
                    cursor = cursor.below()
                    val pos = cursor.north().north()
                    val bigHat: List<BlockPos> = listOf(
                        cursor,
                        pos,
                        pos.west(),
                        pos.west(2),
                        pos.west(2).south(),
                        pos.west(2).south(2),
                        pos.west(2).south(3),
                        pos.west(2).south(4),
                        pos.west(2).south(4).east(),
                        pos.west(2).south(4).east(2),
                        pos.west(2).south(4).east(3),
                        pos.west(2).south(4).east(4),
                        pos.west(2).south(4).east(4).north(),
                        pos.west(2).south(4).east(4).north(2),
                        pos.west(2).south(4).east(4).north(3),
                        pos.west(2).south(4).east(4).north(4),
                        pos.west(2).south(4).east(4).north(4).west(),
                    )

                    for (position in bigHat) {
                        worldgenlevel.setBlock(position, blockstate1, 2)
                    }

                }
            }

            flag = true

        }

        return flag
    }

}