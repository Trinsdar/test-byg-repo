package corgiaoc.byg.common.properties;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BYGCreativeTab {
    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(-1,"byg") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BYGItems.BYG_LOGO);
        }

        public boolean hasSearchBar() {
            return true;
        }

        public ResourceLocation getBackgroundImage() {
            return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png");
        }
    };

    public static void init() {
        BYG.LOGGER.debug("BYG: Item Group Created!");
    }
}
