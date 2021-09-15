package corgiaoc.byg.common.world.feature;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.NoisySphereConfig;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class NoisyCaveSphereWater extends Feature<NoisySphereConfig> {
    public static FastNoise fastNoise;
    protected static long seed;

    public NoisyCaveSphereWater(Codec<NoisySphereConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoisySphereConfig config) {
        setSeed(world.getSeed());

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(position);
        BlockPos.MutableBlockPos mutable2 = new BlockPos.MutableBlockPos().set(mutable);
        int stackHeight = random.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        int xRadius = config.getRandomXRadius(random);
        int yRadius = config.getRandomYRadius(random);
        int zRadius = config.getRandomZRadius(random);

        for (int stackIDX = 0; stackIDX < stackHeight; stackIDX++) {
            for (int x = -xRadius; x <= xRadius; x++) {
                for (int z = -zRadius; z <= zRadius; z++) {
                    for (int y = -yRadius; y <= 0; y++) {
                        mutable.setY(world.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, mutable.getX() + x, mutable.getZ() + z));
                        mutable2.set(mutable).move(x, y, z);
                        ChunkAccess chunk = world.getChunk(mutable2);
//                        BitSet airCarvingMask = ((ChunkPrimer) chunk).getOrAddCarvingMask(GenerationStage.Carving.AIR);

                        //Credits to Hex_26 for this equation!
                        double equationResult = Math.pow(x, 2) / Math.pow(xRadius, 2) + Math.pow(y, 2) / Math.pow(yRadius, 2) + Math.pow(z, 2) / Math.pow(zRadius, 2);
                        double threshold = 1 + 0.7 * fastNoise.GetNoise(mutable2.getX(), mutable2.getY(), mutable2.getZ());
                        if (equationResult >= threshold)
                            continue;

                        if (world.getBlockState(mutable2).canOcclude()) {
                            int bitIndex = (mutable2.getX() & 0xF) | ((mutable2.getZ() & 0xF) << 4) | (mutable2.getY() << 8);
//                            airCarvingMask.set(bitIndex);
                            world.setBlock(mutable2, Blocks.WATER.defaultBlockState(), 2);
                            world.getLiquidTicks().scheduleTick(mutable2, Fluids.WATER, 0);
                        }
                    }
                    xRadius = (int) (xRadius / config.getRadiusDivisorPerStack());
                    yRadius = (int) (yRadius / config.getRadiusDivisorPerStack());
                    zRadius = (int) (zRadius / config.getRadiusDivisorPerStack());
                }
            }
        }
        return true;
    }


    public static void setSeed(long worldSeed) {
        if (seed != worldSeed || fastNoise == null) {
            fastNoise = new FastNoise((int) worldSeed);
            fastNoise.SetNoiseType(FastNoise.NoiseType.Simplex);
            fastNoise.SetFrequency(0.09f);
            seed = worldSeed;
        }
    }
}