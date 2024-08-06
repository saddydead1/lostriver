package su.sonoma.lostriver.client.renderer

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedEntityGeoModel
import software.bernie.geckolib.renderer.GeoEntityRenderer
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.BoomerangEntity

class BoomerangRenderer(renderManager: EntityRendererProvider.Context) :
    GeoEntityRenderer<BoomerangEntity>(
        renderManager,
        DefaultedEntityGeoModel(ResourceLocation(MODID, "boomerang"))
    ){
    init {
        this.shadowRadius = 0.25f
    }
}
