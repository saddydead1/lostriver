package su.sonoma.lostriver.datacomponent

import net.minecraft.core.component.DataComponentType
import net.neoforged.neoforge.registries.DeferredRegister
import su.sonoma.lostriver.Lostriver.MODID
import su.sonoma.lostriver.item.OxygenTankArmorItem
import java.util.function.Supplier


object ModDataComponents {
    val DATA_COMPONENT_TYPES: DeferredRegister.DataComponents =
        DeferredRegister.createDataComponents(MODID)

    val OXYGEN: Supplier<DataComponentType<OxygenTankArmorItem.Oxygen>> =
        DATA_COMPONENT_TYPES.registerComponentType(
            "oxygen"
        ) { builder ->
            builder
                .persistent(OxygenTankArmorItem.Oxygen.CODEC)
                .networkSynchronized(OxygenTankArmorItem.Oxygen.NETWORK_CODEC)
                .cacheEncoding()
        }
}