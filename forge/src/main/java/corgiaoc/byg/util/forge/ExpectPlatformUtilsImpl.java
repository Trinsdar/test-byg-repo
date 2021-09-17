package corgiaoc.byg.util.forge;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGItems;
import me.shedaniel.architectury.ExpectPlatform;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.GrassPathBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

public class ExpectPlatformUtilsImpl {
    public static Biome.ClimateSettings createClimate(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float humidity){
        return new Biome.ClimateSettings(precipitation, temperature, temperatureModifier, humidity);
    }

    public static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacerType(Codec<P> codec) {
        return new BlockPlacerType<>(codec);
    }

    public static Tag.Named<Block> createBlockTag(ResourceLocation location){
        return BlockTags.bind(location.toString());
    }

    public static DoorBlock createDoor(BlockBehaviour.Properties properties) {
        return new DoorBlock(properties);
    }

    public static GrassPathBlock createGrass(BlockBehaviour.Properties properties) {
        return new GrassPathBlock(properties);
    }

    public static IronBarsBlock createIronBars(BlockBehaviour.Properties properties) {
        return new IronBarsBlock(properties);
    }

    public static PressurePlateBlock createPressurePlate(PressurePlateBlock.Sensitivity sensitivity, BlockBehaviour.Properties properties) {
        return new PressurePlateBlock(sensitivity, properties);
    }

    public static StairBlock createStair(BlockState state, BlockBehaviour.Properties properties) {
        return new StairBlock(() -> state, properties);
    }

    public static TrapDoorBlock createTrapDoor(BlockBehaviour.Properties properties) {
        return new TrapDoorBlock(properties);
    }

    public static WoodButtonBlock createWoodButton(BlockBehaviour.Properties properties) {
        return new WoodButtonBlock(properties);
    }

    public static boolean biomeDictionaryHasType(String result, ResourceKey<Biome> biomeKey){
        return BiomeDictionary.hasType(biomeKey, BiomeDictionary.Type.getType(result.substring(1).toUpperCase()));
    }

    public static <T extends AbstractContainerMenu> MenuType<T> createMenu(MenuType.MenuSupplier<T> menuSupplier){
        return new MenuType<>(menuSupplier);
    }

    public static CreativeModeTab createTab(ResourceLocation tabLocation, Item icon){
        return new CreativeModeTab(tabLocation.toString()) {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(icon);
            }

            @Override
            public boolean hasSearchBar() {
                return true;
            }

            @Override
            public ResourceLocation getBackgroundImage() {
                return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png");
            }
        };
    }

    public static Biome getOrThrow(ResourceKey<Biome> key){
        if (ForgeRegistries.BIOMES.containsKey(key.location())){
            return ForgeRegistries.BIOMES.getValue(key.location());
        }
        throw new IllegalStateException("Missing: " + key + "from forge Registry, did you register the biome?");
    }
}
