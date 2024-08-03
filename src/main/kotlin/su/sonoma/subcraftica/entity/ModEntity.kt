package su.sonoma.subcraftica.entity

import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.EntityType.EntityFactory
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.MobCategory
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import software.bernie.example.registry.EntityRegistry
import su.sonoma.subcraftica.Subcraftica.MODID
import su.sonoma.subcraftica.entity.ModEntity.ENTITY_TYPES


object ModEntity {
    val ENTITY_TYPES: DeferredRegister<EntityType<*>> =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID)

    val PEEPER: RegistryObject<EntityType<PeeperEntity>> =
        registerMob("peeper", ::PeeperEntity, 0.5F, 0.2F, 2039583, 855309)
    val BOOMERANG: RegistryObject<EntityType<BoomerangEntity>> =
        registerMob("boomerang", ::BoomerangEntity, 0.5F, 0.4F, 2079543, 855309)

    fun <T : Mob> registerMob(
        name: String,
        entity: EntityFactory<T>,
        width: Float,
        height: Float,
        primaryEggColor: Int,
        secondaryEggColor: Int,
    ): RegistryObject<EntityType<T>> {
        val entityType = ENTITY_TYPES.register(
            name
        ) {
            EntityType.Builder.of(entity, MobCategory.WATER_CREATURE).sized(width, height).build(name)
        }
        return entityType
    }
}