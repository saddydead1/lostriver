package su.sonoma.lostriver.event

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RegisterKeyMappingsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.util.KeyBinding


@Mod.EventBusSubscriber(modid = MODID, value = [Dist.CLIENT], bus = Mod.EventBusSubscriber.Bus.MOD)
object KeyRegister {
    @SubscribeEvent
    fun onKeyRegister(event: RegisterKeyMappingsEvent) {
        event.register(KeyBinding.DOCK)
    }
}