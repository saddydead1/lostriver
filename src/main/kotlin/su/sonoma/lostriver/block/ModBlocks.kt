package su.sonoma.lostriver.block

import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor
import net.minecraft.world.level.material.PushReaction
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.block.custom.BloodKelpBlock
import su.sonoma.lostriver.block.custom.BloodKelpPlantBlock
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

    val BLUEPALM: RegistryObject<Block> = BLOCKS.register("bluepalm") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val YELLOWGRASS: RegistryObject<Block> = BLOCKS.register("yellowgrass") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PURPLEMOSS: RegistryObject<Block> = BLOCKS.register("purplemoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val PORTAL: RegistryObject<Block> = BLOCKS.register("portal") {
        Block(
            BlockBehaviour.Properties.copy(Blocks.STONE))
    }

    val MUSHROOM: RegistryObject<Block> = BLOCKS.register("mushroom") {
        SlabBlock(
            BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM).noOcclusion())
    }

    val MUSHROOMSTEW: RegistryObject<Block> = BLOCKS.register("mushroomstew") {
        Block(
            BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM))
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

    val DEEPACIDMUSHROOM: RegistryObject<Block> = BLOCKS.register("deepacidmushroom") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BLOOD_MOSS: RegistryObject<Block> = BLOCKS.register("bloodmoss") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val BLOODKELP_MOSS: RegistryObject<Block> = BLOCKS.register("bloodkelpmoss") {
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

    val BLOODSTONE: RegistryObject<Block> = BLOCKS.register("bloodstone") {
        ModSandBlock(
            BlockBehaviour.Properties.copy(Blocks.DIRT).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
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

    val TABLECORAL: RegistryObject<Block> = BLOCKS.register("tablecoral") {
        SeagrassBlock(
            BlockBehaviour.Properties.copy(Blocks.SEAGRASS).noOcclusion().noCollission())
    }

    val LITHIUM: RegistryObject<Block> = BLOCKS.register("lithium") {
        ModOreBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                .requiresCorrectToolForDrops().strength(1.5f, 6.0f).noOcclusion()
        )
    }

    val BLOOD_KELP_PLANT: RegistryObject<Block> = BLOCKS.register(
        "blood_kelp_plant") {
        BloodKelpPlantBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().instabreak().sound(
                SoundType.WET_GRASS
            ).pushReaction(PushReaction.DESTROY)
        )
    }

    val BLOOD_KELP: RegistryObject<Block> = BLOCKS.register(
        "blood_kelp") {
        BloodKelpBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().randomTicks().instabreak().sound(
                SoundType.WET_GRASS
            ).pushReaction(PushReaction.DESTROY)
        )
    }


}