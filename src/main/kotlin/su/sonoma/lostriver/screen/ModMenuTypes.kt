package su.sonoma.lostriver.screen

import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.MenuType
import net.minecraftforge.common.extensions.IForgeMenuType
import net.minecraftforge.network.IContainerFactory
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID


object ModMenuTypes {
    val MENUS: DeferredRegister<MenuType<*>> =
        DeferredRegister.create<MenuType<*>>(ForgeRegistries.MENU_TYPES, MODID)

    val VEHICLE_TABLE_MENU: RegistryObject<MenuType<VehicleTableMenu>> =
        registerMenuType<VehicleTableMenu>("vehicletable_menu", ::VehicleTableMenu )


    private fun <T : AbstractContainerMenu?> registerMenuType(
        name: String,
        factory: IContainerFactory<T>,
    ): RegistryObject<MenuType<T>> {
        return MENUS.register(
            name
        ) { IForgeMenuType.create(factory) }
    }
}