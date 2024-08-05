package su.sonoma.subcraftica.item

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.Tiers
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.subcraftica.Subcraftica.MODID

object ModItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    val PEEPER: RegistryObject<Item> = ITEMS.register("peeper") {
        Item(
            Item.Properties().stacksTo(64)
                    .food(FoodProperties.Builder().nutrition(5).saturationMod(0.2f)
                    .effect(MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0f)
                    .build())
        )
    }

    val BOOMERANG: RegistryObject<Item> = ITEMS.register("boomerang") {
        Item(
            Item.Properties().stacksTo(64)
                .food(FoodProperties.Builder().nutrition(5).saturationMod(0.2f)
                    .effect(MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0f)
                    .build())
        )
    }

    val KNIFE: RegistryObject<Item> = ITEMS.register("knife") {
        SwordItem(
            Tiers.IRON,
            2,
            0.1f,
            Item.Properties().stacksTo(1)
        )
    }
}