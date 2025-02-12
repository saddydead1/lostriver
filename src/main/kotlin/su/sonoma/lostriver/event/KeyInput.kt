package su.sonoma.lostriver.event

import net.minecraft.client.Minecraft
import net.minecraft.world.phys.AABB
import su.sonoma.lostriver.Lostriver.MODID


//@Mod.EventBusSubscriber(modid = MODID, value = [Dist.CLIENT])
//object KeyInput {
//    @SubscribeEvent
//    fun onKeyInput(event: InputEvent.Key) {
//        val mine = Minecraft.getInstance()
//        val player = mine.player ?: return
//
//        val i = player.x
//        val j = player.y
//        val k = player.z
//
//        if (KeyBinding.DOCK.consumeClick()) {
//            if (player.vehicle is SeamothEntity) {
//                if (player.tags.contains("canDock")) {
//                    val cyclops = player.level().getEntitiesOfClass(
//                        CyclopEntity::class.java,
//                        AABB(i, j, k, i, (j - 4), k).inflate(
//                            10.0,
//                            5.0,
//                            10.0
//                        )
//                    )
//                    val cyclop: Int = cyclops[0].id
//
//                    INSTANCE.sendToServer(DockMessage(cyclop))
//                    player.removeTag("canDock")
//                }
//            } else if (player.controlledVehicle is CyclopEntity) {
//                INSTANCE.sendToServer(UnDockMessage())
//            }
//        }
//    }
//}