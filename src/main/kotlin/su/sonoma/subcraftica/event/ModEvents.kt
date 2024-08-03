package su.sonoma.subcraftica.event

import net.minecraftforge.event.entity.EntityAttributeCreationEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import su.sonoma.subcraftica.Subcraftica.MODID
import su.sonoma.subcraftica.entity.ModEntity
import su.sonoma.subcraftica.entity.PeeperEntity


class ModEvents {
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    object ModEventBusEvents {
        @SubscribeEvent
        fun entityAttributeEvent(event: EntityAttributeCreationEvent) {
            event.put(ModEntity.PEEPER.get(), PeeperEntity.setAttributes())
        }
    }
}