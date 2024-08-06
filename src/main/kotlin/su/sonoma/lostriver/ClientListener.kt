package su.sonoma.lostriver

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.client.renderer.BoomerangRenderer
import su.sonoma.lostriver.client.renderer.PeeperRenderer
import su.sonoma.lostriver.entity.ModEntity

@EventBusSubscriber(modid = MODID, bus = Bus.MOD, value = [Dist.CLIENT])
object ClientListener {
    @SubscribeEvent
    fun registerRenderers(event: RegisterRenderers) {
        event.registerEntityRenderer(ModEntity.PEEPER.get()
        ) { context: EntityRendererProvider.Context? -> PeeperRenderer(context!!) }

        event.registerEntityRenderer(ModEntity.BOOMERANG.get()
        ) { context: EntityRendererProvider.Context? -> BoomerangRenderer(context!!) }

    }

}