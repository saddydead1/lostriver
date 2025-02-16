package su.sonoma.lostriver.item

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.stats.Stats
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntitySelector
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.ClipContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.LiquidBlock
import net.minecraft.world.level.gameevent.GameEvent
import net.minecraft.world.phys.AABB
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.HitResult
import net.minecraft.world.phys.Vec3
import su.sonoma.lostriver.entity.CyclopEntity
import su.sonoma.lostriver.entity.ModEntity


class CyclopItem(settings: Properties?) : Item(settings) {
    override fun use(world: Level, user: Player, hand: InteractionHand?): InteractionResultHolder<ItemStack> {
        val itemStack: ItemStack = user.getItemInHand(hand)
        val hitResult: HitResult = getPlayerPOVHitResult(world, user, ClipContext.Fluid.SOURCE_ONLY)
        if (hitResult.type != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemStack)
        } else if (world !is ServerLevel) {
            return InteractionResultHolder.success(itemStack)
        } else {
            val blockHitResult = hitResult as BlockHitResult
            val blockPos = blockHitResult.blockPos
            if (world.getBlockState(blockPos).getBlock() !is LiquidBlock) {
                return InteractionResultHolder.pass(itemStack)
            } else if (world.mayInteract(user, blockPos) && user.mayUseItemAt(
                    blockPos,
                    blockHitResult.direction,
                    itemStack
                )
            ) {
                val boatEntity = CyclopEntity(ModEntity.CYCLOP.get(), world)
                boatEntity.setPos(hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z)
                boatEntity.setYRot(user.getYRot())
                world.addFreshEntity(boatEntity)
                world.gameEvent(user, GameEvent.ENTITY_PLACE, BlockPos(hitResult.blockPos))
                if (!user.getAbilities().instabuild) {
                    itemStack.shrink(1)
                }

                user.awardStat(Stats.ITEM_USED.get(this))
                world.gameEvent(user, GameEvent.ENTITY_PLACE, blockPos)
                return InteractionResultHolder.consume(itemStack)
            } else {
                return InteractionResultHolder.fail(itemStack)
            }
        }
    }

    fun usee(world: Level, user: Player, hand: InteractionHand?): InteractionResultHolder<ItemStack> {
        val itemStack: ItemStack = user.getItemInHand(hand)
        val hitResult: HitResult = getPlayerPOVHitResult(world, user, ClipContext.Fluid.SOURCE_ONLY)
        if (hitResult.type == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemStack)
        } else {
            val vec3d: Vec3 = user.getViewVector(1.0f)
            val list: List<Entity> =
                world.getEntities(user, user.getBoundingBox().expandTowards(vec3d.scale(5.0)).inflate(1.0), RIDERS)
            if (!list.isEmpty()) {
                val vec3d2: Vec3 = user.getEyePosition()

                for (entity in list) {
                    val box: AABB = entity.getBoundingBox().inflate(entity.getPickRadius().toDouble())
                    if (box.contains(vec3d2)) {
                        return InteractionResultHolder.pass(itemStack)
                    }
                }
            }

            val boatEntity = CyclopEntity(ModEntity.CYCLOP.get(), world)
            boatEntity.setPos(hitResult.location.x, hitResult.location.y, hitResult.location.z)
            boatEntity.setYRot(user.getYRot())

            run {
                if (!world.isClientSide) {
                    world.addFreshEntity(boatEntity)
                    world.gameEvent(user, GameEvent.ENTITY_PLACE, hitResult.location)
                    if (!user.getAbilities().instabuild) {
                        itemStack.shrink(1)
                    }
                }
                user.awardStat(Stats.ITEM_USED.get(this))
                return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide())
            }
        }
    }

    companion object {
        private val RIDERS = EntitySelector.NO_SPECTATORS.and(Entity::isPickable)
    }
}