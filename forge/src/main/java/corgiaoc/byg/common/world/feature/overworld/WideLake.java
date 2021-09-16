package corgiaoc.byg.common.world.feature.overworld;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.Set;


public class WideLake extends Feature<SimpleBlockProviderConfig> {

    protected static final Set<Material> unacceptableSolidMaterials = ImmutableSet.of(Material.BAMBOO, Material.BAMBOO_SAPLING, Material.LEAVES, Material.WEB, Material.CACTUS, Material.HEAVY_METAL, Material.VEGETABLE, Material.CAKE, Material.EGG, Material.BARRIER, Material.CAKE);

    protected long noiseSeed;
    protected PerlinNoiseGenerator noiseGen;

    public void setSeed(long seed) {
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        if (this.noiseSeed != seed || this.noiseGen == null) {
            this.noiseGen = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
        }

        this.noiseSeed = seed;
    }


    public WideLake(Codec<SimpleBlockProviderConfig> configFactory) {
        super(configFactory);
    }


    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkSettings, Random random, BlockPos position, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(position.below(2));

        // creates the actual lakes
        boolean containedFlag;
        Material material;
        BlockState blockState;
        for (int x = -2; x < 18; ++x) {
            for (int z = -2; z < 18; ++z) {

                int xTemp = x - 10;
                int zTemp = z - 10;
                //circle shaped
                if (xTemp * xTemp + zTemp * zTemp < 64) {

                    double samplePerlin1 = (this.noiseGen.getValue(
                            (double) position.getX() + x * 0.05D,
                            (double) position.getZ() + z * 0.05D, true) + 1)
                            * 3.0D;

                    for (int y = 0; y > -samplePerlin1; --y) {

                        mutable.set(position).move(x, y, z);

                        // checks if the spot is solid all around (diagonally too) and has nothing solid above it
                        containedFlag = checkIfValidSpot(world, mutable, samplePerlin1);

                        // Is spot within the mask (sorta a roundish area) and is contained
                        if (containedFlag) {
                            // check below without moving down

                            // sets the fluid block
                            BlockState configState = config.getBlockProvider().getState(random, mutable);

                            world.setBlock(mutable, configState, 3);
                            if (configState == Blocks.WATER.defaultBlockState())
                                world.getLiquidTicks().scheduleTick(mutable, Fluids.WATER, 0);
                            else if (configState == Blocks.LAVA.defaultBlockState())
                                world.getLiquidTicks().scheduleTick(mutable, Fluids.LAVA, 0);

                            // remove floating plants so they aren't hovering.
                            // check above while moving up one.
                            blockState = world.getBlockState(mutable.move(Direction.UP));
                            material = blockState.getMaterial();

                            if (material == Material.PLANT && blockState.getBlock() != Blocks.LILY_PAD && blockState.getBlock() != BYGBlocks.ENDER_LILY && blockState.getBlock() != BYGBlocks.TINY_LILYPADS) {
                                world.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);

                                // recursively moves up and breaks floating sugar cane
                                while (mutable.getY() < world.getMaxBuildHeight() && world.getBlockState(mutable.move(Direction.UP)) == Blocks.SUGAR_CANE.defaultBlockState()) {
                                    world.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);
                                }
                            }
                            if (material == Material.REPLACEABLE_PLANT && blockState.getBlock() != Blocks.VINE) {
                                world.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);
                                world.setBlock(mutable.above(), Blocks.AIR.defaultBlockState(), 2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    /**
     * checks if the spot is surrounded by solid blocks below and all around horizontally plus nothing solid above.
     *
     * @param world            - world to check for materials in
     * @param blockpos$Mutable - location to check if valid
     * @return - if the spot is valid
     */
    private boolean checkIfValidSpot(IWorld world, BlockPos.Mutable blockpos$Mutable, double noise) {
        Material material;
        BlockState blockState;

        //cannot be under ledge
        BlockPos.Mutable temp = new BlockPos.Mutable().set(blockpos$Mutable);
        blockState = world.getBlockState(temp.above());
        while (!blockState.getFluidState().isEmpty() && temp.getY() < 255) {
            temp.move(Direction.UP);
        }
        if (!blockState.isAir() && blockState.getFluidState().isEmpty())
            return false;


        // must be solid below
        // Will also return false if an unacceptable solid material is found.
        blockState = world.getBlockState(blockpos$Mutable.below());
        material = blockState.getMaterial();
        if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) ||
                BlockTags.PLANKS.contains(blockState.getBlock())) &&
                blockState.getFluidState().isEmpty() &&
                blockState.getFluidState() != Fluids.WATER.getSource(false)) {
            return false;
        }


        // places water on tips
        if ((noise < 2D && world.getBlockState(blockpos$Mutable.above()).isAir())) {
            int open = 0;
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                Material material2 = world.getBlockState(blockpos$Mutable.relative(direction)).getMaterial();
                if (unacceptableSolidMaterials.contains(material2)) return false;
                if (world.getBlockState(blockpos$Mutable.relative(direction)).isAir()) open++;
            }
            if (open == 1) return true;
        }

        // Must be solid all around even diagonally.
        // Will also return false if an unacceptable solid material is found.
        for (int x2 = -1; x2 < 2; x2++) {
            for (int z2 = -1; z2 < 2; z2++) {
                blockState = world.getBlockState(blockpos$Mutable.offset(x2, 0, z2));
                material = blockState.getMaterial();

                if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) || BlockTags.PLANKS.contains(blockState.getBlock())) && blockState.getFluidState().isEmpty() && blockState.getFluidState() != Fluids.WATER.getSource(false)) {
                    return false;
                }
            }
        }

        return true;
    }
}