package su.sonoma.lostriver.item

import it.unimi.dsi.fastutil.objects.ObjectArrayList
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet
import net.minecraft.client.model.HumanoidModel
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.decoration.ArmorStand
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.client.extensions.common.IClientItemExtensions
import software.bernie.example.client.renderer.armor.WolfArmorRenderer
import software.bernie.example.registry.ItemRegistry
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.constant.DataTickets
import software.bernie.geckolib.constant.DefaultAnimations
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.core.animation.AnimationController.AnimationStateHandler
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.renderer.GeoArmorRenderer
import software.bernie.geckolib.util.GeckoLibUtil
import su.sonoma.lostriver.client.renderer.ReaperArmorRenderer
import java.util.function.Consumer

class ReaperArmorItem(armorMaterial: ArmorMaterial?, type: Type?, properties: Properties?) :
    ArmorItem(armorMaterial, type, properties), GeoItem {
    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

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
                    this.renderer = ReaperArmorRenderer()
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