package su.sonoma.lostriver.portal

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.material.Fluids
import net.minecraftforge.common.util.ITeleporter
import su.sonoma.lostriver.block.ModBlocks
import su.sonoma.lostriver.block.custom.ModPortalBlock
import java.util.function.Function


class ModTeleporter(pos: BlockPos, insideDim: Boolean) : ITeleporter {
    companion object {
        var thisPos: BlockPos = BlockPos.ZERO
        var insideDimension: Boolean = true
    }

    init {
        thisPos = pos
        insideDimension = insideDim
    }

    override fun placeEntity(
        entity: Entity,
        currentWorld: ServerLevel,
        destinationWorld: ServerLevel,
        yaw: Float,
        repositionEntity: Function<Boolean, Entity>
    ): Entity {
        var entity = entity
        var y = 61

        if (!insideDimension) {
            y = thisPos.y
        }

        var destinationPos = BlockPos(thisPos.x, y, thisPos.z)

        var tries = 0
        while (destinationWorld.getBlockState(destinationPos).block != Blocks.AIR &&
            !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
            destinationWorld.getBlockState(destinationPos.above()).block != Blocks.AIR &&
            !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && tries < 25) {
            destinationPos = destinationPos.above(2)
            tries++
        }

        entity.setPos(destinationPos.x.toDouble(), destinationPos.y.toDouble(), destinationPos.z.toDouble())

        if (insideDimension) {
            var doSetBlock = true
            for (checkPos in BlockPos.betweenClosed(destinationPos.below(10).west(10), destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).block is ModPortalBlock) {
                    doSetBlock = false
                    break
                }
            }
            if (doSetBlock) {
                destinationWorld.setBlock(destinationPos, ModBlocks.PORTAL.get().defaultBlockState(), 3)
            }
        }

        return entity
    }
}

