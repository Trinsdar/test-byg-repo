package corgiaoc.byg.util;

import com.mojang.serialization.Codec;
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
import net.minecraftforge.common.BiomeDictionary;

public class ExpectPlatformUtilsImpl {
    public static Biome.ClimateSettings createClimate(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float humidity){
        return new Biome.ClimateSettings(precipitation, temperature, temperatureModifier, humidity);
    }

    public static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacerType(Codec<P> codec) {
        return new BlockPlacerType<>(codec);
    }

    public static Tag.Named<Block> createBlockTag(ResourceLocation location){
        return BlockTags.bind(location.toString());
    }

    public static DoorBlock createDoor(BlockBehaviour.Properties properties) {
        return new DoorBlock(properties);
    }

    public static GrassPathBlock createGrass(BlockBehaviour.Properties properties) {
        return new GrassPathBlock(properties);
    }

    public static IronBarsBlock createIronBars(BlockBehaviour.Properties properties) {
        return new IronBarsBlock(properties);
    }

    public static boolean biomeDictionaryHasType(String result, ResourceKey<Biome> biomeKey){
        return BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.getType(result.substring(1).toUpperCase()));
    }
}
