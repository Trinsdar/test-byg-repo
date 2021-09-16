package corgiaoc.byg.util;

import com.mojang.serialization.Codec;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.GrassPathBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ExpectPlatformUtils {
    @ExpectPlatform
    public static Biome.ClimateSettings createClimate(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float humidity){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacerType(Codec<P> codec) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Tag.Named<Block> createBlockTag(ResourceLocation location){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static DoorBlock createDoor(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static GrassPathBlock createGrass(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static IronBarsBlock createIronBars(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
}
