package corgiaoc.byg.util;

import com.mojang.serialization.Codec;
import corgiaoc.byg.mixin.access.BiomeClimateSettingsAccess;
import corgiaoc.byg.mixin.access.BlockPlacerTypeAccess;
import corgiaoc.byg.mixin.access.BlockTagsAccess;
import corgiaoc.byg.mixin.access.DoorBlockAccess;
import corgiaoc.byg.mixin.access.GrassPathBlockAccess;
import corgiaoc.byg.mixin.access.IronBarsBlockAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.GrassPathBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;


public class ExpectPlatformUtilsImpl {
    public static Biome.ClimateSettings createClimate(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float humidity){
        return BiomeClimateSettingsAccess.create(precipitation, temperature, temperatureModifier, humidity);
    }


    public static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacerType(Codec<P> codec) {
        return BlockPlacerTypeAccess.create(codec);
    }


    public static Tag.Named<Block> createBlockTag(ResourceLocation location){
        return BlockTagsAccess.invokeBind(location.toString());
    }


    public static DoorBlock createDoor(BlockBehaviour.Properties properties) {
        return DoorBlockAccess.create(properties);
    }


    public static GrassPathBlock createGrass(BlockBehaviour.Properties properties) {
        return GrassPathBlockAccess.create(properties);
    }


    public static IronBarsBlock createIronBars(BlockBehaviour.Properties properties) {
        return IronBarsBlockAccess.create(properties);
    }


    public static boolean biomeDictionaryHasType(String result, ResourceKey<Biome> biomeKey){
        return true;
    }
}
