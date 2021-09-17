package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import me.shedaniel.architectury.platform.Platform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BYGSounds {

    public static final Map<ResourceLocation, SoundEvent> SOUNDS = new LinkedHashMap<>();
    public static SoundEvent AMBIENT_VISCAL_ISLES_LOOP = createSound("ambient_viscal_isles_loop");
    public static SoundEvent AMBIENT_VISCAL_ISLES_ADDITIONS = createSound("ambient_viscal_isles_additions");
    public static SoundEvent AMBIENT_WAILING_GARTH_ADDITIONS = createSound("ambient_wailing_garth_additions");
    public static SoundEvent AMBIENT_END_FOREST_LOOP = createSound("ambient_end_forest");
    public static SoundEvent AMBIENT_END_OMINOUS_LOOP = createSound("ambient_end_ominous");


    public static SoundEvent createSound(String location) {
        ResourceLocation soundLocation = new ResourceLocation(BYG.MOD_ID, location);
        SoundEvent soundEvent = new SoundEvent(soundLocation);
        if (Platform.isFabric())
        Registry.register(Registry.SOUND_EVENT, soundLocation, soundEvent);
        SOUNDS.put(soundLocation, soundEvent);
        return soundEvent;
    }
}
