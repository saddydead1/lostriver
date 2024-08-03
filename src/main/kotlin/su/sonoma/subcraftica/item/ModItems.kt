package su.sonoma.subcraftica.item

import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.subcraftica.Subcraftica.MODID

object ModItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    val PEEPER: RegistryObject<Item> = ITEMS.register("peeper") {
        Item(
            Item.Properties().stacksTo(1)
        )
    }

}