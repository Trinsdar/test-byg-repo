package corgiaoc.byg.common.properties.items;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AnthraciteItem extends Item {
    public AnthraciteItem(Properties builder) {
        super(builder);
    }

    public int getBurnTime(ItemStack itemStack) {
        return 2400;
    }
}
