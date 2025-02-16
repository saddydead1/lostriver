package su.sonoma.lostriver.item

import net.minecraft.core.Holder
import net.minecraft.core.component.DataComponents
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.food.Foods
import net.minecraft.world.item.*
import net.neoforged.neoforge.registries.DeferredRegister
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.block.ModBlocks
import su.sonoma.lostriver.datacomponent.ModDataComponents
import java.util.function.Supplier

object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(MODID);

    val PEEPER: Supplier<Item> = ITEMS.registerItem("peeper") {
        Item(
            Item.Properties().stacksTo(64)
                    .food(FoodProperties.Builder().nutrition(5)
                    .effect(MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0f)
                    .build())
        )
    }

    val COOKED_PEEPER: Supplier<Item> = ITEMS.registerItem("cooked_peeper") {
        Item(
            Item.Properties().stacksTo(64)
                .food(Foods.COOKED_SALMON)
        )
    }

    val BOOMERANG: Supplier<Item> = ITEMS.registerItem("boomerang") {
        Item(
            Item.Properties().stacksTo(64)
                .food(FoodProperties.Builder().nutrition(5)
                    .effect(MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0f)
                    .build())
        )
    }

    val COOKED_BOOMERANG: Supplier<Item> = ITEMS.registerItem("cooked_boomerang") {
        Item(
            Item.Properties().stacksTo(64)
                .food(Foods.COOKED_SALMON)
        )
    }

    val BLADDER: Supplier<Item> = ITEMS.registerItem("bladderfish") {
        Item(
            Item.Properties().stacksTo(64)
                .food(FoodProperties.Builder().nutrition(5)
                    .effect(MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0f)
                    .build())
        )
    }

    val COOKED_BLADDERFISH: Supplier<Item> = ITEMS.registerItem("cooked_bladderfish") {
        Item(
            Item.Properties().stacksTo(64)
                .food(Foods.COOKED_SALMON)
        )
    }

    val TOOTH: Supplier<Item> = ITEMS.registerItem("tooth") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val WATER: Supplier<Item> = ITEMS.registerItem("water") {
        PotionItem(
            Item.Properties().stacksTo(64))

    }

    val SEAMOTHFRAGMENT: Supplier<Item> = ITEMS.registerItem("seamoth_fragment") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val SEAMOTHBLUEPRINT: Supplier<Item> = ITEMS.registerItem("seamoth_blueprint") {
        BlueprintItem(
            Item.Properties().stacksTo(64))

    }

    val SILICONE: Supplier<Item> = ITEMS.registerItem("silicone") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val TITAN: Supplier<Item> = ITEMS.registerItem("titan") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val COPPER: Supplier<Item> = ITEMS.registerItem("copper") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val SILVER: Supplier<Item> = ITEMS.registerItem("silver") {
        Item(
            Item.Properties().stacksTo(64))

    }
    val GOLD: Supplier<Item> = ITEMS.registerItem("gold") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val LEAD: Supplier<Item> = ITEMS.registerItem("lead") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val QUARTZ: Supplier<Item> = ITEMS.registerItem("quartz") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val LITHIUM: Supplier<Item> = ITEMS.registerItem("lithium") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val TABLECORAL: Supplier<Item> = ITEMS.registerItem("tablecoral") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val COPPERWIRE: Supplier<Item> = ITEMS.registerItem("copperwire") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val COMPUTERCHIP: Supplier<Item> = ITEMS.registerItem("computerchip") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val PLASTEELINGOT: Supplier<Item> = ITEMS.registerItem("plasteelingot") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val ADVANCEDWIRINGKIT: Supplier<Item> = ITEMS.registerItem("advancedwiringkit") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val CYCLOPBLUEPRINT: Supplier<Item> = ITEMS.registerItem("cyclop_blueprint") {
        BlueprintItem(
            Item.Properties().stacksTo(64))

    }

    val EMALEDGLASS: Supplier<Item> = ITEMS.registerItem("emaled_glass") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val KNIFE: Supplier<Item> = ITEMS.registerItem("knife") {
        SwordItem(
            Tiers.IRON,
            Item.Properties().stacksTo(1).attributes(SwordItem.createAttributes(Tiers.IRON, 3, -2.4f))
        )
    }

    val SAND: Supplier<Item> = ITEMS.registerItem("sand") {
        BlockItem( ModBlocks.SAND.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOODSTONE: Supplier<Item> = ITEMS.registerItem("bloodstone") {
        BlockItem( ModBlocks.BLOODSTONE.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val MUSHROOM: Supplier<Item> = ITEMS.registerItem("mushroom") {
        BlockItem( ModBlocks.MUSHROOM.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLUEPALM: Supplier<Item> = ITEMS.registerItem("bluepalm") {
        BlockItem( ModBlocks.BLUEPALM.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val YELLOWGRASS: Supplier<Item> = ITEMS.registerItem("yellowgrass") {
        BlockItem( ModBlocks.YELLOWGRASS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val MUSHROOMSTEW: Supplier<Item> = ITEMS.registerItem("mushroomstew") {
        BlockItem( ModBlocks.MUSHROOMSTEW.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val LIMESTONE: Supplier<Item> = ITEMS.registerItem("limestone") {
        BlockItem( ModBlocks.LIMESTONE.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val SANDSTONE: Supplier<Item> = ITEMS.registerItem("sandstone") {
        BlockItem( ModBlocks.SANDSTONE.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOOD_SAND: Supplier<Item> = ITEMS.registerItem("bloodsand") {
        BlockItem( ModBlocks.BLOOD_SAND.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val KELP_SAND: Supplier<Item> = ITEMS.registerItem("kelpsand") {
        BlockItem( ModBlocks.KELP_SAND.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOOD_GRASS: Supplier<Item> = ITEMS.registerItem("blood_grass") {
        BlockItem( ModBlocks.BLOOD_GRASS.get(),
            Item.Properties().stacksTo(64)
        )
    }
    val BLOOD_MOSS: Supplier<Item> = ITEMS.registerItem("bloodmoss") {
        BlockItem( ModBlocks.BLOOD_MOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOODKELP_MOSS: Supplier<Item> = ITEMS.registerItem("bloodkelpmoss") {
        BlockItem( ModBlocks.BLOODKELP_MOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PORTAL: Supplier<Item> = ITEMS.registerItem("portal") {
        BlockItem( ModBlocks.PORTAL.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PURPLEMOSS: Supplier<Item> = ITEMS.registerItem("purplemoss") {
        BlockItem( ModBlocks.PURPLEMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PURPLEBLOCK: Supplier<Item> = ITEMS.registerItem("purpleblock") {
        BlockItem( ModBlocks.PURPLEBLOCK.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val ROYALBLOCK: Supplier<Item> = ITEMS.registerItem("royalblock") {
        BlockItem( ModBlocks.ROYALBLOCK.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BASKET: Supplier<Item> = ITEMS.registerItem("basket") {
        BlockItem( ModBlocks.BASKET.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PAPYRUS: Supplier<Item> = ITEMS.registerItem("papyrus") {
        BlockItem( ModBlocks.PAPYRUS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val GREENCOVERMOSS: Supplier<Item> = ITEMS.registerItem("greencovermoss") {
        BlockItem( ModBlocks.GREENCOVERMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }
    val ROYALMOSS: Supplier<Item> = ITEMS.registerItem("royalmoss") {
        BlockItem( ModBlocks.ROYALMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val CORAL: Supplier<Item> = ITEMS.registerItem("coral") {
        BlockItem( ModBlocks.CORAL.get(),
            Item.Properties().stacksTo(64)
        )
    }


    val SAFESHALLOWMOSS: Supplier<Item> = ITEMS.registerItem("safeshallowmoss") {
        BlockItem( ModBlocks.SAFESHALLOWMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }
    val VEINED: Supplier<Item> = ITEMS.registerItem("veined") {
        BlockItem( ModBlocks.VEINED.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val DOUBLEKELP: Supplier<Item> = ITEMS.registerItem("double_kelp") {
        BlockItem( ModBlocks.DOUBLEKELP.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val REAPER_FRAGMENT: Supplier<Item> = ITEMS.registerItem("reaper_fragment") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val WIRINGKIT: Supplier<Item> = ITEMS.registerItem("wiringkit") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val FIBERMESH: Supplier<Item> = ITEMS.registerItem("fibermesh") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val TITANINGOT: Supplier<Item> = ITEMS.registerItem("titan_ingot") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val BATTERY: Supplier<Item> = ITEMS.registerItem("battery") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val ACIDMUSHROOM: Supplier<Item> = ITEMS.registerItem("acidmushroom") {
        BlockItem( ModBlocks.ACIDMUSHROOM.get(),
            Item.Properties().stacksTo(64))
    }

    val DEEPACIDMUSHROOM: Supplier<Item> = ITEMS.registerItem("deepacidmushroom") {
        BlockItem( ModBlocks.DEEPACIDMUSHROOM.get(),
            Item.Properties().stacksTo(64))
    }

    val POWERCELL: Supplier<Item> = ITEMS.registerItem("powercell") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val LUBRICANT: Supplier<Item> = ITEMS.registerItem("lubricant") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val SEAMOTH: Supplier<Item> = ITEMS.registerItem("seamoth") {
        SeamothItem(
            Item.Properties().stacksTo(1)
        )
    }

    val CYCLOP: Supplier<Item> = ITEMS.registerItem("cyclop") {
        CyclopItem(
            Item.Properties().stacksTo(1))
    }

    val REAPER_HELMET = ITEMS.registerItem("reaper_helmet")
    { ReaperArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, Item.Properties()) }

    val OXYGENTANK = ITEMS.registerItem("oxygentank")
    { OxygenTankArmorItem(
        75,
        ArmorMaterials.IRON,
        ArmorItem.Type.CHESTPLATE,
        Item.Properties().stacksTo(1).component(ModDataComponents.OXYGEN.get(), OxygenTankArmorItem.Oxygen(75))
    )
    }

    val HIGHOXYGENTANK = ITEMS.registerItem("highoxygentank")
    { OxygenTankArmorItem(
        135,
        ArmorMaterials.IRON,
        ArmorItem.Type.CHESTPLATE,
        Item.Properties().stacksTo(1).component(ModDataComponents.OXYGEN.get(), OxygenTankArmorItem.Oxygen(135))
    )
    }

    val REBREATHER = ITEMS.registerItem("rebreather")
    { RebreatherArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, Item.Properties()) }

    val FINS = ITEMS.registerItem("fins")
    { FinsArmorItem(ArmorMaterials.IRON, ArmorItem.Type.BOOTS, Item.Properties()) }
}