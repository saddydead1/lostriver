package su.sonoma.lostriver.protocol

import net.minecraft.network.FriendlyByteBuf
import net.minecraft.world.InteractionHand
import net.minecraftforge.network.NetworkDirection
import net.minecraftforge.network.NetworkEvent
import java.util.function.Supplier

data class BoatMessage(
    val boat: Int
) {
    companion object{
        val id: Int = 2

        fun toFriendlyByteBuf(msg: BoatMessage, buf: FriendlyByteBuf){
            buf.writeInt(msg.boat)
        }

        fun toBoatMessage(buf: FriendlyByteBuf): BoatMessage {
            val boat = buf.readInt()

            return BoatMessage(boat)
        }

        fun handle(msg: BoatMessage, ctx: Supplier<NetworkEvent.Context>) {
            val context = ctx.get()

            if (context.direction == NetworkDirection.PLAY_TO_SERVER) {
                context.enqueueWork{
                    val player = context.sender ?: return@enqueueWork
                    val level = player.level()
                    val boat = level.getEntity(msg.boat) ?: return@enqueueWork

                    player.vehicle?.kill()
                    player.interactOn(boat, InteractionHand.OFF_HAND)

                }
            }
            context.packetHandled = true
        }
    }
}