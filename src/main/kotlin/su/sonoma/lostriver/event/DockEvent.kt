package su.sonoma.lostriver.event

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.world.phys.AABB
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RenderGuiOverlayEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import su.sonoma.lostriver.Lostriver
import su.sonoma.lostriver.entity.CyclopEntity
import su.sonoma.lostriver.entity.SeamothEntity
import su.sonoma.lostriver.util.KeyBinding

@Mod.EventBusSubscriber(modid = Lostriver.MODID, value = [Dist.CLIENT], bus = Mod.EventBusSubscriber.Bus.FORGE)
object DockEvent {
    @SubscribeEvent
    fun draw(event: RenderGuiOverlayEvent.Post) {
        val mine = Minecraft.getInstance()
        val player = mine.player ?: return
        val i = player.x
        val j = player.y
        val k = player.z

        val graphics: GuiGraphics = event.guiGraphics
        val font: Font = mine.font

        if (player.vehicle is SeamothEntity) {
            val cyclops = player.level().getEntitiesOfClass(
                CyclopEntity::class.java,
                AABB(i, j, k, i, (j - 4), k).inflate(
                    10.0,
                    5.0,
                    10.0
                )
            )

            if (cyclops.isNotEmpty()) {
                if (!player.tags.contains("canDock")) {
                    player.addTag("canDock")
                }

                graphics.drawString(font, "Press ${KeyBinding.DOCK.key.displayName.string} to enter Cyclop", 10, 30, 16383998)
            } else {
                player.removeTag("canDock")
            }
        }

    }

}