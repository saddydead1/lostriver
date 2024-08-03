package su.sonoma.subcraftica

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus
import su.sonoma.subcraftica.Subcraftica.MODID
import su.sonoma.subcraftica.client.renderer.PeeperRenderer
import su.sonoma.subcraftica.entity.ModEntity

@EventBusSubscriber(modid = MODID, bus = Bus.MOD, value = [Dist.CLIENT])
object ClientListener {
    @SubscribeEvent
    fun registerRenderers(event: RegisterRenderers) {
            event.registerEntityRenderer(ModEntity.PEEPER.get()
            ) { context: EntityRendererProvider.Context? -> PeeperRenderer(context!!) }

    }

}