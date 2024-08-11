package su.sonoma.lostriver.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import su.sonoma.lostriver.dimension.B4546
import su.sonoma.lostriver.portal.ModTeleporter


class ModPortalBlock(pProperties: Properties) : Block(pProperties) {
    override fun use(
        pState: BlockState,
        pLevel: Level,
        pPos: BlockPos,
        pPlayer: Player,
        pHand: InteractionHand,
        pHit: BlockHitResult,
    ): InteractionResult {
        if (pPlayer.canChangeDimensions()) {
            handlePortal(pPlayer, pPos)
            return InteractionResult.SUCCESS
        } else {
            return InteractionResult.CONSUME
        }
    }

    private fun handlePortal(player: Entity, pPos: BlockPos) {
        if (player.level() is ServerLevel) {
            val serverLevel = player.level() as ServerLevel
            val minecraftServer = serverLevel.server
            val resourceKey = if (player.level().dimension() == B4546.B4546_LEVEL_KEY)
                Level.OVERWORLD
            else
                B4546.B4546_LEVEL_KEY

            val portalDimension = minecraftServer.getLevel(resourceKey)
            if (portalDimension != null && !player.isPassenger) {
                player.changeDimension(portalDimension, ModTeleporter(pPos, resourceKey == B4546.B4546_LEVEL_KEY))
            }
        }
    }


}