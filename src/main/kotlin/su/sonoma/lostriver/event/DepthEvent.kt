package su.sonoma.lostriver.event

import net.minecraft.client.Minecraft
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.damagesource.DamageSources
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.tick.PlayerTickEvent
import su.sonoma.lostriver.Lostriver
import su.sonoma.lostriver.damage.OxygenDamage
import su.sonoma.lostriver.dimension.B4546
import su.sonoma.lostriver.item.ModItems

@EventBusSubscriber(modid = Lostriver.MODID, value = [Dist.CLIENT], bus = EventBusSubscriber.Bus.GAME)
object DepthEvent {
    @SubscribeEvent
    fun depthPlayer(event: PlayerTickEvent.Post) {
        val player = event.entity ?: return

        val depth = 129 - Math.round(player.y)

        if (player.level().dimension() == B4546.B4546_LEVEL_KEY) {
            if (player.getInventory().armor.get(3).item != ModItems.REBREATHER.get()) {
                if (depth >= 50 && player.isInWater && !player.isCreative) {
                    if (player.tickCount % 20 == 0) {
                        player.hurt(OxygenDamage(player).source(), 3f)
                    }
                }
            }
        }
    }

    @SubscribeEvent
    fun tpToLavaZone(event: PlayerTickEvent.Post) {
        val player = event.entity ?: return

        if (player.level().dimension() == B4546.B4546_LEVEL_KEY) {
            if (player.getY() <= 0) {
                player.setPos(player.x, 200.0, player.z) // пока что просто тпхает наверх
            }
        }
    }
}