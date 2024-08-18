package su.sonoma.lostriver.event

import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import su.sonoma.lostriver.Lostriver.MODID

object Sounds {
    val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID)

    private fun registerSoundEvent(name: String): RegistryObject<SoundEvent> {
        val id: ResourceLocation = ResourceLocation(MODID, name)
        return SOUNDS.register(name) { SoundEvent.createVariableRangeEvent(id) }
    }

    val PEEPER: RegistryObject<SoundEvent> = registerSoundEvent("peeper")
    val BOOMERANG: RegistryObject<SoundEvent> = registerSoundEvent("boomerang")
    val STALKER: RegistryObject<SoundEvent> = registerSoundEvent("stalker")
    val REAPER: RegistryObject<SoundEvent> = registerSoundEvent("reaper")
    val CYCLOP: RegistryObject<SoundEvent> = registerSoundEvent("cyclop")
    val CYCLOP_WELCOME: RegistryObject<SoundEvent> = registerSoundEvent("cyclop_welcome")
    val SEAMOTH_WELCOME: RegistryObject<SoundEvent> = registerSoundEvent("seamoth_welcome")
}