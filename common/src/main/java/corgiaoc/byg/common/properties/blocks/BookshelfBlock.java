package corgiaoc.byg.common.properties.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BookshelfBlock extends Block {
    public BookshelfBlock(Properties builder) {
        super(builder);
    }

    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1f;
    }
}
