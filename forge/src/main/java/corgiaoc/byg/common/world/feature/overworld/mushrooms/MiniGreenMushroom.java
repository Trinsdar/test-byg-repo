package corgiaoc.byg.common.world.feature.overworld.mushrooms;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class MiniGreenMushroom extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public MiniGreenMushroom(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 3 + rand.nextInt(2);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(config, worldIn, pos.below(), BYGBlocks.WAILING_NYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 2, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 2, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 2, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 2, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 2, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 2, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 3, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 3, 1));
            }
        }
        return true;
    }
}