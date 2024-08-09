package su.sonoma.lostriver.client.renderer

import net.minecraft.resources.ResourceLocation
import software.bernie.example.item.WolfArmorItem
import software.bernie.geckolib.model.DefaultedItemGeoModel
import software.bernie.geckolib.renderer.GeoArmorRenderer
import su.sonoma.lostriver.item.ReaperArmorItem

class ReaperArmorRenderer :
    GeoArmorRenderer<ReaperArmorItem>(DefaultedItemGeoModel(ResourceLocation("lostriver", "armor/reaper_armor")))

