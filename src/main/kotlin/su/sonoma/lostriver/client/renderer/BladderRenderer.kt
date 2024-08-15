package su.sonoma.lostriver.client.renderer

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedEntityGeoModel
import software.bernie.geckolib.renderer.GeoEntityRenderer
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.BladderEntity

class BladderRenderer(renderManager: EntityRendererProvider.Context) :
    GeoEntityRenderer<BladderEntity>(
        renderManager,
        DefaultedEntityGeoModel(ResourceLocation(MODID, "bladderfish"))
    ){
    init {
        this.shadowRadius = 0.25f
    }
}
