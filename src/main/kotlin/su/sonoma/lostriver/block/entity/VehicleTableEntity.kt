package su.sonoma.lostriver.block.entity

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.network.protocol.Packet
import net.minecraft.network.protocol.game.ClientGamePacketListener
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket
import net.minecraft.world.Containers
import net.minecraft.world.MenuProvider
import net.minecraft.world.SimpleContainer
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.ContainerData
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ForgeCapabilities
import net.minecraftforge.common.util.LazyOptional
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.ItemStackHandler
import su.sonoma.lostriver.recipe.VehicleTableRecipe
import su.sonoma.lostriver.screen.VehicleTableMenu
import java.util.*

class VehicleTableEntity(pPos: BlockPos?, pBlockState: BlockState?) :
    BlockEntity(ModBlockEntities.VEHICLE_TABLE.get(), pPos, pBlockState), MenuProvider {
    private val itemHandler: ItemStackHandler = object : ItemStackHandler(2) {
        override fun onContentsChanged(slot: Int) {
            setChanged()
            if (!level!!.isClientSide()) {
                level!!.sendBlockUpdated(blockPos, blockState, blockState, 3)
            }
        }
    }

    val renderStack: ItemStack
        get() = if (itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty) {
            itemHandler.getStackInSlot(INPUT_SLOT)
        } else {
            itemHandler.getStackInSlot(OUTPUT_SLOT)
        }

    private var lazyItemHandler: LazyOptional<IItemHandler> = LazyOptional.empty()

    protected val data: ContainerData
    private var progress = 0
    private var maxProgress = 78

    init {
        this.data = object : ContainerData {
            override fun get(pIndex: Int): Int {
                return when (pIndex) {
                    0 -> this@VehicleTableEntity.progress
                    1 -> this@VehicleTableEntity.maxProgress
                    else -> 0
                }
            }

            override fun set(pIndex: Int, pValue: Int) {
                when (pIndex) {
                    0 -> this@VehicleTableEntity.progress = pValue
                    1 -> this@VehicleTableEntity.maxProgress = pValue
                }
            }

            override fun getCount(): Int {
                return 2
            }
        }
    }


    override fun <T> getCapability(cap: Capability<T>, side: Direction?): LazyOptional<T> {
        if (cap === ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast()
        }

        return super.getCapability(cap, side)
    }

    override fun onLoad() {
        super.onLoad()
        lazyItemHandler = LazyOptional.of { itemHandler }
    }

    override fun invalidateCaps() {
        super.invalidateCaps()
        lazyItemHandler.invalidate()
    }

    fun drops() {
        val inventory = SimpleContainer(itemHandler.slots)
        for (i in 0 until itemHandler.slots) {
            inventory.setItem(i, itemHandler.getStackInSlot(i))
        }
        Containers.dropContents(this.level, this.worldPosition, inventory)
    }

    override fun getDisplayName(): Component {
        return Component.translatable("block.lostriver.vehicletable")
    }

    override fun createMenu(pContainerId: Int, pPlayerInventory: Inventory, pPlayer: Player): AbstractContainerMenu? {
        return VehicleTableMenu(pContainerId, pPlayerInventory, this, this.data)
    }

    override fun saveAdditional(pTag: CompoundTag) {
        pTag.put("inventory", itemHandler.serializeNBT())
        pTag.putInt("vehicletable.progress", progress)

        super.saveAdditional(pTag)
    }

    override fun load(pTag: CompoundTag) {
        super.load(pTag)
        itemHandler.deserializeNBT(pTag.getCompound("inventory"))
        progress = pTag.getInt("vehicletable.progress")
    }

    fun tick(pLevel: Level?, pPos: BlockPos?, pState: BlockState?) {
        if (hasRecipe()) {
            increaseCraftingProgress()
            setChanged(pLevel, pPos, pState)

            if (hasProgressFinished()) {
                craftItem()
                resetProgress()
            }
        } else {
            resetProgress()
        }
    }

    private fun resetProgress() {
        progress = 0
    }

    private fun craftItem() {
        val recipe: Optional<VehicleTableRecipe> = currentRecipe
        val result: ItemStack = recipe.get().getResultItem(null)

        itemHandler.extractItem(INPUT_SLOT, 1, false)

        itemHandler.setStackInSlot(
            OUTPUT_SLOT, ItemStack(
                result.item,
                itemHandler.getStackInSlot(OUTPUT_SLOT).count + result.count
            )
        )
    }

    private fun hasRecipe(): Boolean {
        val recipe: Optional<VehicleTableRecipe> = currentRecipe

        if (recipe.isEmpty()) {
            return false
        }
        val result: ItemStack = recipe.get().getResultItem(getLevel()!!.registryAccess())

        return canInsertAmountIntoOutputSlot(result.count) && canInsertItemIntoOutputSlot(result.item)
    }

    private val currentRecipe: Optional<VehicleTableRecipe>
        get() {
            val inventory = SimpleContainer(itemHandler.slots)
            for (i in 0 until itemHandler.slots) {
                inventory.setItem(i, itemHandler.getStackInSlot(i))
            }

            return level!!.recipeManager.getRecipeFor<SimpleContainer, VehicleTableRecipe>(
                VehicleTableRecipe.Type.INSTANCE,
                inventory,
                level
            )
        }

    private fun canInsertItemIntoOutputSlot(item: Item): Boolean {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty || itemHandler.getStackInSlot(OUTPUT_SLOT).`is`(item)
    }

    private fun canInsertAmountIntoOutputSlot(count: Int): Boolean {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).count + count <= itemHandler.getStackInSlot(OUTPUT_SLOT).maxStackSize
    }

    private fun hasProgressFinished(): Boolean {
        return progress >= maxProgress
    }

    private fun increaseCraftingProgress() {
        progress++
    }

    override fun getUpdatePacket(): Packet<ClientGamePacketListener>? {
        return ClientboundBlockEntityDataPacket.create(this)
    }

    override fun getUpdateTag(): CompoundTag {
        return saveWithoutMetadata()
    }


    companion object {
        private const val INPUT_SLOT = 0
        private const val OUTPUT_SLOT = 1

    }
}