package corgiaoc.byg.common.world.feature.overworld.trees.joshua;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import java.util.Random;
import java.util.Set;

public class JoshuaTree1 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public JoshuaTree1(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    public boolean generate(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {

                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getStepX();
                        posZ1 += direction.getStepZ();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north().below(2), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.north(2).below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south().below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.south(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east().below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.east(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west().below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west(2).below(), boundsIn);
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, blockpos2.west(2), boundsIn);


                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 - 3, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 1, topTrunkHeight, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 - 3, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 - 2, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1, topTrunkHeight, posZ1 + 2, boundsIn, changedBlocks);

                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 2, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        placeLeaves(pos, config, rand, worldIn, posX1 + 1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);


                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
