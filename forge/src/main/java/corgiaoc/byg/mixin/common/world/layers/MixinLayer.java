package corgiaoc.byg.mixin.common.world.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Layer.class)
public class MixinLayer {

    @Shadow @Final private LazyArea area;

    @Inject(method = "get", at = @At("RETURN"), cancellable = true)
    private void returnBYGOceans(Registry<Biome> registry, int x, int z, CallbackInfoReturnable<Biome> cir) {
        

    }
}
