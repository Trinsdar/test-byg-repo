package corgiaoc.byg.common.world.feature.end.trees.impariusgrove;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.properties.blocks.end.impariusgrove.ImpariusMushroomBranchBlock;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class ImpariusMushroom1 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public ImpariusMushroom1(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(WorldGenLevel worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 8 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwEndTags(config, worldIn, pos.below(), BYGBlocks.IMPARIUS_PHYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 1, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 1, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 2, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 3, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 4, -1));
                this.vine(worldIn, mainmutable.set(pos).move(0, 1, 0));
                this.vine(worldIn, mainmutable.set(pos).move(-1, 2, -2));
                this.vineplant(worldIn, mainmutable.set(pos).move(0, 2, 0));
                this.vine(worldIn, mainmutable.set(pos).move(1, 2, -1));
                this.imparius_mushroom_branch(worldIn, mainmutable.set(pos).move(-1, 4, -1), Direction.WEST);
                this.imparius_mushroom_branch(worldIn, mainmutable.set(pos).move(0, 4, -2), Direction.NORTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.set(pos).move(0, 4, 0), Direction.SOUTH);
                this.imparius_mushroom_branch(worldIn, mainmutable.set(pos).move(1, 4, -1), Direction.EAST);
            }
        }
        return true;
    }
    private void imparius_mushroom_branch(WorldGenLevel reader, BlockPos pos, Direction direction) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.IMPARIUS_MUSHROOM_BRANCH.defaultBlockState().setValue(ImpariusMushroomBranchBlock.FACING, direction));
        }
    }

    private void vine(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.IMPARIUS_VINE.defaultBlockState());
        }
    }

    private void vineplant(WorldGenLevel reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.IMPARIUS_VINE_PLANT.defaultBlockState());
        }
    }
}