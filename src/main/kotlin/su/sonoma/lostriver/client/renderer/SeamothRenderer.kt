package su.sonoma.lostriver.client.renderer

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.math.Axis
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.Mth
import software.bernie.geckolib.model.DefaultedEntityGeoModel
import software.bernie.geckolib.renderer.GeoEntityRenderer
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.SeamothEntity


class SeamothRenderer(renderManager: EntityRendererProvider.Context) :
    GeoEntityRenderer<SeamothEntity>(
        renderManager,
        DefaultedEntityGeoModel(ResourceLocation(MODID, "seamoth"))
    ){
    init {
        this.shadowRadius = 0.25f
    }

    override fun applyRotations(
        animatable: SeamothEntity,
        poseStack: PoseStack,
        ageInTicks: Float,
        rotationYaw: Float,
        partialTick: Float,
    ) {
        poseStack.mulPose(Axis.YN.rotationDegrees(Mth.rotLerp(partialTick, animatable.yRotO, animatable.getYRot())))
    }

}