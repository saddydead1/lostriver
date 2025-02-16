package su.sonoma.lostriver.event

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.core.component.DataComponents
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.RenderGuiEvent
import su.sonoma.lostriver.Lostriver
import su.sonoma.lostriver.datacomponent.ModDataComponents
import su.sonoma.lostriver.dimension.B4546
import su.sonoma.lostriver.item.ModItems

@EventBusSubscriber(modid = Lostriver.MODID, value = [Dist.CLIENT], bus = EventBusSubscriber.Bus.GAME)
object HudEvent {

    @SubscribeEvent
    fun drawOxygen(event: RenderGuiEvent.Post) {
        val mine= Minecraft.getInstance()
        val player = mine.player ?: return

        val graphics: GuiGraphics = event.guiGraphics

        val font: Font = mine.font
        val oxygen = player.inventory.armor[2].get(ModDataComponents.OXYGEN)?.count

        if (player.getInventory().armor.get(2).item == ModItems.OXYGENTANK.get() ||
            player.getInventory().armor.get(2).item == ModItems.HIGHOXYGENTANK.get()) {
            graphics.drawString(font, "Oxygen: ${oxygen}", 10, 20, 16383998)
        }
    }

    @SubscribeEvent
    fun drawDepth(event: RenderGuiEvent.Post) {
        val mine= Minecraft.getInstance()
        val player = mine.player ?: return

        val graphics: GuiGraphics = event.guiGraphics

        val font: Font = mine.font
        val depth = 129 - Math.round(player.y)

        if (player.level().dimension() == B4546.B4546_LEVEL_KEY) {
            if (depth <= 0) {
                graphics.drawString(font, "Depth: 0", 10, 10, 16383998)
            } else {
                graphics.drawString(font, "Depth: ${depth}", 10, 10, 16383998)
            }
        }
    }
}