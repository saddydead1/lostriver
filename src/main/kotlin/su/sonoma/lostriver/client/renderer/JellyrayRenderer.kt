package su.sonoma.lostriver.client.renderer

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.core.BlockPos
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedEntityGeoModel
import software.bernie.geckolib.renderer.GeoEntityRenderer
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.JellyrayEntity

class JellyrayRenderer(renderManager: EntityRendererProvider.Context) :
    GeoEntityRenderer<JellyrayEntity>(
        renderManager,
        DefaultedEntityGeoModel(ResourceLocation(MODID, "jellyray"))
    ){
    init {
        this.shadowRadius = 0.25f
    }

    override fun getBlockLightLevel(p_174146_: JellyrayEntity, p_174147_: BlockPos?): Int {
        return 10
    }
}
