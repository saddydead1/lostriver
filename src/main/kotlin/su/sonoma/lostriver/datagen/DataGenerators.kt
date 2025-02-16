package su.sonoma.lostriver.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider
import net.neoforged.neoforge.data.event.GatherDataEvent
import su.sonoma.lostriver.Lostriver.MODID
import java.util.concurrent.CompletableFuture


@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val packOutput = generator.packOutput
//        val existingFileHelper = event.existingFileHelper
        val lookupProvider = event.lookupProvider


        generator.addProvider(event.includeServer(), ModWorldGenProvider(packOutput, lookupProvider))
    }
}