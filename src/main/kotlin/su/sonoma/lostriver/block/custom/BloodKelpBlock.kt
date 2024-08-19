package su.sonoma.lostriver.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.tags.FluidTags
import net.minecraft.util.RandomSource
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.GrowingPlantHeadBlock
import net.minecraft.world.level.block.LiquidBlockContainer
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.material.Fluids
import net.minecraft.world.phys.shapes.VoxelShape
import su.sonoma.lostriver.block.ModBlocks

class BloodKelpBlock(p_54300_: Properties?) :
    GrowingPlantHeadBlock(p_54300_, Direction.UP, SHAPE, true, 0.14),
    LiquidBlockContainer {
    override fun canGrowInto(p_54321_: BlockState): Boolean {
        return p_54321_.`is`(Blocks.WATER)
    }

    override fun getBodyBlock(): Block {
        return ModBlocks.BLOOD_KELP_PLANT.get()
    }

    override fun canAttachTo(p_153455_: BlockState): Boolean {
        return !p_153455_.`is`(Blocks.MAGMA_BLOCK)
    }

    override fun canPlaceLiquid(
        p_54304_: BlockGetter,
        p_54305_: BlockPos,
        p_54306_: BlockState,
        p_54307_: Fluid,
    ): Boolean {
        return false
    }

    override fun placeLiquid(
        p_54309_: LevelAccessor,
        p_54310_: BlockPos,
        p_54311_: BlockState,
        p_54312_: FluidState,
    ): Boolean {
        return false
    }

    override fun getBlocksToGrowWhenBonemealed(p_221366_: RandomSource): Int {
        return 1
    }

    override fun getStateForPlacement(p_54302_: BlockPlaceContext): BlockState? {
        val fluidstate = p_54302_.level.getFluidState(p_54302_.clickedPos)
        return if (fluidstate.`is`(FluidTags.WATER) && fluidstate.amount == 8) super.getStateForPlacement(p_54302_) else null
    }

    override fun getFluidState(p_54319_: BlockState): FluidState {
        return Fluids.WATER.getSource(false)
    }

    companion object {
        protected val SHAPE: VoxelShape = box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0)
        private const val GROW_PER_TICK_PROBABILITY = 0.14
    }
}