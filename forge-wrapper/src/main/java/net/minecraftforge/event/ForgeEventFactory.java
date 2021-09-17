package net.minecraftforge.event;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.BlockSnapshot;

public class ForgeEventFactory {
    public static boolean onBlockPlace(Player player, BlockSnapshot snapshot, Direction direction){
        return false;
    }
}