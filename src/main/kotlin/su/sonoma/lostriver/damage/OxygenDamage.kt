package su.sonoma.lostriver.damage

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.damagesource.DamageSource
import net.minecraft.world.damagesource.DamageType
import net.minecraft.world.entity.Entity
import su.sonoma.lostriver.Lostriver.MODID


class OxygenDamage(val causer: Entity) {
    val OXYGEN_DAMAGE: ResourceKey<DamageType> = ResourceKey.create(
        Registries.DAMAGE_TYPE,
        ResourceLocation.fromNamespaceAndPath(MODID, "oxygen")
    )

    fun source(): DamageSource {
        return DamageSource(
            causer.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(OXYGEN_DAMAGE)
        )
    }
}