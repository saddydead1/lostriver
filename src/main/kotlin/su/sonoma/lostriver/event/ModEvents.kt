package su.sonoma.lostriver.event

import net.minecraftforge.event.entity.EntityAttributeCreationEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.BoomerangEntity
import su.sonoma.lostriver.entity.ModEntity
import su.sonoma.lostriver.entity.PeeperEntity
import su.sonoma.lostriver.entity.StalkerEntity


class ModEvents {
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    object ModEventBusEvents {
        @SubscribeEvent
        fun entityAttributeEvent(event: EntityAttributeCreationEvent) {
            event.put(ModEntity.PEEPER.get(), PeeperEntity.setAttributes())
            event.put(ModEntity.BOOMERANG.get(), BoomerangEntity.setAttributes())
            event.put(ModEntity.STALKER.get(), StalkerEntity.setAttributes())
        }
    }
}