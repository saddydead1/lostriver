package su.sonoma.lostriver.entity

import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.ai.goal.*
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
import net.minecraft.world.entity.animal.AbstractSchoolingFish
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.LevelReader
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.constant.DefaultAnimations
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.util.GeckoLibUtil
import su.sonoma.lostriver.event.Sounds


class GhostLeviathanEntity(pEntityType: EntityType<out AbstractSchoolingFish>, pLevel: Level) : AbstractSchoolingFish(pEntityType, pLevel), GeoEntity {

    private val cache: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    override fun checkSpawnObstruction(world: LevelReader): Boolean {
        return world.isUnobstructed(this)
    }

    override fun getBucketItemStack(): ItemStack {
        return ItemStack.EMPTY
    }

    override fun getFlopSound(): SoundEvent {
        return SoundEvents.DOLPHIN_AMBIENT
    }

    override fun canBreatheUnderwater(): Boolean {
        return true
    }

    override fun registerGoals() {
        goalSelector.addGoal(1, MeleeAttackGoal(this, 2.0, false))
        goalSelector.addGoal(0, RandomLookAroundGoal(this))
        goalSelector.addGoal(2, RandomSwimmingGoal(this, 0.5, 1))
        goalSelector.addGoal(3, TryFindWaterGoal(this))
        goalSelector.addGoal(4, LookAtPlayerGoal(this, LivingEntity::class.java, 10f))

        targetSelector.addGoal(2, NearestAttackableTargetGoal(this, Player::class.java, true))
    }

    override fun aiStep() {
        super.aiStep()
        target = level().getNearestPlayer(x, y, z, 10.0, true)
    }

    override fun getAmbientSound(): SoundEvent {
        return Sounds.GHOSTLEVIATHAN.get()
    }

    override fun getDeathSound(): SoundEvent {
        return Sounds.REAPER.get()
    }

    override fun getSoundVolume(): Float {
        return 0.5f
    }

    override fun getAmbientSoundInterval(): Int {
        return 90
    }

    companion object {

        fun setAttributes(): AttributeSupplier {
            return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 150.0)
                .add(Attributes.MOVEMENT_SPEED, 2.0)
                .add(Attributes.ATTACK_DAMAGE, 10.0)
                .add(Attributes.ATTACK_SPEED, 0.2)
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