package su.sonoma.lostriver.entity

import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.EntityType.EntityFactory
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.MobCategory
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID


object ModEntity {
    val ENTITY_TYPES: DeferredRegister<EntityType<*>> =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID)

    val PEEPER: RegistryObject<EntityType<PeeperEntity>> =
        registerMob("peeper", ::PeeperEntity, 0.5F, 0.2F, MobCategory.WATER_CREATURE)

    val BOOMERANG: RegistryObject<EntityType<BoomerangEntity>> =
        registerMob("boomerang", ::BoomerangEntity, 0.5F, 0.4F, MobCategory.WATER_CREATURE)

    val STALKER: RegistryObject<EntityType<StalkerEntity>> =
        registerMob("stalker", ::StalkerEntity,4F, 2F, MobCategory.WATER_CREATURE)

    fun <T : Mob> registerMob(
        name: String,
        entity: EntityFactory<T>,
        width: Float,
        height: Float,
        category: MobCategory
    ): RegistryObject<EntityType<T>> {
        val entityType = ENTITY_TYPES.register(
            name
        ) {
            EntityType.Builder.of(entity, category).sized(width, height).build(name)
        }
        return entityType
    }

}