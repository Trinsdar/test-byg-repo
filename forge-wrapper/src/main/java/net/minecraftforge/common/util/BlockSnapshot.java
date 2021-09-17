package net.minecraftforge.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class BlockSnapshot {
    public static BlockSnapshot create(ResourceKey<?> key, Level level, BlockPos pos){
        return new BlockSnapshot();
    }

    public void restore(boolean a, boolean b){
    }
}