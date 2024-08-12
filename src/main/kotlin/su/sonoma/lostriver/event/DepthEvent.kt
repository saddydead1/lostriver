package su.sonoma.lostriver.event

import net.minecraft.client.Minecraft
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.TickEvent.PlayerTickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import su.sonoma.lostriver.Lostriver
import su.sonoma.lostriver.dimension.B4546
import su.sonoma.lostriver.item.ModItems

@Mod.EventBusSubscriber(modid = Lostriver.MODID, value = [Dist.CLIENT], bus = Mod.EventBusSubscriber.Bus.FORGE)
object DepthEvent {
    @SubscribeEvent
    fun depthPlayer(event: PlayerTickEvent) {
        val mine= Minecraft.getInstance()
        val player = mine.player ?: return

        val depth = 129 - Math.round(player.y)

        if (player.level().dimensionTypeId() == B4546.B4546_TYPE) {
            if (player.getInventory().armor.get(3).item != ModItems.REBREATHER.get()) {
                if (depth >= 50 && player.isInWater && !player.isCreative) {
                    if (player.tickCount % 20 == 0) {  // довольно костыльно, но работает
                        player.attack(event.player)
                    }
                }
            }
        }
    }
}