package corgiaoc.byg.common.world.feature.nether.trees.withering;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.properties.blocks.end.impariusgrove.ImpariusMushroomBranchBlock;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class WitheringOakTree2 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public WitheringOakTree2(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 14 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), BYGBlocks.OVERGROWN_NETHERRACK)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 2, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 6, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 6, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 7, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 7, -5));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 7, -5));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 7, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 7, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 8, -4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 8, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(5, 8, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(6, 8, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 9, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 9, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 9, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 10, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 4, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 5, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 5, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 5, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 5, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 6, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, -6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 6, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 6, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 6, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 6, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 7, -6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 7, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 7, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(7, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, -6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 8, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(7, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(7, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(7, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 9, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -2));
                this.ArisianBloomBranch(worldIn, mainmutable.set(pos).move(-1, 1, -1), Direction.WEST);
                this.ArisianBloomBranch(worldIn, mainmutable.set(pos).move(1, 1, -1), Direction.EAST);
                this.ArisianBloomBranch(worldIn, mainmutable.set(pos).move(0, 2, -2), Direction.NORTH);
                this.ArisianBloomBranch(worldIn, mainmutable.set(pos).move(0, 2, 1), Direction.SOUTH);
                this.ArisianBloomBranch(worldIn, mainmutable.set(pos).move(-1, 3, 0), Direction.WEST);
                this.ArisianBloomBranch(worldIn, mainmutable.set(pos).move(1, 3, 0), Direction.EAST);
                this.ArisianBloomBranch(worldIn, mainmutable.set(pos).move(0, 4, 1), Direction.SOUTH);
            }
        }
        return true;
    }

    private void ArisianBloomBranch(ISeedReader reader, BlockPos pos, Direction direction) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.ARISIAN_BLOOM_BRANCH.defaultBlockState().setValue(ImpariusMushroomBranchBlock.FACING, direction));
        }
    }
}
