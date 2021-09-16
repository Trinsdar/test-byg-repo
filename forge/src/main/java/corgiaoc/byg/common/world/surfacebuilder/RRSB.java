package corgiaoc.byg.common.world.surfacebuilder;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Arrays;
import java.util.Random;

public class RRSB extends SurfaceBuilder<SurfaceBuilderConfig> {
    private static final BlockState WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.defaultBlockState();
    private static final BlockState ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA.defaultBlockState();
    private static final BlockState TERRACOTTA = BYGBlocks.RED_ROCK.defaultBlockState();
    private static final BlockState YELLOW_TERRACOTTA = Blocks.YELLOW_TERRACOTTA.defaultBlockState();
    private static final BlockState BROWN_TERRACOTTA = Blocks.BROWN_TERRACOTTA.defaultBlockState();
    private static final BlockState RED_TERRACOTTA = Blocks.RED_TERRACOTTA.defaultBlockState();
    private static final BlockState LIGHT_GRAY_TERRACOTTA = Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState();
    protected BlockState[] clayBands;
    protected long seed;
    protected PerlinNoiseGenerator pillarNoise;
    protected PerlinNoiseGenerator pillarRoofNoise;
    protected PerlinNoiseGenerator clayBandsOffsetNoise;

    public RRSB(Codec<SurfaceBuilderConfig> p_i51317_1_) {
        super(p_i51317_1_);
    }

    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        int i = x & 15;
        int j = z & 15;
        BlockState blockstate = TERRACOTTA;
        BlockState blockstate1 = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
        int k = (int) (noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        int l = -1;
        boolean flag1 = false;
        int i1 = 0;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (int j1 = startHeight; j1 >= 0; --j1) {
            if (i1 < 15) {
                blockpos$mutable.set(i, j1, j);
                BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
                if (blockstate2.isAir()) {
                    l = -1;
                } else if (blockstate2.getBlock() == defaultBlock.getBlock()) {
                    if (l == -1) {
                        flag1 = false;
                        if (k <= 0) {
                            blockstate = Blocks.AIR.defaultBlockState();
                            blockstate1 = defaultBlock;
                        } else if (j1 >= seaLevel - 4 && j1 <= seaLevel + 1) {
                            blockstate = TERRACOTTA;
                            blockstate1 = biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getUnderMaterial();
                        }

                        if (j1 < seaLevel && (blockstate == null || blockstate.isAir())) {
                            blockstate = defaultFluid;
                        }

                        l = k + Math.max(0, j1 - seaLevel);
                        if (j1 >= seaLevel - 1) {
                            if (j1 > seaLevel + 3 + k) {
                                BlockState blockstate3;
                                if (j1 >= 64 && j1 <= 127) {
                                    if (flag) {
                                        blockstate3 = TERRACOTTA;
                                    } else {
                                        blockstate3 = this.getBand(x, j1, z);
                                    }
                                } else {
                                    blockstate3 = TERRACOTTA;
                                }

                                chunkIn.setBlockState(blockpos$mutable, blockstate3, false);
                            } else {
                                chunkIn.setBlockState(blockpos$mutable, biomeIn.getGenerationSettings().getSurfaceBuilderConfig().getTopMaterial(), false);
                                flag1 = true;
                            }
                        } else {
                            chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                            Block block = blockstate1.getBlock();
                            if (block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA || block == Blocks.TERRACOTTA) {
                                chunkIn.setBlockState(blockpos$mutable, TERRACOTTA, false);
                            }
                        }
                    } else if (l > 0) {
                        --l;
                        if (flag1) {
                            chunkIn.setBlockState(blockpos$mutable, TERRACOTTA, false);
                        } else {
                            chunkIn.setBlockState(blockpos$mutable, this.getBand(x, j1, z), false);
                        }
                    }

                    ++i1;
                }
            }
        }

    }

    public void initNoise(long seed) {
        if (this.seed != seed || this.clayBands == null) {
            this.generateBands(seed);
        }

        if (this.seed != seed || this.pillarNoise == null || this.pillarRoofNoise == null) {
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
            this.pillarNoise = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
            this.pillarRoofNoise = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
        }

        this.seed = seed;
    }

    protected void generateBands(long p_215430_1_) {
        this.clayBands = new BlockState[64];
        Arrays.fill(this.clayBands, TERRACOTTA);
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(p_215430_1_);
        this.clayBandsOffsetNoise = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));

        for (int l1 = 0; l1 < 64; ++l1) {
            l1 += sharedseedrandom.nextInt(5) + 1;
            if (l1 < 64) {
                this.clayBands[l1] = TERRACOTTA;
            }
        }

        int i2 = sharedseedrandom.nextInt(4) + 2;

        for (int i = 0; i < i2; ++i) {
            int j = sharedseedrandom.nextInt(3) + 1;
            int k = sharedseedrandom.nextInt(64);

            for (int l = 0; k + l < 64 && l < j; ++l) {
                this.clayBands[k + l] = TERRACOTTA;
            }
        }

        int j2 = sharedseedrandom.nextInt(4) + 2;

        for (int k2 = 0; k2 < j2; ++k2) {
            int i3 = sharedseedrandom.nextInt(3) + 2;
            int l3 = sharedseedrandom.nextInt(64);

            for (int i1 = 0; l3 + i1 < 64 && i1 < i3; ++i1) {
                this.clayBands[l3 + i1] = TERRACOTTA;
            }
        }

        int l2 = sharedseedrandom.nextInt(4) + 2;

        for (int j3 = 0; j3 < l2; ++j3) {
            int i4 = sharedseedrandom.nextInt(3) + 1;
            int k4 = sharedseedrandom.nextInt(64);

            for (int j1 = 0; k4 + j1 < 64 && j1 < i4; ++j1) {
                this.clayBands[k4 + j1] = TERRACOTTA;
            }
        }

        int k3 = sharedseedrandom.nextInt(3) + 3;
        int j4 = 0;

        for (int l4 = 0; l4 < k3; ++l4) {
            int i5 = 1;
            j4 += sharedseedrandom.nextInt(16) + 4;

            for (int k1 = 0; j4 + k1 < 64 && k1 < 1; ++k1) {
                this.clayBands[j4 + k1] = TERRACOTTA;
                if (j4 + k1 > 1 && sharedseedrandom.nextBoolean()) {
                    this.clayBands[j4 + k1 - 1] = TERRACOTTA;
                }

                if (j4 + k1 < 63 && sharedseedrandom.nextBoolean()) {
                    this.clayBands[j4 + k1 + 1] = TERRACOTTA;
                }
            }
        }

    }

    protected BlockState getBand(int p_215431_1_, int p_215431_2_, int p_215431_3_) {
        int i = (int) Math.round(this.clayBandsOffsetNoise.getValue((double) p_215431_1_ / 512.0D, (double) p_215431_3_ / 512.0D, false) * 2.0D);
        return this.clayBands[(p_215431_2_ + i + 64) % 64];
    }
}