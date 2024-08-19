package su.sonoma.lostriver.item

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.food.Foods
import net.minecraft.world.item.*
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
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

    val COOKED_PEEPER: RegistryObject<Item> = ITEMS.register("cooked_peeper") {
        Item(
            Item.Properties().stacksTo(64)
                .food(Foods.COOKED_SALMON)
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

    val COOKED_BOOMERANG: RegistryObject<Item> = ITEMS.register("cooked_boomerang") {
        Item(
            Item.Properties().stacksTo(64)
                .food(Foods.COOKED_SALMON)
        )
    }

    val BLADDER: RegistryObject<Item> = ITEMS.register("bladderfish") {
        Item(
            Item.Properties().stacksTo(64)
                .food(FoodProperties.Builder().nutrition(5).saturationMod(0.2f)
                    .effect(MobEffectInstance(MobEffects.HUNGER, 400, 1), 1.0f)
                    .build())
        )
    }

    val COOKED_BLADDERFISH: RegistryObject<Item> = ITEMS.register("cooked_bladderfish") {
        Item(
            Item.Properties().stacksTo(64)
                .food(Foods.COOKED_SALMON)
        )
    }

    val TOOTH: RegistryObject<Item> = ITEMS.register("tooth") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val WATER: RegistryObject<Item> = ITEMS.register("water") {
        PotionItem(
            Item.Properties().stacksTo(64))

    }

    val SEAMOTHFRAGMENT: RegistryObject<Item> = ITEMS.register("seamoth_fragment") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val SEAMOTHBLUEPRINT: RegistryObject<Item> = ITEMS.register("seamoth_blueprint") {
        BlueprintItem(
            Item.Properties().stacksTo(64))

    }

    val SILICONE: RegistryObject<Item> = ITEMS.register("silicone") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val TITAN: RegistryObject<Item> = ITEMS.register("titan") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val COPPER: RegistryObject<Item> = ITEMS.register("copper") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val SILVER: RegistryObject<Item> = ITEMS.register("silver") {
        Item(
            Item.Properties().stacksTo(64))

    }
    val GOLD: RegistryObject<Item> = ITEMS.register("gold") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val LEAD: RegistryObject<Item> = ITEMS.register("lead") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val QUARTZ: RegistryObject<Item> = ITEMS.register("quartz") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val LITHIUM: RegistryObject<Item> = ITEMS.register("lithium") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val TABLECORAL: RegistryObject<Item> = ITEMS.register("tablecoral") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val COPPERWIRE: RegistryObject<Item> = ITEMS.register("copperwire") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val COMPUTERCHIP: RegistryObject<Item> = ITEMS.register("computerchip") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val PLASTEELINGOT: RegistryObject<Item> = ITEMS.register("plasteelingot") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val ADVANCEDWIRINGKIT: RegistryObject<Item> = ITEMS.register("advancedwiringkit") {
        Item(
            Item.Properties().stacksTo(64))

    }

    val CYCLOPBLUEPRINT: RegistryObject<Item> = ITEMS.register("cyclop_blueprint") {
        BlueprintItem(
            Item.Properties().stacksTo(64))

    }

    val EMALEDGLASS: RegistryObject<Item> = ITEMS.register("emaled_glass") {
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

    val BLOODSTONE: RegistryObject<Item> = ITEMS.register("bloodstone") {
        BlockItem( ModBlocks.BLOODSTONE.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val MUSHROOM: RegistryObject<Item> = ITEMS.register("mushroom") {
        BlockItem( ModBlocks.MUSHROOM.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLUEPALM: RegistryObject<Item> = ITEMS.register("bluepalm") {
        BlockItem( ModBlocks.BLUEPALM.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val YELLOWGRASS: RegistryObject<Item> = ITEMS.register("yellowgrass") {
        BlockItem( ModBlocks.YELLOWGRASS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val MUSHROOMSTEW: RegistryObject<Item> = ITEMS.register("mushroomstew") {
        BlockItem( ModBlocks.MUSHROOMSTEW.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val LIMESTONE: RegistryObject<Item> = ITEMS.register("limestone") {
        BlockItem( ModBlocks.LIMESTONE.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val SANDSTONE: RegistryObject<Item> = ITEMS.register("sandstone") {
        BlockItem( ModBlocks.SANDSTONE.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOOD_SAND: RegistryObject<Item> = ITEMS.register("bloodsand") {
        BlockItem( ModBlocks.BLOOD_SAND.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val KELP_SAND: RegistryObject<Item> = ITEMS.register("kelpsand") {
        BlockItem( ModBlocks.KELP_SAND.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOOD_GRASS: RegistryObject<Item> = ITEMS.register("blood_grass") {
        BlockItem( ModBlocks.BLOOD_GRASS.get(),
            Item.Properties().stacksTo(64)
        )
    }
    val BLOOD_MOSS: RegistryObject<Item> = ITEMS.register("bloodmoss") {
        BlockItem( ModBlocks.BLOOD_MOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BLOODKELP_MOSS: RegistryObject<Item> = ITEMS.register("bloodkelpmoss") {
        BlockItem( ModBlocks.BLOODKELP_MOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PORTAL: RegistryObject<Item> = ITEMS.register("portal") {
        BlockItem( ModBlocks.PORTAL.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PURPLEMOSS: RegistryObject<Item> = ITEMS.register("purplemoss") {
        BlockItem( ModBlocks.PURPLEMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PURPLEBLOCK: RegistryObject<Item> = ITEMS.register("purpleblock") {
        BlockItem( ModBlocks.PURPLEBLOCK.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val ROYALBLOCK: RegistryObject<Item> = ITEMS.register("royalblock") {
        BlockItem( ModBlocks.ROYALBLOCK.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val BASKET: RegistryObject<Item> = ITEMS.register("basket") {
        BlockItem( ModBlocks.BASKET.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val PAPYRUS: RegistryObject<Item> = ITEMS.register("papyrus") {
        BlockItem( ModBlocks.PAPYRUS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val GREENCOVERMOSS: RegistryObject<Item> = ITEMS.register("greencovermoss") {
        BlockItem( ModBlocks.GREENCOVERMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }
    val ROYALMOSS: RegistryObject<Item> = ITEMS.register("royalmoss") {
        BlockItem( ModBlocks.ROYALMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val CORAL: RegistryObject<Item> = ITEMS.register("coral") {
        BlockItem( ModBlocks.CORAL.get(),
            Item.Properties().stacksTo(64)
        )
    }


    val SAFESHALLOWMOSS: RegistryObject<Item> = ITEMS.register("safeshallowmoss") {
        BlockItem( ModBlocks.SAFESHALLOWMOSS.get(),
            Item.Properties().stacksTo(64)
        )
    }
    val VEINED: RegistryObject<Item> = ITEMS.register("veined") {
        BlockItem( ModBlocks.VEINED.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val DOUBLEKELP: RegistryObject<Item> = ITEMS.register("double_kelp") {
        BlockItem( ModBlocks.DOUBLEKELP.get(),
            Item.Properties().stacksTo(64)
        )
    }

    val REAPER_FRAGMENT: RegistryObject<Item> = ITEMS.register("reaper_fragment") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val WIRINGKIT: RegistryObject<Item> = ITEMS.register("wiringkit") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val FIBERMESH: RegistryObject<Item> = ITEMS.register("fibermesh") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val TITANINGOT: RegistryObject<Item> = ITEMS.register("titan_ingot") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val BATTERY: RegistryObject<Item> = ITEMS.register("battery") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val ACIDMUSHROOM: RegistryObject<Item> = ITEMS.register("acidmushroom") {
        BlockItem( ModBlocks.ACIDMUSHROOM.get(),
            Item.Properties().stacksTo(64))
    }

    val POWERCELL: RegistryObject<Item> = ITEMS.register("powercell") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val LUBRICANT: RegistryObject<Item> = ITEMS.register("lubricant") {
        Item(
            Item.Properties().stacksTo(64))
    }

    val SEAMOTH: RegistryObject<Item> = ITEMS.register("seamoth") {
        SeamothItem(
            Item.Properties().stacksTo(1))
    }

    val CYCLOP: RegistryObject<Item> = ITEMS.register("cyclop") {
        CyclopItem(
            Item.Properties().stacksTo(1))
    }

    val REAPER_HELMET = ITEMS.register("reaper_helmet")
    { ReaperArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, Item.Properties()) }

    val OXYGENTANK = ITEMS.register("oxygentank")
    { OxygenTankArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, Item.Properties()) }

    val HIGHOXYGENTANK = ITEMS.register("highoxygentank")
    { HighOxygenTankArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE, Item.Properties()) }

    val REBREATHER = ITEMS.register("rebreather")
    { RebreatherArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET, Item.Properties()) }

    val FINS = ITEMS.register("fins")
    { FinsArmorItem(ArmorMaterials.IRON, ArmorItem.Type.BOOTS, Item.Properties()) }
}