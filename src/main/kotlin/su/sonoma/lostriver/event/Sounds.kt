package su.sonoma.lostriver.event

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.neoforged.neoforge.registries.DeferredRegister
import su.sonoma.lostriver.Lostriver.MODID
import java.util.function.Supplier

object Sounds {
    val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MODID)

    private fun registerSoundEvent(name: String): Supplier<SoundEvent> {
        val id: ResourceLocation = ResourceLocation.fromNamespaceAndPath(MODID, name)
        return SOUNDS.register(name, Supplier { SoundEvent.createVariableRangeEvent(id) } )
    }

    val PEEPER: Supplier<SoundEvent> = registerSoundEvent("peeper")
    val BOOMERANG: Supplier<SoundEvent> = registerSoundEvent("boomerang")
    val STALKER: Supplier<SoundEvent> = registerSoundEvent("stalker")
    val REAPER: Supplier<SoundEvent> = registerSoundEvent("reaper")
    val CYCLOP: Supplier<SoundEvent> = registerSoundEvent("cyclop")
    val CYCLOP_WELCOME: Supplier<SoundEvent> = registerSoundEvent("cyclop_welcome")
    val SEAMOTH_WELCOME: Supplier<SoundEvent> = registerSoundEvent("seamoth_welcome")
    val GHOSTLEVIATHAN: Supplier<SoundEvent> = registerSoundEvent("ghostleviathan")
}