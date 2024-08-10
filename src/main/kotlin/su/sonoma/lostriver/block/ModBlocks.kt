package su.sonoma.lostriver.block

import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SeagrassBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.block.custom.ModOreBlock
import su.sonoma.lostriver.block.custom.ModSandBlock
import su.sonoma.lostriver.block.custom.VehicleTable


object ModBlocks {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID)

    val SAND: RegistryObject<Block> = BLOCKS.register("sand") {
        ModSandBlock(
        BlockBehaviour.Properties.copy(Blocks.DIRT))
    }

    val BLOOD_SAND: RegistryObject<Block> = BLOCKS.register("bloodsand") {
        ModSandBlock(
            BlockBehaviour.Properties.copy(Blocks.DIRT))
    }

    val KELP_SAND: RegistryObject<Block> = BLOCKS.register("kelpsand") {
        ModSandBlock(
            BlockBehaviour.Properties.copy(Blocks.DIRT))
    }

    val BLOOD_GRASS: RegistryObject<Block> = BLOCKS.register("blood_grass") {
        SeagrassBlock(
        BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BLOOD_MOSS: RegistryObject<Block> = BLOCKS.register("bloodmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val DOUBLEKELP: RegistryObject<Block> = BLOCKS.register("double_kelp") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val LIMESTONE: RegistryObject<Block> = BLOCKS.register("limestone") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val QUARTZ: RegistryObject<Block> = BLOCKS.register("quartz") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val SANDSTONE: RegistryObject<Block> = BLOCKS.register("sandstone") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val VEHICLE_TABLE: RegistryObject<Block> = BLOCKS.register("vehicletable") {
        VehicleTable(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }
}