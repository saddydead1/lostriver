package su.sonoma.lostriver.entity

import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal
import net.minecraft.world.entity.animal.AbstractSchoolingFish
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.constant.DefaultAnimations
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.util.GeckoLibUtil
import su.sonoma.lostriver.event.Sounds


class PeeperEntity(pEntityType: EntityType<out AbstractSchoolingFish>, pLevel: Level) : AbstractSchoolingFish(pEntityType, pLevel), GeoEntity {

    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    override fun registerGoals() {
        goalSelector.addGoal(0, RandomLookAroundGoal(this))
        goalSelector.addGoal(1, RandomSwimmingGoal(this, 0.5, 1))
        goalSelector.addGoal(2, TryFindWaterGoal(this))

    }


    override fun getAmbientSound(): SoundEvent {
        return Sounds.PEEPER.get()
    }

    override fun getBucketItemStack(): ItemStack {
        return ItemStack.EMPTY
    }

    override fun getFlopSound(): SoundEvent {
       return SoundEvents.TROPICAL_FISH_FLOP
    }

    override fun getDeathSound(): SoundEvent {
        return SoundEvents.DOLPHIN_DEATH
    }

    override fun getSoundVolume(): Float {
        return 0.2f
    }


    companion object {
        fun setAttributes(): AttributeSupplier {
            return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2.0)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .build()
        }
    }

    override fun registerControllers(p0: AnimatableManager.ControllerRegistrar) {
        p0.add(*arrayOf<AnimationController<*>>(DefaultAnimations.genericIdleController(this)))
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return this.cache
    }


}