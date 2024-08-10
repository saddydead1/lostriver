package su.sonoma.lostriver.client.renderer

import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedItemGeoModel
import software.bernie.geckolib.renderer.GeoArmorRenderer
import su.sonoma.lostriver.item.RebreatherArmorItem

class RebreatherRenderer :
    GeoArmorRenderer<RebreatherArmorItem>(DefaultedItemGeoModel(ResourceLocation("lostriver", "armor/rebreather")))

