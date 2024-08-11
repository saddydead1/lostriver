package su.sonoma.lostriver.item

import net.minecraft.client.model.HumanoidModel
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import net.minecraftforge.client.extensions.common.IClientItemExtensions
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.constant.DefaultAnimations
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.renderer.GeoArmorRenderer
import software.bernie.geckolib.util.GeckoLibUtil
import su.sonoma.lostriver.client.renderer.RebreatherRenderer
import java.util.function.Consumer


class RebreatherArmorItem(armorMaterial: ArmorMaterial?, type: Type?, properties: Properties?) :
    ArmorItem(armorMaterial, type, properties), GeoItem {
    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    val oxygenCount = 75.0

    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(object : IClientItemExtensions {
            private var renderer: GeoArmorRenderer<*>? = null

            override fun getHumanoidArmorModel(
                livingEntity: LivingEntity,
                itemStack: ItemStack,
                equipmentSlot: EquipmentSlot,
                original: HumanoidModel<*>?,
            ): HumanoidModel<*> {
                if (this.renderer == null) {
                    this.renderer = RebreatherRenderer()
                }

                renderer!!.prepForRender(livingEntity, itemStack, equipmentSlot, original)
                return renderer!!
            }
        })
    }

    override fun registerControllers(controllers: ControllerRegistrar) {
        controllers.add(*arrayOf<AnimationController<*>>(DefaultAnimations.genericIdleController(this)))
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return this.cache
    }

}
