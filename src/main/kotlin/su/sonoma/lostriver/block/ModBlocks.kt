package su.sonoma.lostriver.block

import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SeagrassBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.block.custom.ModOreBlock
import su.sonoma.lostriver.block.custom.ModSandBlock


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

    val PURPLEBLOCK: RegistryObject<Block> = BLOCKS.register("purpleblock") {
        ModSandBlock(
            BlockBehaviour.Properties.copy(Blocks.DIRT))
    }

    val ROYALBLOCK: RegistryObject<Block> = BLOCKS.register("royalblock") {
        ModSandBlock(
            BlockBehaviour.Properties.copy(Blocks.DIRT))
    }

    val BLOOD_GRASS: RegistryObject<Block> = BLOCKS.register("blood_grass") {
        SeagrassBlock(
        BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PURPLEMOSS: RegistryObject<Block> = BLOCKS.register("purplemoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PORTAL: RegistryObject<Block> = BLOCKS.register("portal") {
        ModPortalBlock(
            BlockBehaviour.Properties.copy(Blocks.STONE))
    }

    val ROYALMOSS: RegistryObject<Block> = BLOCKS.register("royalmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BASKET: RegistryObject<Block> = BLOCKS.register("basket") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PAPYRUS: RegistryObject<Block> = BLOCKS.register("papyrus") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val GREENCOVERMOSS: RegistryObject<Block> = BLOCKS.register("greencovermoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val SAFESHALLOWMOSS: RegistryObject<Block> = BLOCKS.register("safeshallowmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val VEINED: RegistryObject<Block> = BLOCKS.register("veined") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val ACIDMUSHROOM: RegistryObject<Block> = BLOCKS.register("acidmushroom") {
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

    val CORAL: RegistryObject<Block> = BLOCKS.register("coral") {
        ModSandBlock(
            BlockBehaviour.Properties.copy(Blocks.DIRT).requiresCorrectToolForDrops().sound(SoundType.CORAL_BLOCK)
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

}