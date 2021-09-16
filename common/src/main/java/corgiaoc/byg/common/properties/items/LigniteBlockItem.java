package corgiaoc.byg.common.properties.items;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class LigniteBlockItem extends BlockItem {
    public LigniteBlockItem(Block blockIn, Properties builder) {
        super(blockIn, builder);
    }

    public int getBurnTime(ItemStack itemStack) {
        return 14000;
    }
}
