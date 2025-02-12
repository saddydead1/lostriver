package su.sonoma.lostriver.block

import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.minecraft.world.level.material.PushReaction
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.block.custom.BloodKelpBlock
import su.sonoma.lostriver.block.custom.BloodKelpPlantBlock
import su.sonoma.lostriver.block.custom.ModOreBlock
import su.sonoma.lostriver.block.custom.ModSandBlock


object ModBlocks {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(MODID)

    val SAND: DeferredBlock<Block> = BLOCKS.registerBlock("sand") {
        ModSandBlock(
        BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))
    }

    val BLOOD_SAND: DeferredBlock<Block> = BLOCKS.registerBlock("bloodsand") {
        ModSandBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))
    }

    val KELP_SAND: DeferredBlock<Block> = BLOCKS.registerBlock("kelpsand") {
        ModSandBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))
    }

    val PURPLEBLOCK: DeferredBlock<Block> = BLOCKS.registerBlock("purpleblock") {
        ModSandBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))
    }

    val ROYALBLOCK: DeferredBlock<Block> = BLOCKS.registerBlock("royalblock") {
        ModSandBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT))
    }

    val BLOOD_GRASS: DeferredBlock<Block> = BLOCKS.registerBlock("blood_grass") {
        SeagrassBlock(
        BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BLUEPALM: DeferredBlock<Block> = BLOCKS.registerBlock("bluepalm") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val YELLOWGRASS: DeferredBlock<Block> = BLOCKS.registerBlock("yellowgrass") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PURPLEMOSS: DeferredBlock<Block> = BLOCKS.registerBlock("purplemoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PORTAL: DeferredBlock<Block> = BLOCKS.registerBlock("portal") {
        Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE))
    }

    val MUSHROOM: DeferredBlock<Block> = BLOCKS.registerBlock("mushroom") {
        SlabBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM).noOcclusion())
    }

    val MUSHROOMSTEW: DeferredBlock<Block> = BLOCKS.registerBlock("mushroomstew") { // its not stew lmao its stem
        Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM))
    }

    val ROYALMOSS: DeferredBlock<Block> = BLOCKS.registerBlock("royalmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BASKET: DeferredBlock<Block> = BLOCKS.registerBlock("basket") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PAPYRUS: DeferredBlock<Block> = BLOCKS.registerBlock("papyrus") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val GREENCOVERMOSS: DeferredBlock<Block> = BLOCKS.registerBlock("greencovermoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val SAFESHALLOWMOSS: DeferredBlock<Block> = BLOCKS.registerBlock("safeshallowmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val VEINED: DeferredBlock<Block> = BLOCKS.registerBlock("veined") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val ACIDMUSHROOM: DeferredBlock<Block> = BLOCKS.registerBlock("acidmushroom") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val DEEPACIDMUSHROOM: DeferredBlock<Block> = BLOCKS.registerBlock("deepacidmushroom") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BLOOD_MOSS: DeferredBlock<Block> = BLOCKS.registerBlock("bloodmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BLOODKELP_MOSS: DeferredBlock<Block> = BLOCKS.registerBlock("bloodkelpmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val DOUBLEKELP: DeferredBlock<Block> = BLOCKS.registerBlock("double_kelp") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val LIMESTONE: DeferredBlock<Block> = BLOCKS.registerBlock("limestone") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val CORAL: DeferredBlock<Block> = BLOCKS.registerBlock("coral") {
        ModSandBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).requiresCorrectToolForDrops().sound(SoundType.CORAL_BLOCK)
        )
    }

    val BLOODSTONE: DeferredBlock<Block> = BLOCKS.registerBlock("bloodstone") {
        ModSandBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
        )
    }

    val QUARTZ: DeferredBlock<Block> = BLOCKS.registerBlock("quartz") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val SANDSTONE: DeferredBlock<Block> = BLOCKS.registerBlock("sandstone") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val TABLECORAL: DeferredBlock<Block> = BLOCKS.registerBlock("tablecoral") {
        SeagrassBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val LITHIUM: DeferredBlock<Block> = BLOCKS.registerBlock("lithium") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val BLOOD_KELP_PLANT: DeferredBlock<Block> = BLOCKS.registerBlock(
        "blood_kelp_plant") {
        BloodKelpPlantBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().instabreak().sound(
                SoundType.WET_GRASS
            ).pushReaction(PushReaction.DESTROY)
        )
    }

    val BLOOD_KELP: DeferredBlock<Block> = BLOCKS.registerBlock(
        "blood_kelp") {
        BloodKelpBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().randomTicks().instabreak().sound(
                SoundType.WET_GRASS
            ).pushReaction(PushReaction.DESTROY)
        )
    }


}