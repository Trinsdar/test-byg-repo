package corgiaoc.byg.entrypoint;

import corgiaoc.byg.BYG;
import corgiaoc.byg.client.textures.renders.BYGCutoutRenders;
import corgiaoc.byg.common.world.BYGWorldTypeThatIsntAWorldtype;
import corgiaoc.byg.common.world.feature.blockplacer.BYGBlockPlacerTypes;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.BYGSounds;
import corgiaoc.byg.core.BYGTileEntities;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGContainerTypes;
import corgiaoc.byg.core.world.BYGDecorators;
import corgiaoc.byg.core.world.BYGFeatures;
import corgiaoc.byg.core.world.BYGStructures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import corgiaoc.byg.data.providers.BYGBlockTagsProvider;
import corgiaoc.byg.mixin.access.FillerBlockTypeAccess;
import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.network.NetworkHooks;

import java.nio.file.Path;
import java.util.Comparator;


@Mod("byg")
@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeEntryPoint implements EntryPoint {

    public ForgeEntryPoint() {
//        NetherConfig.loadConfig(NetherConfig.COMMON_CONFIG, configDirectory().resolve(BYG.MOD_ID + "-nether.toml"));
        EventBuses.registerModEventBus(BYG.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
        BYG.entryPoint = this;
        BYG.CONFIG_PATH = configDirectory();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        BYG.commonLoad();
        event.enqueueWork(BYG::threadSafeCommonLoad);
    }


    private void clientSetup(FMLClientSetupEvent event) {
        BYG.clientLoad();
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(BYG::threadSafeLoadFinish);
    }

    @Override
    public Path configDirectory() {
        return FMLPaths.CONFIGDIR.get().resolve(BYG.MOD_ID);
    }

    @Override
    public Packet<?> getEntitySpawnPacket(Entity entity) {
        return NetworkHooks.getEntitySpawningPacket(entity);
    }

    @Override
    public void renderCutouts() {
        BYGCutoutRenders.renderCutOuts();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BYG.LOGGER.debug("BYG: Registering blocks...");
        BYGBlocks.blocksList.forEach(block -> event.getRegistry().register(block));
        BYGBlocks.flowerPotBlocks.forEach(block -> event.getRegistry().register(block));
        BYG.LOGGER.info("BYG: Blocks registered!");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        BYG.LOGGER.debug("BYG: Registering items...");
        BYGItems.itemsList.forEach(item -> event.getRegistry().register(item));
        BYG.LOGGER.info("BYG: Items registered!");
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering entities...");
        BYGEntities.entities.forEach(entityType -> event.getRegistry().register(entityType));
        BYG.LOGGER.info("BYG: Entities registered!");
    }

    @SubscribeEvent
    public static void registerTileEntities(RegistryEvent.Register<BlockEntityType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering block entities...");
        BYGTileEntities.BLOCK_ENTITIES.forEach(entityType -> event.getRegistry().register(entityType));
        BYG.LOGGER.info("BYG: Block Entities registered!");
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        BYG.LOGGER.debug("BYG: Registering sounds...");
        BYGSounds.SOUNDS.forEach(soundEvent -> event.getRegistry().register(soundEvent));
        BYG.LOGGER.info("BYG: Sounds registered!");
    }

    @SubscribeEvent
    public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering block entities...");
        BYGEntities.init();
        BYGContainerTypes.CONTAINER_TYPES.forEach(containerType -> event.getRegistry().register(containerType));
        BYG.LOGGER.info("BYG: Block Entities registered!");
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        BYG.LOGGER.debug("BYG: Registering biomes...");
        BYGBiomes.init();
        BYGBiomes.biomeList.sort(Comparator.comparingInt(BYGBiomes.PreserveBiomeOrder::getOrderPosition));
        BYGBiomes.biomeList.forEach(preserveBiomeOrder -> event.getRegistry().register(preserveBiomeOrder.getBiome()));
        BYGBiomes.CANYON_KEY = BYGBiomes.CANYON.getKey();
        BYG.LOGGER.info("BYG: Biomes registered!");
    }

    @SubscribeEvent
    public static void registerDecorators(RegistryEvent.Register<FeatureDecorator<?>> event) {
        BYG.LOGGER.debug("BYG: Registering decorators...");
        BYGDecorators.init();
        BYGDecorators.decorators.forEach(decorator -> event.getRegistry().register(decorator));
        BYG.LOGGER.info("BYG: Decorators registered!");
    }

    @SubscribeEvent
    public static void registerStructures(RegistryEvent.Register<StructureFeature<?>> event) {
        BYG.LOGGER.debug("BYG: Registering structures...");
        BYGStructures.init();
//            BYGStructures.structures.forEach(structure -> event.getRegistry().register(structure));
//            Structure.STRUCTURE_DECORATION_STAGE_MAP.forEach(((structure, decoration) -> System.out.println(Registry.STRUCTURE_FEATURE.getKey(structure).toString())));
        BYG.LOGGER.info("BYG: Structures registered!");
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        BYG.LOGGER.debug("BYG: Registering features...");
        FillerBlockTypeAccess.setNetherFillerType(new TagMatchTest(BlockTags.BASE_STONE_NETHER));
        BYGFeatures.init();
        BYGFeatures.features.forEach(feature -> event.getRegistry().register(feature));
        BYG.LOGGER.info("BYG: Features registered!");
    }

    @SubscribeEvent
    public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
        BYG.LOGGER.debug("BYG: Registering surface builders...");
        BYGSurfaceBuilders.init();
        BYGSurfaceBuilders.surfaceBuilders.forEach(surfaceBuilder -> event.getRegistry().register(surfaceBuilder));
        BYG.LOGGER.info("BYG: Surface builders Registered!");
    }

    @SubscribeEvent
    public static void registerBlockPlacerType(RegistryEvent.Register<BlockPlacerType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering block placer types...");
        BYGBlockPlacerTypes.init();
        BYGBlockPlacerTypes.types.forEach(type -> event.getRegistry().register(type));
        BYG.LOGGER.info("BYG: Registering block placer types!");
    }

    //Only for terraforged usage and not player's.
    @SubscribeEvent
    public static void registerWorldtype(RegistryEvent.Register<ForgeWorldType> event) {
        event.getRegistry().register(new BYGWorldTypeThatIsntAWorldtype().setRegistryName(new ResourceLocation(BYG.MOD_ID, "world")));
    }

    @SubscribeEvent
    public static void data(GatherDataEvent event) {
        event.getGenerator().addProvider(new BYGBlockTagsProvider(event.getGenerator(), event.getExistingFileHelper()));
    }
}