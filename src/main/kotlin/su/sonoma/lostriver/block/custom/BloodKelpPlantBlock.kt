package su.sonoma.lostriver.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.block.GrowingPlantBodyBlock
import net.minecraft.world.level.block.GrowingPlantHeadBlock
import net.minecraft.world.level.block.LiquidBlockContainer
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.material.Fluids
import net.minecraft.world.phys.shapes.Shapes
import su.sonoma.lostriver.block.ModBlocks

class BloodKelpPlantBlock(p_54323_: Properties?) :
    GrowingPlantBodyBlock(p_54323_, Direction.UP, Shapes.block(), true), LiquidBlockContainer {
    override fun getHeadBlock(): GrowingPlantHeadBlock {
        return ModBlocks.BLOOD_KELP.get() as GrowingPlantHeadBlock
    }

    override fun getFluidState(p_54336_: BlockState): FluidState {
        return Fluids.WATER.getSource(false)
    }

    override fun canPlaceLiquid(
        p_54325_: BlockGetter,
        p_54326_: BlockPos,
        p_54327_: BlockState,
        p_54328_: Fluid,
    ): Boolean {
        return false
    }

    override fun placeLiquid(
        p_54330_: LevelAccessor,
        p_54331_: BlockPos,
        p_54332_: BlockState,
        p_54333_: FluidState,
    ): Boolean {
        return false
    }
}