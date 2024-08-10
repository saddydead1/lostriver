package su.sonoma.lostriver.client.renderer

import net.minecraft.resources.ResourceLocation
import software.bernie.example.item.WolfArmorItem
import software.bernie.geckolib.model.DefaultedItemGeoModel
import software.bernie.geckolib.renderer.GeoArmorRenderer
import su.sonoma.lostriver.item.OxygenTankArmorItem
import su.sonoma.lostriver.item.ReaperArmorItem

class HighOxygenTankRenderer :
    GeoArmorRenderer<OxygenTankArmorItem>(DefaultedItemGeoModel(ResourceLocation("lostriver", "armor/highoxygentank")))

