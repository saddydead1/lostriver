package su.sonoma.subcraftica.client.renderer

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedEntityGeoModel
import software.bernie.geckolib.renderer.GeoEntityRenderer
import su.sonoma.subcraftica.Subcraftica.MODID
import su.sonoma.subcraftica.entity.PeeperEntity

class PeeperRenderer(renderManager: EntityRendererProvider.Context) :
    GeoEntityRenderer<PeeperEntity>(
        renderManager,
        DefaultedEntityGeoModel(ResourceLocation(MODID, "peeper"))
    ){
    init {
        this.shadowRadius = 0.25f
    }
}
