package su.sonoma.lostriver.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import net.minecraftforge.network.NetworkHooks
import su.sonoma.lostriver.block.entity.VehicleTableEntity


class VehicleTable(p_49224_: Properties) : BaseEntityBlock(p_49224_) {
    override fun use(
        pState: BlockState?,
        pLevel: Level,
        pPos: BlockPos?,
        pPlayer: Player?,
        pHand: InteractionHand?,
        pHit: BlockHitResult?,
    ): InteractionResult {
        if (!pLevel.isClientSide()) {
            val entity = pLevel.getBlockEntity(pPos)
            if (entity is VehicleTableEntity) {
                NetworkHooks.openScreen((pPlayer as ServerPlayer?), entity as VehicleTableEntity?, pPos)
            } else {
                throw IllegalStateException("Our Container provider is missing!")
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide())
    }
    override fun newBlockEntity(pPos: BlockPos, pState: BlockState): BlockEntity? {
        return VehicleTableEntity(pPos, pState)
    }
}