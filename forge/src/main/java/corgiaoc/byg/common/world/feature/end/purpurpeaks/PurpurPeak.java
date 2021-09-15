package corgiaoc.byg.common.world.feature.end.purpurpeaks;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class PurpurPeak extends Feature<SimpleBlockProviderConfig> {

    FastNoiseLite fnlPerlin = null;

    public PurpurPeak(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        if (world.getBlockState(pos.below()).getMaterial() == Material.AIR || world.getBlockState(pos.below()).getMaterial() == Material.WATER || world.getBlockState(pos.below()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Type.MOTION_BLOCKING, pos.getX(), pos.getZ()) < 4)
            return false;


        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double baseRadius = 15;
        int peakHeight = 125;
        int peakStartHeight = peakHeight - 5;
        double threshold = 0.5;

        for (double y = -peakHeight; y <= peakHeight; y++) {
            for (double x = -peakHeight; x <= peakHeight; x++) {
                for (double z = -peakHeight; z <= peakHeight; z++) {
                    mutable.set(pos).move((int) x, (int) y + peakStartHeight, (int)z);
                    float noise3 = FastNoiseLite.getSpongePerlinValue(fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));
                    double scaledNoise = (noise3 / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (y == -peakHeight) {
                        if (scaledNoise >= threshold)
                            if (world.getBlockState(mutable.relative(Direction.DOWN)).getMaterial() == Material.AIR)
                                return false;
                    }

                    if (scaledNoise >= threshold) {
                        if (world.isEmptyBlock(mutable))
                            world.setBlock(mutable, config.getBlockProvider().getState(rand, mutable), 2);
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (fnlPerlin == null) {
            fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
            fnlPerlin.SetFrequency(0.2F);
        }
    }
}
