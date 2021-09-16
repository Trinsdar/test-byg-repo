package corgiaoc.byg.common.world.feature.overworld.trees.willow.mutated;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;

import java.util.Random;
import java.util.Set;

public class WillowTreeM1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public WillowTreeM1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, mainmutable, boundsIn);

                    mainmutable.move(Direction.UP);
                }
                mainmutable.set(pos);

                BlockPos.Mutable rootMutable = new BlockPos.Mutable().set(mainmutable.offset(0, 0, -2));
                BlockPos.Mutable rootMutable2 = new BlockPos.Mutable().set(mainmutable.offset(-2, 0, 0));
                BlockPos.Mutable rootMutable3 = new BlockPos.Mutable().set(mainmutable.offset(2, 0, 0));
                BlockPos.Mutable rootMutable4 = new BlockPos.Mutable().set(mainmutable.offset(0, 0, 2));

                for (int buildRoot = 0; buildRoot <= 5; buildRoot++) {
                    placeBranch(pos, config, rand, changedBlocks, worldIn, rootMutable, boundsIn);
                    placeBranch(pos, config, rand, changedBlocks, worldIn, rootMutable2, boundsIn);
                    placeBranch(pos, config, rand, changedBlocks, worldIn, rootMutable3, boundsIn);
                    placeBranch(pos, config, rand, changedBlocks, worldIn, rootMutable4, boundsIn);

                    rootMutable.move(Direction.DOWN);
                    rootMutable2.move(Direction.DOWN);
                    rootMutable3.move(Direction.DOWN);
                    rootMutable4.move(Direction.DOWN);
                }

                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 4, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight - 4, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight - 4, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 4, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight - 3, 1), boundsIn);

                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 2, -8), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 2, -8), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 2, -6), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 2, -6), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 2, -4), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 1, -8), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 1, -7), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 1, -6), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 1, -6), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 1, -5), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight, -6), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 1, -5), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 1, -4), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 1, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 1, 0), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 1, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, randTreeHeight + 1, 2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 2, -4), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 2, -4), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 2, -2), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 2, -1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 2, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, randTreeHeight + 2, 1), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 3, -3), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 3, -3), boundsIn);
                placeBranch(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 3, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 4, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 4, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 4, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 4, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 4, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 4, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 3, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 3, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 3, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 3, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 3, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 3, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 3, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 3, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 3, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 2, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 2, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 2, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 2, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 2, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 2, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 2, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 2, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 2, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 2, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 2, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 2, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 2, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 2, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 2, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 2, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 2, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 2, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 2, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 1, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 1, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 1, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 1, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 1, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 1, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-9, randTreeHeight - 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight - 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight - 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight - 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight - 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight - 1, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight - 1, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight - 1, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-9, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight, -3), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 1, -9), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight + 1, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 1, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 1, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 1, -8), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight + 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight + 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 1, -7), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight + 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight + 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 1, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-8, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 1, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-7, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 1, -4), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 1, -3), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 1, -2), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 2, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 2, -6), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-6, randTreeHeight + 2, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 2, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 2, -5), boundsIn);
                placeLeaves(pos, config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 2, -4), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 2, -3), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 2, -2), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 2, -2), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 3, -3), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 3, -1), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 4, -3), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-2, randTreeHeight + 4, -1), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 4, 0), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 5, -3), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 5, 0), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 6, -3), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 6, 0), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 6, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 7, -4), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 7, -4), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 7, -4), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 7, -3), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 7, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 7, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 7, -2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 7, -2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 7, -2), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 7, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 8, -4), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 8, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 8, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 8, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 8, -2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 8, 0), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 8, 0), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 8, 0), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 8, 1), boundsIn);
                this.stem(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 8, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 8, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 8, 2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 8, 2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 8, 2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 9, -4), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 9, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 9, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 9, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 9, -2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 9, 0), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 9, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 9, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 9, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 9, 2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-1, randTreeHeight + 10, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 10, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(1, randTreeHeight + 10, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 10, 0), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-5, randTreeHeight + 10, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 10, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-3, randTreeHeight + 10, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 10, 2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 11, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 11, 0), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 11, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 11, 2), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(0, randTreeHeight + 12, -3), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 12, 1), boundsIn);
                this.glowshroom(pos, config, changedBlocks, worldIn, mainmutable.set(pos).move(-4, randTreeHeight + 13, 1), boundsIn);
            }
        }
        return true;
    }

    private void stem(BlockPos startPos, BYGTreeConfig config, Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
        blockpos = (BlockPos.Mutable) getTransformedPos(config, startPos, blockpos);

        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(startPos, config, blockPos, reader, blockpos, BYGBlocks.RED_GLOWSHROOM_STEM.defaultBlockState(), boundingBox);
        }
    }


    private void glowshroom(BlockPos startPos, BYGTreeConfig config, Set<BlockPos> blockPos, ISeedReader reader, BlockPos pos, MutableBoundingBox boundingBox) {
        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
        blockpos = (BlockPos.Mutable) getTransformedPos(config, startPos, blockpos);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(startPos, config, blockPos, reader, blockpos, BYGBlocks.PURPLE_GLOWSHROOM_BLOCK.defaultBlockState(), boundingBox);
        }
    }



}