package su.sonoma.lostriver.item

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.*
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import software.bernie.example.item.WolfArmorItem
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.block.ModBlocks

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

    val TOOTH: RegistryObject<Item> = ITEMS.register("tooth") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val SILICONE: RegistryObject<Item> = ITEMS.register("silicone") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val KNIFE: RegistryObject<Item> = ITEMS.register("knife") {
        SwordItem(
            Tiers.IRON,
            2,
            0.1f,
            Item.Properties().stacksTo(1)
        )
    }

    val SAND: RegistryObject<Item> = ITEMS.register("sand") {
        BlockItem( ModBlocks.SAND.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOOD_GRASS: RegistryObject<Item> = ITEMS.register("blood_grass") {
        BlockItem( ModBlocks.BLOOD_GRASS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val REAPER_FRAGMENT: RegistryObject<Item> = ITEMS.register("reaper_fragment") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val REAPER_HELMET = ITEMS.register("reaper_helmet")
    { ReaperArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, Item.Properties()) }
}