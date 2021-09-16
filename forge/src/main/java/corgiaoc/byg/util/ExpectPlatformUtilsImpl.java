package corgiaoc.byg.util;

import com.mojang.serialization.Codec;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.GrassPathBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.placer.BlockPlacer;
import net.minecraft.world.gen.placer.BlockPlacerType;
import net.minecraftforge.common.BiomeDictionary;

public class ExpectPlatformUtilsImpl {

    public static Biome.ClimateSettings createClimate(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float humidity){
        throw new AssertionError();
    }


    public static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacerType(Codec<P> codec) {
        throw new AssertionError();
    }


    public static Tag.Named<Block> createBlockTag(ResourceLocation location){
        return BlockTags.bind(location);
    }


    public static DoorBlock createDoor(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }


    public static GrassPathBlock createGrass(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }


    public static IronBarsBlock createIronBars(BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }


    public static boolean biomeDictionaryHasType(String result, ResourceKey<Biome> biomeKey){
        return BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.getType(result.substring(1).toUpperCase()));;
    }
}
