package corgiaoc.byg.mixin.common.world.layers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.util.ExpectPlatformUtils;
import corgiaoc.byg.util.LayerRandomWeightedListUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.area.Area;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.RegionHillsLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@Mixin(RegionHillsLayer.class)
public abstract class MixinHillsLayer {

    private static final List<Biome> topOceanList = new ArrayList<>();


    @SuppressWarnings("ConstantConditions")
    @Inject(method = "applyPixel",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/level/newbiome/context/Context;nextRandom(I)I"),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void injectBYGSubBiomes(Context rand, Area area1, Area area2, int x, int z, CallbackInfoReturnable<Integer> cir, int i, int j, int k) {
        if (rand.nextRandom(9) == 0 || k == 0) {
            int l = i;
            Biome biome = BuiltinRegistries.BIOME.byId(i);
            if (topOceanList.contains(biome))
                l = BuiltinRegistries.BIOME.getId(BYGBiomes.TROPICAL_ISLAND);
            cir.setReturnValue(l);
        }
    }


    static {
        topOceanList.add(ExpectPlatformUtils.getOrThrow(Biomes.DEEP_OCEAN));
        topOceanList.add(ExpectPlatformUtils.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN));
        topOceanList.add(ExpectPlatformUtils.getOrThrow(Biomes.DEEP_WARM_OCEAN));
    }
}
