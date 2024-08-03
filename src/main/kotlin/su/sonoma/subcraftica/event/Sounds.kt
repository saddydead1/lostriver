package su.sonoma.subcraftica.event

import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.subcraftica.Subcraftica.MODID

object Sounds {
    val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID)

    private fun registerSoundEvent(name: String): RegistryObject<SoundEvent> {
        val id: ResourceLocation = ResourceLocation(MODID, name)
        return SOUNDS.register(name) { SoundEvent.createVariableRangeEvent(id) }
    }

    val PEEPER: RegistryObject<SoundEvent> = registerSoundEvent("peeper")
}