package su.sonoma.lostriver.entity

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.EntityType.EntityFactory
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.MobCategory
import net.neoforged.neoforge.registries.DeferredRegister
import su.sonoma.lostriver.Lostriver.MODID
import java.util.function.Supplier


object ModEntity {
    val ENTITY_TYPES: DeferredRegister<EntityType<*>> =
        DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MODID)

    val PEEPER: Supplier<EntityType<PeeperEntity>> =
        registerMob("peeper", ::PeeperEntity, 0.5F, 0.2F, MobCategory.WATER_AMBIENT)

    val BLADDER: Supplier<EntityType<BladderEntity>> =
        registerMob("bladderfish", ::BladderEntity, 0.5F, 0.6F, MobCategory.WATER_AMBIENT)

    val BOOMERANG: Supplier<EntityType<BoomerangEntity>> =
        registerMob("boomerang", ::BoomerangEntity, 0.5F, 0.4F, MobCategory.WATER_AMBIENT)

    val STALKER: Supplier<EntityType<StalkerEntity>> =
        registerMob("stalker", ::StalkerEntity,2F, 2F, MobCategory.WATER_AMBIENT)

    val REAPER: Supplier<EntityType<ReaperEntity>> =
        registerMob("reaper", ::ReaperEntity,11F, 5F, MobCategory.WATER_AMBIENT)

    val GHOST_LEVIATHAN: Supplier<EntityType<GhostLeviathanEntity>> =
        registerMob("ghost_leviathan", ::GhostLeviathanEntity,11F, 5F, MobCategory.WATER_AMBIENT)

    val JELLYRAY: Supplier<EntityType<JellyrayEntity>> =
        registerMob("jellyray", ::JellyrayEntity,2F, 0.5F, MobCategory.WATER_AMBIENT)

//    val SEAMOTH: Supplier<EntityType<SeamothEntity>> =
//        registerBoat("seamoth", EntityType.Builder.of(::SeamothEntity , MobCategory.MISC
//        ).sized(1.6f, 1.6f).clientTrackingRange(1)
//        )

//    val CYCLOP: Supplier<EntityType<CyclopEntity>> =
//        registerBoat("cyclop", EntityType.Builder.of(::CyclopEntity , MobCategory.MISC
//        ).sized(1.6f, 1.6f).clientTrackingRange(1)
//        )

//    private fun <T : Entity?> registerBoat(name: String, builder: EntityType.Builder<T>): Supplier<EntityType<T>> {
//        return ENTITY_TYPES.register(name) { builder.build("lostriver:$name") }
//    }
    

    fun <T : Mob> registerMob(
        name: String,
        entity: EntityFactory<T>,
        width: Float,
        height: Float,
        category: MobCategory,
    ): Supplier<EntityType<T>> {
        val entityType = ENTITY_TYPES.register(name, Supplier { EntityType.Builder.of(entity, category).sized(width, height).build(name) } )
        return entityType
    }

}