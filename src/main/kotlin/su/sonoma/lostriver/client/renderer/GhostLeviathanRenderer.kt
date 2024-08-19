package su.sonoma.lostriver.client.renderer

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedEntityGeoModel
import software.bernie.geckolib.renderer.GeoEntityRenderer
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.GhostLeviathanEntity

class GhostLeviathanRenderer(renderManager: EntityRendererProvider.Context) :
    GeoEntityRenderer<GhostLeviathanEntity>(
        renderManager,
        DefaultedEntityGeoModel(ResourceLocation(MODID, "ghost_leviathan"))
    ){
    init {
        this.shadowRadius = 0.25f
    }
}
