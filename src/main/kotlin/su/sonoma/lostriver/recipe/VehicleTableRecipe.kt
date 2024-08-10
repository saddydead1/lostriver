package su.sonoma.lostriver.recipe

import com.google.gson.JsonObject
import net.minecraft.core.NonNullList
import net.minecraft.core.RegistryAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.GsonHelper
import net.minecraft.world.SimpleContainer
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.*
import net.minecraft.world.level.Level
import su.sonoma.lostriver.Lostriver.MODID

class VehicleTableRecipe(
    private val inputItems: NonNullList<Ingredient>,
    private val output: ItemStack,
    private val id: ResourceLocation,
) :
    Recipe<SimpleContainer> {
    override fun matches(pContainer: SimpleContainer, pLevel: Level): Boolean {
        if (pLevel.isClientSide()) {
            return false
        }

        return inputItems[0].test(pContainer.getItem(0))
    }

    override fun getIngredients(): NonNullList<Ingredient> {
        return inputItems
    }

    override fun assemble(pContainer: SimpleContainer, pRegistryAccess: RegistryAccess): ItemStack {
        return output.copy()
    }

    override fun canCraftInDimensions(pWidth: Int, pHeight: Int): Boolean {
        return true
    }

    override fun getResultItem(pRegistryAccess: RegistryAccess?): ItemStack {
        return output.copy()
    }

    override fun getId(): ResourceLocation {
        return id
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return Serializer.INSTANCE
    }

    override fun getType(): RecipeType<*> {
        return Type.INSTANCE
    }

    object Type : RecipeType<VehicleTableRecipe> {
        val INSTANCE: Type = Type
        const val ID: String = "vehicle_craft"
    }

    class Serializer : RecipeSerializer<VehicleTableRecipe> {
        override fun fromJson(pRecipeId: ResourceLocation, pSerializedRecipe: JsonObject): VehicleTableRecipe {
            val output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"))

            val ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients")
            val inputs = NonNullList.withSize(1, Ingredient.EMPTY)

            for (i in inputs.indices) {
                inputs[i] = Ingredient.fromJson(ingredients[i])
            }

            return VehicleTableRecipe(inputs, output, pRecipeId)
        }

        override fun fromNetwork(pRecipeId: ResourceLocation, pBuffer: FriendlyByteBuf): VehicleTableRecipe? {
            val inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY)

            for (i in inputs.indices) {
                inputs[i] = Ingredient.fromNetwork(pBuffer)
            }

            val output = pBuffer.readItem()
            return VehicleTableRecipe(inputs, output, pRecipeId)
        }

        override fun toNetwork(pBuffer: FriendlyByteBuf, pRecipe: VehicleTableRecipe?) {
            pBuffer.writeInt(pRecipe!!.inputItems.size)

            for (ingredient in pRecipe.ingredients) {
                ingredient.toNetwork(pBuffer)
            }

            pBuffer.writeItemStack(pRecipe.getResultItem(null), false)
        }

        companion object {
            val INSTANCE: Serializer = Serializer()
            val ID: ResourceLocation = ResourceLocation(MODID, "vehicle_craft")
        }
    }
}