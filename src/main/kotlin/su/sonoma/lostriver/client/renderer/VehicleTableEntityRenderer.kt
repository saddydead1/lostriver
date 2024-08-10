package su.sonoma.lostriver.client.renderer

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.math.Axis
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.LightTexture
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.client.renderer.texture.OverlayTexture
import net.minecraft.core.BlockPos
import net.minecraft.world.item.ItemDisplayContext
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.LightLayer
import su.sonoma.lostriver.block.entity.VehicleTableEntity

class VehicleTableEntityRenderer(context: BlockEntityRendererProvider.Context?) :
    BlockEntityRenderer<VehicleTableEntity> {
    override fun render(
        pBlockEntity: VehicleTableEntity, pPartialTick: Float, pPoseStack: PoseStack,
        pBuffer: MultiBufferSource, pPackedLight: Int, pPackedOverlay: Int,
    ) {
        val itemRenderer = Minecraft.getInstance().itemRenderer
        val itemStack: ItemStack = pBlockEntity.renderStack

        pPoseStack.pushPose()
        pPoseStack.translate(0.5f, 0.75f, 0.5f)
        pPoseStack.scale(0.35f, 0.35f, 0.35f)
        pPoseStack.mulPose(Axis.XP.rotationDegrees(270f))

        itemRenderer.renderStatic(
            itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel()!!, pBlockEntity.getBlockPos()),
            OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pBlockEntity.getLevel(), 1
        )
        pPoseStack.popPose()
    }

    private fun getLightLevel(level: Level, pos: BlockPos): Int {
        val bLight = level.getBrightness(LightLayer.BLOCK, pos)
        val sLight = level.getBrightness(LightLayer.SKY, pos)
        return LightTexture.pack(bLight, sLight)
    }
}