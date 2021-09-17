package corgiaoc.byg.core.world;

import corgiaoc.byg.BYG;
import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import corgiaoc.byg.util.ExpectPlatformUtils;
import me.shedaniel.architectury.platform.Platform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.LinkedHashMap;
import java.util.Map;

public class BYGContainerTypes {

    public static final Map<ResourceLocation, MenuType<?>> CONTAINER_TYPES = new LinkedHashMap<>();

    public static final MenuType<HypogealImperiumContainer> HYPOGEAL_CONTAINER = register("hypogeal", HypogealImperiumContainer::new);


    private static <T extends AbstractContainerMenu> MenuType<T> register(String key, MenuType.MenuSupplier<T> builder) {
        MenuType<T> containerType = ExpectPlatformUtils.createMenu(builder);
        if (Platform.isFabric())
        Registry.register(Registry.MENU, new ResourceLocation(BYG.MOD_ID, key), containerType);
        CONTAINER_TYPES.put(new ResourceLocation(BYG.MOD_ID, key), containerType);
        return containerType;
    }
}
