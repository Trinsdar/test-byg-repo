package net.minecraftforge.common;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;

public class ForgeHooks {
    public static void onCropsGrowPost(ServerLevel level, BlockPos pos, BlockState state){

    }

    public static boolean onCropsGrowPre(ServerLevel level, BlockPos pos, BlockState state, boolean b){
        return true;
    }
}
