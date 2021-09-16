package corgiaoc.byg.common.world.feature.end.trees.shulkren;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class ShulkrenTree2 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public ShulkrenTree2(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(ISeedReader worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getState(rand, pos);
        int randTreeHeight = 8 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwEndTags(config, worldIn, pos.below(), BYGBlocks.SHULKREN_PHYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 9, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 11, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 13, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 16, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 2, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 4, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 6, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 8, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 10, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 12, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 14, 2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 14, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 14, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(3, 14, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-2, 15, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 15, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 15, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 15, -4));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 15, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 15, 3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 15, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(2, 15, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(4, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 12, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 12, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 12, -5));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(-1, 12, 2));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(-1, 12, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 12, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 12, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 12, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-6, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 13, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 13, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 13, 3));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(-4, 13, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 13, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 13, -3));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(-3, 13, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 13, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 13, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 13, -6));
                placeHangingBody(worldIn, mainmutable.set(pos).move(-1, 13, 2));
                placeHangingBody(worldIn, mainmutable.set(pos).move(-1, 13, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 13, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, -6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 13, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 13, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 13, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 13, -3));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(3, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 13, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 13, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 13, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 13, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-6, 14, -1));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(-6, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-6, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 14, 3));
                placeHangingBody(worldIn, mainmutable.set(pos).move(-4, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 14, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 14, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 14, -3));
                placeHangingBody(worldIn, mainmutable.set(pos).move(-3, 14, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 14, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 14, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 14, -6));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-1, 14, -5));
                placeHangingBody(worldIn, mainmutable.set(pos).move(-1, 14, 6));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(0, 14, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 14, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, -6));
                placeShroomlight(worldIn, mainmutable.set(pos).move(1, 14, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 14, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 14, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 14, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 14, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 14, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 14, -3));
                placeHangingEnd(worldIn, mainmutable.set(pos).move(4, 14, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 14, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 14, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 14, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 14, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 14, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-6, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-6, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-6, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 15, -2));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-5, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 15, -3));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-4, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 15, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 15, -5));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-2, 15, -4));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-2, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 15, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 15, -6));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-1, 15, -5));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-1, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 15, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 15, -6));
                placeHangingBody(worldIn, mainmutable.set(pos).move(0, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 15, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 15, -6));
                placeShroomlight(worldIn, mainmutable.set(pos).move(1, 15, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 15, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 15, -5));
                placeShroomlight(worldIn, mainmutable.set(pos).move(2, 15, -4));
                placeShroomlight(worldIn, mainmutable.set(pos).move(2, 15, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 15, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 15, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 15, -3));
                placeShroomlight(worldIn, mainmutable.set(pos).move(4, 15, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 15, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 15, -2));
                placeShroomlight(worldIn, mainmutable.set(pos).move(5, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 15, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 15, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 15, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 15, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(6, 15, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 16, 2));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-3, 16, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 16, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 16, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 16, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 16, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 16, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 16, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 16, 2));
                placeShroomlight(worldIn, mainmutable.set(pos).move(5, 16, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 16, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 16, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 16, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 17, 1));
                placeShroomlight(worldIn, mainmutable.set(pos).move(-4, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 17, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 17, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 17, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 17, 3));
                placeShroomlight(worldIn, mainmutable.set(pos).move(2, 17, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 17, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 17, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 17, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(5, 17, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 18, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 18, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 18, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 18, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 18, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 18, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 18, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 18, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 19, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 19, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 19, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 19, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 19, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 19, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 19, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 19, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 19, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 19, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 19, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 19, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 20, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 20, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 20, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 20, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 20, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 20, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 20, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 20, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 20, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 20, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 20, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 20, 3));
                placeShroomlight(worldIn, mainmutable.set(pos).move(1, 20, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 20, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 20, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 20, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 20, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 20, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 20, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 20, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 20, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 20, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 20, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 20, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 21, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 21, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 21, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 21, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 21, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 21, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 21, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 21, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 21, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 21, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 21, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 21, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 21, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 21, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 21, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 21, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 21, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 21, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 21, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 21, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 21, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 22, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 22, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 22, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 22, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 22, 0));
            }
        }
        return true;
    }

        private void placeShroomlight(ISeedReader reader, BlockPos pos) {
            if (isAir(reader, pos)) {
                this.setFinalBlockState(reader, pos, BYGBlocks.PURPLE_SHROOMLIGHT.defaultBlockState());
            }
        }

    private void placeHangingEnd(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.SHULKREN_VINE.defaultBlockState());
        }
    }

    private void placeHangingBody(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.SHULKREN_VINE_PLANT.defaultBlockState());
        }
    }

}