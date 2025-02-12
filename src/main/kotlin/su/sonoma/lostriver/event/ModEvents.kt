package su.sonoma.lostriver.event

import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.*


class ModEvents {
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
    object ModEventBusEvents {
        @SubscribeEvent
        fun entityAttributeEvent(event: EntityAttributeCreationEvent) {
            event.put(ModEntity.PEEPER.get(), PeeperEntity.setAttributes())
            event.put(ModEntity.BOOMERANG.get(), BoomerangEntity.setAttributes())
            event.put(ModEntity.STALKER.get(), StalkerEntity.setAttributes())
            event.put(ModEntity.REAPER.get(), ReaperEntity.setAttributes())
            event.put(ModEntity.BLADDER.get(), BladderEntity.setAttributes())
            event.put(ModEntity.JELLYRAY.get(), JellyrayEntity.setAttributes())
            event.put(ModEntity.GHOST_LEVIATHAN.get(), GhostLeviathanEntity.setAttributes())
        }
    }
}