package su.sonoma.lostriver.block.entity

import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.block.ModBlocks
import java.util.function.Supplier


object ModBlockEntities {
    val BLOCK_ENTITIES: DeferredRegister<BlockEntityType<*>> =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID)

    val VEHICLE_TABLE: RegistryObject<BlockEntityType<VehicleTableEntity>> =
        BLOCK_ENTITIES.register("vehicle_table") {
            BlockEntityType.Builder.of(::VehicleTableEntity,
                ModBlocks.VEHICLE_TABLE.get()
            ).build(null)
        }
}