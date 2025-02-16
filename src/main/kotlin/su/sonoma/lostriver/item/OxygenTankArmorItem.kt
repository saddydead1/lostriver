package su.sonoma.lostriver.item


import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.client.model.HumanoidModel
import net.minecraft.core.Holder
import net.minecraft.network.RegistryFriendlyByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.animation.AnimatableManager
import software.bernie.geckolib.animation.AnimationController
import software.bernie.geckolib.constant.DefaultAnimations
import software.bernie.geckolib.renderer.GeoArmorRenderer
import software.bernie.geckolib.util.GeckoLibUtil
import su.sonoma.lostriver.client.renderer.OxygenTankRenderer
import su.sonoma.lostriver.datacomponent.ModDataComponents
import java.util.function.Consumer


class OxygenTankArmorItem(val maxOxygenCount: Int, armorMaterial: Holder<ArmorMaterial?>, type: Type?, properties: Properties?) :
    ArmorItem(armorMaterial, type, properties), GeoItem {
    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    private fun getProperties(stack: ItemStack): Oxygen {
        return stack.getOrDefault(
            ModDataComponents.OXYGEN.get(),
            Oxygen.DEFAULT
        )
    }

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

    override fun inventoryTick(stack: ItemStack, level: Level, entity: Entity, slotId: Int, isSelected: Boolean) {
        if (entity is Player) {
            if (entity.inventory.armor[2].item == ModItems.OXYGENTANK.get() ||
                entity.inventory.armor[2].item == ModItems.HIGHOXYGENTANK.get()) {
//            stack.set(ModDataComponents.OXYGEN.get(), Oxygen(oxygenCount))
                if (entity.isInWater()) {
                    if (stack.get(ModDataComponents.OXYGEN)!!.count > 0.0) {
                        if (entity.tickCount % 20 == 0) {
                            stack.update(
                                ModDataComponents.OXYGEN,
                                Oxygen.DEFAULT,
                                { oxygen -> Oxygen(oxygen.count - 1) }
                            )
                        }
                        entity.addEffect(MobEffectInstance(MobEffects.WATER_BREATHING))
                    }
                } else {
                    stack.update(
                        ModDataComponents.OXYGEN,
                        Oxygen.DEFAULT,
                        { oxygen -> Oxygen(maxOxygenCount) }
                    )
                }
            }
        }
    }

    override fun registerControllers(controllers: AnimatableManager.ControllerRegistrar) {
        controllers.add(*arrayOf<AnimationController<*>>(DefaultAnimations.genericIdleController(this)))
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return this.cache
    }

    @JvmRecord
    data class Oxygen(val count: Int) {
        companion object {
            val CODEC: Codec<Oxygen> = RecordCodecBuilder.create { builder ->
                builder.group(
                    Codec.INT
                        .fieldOf("count")
                        .forGetter(Oxygen::count),

                ).apply(builder) { count: Int ->
                    Oxygen(
                        count
                    )
                }
            }

            val NETWORK_CODEC: StreamCodec<RegistryFriendlyByteBuf, Oxygen> = StreamCodec.composite(
                ByteBufCodecs.VAR_INT,
                Oxygen::count
            ) { count: Int -> Oxygen(count) }

            val DEFAULT: Oxygen = Oxygen(0)
        }
    }
}


