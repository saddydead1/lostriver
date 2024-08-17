package su.sonoma.lostriver.entity

import net.minecraft.sounds.SoundEvent
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MoverType
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.vehicle.Boat
import net.minecraft.world.item.Item
import net.minecraft.world.level.Level
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager.ControllerRegistrar
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.animation.RawAnimation
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil
import su.sonoma.lostriver.event.Sounds
import su.sonoma.lostriver.item.ModItems
import su.sonoma.lostriver.mixin.BoatEntityAccessor


class CyclopEntity(entityType: EntityType<out Boat>, world: Level) : Boat(entityType, world), GeoEntity {
    var pressingForward: Boolean = false

    private val factory: AnimatableInstanceCache = GeckoLibUtil.createInstanceCache(this)

    init {
        this.setMaxUpStep(5.0f)
    }

    override fun getDropItem(): Item {
        return ModItems.CYCLOP.get()
    }

    override fun getPaddleSound(): SoundEvent? {
        return Sounds.CYCLOP.get()
    }

    override fun tick() {
        (this as BoatEntityAccessor).setStatusField(Status.UNDER_WATER)
        super.tick()
        (this as BoatEntityAccessor).setOutOfControlTicks(0F)
        floatBoat()
        this.move(MoverType.SELF, this.deltaMovement)
        if (this.firstPassenger != null && this.pressingForward) {
            val passenger: Entity = this.firstPassenger!!
            this.xRot = passenger.getXRot() * 0.5f
        }
    }

    override fun isNoGravity(): Boolean {
        return true
    }

    override fun interact(player: Player, hand: InteractionHand?): InteractionResult {
        if (player.startRiding(this)) {
            this.playSound(Sounds.CYCLOP_WELCOME.get(), 0.2f, 1f)
            return InteractionResult.CONSUME
        } else return InteractionResult.PASS
    }

    override fun canAddPassenger(passenger: Entity?): Boolean {
        return passengers.size < 3
    }

    override fun positionRider(pPassenger: Entity, pCallback: MoveFunction?) {
        super.positionRider(pPassenger, pCallback)
    }

    override fun setInput(
        pressingLeft: Boolean,
        pressingRight: Boolean,
        pressingForward: Boolean,
        pressingBack: Boolean,
    ) {
        super.setInput(pressingLeft, pressingRight, pressingForward, pressingBack)
        this.pressingForward = pressingForward
    }

    private fun floatBoat() {
        val vec3d = this.deltaMovement
        if ((this as BoatEntityAccessor).getStatus() === Status.UNDER_WATER && (this.firstPassenger != null) && this.pressingForward) {
            this.setDeltaMovement(vec3d.x * 1.5, vec3d.y - (this.xRot) * 0.001, vec3d.z * 1.5)
        }
        val velocity = this.deltaMovement
        if (wasTouchingWater) {
            this.setDeltaMovement(velocity.x, velocity.y, velocity.z)
        } else {
            this.setDeltaMovement(velocity.x * 0.4, -0.75, velocity.z * 0.4)
        }
    }

    override fun isUnderWater(): Boolean {
        return false
    }

    override fun registerControllers(controllerRegistrar: ControllerRegistrar) {
        controllerRegistrar.add(AnimationController(
            this, "main", 0
        ) { event: AnimationState<CyclopEntity?> ->
            event.controller.setAnimation(RawAnimation.begin().thenLoop("misc.idle"))
            PlayState.CONTINUE
        })
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return factory
    }
}