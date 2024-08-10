package su.sonoma.lostriver.recipe

import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID
import java.util.function.Supplier


object ModRecipes {
    val SERIALIZERS: DeferredRegister<RecipeSerializer<*>> =
        DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID)

    val VEHICLETABLE_SERIALIZER: RegistryObject<RecipeSerializer<VehicleTableRecipe>> =
        SERIALIZERS.register("vehicle_craft",
            Supplier<RecipeSerializer<VehicleTableRecipe>> { VehicleTableRecipe.Serializer.INSTANCE })

    fun register(eventBus: IEventBus?) {
        SERIALIZERS.register(eventBus)
    }
}