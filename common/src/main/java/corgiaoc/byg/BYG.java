package corgiaoc.byg;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import corgiaoc.byg.common.entity.villager.BYGVillagerType;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.blocks.vanilla.ITreeSpawner;
import corgiaoc.byg.common.properties.vanilla.BYGCarvableBlocks;
import corgiaoc.byg.common.properties.vanilla.BYGCompostables;
import corgiaoc.byg.common.properties.vanilla.BYGFlammables;
import corgiaoc.byg.common.properties.vanilla.BYGHoeables;
import corgiaoc.byg.common.properties.vanilla.BYGPaths;
import corgiaoc.byg.common.properties.vanilla.BYGStrippables;
import corgiaoc.byg.common.world.biome.BYGBiome;
import corgiaoc.byg.common.world.biome.BYGEndBiome;
import corgiaoc.byg.common.world.biome.BYGEndSubBiome;
import corgiaoc.byg.common.world.biome.BYGNetherBiome;
import corgiaoc.byg.common.world.biome.BYGSubBiome;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeSource;
import corgiaoc.byg.config.WorldConfig;
import corgiaoc.byg.config.json.biomedata.BiomeData;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.WeightedBiomeData;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.entrypoint.EntryPoint;
import corgiaoc.byg.mixin.access.BlockEntityTypeAccess;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import corgiaoc.byg.mixin.access.WeightedListEntryAccess;
import corgiaoc.byg.util.ExpectPlatformUtils;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import me.shedaniel.architectury.platform.Platform;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BYG {
    public static final String MOD_ID = "byg";
    public static final Logger LOGGER = LogManager.getLogger();

    public static boolean isClient = false;
    public static boolean isUsingMixin;
    public static String FILE_PATH = "yeet";
    public static Path CONFIG_PATH = null;
    public static EntryPoint entryPoint = null;
    public static WorldConfig worldConfig = null;
    public static final ResourceLocation EMPTY = new ResourceLocation("");

    public static Registry<Biome> biomeRegistryAccess = null;

    public static WorldConfig worldConfig(boolean refreshConfig) {
        if (worldConfig == null || refreshConfig) {
            worldConfig = new WorldConfig(CONFIG_PATH.resolve("byg-world.toml"));
        }
        return worldConfig;
    }

    public static WorldConfig worldConfig() {
        return worldConfig(false);
    }

    public static boolean ENABLE_OVERWORLD_TREES = true;
    public static boolean ENABLE_CACTI = true;
    public static boolean ENABLE_NYLIUM_FUNGI = true;
    public static boolean ENABLE_NETHER_MUSHROOMS = true;

    public BYG() {
        File dir = new File(CONFIG_PATH.toString());
        if (!dir.exists())
            dir.mkdir();
    }

    public static void commonLoad() {
        LOGGER.debug("BYG: \"Common Setup\" Event Starting...");
        BYGCreativeTab.init();

        for (Block block : Registry.BLOCK) {
            if (block instanceof ITreeSpawner) {
                if (ITreeSpawner.VANILLA_SAPLING_BYG_TREE_SPAWNERS.containsKey(block)) {
                    ((ITreeSpawner) block).setTreeSpawner(ITreeSpawner.VANILLA_SAPLING_BYG_TREE_SPAWNERS.get(block));
                }
            }
        }
        LOGGER.info("BYG: \"Common Setup\" Event Complete!");
    }

    public static void threadSafeCommonLoad() {
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_nether"), BYGNetherBiomeSource.BYGNETHERCODEC);
        Registry.register(Registry.BIOME_SOURCE, new ResourceLocation(MOD_ID, "byg_end"), BYGEndBiomeSource.BYGENDCODEC);
        BYGVillagerType.setVillagerForBYGBiomes();
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        handleOverWorldConfig(gson);
        handleOverWorldSubConfig(gson);
        handleEndConfig(gson);
        handleNetherConfig(gson);

        BlockEntityTypeAccess builderAccess = (BlockEntityTypeAccess)  BlockEntityType.CAMPFIRE;
        Set<Block> validBlocks = new ObjectOpenHashSet<>(builderAccess.getValidBlocks());
        validBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE);
        validBlocks.add(BYGBlocks.BORIC_CAMPFIRE);
        builderAccess.setValidBlocks(validBlocks);
    }

    public static void handleEndConfig(Gson gson){
        BiomeDataHolders.EndBiomeDataHolder endBiomeDataHolder = BYG.getEndData(gson, BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-biomes.json"));
        Map<ResourceLocation, WeightedBiomeData> endBiomeData1 = endBiomeDataHolder.getEndBiomeData();
        endBiomeData1.remove(null);
        endBiomeData1.remove(BYG.EMPTY);
        endBiomeData1.forEach(((biome, endBiomeData) -> {
            ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, biome);
            TheEndBiomes.addHighlandsBiome(key, endBiomeData.getWeight());
            List<WeightedList.WeightedEntry<ResourceLocation>> entries = ((WeightedListAccess<ResourceLocation>) endBiomeData.getSubBiomes()).getEntries();
            entries.forEach(r -> {
                //todo figure out if I need to translate this weight to a double
                TheEndBiomes.addBarrensBiome(key, ResourceKey.create(Registry.BIOME_REGISTRY, r.getData()), (((WeightedListEntryAccess)r).getWeight()));
            });
            if (entries.isEmpty()){
                TheEndBiomes.addBarrensBiome(key, key, 1.0);
            }
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                TheEndBiomes.addMidlandsBiome(key, ResourceKey.create(Registry.BIOME_REGISTRY, edgeBiome), 1.0);
            } else {
                TheEndBiomes.addMidlandsBiome(key, key, 1.0);
            }
        }));

        Map<ResourceLocation, WeightedBiomeData> voidBiomeData = endBiomeDataHolder.getVoidBiomeData();
        voidBiomeData.remove(null);
        voidBiomeData.remove(BYG.EMPTY);
        voidBiomeData.forEach(((biome, endBiomeData) -> {
            TheEndBiomes.addSmallIslandsBiome(ResourceKey.create(Registry.BIOME_REGISTRY, biome), endBiomeData.getWeight());
        }));

        BiomeDataHolders.EndSubBiomeDataHolder endSubBiomeDataHolder = BYG.getEndSubBiomeData(gson, BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-sub-biomes.json"));
        Map<ResourceLocation, BiomeData> endSubBiomeData = endSubBiomeDataHolder.getEndSubBiomeData();
        endSubBiomeData.remove(null);
        endSubBiomeData.remove(BYG.EMPTY);
        endSubBiomeData.forEach(((biome, endBiomeData) -> {
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                TheEndBiomes.addMidlandsBiome(ResourceKey.create(Registry.BIOME_REGISTRY, biome), ResourceKey.create(Registry.BIOME_REGISTRY, edgeBiome), 1.0);
            }
        }));

    }

    public static void handleNetherConfig(Gson gson){
        BiomeDataHolders.WeightedBiomeDataHolder endBiomeDataHolder = BYG.getNetherData(gson, BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-nether-biomes.json"));
        Map<ResourceLocation, WeightedBiomeData> endBiomeData1 = endBiomeDataHolder.getBiomeData();
        endBiomeData1.remove(null);
        endBiomeData1.remove(BYG.EMPTY);
        endBiomeData1.forEach(((biome, weightedBiomeData) -> {
            ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, biome);
            Biome biome1 = ExpectPlatformUtils.getOrThrow(key);
            //todo figure out climate parameters
            //NetherBiomes.addNetherBiome(key, new Biome.ClimateParameters());
        }));
    }

    public static BiomeDataHolders.EndBiomeDataHolder getEndData(Gson gson, Path biomesConfigPath) {
        BiomeDataHolders.EndBiomeDataHolder endBiomeDataHolder = BYGEndBiome.extractDefaultHolder(BuiltinRegistries.BIOME);

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.EndBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, endBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.EndBiomeDataHolder, JsonElement>> result = BiomeDataHolders.EndBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                endBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getEndBiomeData());
        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getVoidBiomeData());
        return endBiomeDataHolder;
    }

    public static BiomeDataHolders.WeightedBiomeDataHolder getNetherData(Gson gson, Path biomesConfigPath) {
        BiomeDataHolders.WeightedBiomeDataHolder endWeightedBiomeDataHolder = BYGNetherBiome.extractDefaultHolder(BuiltinRegistries.BIOME);

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.WeightedBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, endWeightedBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.WeightedBiomeDataHolder, JsonElement>> result = BiomeDataHolders.WeightedBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                endWeightedBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        BYGBiomes.fillBiomeDictionary(endWeightedBiomeDataHolder.getBiomeData());
        return endWeightedBiomeDataHolder;
    }


    public static BiomeDataHolders.EndSubBiomeDataHolder getEndSubBiomeData(Gson gson, Path biomesConfigPath) {
        BiomeDataHolders.EndSubBiomeDataHolder endBiomeDataHolder = BYGEndSubBiome.extractDefaultHolder(BuiltinRegistries.BIOME);

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.EndSubBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, endBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.EndSubBiomeDataHolder, JsonElement>> result = BiomeDataHolders.EndSubBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                endBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getEndSubBiomeData());
        BYGBiomes.fillBiomeDictionary(endBiomeDataHolder.getVoidSubBiomeData());
        return endBiomeDataHolder;
    }

    private static void handleOverWorldConfig(Gson gson) {
        BiomeDataHolders.OverworldPrimaryBiomeDataHolder overworldPrimaryBiomeDataHolder = BYGBiome.extractDefaultHolder();
        Path biomesConfigPath = CONFIG_PATH.resolve(BYG.MOD_ID + "-biomes.json");

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.OverworldPrimaryBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, overworldPrimaryBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.OverworldPrimaryBiomeDataHolder, JsonElement>> result = BiomeDataHolders.OverworldPrimaryBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
              overworldPrimaryBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }
        overworldPrimaryBiomeDataHolder.getBiomeData().forEach((location, primaryBiomeData) -> {
            ResourceLocation river = primaryBiomeData.getRiver();
            if (!river.equals(EMPTY)) {
                OverworldBiomes.setRiverBiome(ResourceKey.create(Registry.BIOME_REGISTRY, location), ResourceKey.create(Registry.BIOME_REGISTRY, river));
                //BYGBiome.BIOME_TO_RIVER_LIST.put(location, river);
            }
            ResourceLocation beach = primaryBiomeData.getBeach();
            if (!beach.equals(EMPTY)) {
                OverworldBiomes.addShoreBiome(ResourceKey.create(Registry.BIOME_REGISTRY, location), ResourceKey.create(Registry.BIOME_REGISTRY, beach), 1.0);
                //BYGBiome.BIOME_TO_BEACH_LIST.put(location, beach);
            }
            ResourceLocation edgeBiome = primaryBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(EMPTY)) {
                OverworldBiomes.addEdgeBiome(ResourceKey.create(Registry.BIOME_REGISTRY, location), ResourceKey.create(Registry.BIOME_REGISTRY, edgeBiome), 1.0);
                //BYGBiome.BIOME_TO_EDGE_LIST.put(location, edgeBiome);
            }
            WeightedList<ResourceLocation> subBiomes = primaryBiomeData.getSubBiomes();
            List<WeightedList.WeightedEntry<ResourceLocation>> entries = ((WeightedListAccess<ResourceLocation>) subBiomes).getEntries();
            entries.forEach(r -> {
                //todo figure out if I need to translate this weight to a double
                OverworldBiomes.addHillsBiome(ResourceKey.create(Registry.BIOME_REGISTRY, location), ResourceKey.create(Registry.BIOME_REGISTRY, r.getData()), (((WeightedListEntryAccess)r).getWeight()));
            });
            //BYGBiome.BIOME_TO_HILLS_LIST.put(location, subBiomes);
        });
        

        BYGBiomes.handleOverworldEntries(overworldPrimaryBiomeDataHolder);
    }

    private static void handleOverWorldSubConfig(Gson gson) {
        BiomeDataHolders.OverworldSubBiomeDataHolder overworldSubBiomeDataHolder = BYGSubBiome.extractDefaultHolder();
        Path biomesConfigPath = CONFIG_PATH.resolve(BYG.MOD_ID + "-sub-biomes.json");

        File biomesConfigFile = biomesConfigPath.toFile();
        try {
            if (!biomesConfigFile.exists()) {
                DataResult<JsonElement> jsonElementDataResult = BiomeDataHolders.OverworldSubBiomeDataHolder.CODEC.encodeStart(JsonOps.INSTANCE, overworldSubBiomeDataHolder);
                Files.createDirectories(biomesConfigPath.getParent());
                Files.write(biomesConfigPath, gson.toJson(jsonElementDataResult.result().get()).getBytes());
            }
            Optional<Pair<BiomeDataHolders.OverworldSubBiomeDataHolder, JsonElement>> result = BiomeDataHolders.OverworldSubBiomeDataHolder.CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(biomesConfigFile))).result();
            if (result.isPresent()) {
                overworldSubBiomeDataHolder = result.get().getFirst();
            }

        } catch (IOException e) {
            LOGGER.error("Could not read \"" + biomesConfigPath.toString() + "\"... using internal defaults...");
            e.printStackTrace();
        }

        overworldSubBiomeDataHolder.getBiomeData().forEach(((location, subBiomeData) -> {
            ResourceLocation river = subBiomeData.getRiver();
            if (!river.equals(EMPTY) ) {
                BYGBiome.BIOME_TO_RIVER_LIST.put(location, river);
            }
            ResourceLocation beach = subBiomeData.getBeach();
            if (!beach.equals(EMPTY) ) {
                BYGBiome.BIOME_TO_BEACH_LIST.put(location, beach);
            }
            ResourceLocation edgeBiome = subBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(EMPTY)) {
                BYGBiome.BIOME_TO_EDGE_LIST.put(location, edgeBiome);
            }
        }));

        BYGBiomes.fillBiomeDictionary(overworldSubBiomeDataHolder.getBiomeData());
    }

    public static void clientLoad() {
        isClient = true;
        LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        entryPoint.renderCutouts();
        LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    public static void threadSafeLoadFinish() {
        LOGGER.debug("BYG: \"Load Complete Event\" Starting...");
        BYGCompostables.compostablesBYG();
        BYGHoeables.hoeablesBYG();
        BYGFlammables.flammablesBYG();
        BYGStrippables.strippableLogsBYG();
        BYGCarvableBlocks.addCarverBlocks();
        BYGPaths.addBYGPaths();
        if (Platform.isForge()){
            cleanMemory();
        }
        LOGGER.info("BYG: \"Load Complete\" Event Complete!");
    }

    //Minimize BYG's ram footprint.
    private static void cleanMemory() {
        BYG.LOGGER.debug("Cleaning memory...");
        BYGBlocks.flowerPotBlocks = null;
        FILE_PATH = null;
        BYG.LOGGER.debug("Cleaned memory!");
    }
}