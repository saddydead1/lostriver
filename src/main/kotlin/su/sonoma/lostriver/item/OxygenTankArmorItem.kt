package su.sonoma.lostriver.item

import com.mojang.blaze3d.vertex.Tesselator
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.font.FontManager
import net.minecraft.client.model.HumanoidModel
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RenderGuiOverlayEvent
import net.minecraftforge.client.extensions.common.IClientItemExtensions
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.constant.DefaultAnimations
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.renderer.GeoArmorRenderer
import software.bernie.geckolib.util.GeckoLibUtil
import su.sonoma.lostriver.Lostriver
import su.sonoma.lostriver.client.renderer.OxygenTankRenderer
import java.util.function.Consumer


class OxygenTankArmorItem(armorMaterial: ArmorMaterial?, type: Type?, properties: Properties?) :
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
                    this.renderer = OxygenTankRenderer()
                }

                renderer!!.prepForRender(livingEntity, itemStack, equipmentSlot, original)
                return renderer!!
            }
        })
    }

    override fun onArmorTick(stack: ItemStack, level: Level, player: Player) {
        val nbt = stack.getOrCreateTagElement("Oxygen")
        val oxygen = nbt.getDouble("Oxygen")

        if(player.isInWater()) {
            if(oxygen > 0.0) {
                if (player.tickCount % 20 == 0) {  // довольно костыльно, но работает
                    nbt.putDouble("Oxygen",oxygen - 1.0)
                }
                player.addEffect(MobEffectInstance(MobEffect.byId(13)))
            }
        } else {
            nbt.putDouble("Oxygen",oxygenCount)
        }
    }

    override fun registerControllers(controllers: ControllerRegistrar) {
        controllers.add(*arrayOf<AnimationController<*>>(DefaultAnimations.genericIdleController(this)))
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return this.cache
    }

}
