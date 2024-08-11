package su.sonoma.lostriver.client.renderer

import net.minecraft.resources.ResourceLocation
import software.bernie.geckolib.model.DefaultedItemGeoModel
import software.bernie.geckolib.renderer.GeoArmorRenderer
import su.sonoma.lostriver.item.FinsArmorItem

class FinsRenderer :
    GeoArmorRenderer<FinsArmorItem>(DefaultedItemGeoModel(ResourceLocation("lostriver", "armor/fins")))

