package corgiaoc.byg.common.properties.blocks.end;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class TallNightshadePlantBlock extends DoublePlantBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);

    public TallNightshadePlantBlock(Properties builder) {
        super(builder);

    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.is(BYGBlocks.NIGHTSHADE_PHYLIUM) || super.mayPlaceOn(state, worldIn, pos);
    }
}

