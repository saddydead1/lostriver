//package su.sonoma.lostriver.event
//
//import net.minecraft.client.Minecraft
//import net.neoforged.api.distmarker.Dist
//import net.neoforged.bus.api.SubscribeEvent
//import net.neoforged.fml.common.EventBusSubscriber
//import net.neoforged.neoforge.event.tick.PlayerTickEvent
//import su.sonoma.lostriver.Lostriver
//import su.sonoma.lostriver.dimension.B4546
//import su.sonoma.lostriver.item.ModItems
//
//@EventBusSubscriber(modid = Lostriver.MODID, value = [Dist.CLIENT], bus = EventBusSubscriber.Bus.GAME)
//object DepthEvent {
//    @SubscribeEvent
//    fun depthPlayer(event: PlayerTickEvent) {
//        val mine= Minecraft.getInstance()
//        val player = mine.player ?: return
//
//        val depth = 129 - Math.round(player.y)
//
//        if (player.level().dimension() == B4546.B4546_TYPE) {
//            if (player.getInventory().armor.get(3).item != ModItems.REBREATHER.get()) {
//                if (depth >= 50 && player.isInWater && !player.isCreative) {
//                    if (player.tickCount % 20 == 0) {  // довольно костыльно, но работает
//                        player.attack(event.entity)
//                    }
//                }
//            }
//        }
//    }
//
//    @SubscribeEvent
//    fun tpToLavaZone(event: PlayerTickEvent) {
//        val mine= Minecraft.getInstance()
//        val player = mine.player ?: return
//
//        if (player.level().dimension() == B4546.B4546_TYPE) {
//            if (player.getY() <= 0) {
//                player.setPos(player.x, 200.0, player.z) // пока что просто тпхает наверх
//            }
//        }
//    }
//}