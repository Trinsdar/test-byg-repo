package net.minecraftforge.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.util.BlockSnapshot;

import java.util.Random;

public class ForgeEventFactory {
    public static boolean onBlockPlace(Entity player, BlockSnapshot snapshot, Direction direction){
        return false;
    }

    public static boolean saplingGrowTree(LevelAccessor level, Random random, BlockPos pos){
        return false;
    }

    public static boolean getMobGriefingEvent(Level level, Entity mob){
        return false;
    }
}