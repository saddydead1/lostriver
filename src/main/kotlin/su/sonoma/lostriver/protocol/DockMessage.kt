package su.sonoma.lostriver.protocol

import net.minecraft.network.FriendlyByteBuf
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraftforge.network.NetworkDirection
import net.minecraftforge.network.NetworkEvent
import su.sonoma.lostriver.Lostriver
import java.util.function.Supplier

data class DockMessage(
    val boat: Int
) {
    companion object{
        val id: Int = 1

        fun toFriendlyByteBuf(msg: DockMessage, buf: FriendlyByteBuf){
            buf.writeInt(msg.boat)
        }

        fun toBoatMessage(buf: FriendlyByteBuf): DockMessage {
            val boat = buf.readInt()

            return DockMessage(boat)
        }

        fun handle(msg: DockMessage, ctx: Supplier<NetworkEvent.Context>) {
            val context = ctx.get()

            if (context.direction == NetworkDirection.PLAY_TO_SERVER) {
                context.enqueueWork{
                    val player = context.sender ?: return@enqueueWork
                    val level = player.level()
                    val boat = level.getEntity(msg.boat) ?: return@enqueueWork

                    if (!boat.tags.contains("docked")) {
                        player.vehicle?.kill()
                        player.interactOn(boat, InteractionHand.OFF_HAND)

                        boat.addTag("docked")
                    } else {
                        player.sendSystemMessage(Component.translatable(Lostriver.MODID + ".cannotdock"))
                    }
                }
            }
            context.packetHandled = true
        }
    }
}