package corgiaoc.byg.util.fabric;

import com.mojang.serialization.Codec;
import corgiaoc.byg.mixin.fabric.access.BiomeClimateSettingsAccess;
import corgiaoc.byg.mixin.fabric.access.BlockPlacerTypeAccess;
import corgiaoc.byg.mixin.fabric.access.BlockTagsAccess;
import corgiaoc.byg.mixin.fabric.access.DoorBlockAccess;
import corgiaoc.byg.mixin.fabric.access.GrassPathBlockAccess;
import corgiaoc.byg.mixin.fabric.access.IronBarsBlockAccess;
import corgiaoc.byg.mixin.fabric.access.MenuTypeAccess;
import corgiaoc.byg.mixin.fabric.access.PressurePlateBlockAccess;
import corgiaoc.byg.mixin.fabric.access.StairBlockAccess;
import corgiaoc.byg.mixin.fabric.access.TrapDoorBlockAccess;
import corgiaoc.byg.mixin.fabric.access.WoodButtonBlockAccess;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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


public class ExpectPlatformUtilsImpl {
    public static Biome.ClimateSettings createClimate(Biome.Precipitation precipitation, float temperature, Biome.TemperatureModifier temperatureModifier, float humidity){
        return BiomeClimateSettingsAccess.create(precipitation, temperature, temperatureModifier, humidity);
    }


    public static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacerType(Codec<P> codec) {
        return BlockPlacerTypeAccess.create(codec);
    }


    public static Tag.Named<Block> createBlockTag(ResourceLocation location){
        return BlockTagsAccess.invokeBind(location.toString());
    }


    public static DoorBlock createDoor(BlockBehaviour.Properties properties) {
        return DoorBlockAccess.create(properties);
    }


    public static GrassPathBlock createGrass(BlockBehaviour.Properties properties) {
        return GrassPathBlockAccess.create(properties);
    }


    public static IronBarsBlock createIronBars(BlockBehaviour.Properties properties) {
        return IronBarsBlockAccess.create(properties);
    }

    public static PressurePlateBlock createPressurePlate(PressurePlateBlock.Sensitivity sensitivity, BlockBehaviour.Properties properties) {
        return PressurePlateBlockAccess.create(sensitivity, properties);
    }

    public static StairBlock createStair(BlockState state, BlockBehaviour.Properties properties) {
        return StairBlockAccess.create(state, properties);
    }

    public static TrapDoorBlock createTrapDoor(BlockBehaviour.Properties properties) {
        return TrapDoorBlockAccess.create(properties);
    }

    public static WoodButtonBlock createWoodButton(BlockBehaviour.Properties properties) {
        return WoodButtonBlockAccess.create(properties);
    }

    public static boolean biomeDictionaryHasType(String result, ResourceKey<Biome> biomeKey){
        return true;
    }

    public static <T extends AbstractContainerMenu> MenuType<T> createMenu(MenuType.MenuSupplier<T> menuSupplier){
        return MenuTypeAccess.create(menuSupplier);
    }

    public static CreativeModeTab createTab(ResourceLocation tabLocation, Item icon){
        return FabricItemGroupBuilder.build(tabLocation, () -> new ItemStack(icon));
    }

    public static Biome getOrThrow(ResourceKey<Biome> key){
        return BuiltinRegistries.BIOME.getOrThrow(key);
    }
}
