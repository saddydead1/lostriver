package su.sonoma.lostriver.util

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.settings.KeyConflictContext
import org.lwjgl.glfw.GLFW


object KeyBinding {
    const val KEY_CATEGORY: String = "key.category.lostriver.lost_river_transport"
    const val KEY_DOCK: String = "key.lostriver.dock"

    val DOCK: KeyMapping = KeyMapping(
        KEY_DOCK, KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY
    )
}