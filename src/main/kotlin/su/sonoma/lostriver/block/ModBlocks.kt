package su.sonoma.lostriver.block

import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.item.ModItems
import java.util.function.Supplier


object ModBlocks {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID)

    val SAND: RegistryObject<Block> = BLOCKS.register("sand") { ModSandBlock(
        BlockBehaviour.Properties.copy(Blocks.DIRT))
    }


}