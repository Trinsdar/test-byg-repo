package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(StructureFeature.class)
public interface StructureAccess {

    @Accessor("STEP")
    static Map<StructureFeature<?>, GenerationStep.Decoration> getStructureStep() {
        throw new Error("Mixin did not apply!");
    }
}
