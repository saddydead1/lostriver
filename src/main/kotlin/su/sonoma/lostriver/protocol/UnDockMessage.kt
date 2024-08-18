package su.sonoma.lostriver.protocol

import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraft.world.entity.MobSpawnType
import net.minecraftforge.network.NetworkDirection
import net.minecraftforge.network.NetworkEvent
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.entity.ModEntity
import java.util.function.Supplier

class UnDockMessage() {
    companion object{
        val id: Int = 3

        fun toFriendlyByteBuf(msg: UnDockMessage, buf: FriendlyByteBuf){
        }

        fun toBoatMessage(buf: FriendlyByteBuf): UnDockMessage {
            return UnDockMessage()
        }

        fun handle(msg: UnDockMessage, ctx: Supplier<NetworkEvent.Context>) {
            val context = ctx.get()

            if (context.direction == NetworkDirection.PLAY_TO_SERVER) {
                context.enqueueWork{
                    val player = context.sender ?: return@enqueueWork
                    val level = player.level()
                    val serverlevel = player.serverLevel()
                    val boat = player.vehicle ?: return@enqueueWork

                    if (boat.tags.contains("docked")) {
                        val spawnedBoat = ModEntity.SEAMOTH.get().spawn(
                            serverlevel,
                            null,
                            player,
                            player.blockPosition().below(2),
                            MobSpawnType.COMMAND,
                            true,
                            false
                        )

                        player.interactOn(spawnedBoat, InteractionHand.OFF_HAND)

                        boat.removeTag("docked")
                    } else {
                        player.sendSystemMessage(Component.translatable(MODID + ".cannotundock"))
                    }
                }
            }
            context.packetHandled = true
        }
    }
}