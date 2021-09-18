package net.minecraftforge.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ForgeHooks {
    public static void onCropsGrowPost(Level level, BlockPos pos, BlockState state){

    }

    public static boolean onCropsGrowPre(Level level, BlockPos pos, BlockState state, boolean b){
        return true;
    }
}
