package su.sonoma.lostriver.block

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.common.IPlantable
import java.util.function.Supplier

class ModSandBlock(p_49795_: Properties) : Block(p_49795_) {
    override fun canSustainPlant(
        state: BlockState,
        world: BlockGetter,
        pos: BlockPos,
        facing: Direction,
        plantable: IPlantable
    ): Boolean {
        return true
    }
}