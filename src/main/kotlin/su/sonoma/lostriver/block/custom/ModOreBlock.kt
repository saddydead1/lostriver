package su.sonoma.lostriver.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.material.Fluids
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class ModOreBlock(p_49795_: Properties) : Block(p_49795_), SimpleWaterloggedBlock {
    private val northAabb: VoxelShape = box(WIDTH, WIDTH, (16 - HEIGHT), (16 - WIDTH), (16 - WIDTH), 16.0)
    private val southAabb: VoxelShape = box(WIDTH, WIDTH, 0.0, (16 - WIDTH), (16 - WIDTH), HEIGHT)
    private val eastAabb: VoxelShape = box(0.0, WIDTH, WIDTH, HEIGHT, (16 - WIDTH), (16 - WIDTH))
    private val westAabb: VoxelShape = box((16 - HEIGHT), WIDTH, WIDTH, 16.0, (16 - WIDTH), (16 - WIDTH))
    private val upAabb: VoxelShape = box(WIDTH, 0.0, WIDTH, (16 - WIDTH), HEIGHT, (16 - WIDTH))
    private val downAabb: VoxelShape = box(WIDTH, (16 - HEIGHT), WIDTH, (16 - WIDTH), 16.0, (16 - WIDTH))

    override fun getShape(
        blockState: BlockState,
        blockGetter: BlockGetter,
        blockPos: BlockPos,
        collisionContext: CollisionContext,
    ): VoxelShape {
        return when (blockState.getValue(FACING)) {
            Direction.NORTH -> northAabb
            Direction.SOUTH -> southAabb
            Direction.EAST -> eastAabb
            Direction.WEST -> westAabb
            Direction.UP -> upAabb
            Direction.DOWN -> downAabb
        }
    }

    override fun updateShape(
        blockStateFrom: BlockState,
        direction: Direction,
        blockStateTo: BlockState,
        levelAccessor: LevelAccessor,
        blockPosFrom: BlockPos,
        blockPosTo: BlockPos,
    ): BlockState {
        if (blockStateFrom.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPosFrom, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor))
        }
        return if (direction == blockStateFrom.getValue(FACING).getOpposite() &&
            !blockStateFrom.canSurvive(levelAccessor, blockPosFrom)
        ) {
            Blocks.AIR.defaultBlockState()
        } else {
            super.updateShape(blockStateFrom, direction, blockStateTo, levelAccessor, blockPosFrom, blockPosTo)
        }
    }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState {
        val level = context.level
        val blockstate = level.getBlockState(context.clickedPos)
        val fluidstate = level.getFluidState(context.clickedPos)
        val flag = fluidstate.type === Fluids.WATER
        return super.getStateForPlacement(context)!!
            .setValue(WATERLOGGED, flag)
            .setValue(FACING, context.clickedFace)
    }

    override fun getFluidState(blockState: BlockState): FluidState {
        return if (blockState.getValue(WATERLOGGED)) {
            Fluids.WATER.getSource(false)
        } else {
            super.getFluidState(blockState)
        }
    }

    override fun canSurvive(blockState: BlockState, levelReader: LevelReader, blockPos: BlockPos): Boolean {
        val direction = blockState.getValue(FACING)
        val blockpos = blockPos.relative(direction.getOpposite())
        return levelReader.getBlockState(blockpos).isFaceSturdy(levelReader, blockpos, direction)
    }

    override fun rotate(blockState: BlockState, rotation: Rotation): BlockState {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)))
    }

    override fun mirror(blockState: BlockState, mirror: Mirror): BlockState {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)))
    }

    init {
        registerDefaultState(
            stateDefinition.any()
                .setValue(FACING, Direction.UP)
                .setValue(WATERLOGGED, false),
        )
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(FACING)
        builder.add(WATERLOGGED)
    }


    companion object {
        val WIDTH = 4.0
        val HEIGHT = 6.0

        val FACING = BlockStateProperties.FACING
        val WATERLOGGED = BlockStateProperties.WATERLOGGED
    }

}