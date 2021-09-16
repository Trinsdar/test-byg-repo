package corgiaoc.byg.common.world.feature.end.trees.impariusgrove.fungus;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;

import java.util.Random;

public class FungalImparius2 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public FungalImparius2(Codec<BYGMushroomConfig> configIn) {
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
            if (!isDesiredGroundwEndTags(config, worldIn, pos.below(), BYGBlocks.IMPARIUS_PHYLIUM)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 9, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 0, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, -3));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 0, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 1, -2));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(1, 1, 0));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 2, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(0, 2, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 3, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 4, -1));
                placeStemBranch(STEM, worldIn, mainmutable.set(pos).move(-1, 4, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 7, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 7, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 7, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 7, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, -2));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-2, 8, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-2, 8, 0));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, -3));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 8, -2));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 8, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 8, 0));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 8, 1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(-1, 8, 2));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(0, 8, -2));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(0, 8, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(0, 8, 1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(0, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, -3));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 8, -2));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 8, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 8, 0));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 8, 1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, -2));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(2, 8, -1));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(2, 8, 0));
                this.imparius_filament(worldIn, mainmutable.set(pos).move(2, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 8, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 8, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-2, 9, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-2, 9, 0));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -3));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 9, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 9, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 9, 0));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 9, 1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(-1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -3));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(0, 9, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(0, 9, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(0, 9, 1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(0, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -3));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 9, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 9, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 9, 0));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 9, 1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -2));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(2, 9, -1));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(2, 9, 0));
                this.imparius_filament_block(worldIn, mainmutable.set(pos).move(2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 1));
            }
        }
        return true;
    }

    private void imparius_filament(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.FUNGAL_IMPARIUS_FILAMENT.defaultBlockState());
        }
    }

    private void imparius_filament_block(ISeedReader reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK.defaultBlockState());
        }
    }
}