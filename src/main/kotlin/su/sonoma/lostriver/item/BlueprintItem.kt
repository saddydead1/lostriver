package su.sonoma.lostriver.item

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack


class BlueprintItem(p_41383_: Properties) : Item(p_41383_) {
    override fun getCraftingRemainingItem(stack: ItemStack?): ItemStack? {
        val container = stack!!.copy()
        return container
    }

    override fun hasCraftingRemainingItem(stack: ItemStack?): Boolean {
        return true
    }
}