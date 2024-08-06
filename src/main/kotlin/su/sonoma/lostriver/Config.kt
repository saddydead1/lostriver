package su.sonoma.lostriver

import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.config.ModConfigEvent
import net.minecraftforge.registries.ForgeRegistries

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@EventBusSubscriber(modid = Lostriver.MODID, bus = EventBusSubscriber.Bus.MOD)
object Config {
    private val BUILDER = ForgeConfigSpec.Builder()

    private val LOG_DIRT_BLOCK: ForgeConfigSpec.BooleanValue = BUILDER
        .comment("Whether to log the dirt block on common setup")
        .define("logDirtBlock", true)

    private val MAGIC_NUMBER: ForgeConfigSpec.IntValue = BUILDER
        .comment("A magic number")
        .defineInRange("magicNumber", 42, 0, Int.MAX_VALUE)

    val MAGIC_NUMBER_INTRODUCTION: ForgeConfigSpec.ConfigValue<String> = BUILDER
        .comment("What you want the introduction message to be for the magic number")
        .define("magicNumberIntroduction", "The magic number is... ")

    // a list of strings that are treated as resource locations for items
    private val ITEM_STRINGS: ForgeConfigSpec.ConfigValue<List<String>> = BUILDER
        .comment("A list of items to log on common setup.")
        .defineListAllowEmpty("items", listOf("minecraft:iron_ingot")) { obj: Any -> validateItemName(obj) }

    @JvmField
    val SPEC: ForgeConfigSpec = BUILDER.build()

    var logDirtBlock: Boolean = false
    var magicNumber: Int = 0
    var magicNumberIntroduction: String? = null
    lateinit var items: Set<Item>

    private fun validateItemName(obj: Any): Boolean {
        return obj is String && ForgeRegistries.ITEMS.containsKey(ResourceLocation(obj))
    }

    @SubscribeEvent
    fun onLoad(event: ModConfigEvent?) {
        logDirtBlock = LOG_DIRT_BLOCK.get()
        magicNumber = MAGIC_NUMBER.get()
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get()

        // convert the list of strings into a set of items
        items = ITEM_STRINGS.get()
            .mapNotNull { itemName: String -> ForgeRegistries.ITEMS.getValue(ResourceLocation(itemName)) }
            .toSet()
    }
}
