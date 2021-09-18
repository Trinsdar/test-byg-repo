package net.minecraftforge.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BlockSnapshot {
    public static BlockSnapshot create(ResourceKey<?> key, LevelAccessor level, BlockPos pos){
        return new BlockSnapshot();
    }

    public void restore(boolean force, boolean notifyNeighbors){
    }
}