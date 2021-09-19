package corgiaoc.byg.common.world.dimension.end;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.world.dimension.DatapackLayer;
import corgiaoc.byg.config.json.biomedata.BiomeData;
import corgiaoc.byg.config.json.biomedata.BiomeDataHolders;
import corgiaoc.byg.config.json.biomedata.WeightedBiomeData;
import corgiaoc.byg.mixin.access.WeightedListAccess;
import net.fabricmc.fabric.impl.biome.InternalBiomeData;
import net.fabricmc.fabric.impl.biome.SimpleLayerRandomnessSource;
import net.fabricmc.fabric.impl.biome.WeightedBiomePicker;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import net.minecraft.world.level.newbiome.context.Context;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class BYGEndBiomeSource extends BiomeSource {
    public static final Codec<BYGEndBiomeSource> BYGENDCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGEndBiomeSource::new)));

    private final long seed;
    private final DatapackLayer mainIslandLayer;
    private final DatapackLayer smallIslandLayer;
    private final Registry<Biome> biomeRegistry;
    private final SimplexNoise generator;
    Context randomnessSource;

    @SuppressWarnings("unchecked")
    public BYGEndBiomeSource(Registry<Biome> registry, long seed) {
        super(new ArrayList<>());
        this.seed = seed;
        WorldgenRandom sharedseedrandom = new WorldgenRandom(seed);
        sharedseedrandom.consumeCount(17292);
        this.biomeRegistry = registry;
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        WeightedList<ResourceLocation> endBiomes = new WeightedList<>();
        Map<ResourceLocation, WeightedList<ResourceLocation>> endHills = new HashMap<>();
        Map<ResourceLocation, ResourceLocation> biomeToEdge = new HashMap<>();
        Set<ResourceLocation> allBiomes = new HashSet<>();
        BiomeDataHolders.EndBiomeDataHolder endBiomeDataHolder = BYG.getEndData(gson, BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-biomes.json"));
        Map<ResourceLocation, WeightedBiomeData> endBiomeData1 = endBiomeDataHolder.getEndBiomeData();
        endBiomeData1.remove(null);
        endBiomeData1.remove(BYG.EMPTY);
        endBiomeData1.forEach(((biome, endBiomeData) -> {
            endBiomes.add(biome, endBiomeData.getWeight());
            endHills.put(biome, endBiomeData.getSubBiomes());
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                biomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.addAll(((WeightedListAccess<ResourceLocation>) endBiomeData.getSubBiomes()).getEntries().stream().map(WeightedList.WeightedEntry::getData).collect(Collectors.toList()));
        }));
        endHills.remove(BYG.EMPTY);
        biomeToEdge.remove(BYG.EMPTY);
        endHills.remove(null);
        biomeToEdge.remove(null);
        WeightedList<ResourceLocation> voidBiomes = new WeightedList<>();
        Map<ResourceLocation, WeightedList<ResourceLocation>> voidHillsMap = new HashMap<>();
        Map<ResourceLocation, ResourceLocation> voidBiomeToEdge = new HashMap<>();

        Map<ResourceLocation, WeightedBiomeData> voidBiomeData = endBiomeDataHolder.getVoidBiomeData();
        voidBiomeData.remove(null);
        voidBiomeData.remove(BYG.EMPTY);
        voidBiomeData.forEach(((biome, endBiomeData) -> {
            voidBiomes.add(biome, endBiomeData.getWeight());
            voidHillsMap.put(biome, endBiomeData.getSubBiomes());
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                voidBiomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.addAll(((WeightedListAccess<ResourceLocation>) endBiomeData.getSubBiomes()).getEntries().stream().map(WeightedList.WeightedEntry::getData).collect(Collectors.toList()));
        }));

        BiomeDataHolders.EndSubBiomeDataHolder endSubBiomeDataHolder = BYG.getEndSubBiomeData(gson, BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-sub-biomes.json"));

        Map<ResourceLocation, BiomeData> endSubBiomeData = endSubBiomeDataHolder.getEndSubBiomeData();
        endSubBiomeData.remove(null);
        endSubBiomeData.remove(BYG.EMPTY);
        endSubBiomeData.forEach(((biome, endBiomeData) -> {
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                biomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.add(endBiomeData.getEdgeBiome());
        }));

        Map<ResourceLocation, BiomeData> voidSubBiomeData = endSubBiomeDataHolder.getVoidSubBiomeData();
        voidSubBiomeData.remove(null);
        voidBiomeData.remove(BYG.EMPTY);
        voidSubBiomeData.forEach(((biome, endBiomeData) -> {
            ResourceLocation edgeBiome = endBiomeData.getEdgeBiome();
            if (!edgeBiome.equals(BYG.EMPTY)) {
                voidBiomeToEdge.put(biome, edgeBiome);
            }
            allBiomes.add(biome);
            allBiomes.add(endBiomeData.getEdgeBiome());
        }));
        voidHillsMap.remove(BYG.EMPTY);
        voidBiomeToEdge.remove(BYG.EMPTY);
        voidHillsMap.remove(null);
        voidBiomeToEdge.remove(null);
        this.possibleBiomes.addAll(allBiomes.stream().filter(resourceLocation -> resourceLocation != null && !resourceLocation.equals(BYG.EMPTY)).map(registry::get).collect(Collectors.toList()));
        this.mainIslandLayer = SimpleLayerProvider.stackLayers(this.biomeRegistry, seed, BYG.worldConfig().endBiomeSize, endBiomes, endHills, biomeToEdge);
        this.smallIslandLayer = SimpleLayerProvider.stackLayers(this.biomeRegistry, seed, BYG.worldConfig().voidBiomeSize, voidBiomes, voidHillsMap, voidBiomeToEdge);
        this.generator = new SimplexNoise(sharedseedrandom);
        randomnessSource = new SimpleRandomSource(seed);
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return BYGENDCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGEndBiomeSource(biomeRegistry, seed);
    }

    //@Override
    public Biome getNoiseBiome2(int x, int y, int z) {
        int xBitOffset = x >> 2;
        int zBitOffset = z >> 2;
        if ((long) xBitOffset * (long) xBitOffset + (long) zBitOffset * (long) zBitOffset <= 4096L) {
            return biomeRegistry.getOrThrow(Biomes.THE_END);
        } else {
            float sampledNoise = TheEndBiomeSource.getHeightValue(this.generator, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (sampledNoise >= -20.0F) {
                return mainIslandLayer.sampleEnd(biomeRegistry, x, z);
            } else {
                return this.smallIslandLayer.sampleEndVoid(biomeRegistry, x, z);
            }
        }
    }

    public Biome getNoiseBiome(int x, int y, int z) {
        int xBitOffset = x >> 2;
        int zBitOffset = z >> 2;
        if ((long)xBitOffset * (long)xBitOffset + (long)zBitOffset * (long)zBitOffset <= 4096L) {
            return biomeRegistry.getOrThrow(Biomes.THE_END);
        } else {
            float sampledNoise = TheEndBiomeSource.getHeightValue(this.generator, xBitOffset * 2 + 1, zBitOffset * 2 + 1);
            if (sampledNoise > 40.0F) {
                return getWeightedEndBiome(x, y, z, biomeRegistry.getOrThrow(Biomes.END_HIGHLANDS));
            } else if (sampledNoise >= 0.0F) {
                return biomeRegistry.getOrThrow(Biomes.END_MIDLANDS);
            } else {
                return sampledNoise < -20.0F ? biomeRegistry.getOrThrow(Biomes.SMALL_END_ISLANDS) : biomeRegistry.getOrThrow(Biomes.END_BARRENS);
            }
        }
    }

    private Biome getWeightedEndBiome(int biomeX, int biomeY, int biomeZ, Biome vanillaBiome) {

        // Since all vanilla biomes are added to the registry, this will never fail.
        ResourceKey<Biome> vanillaKey = biomeRegistry.getResourceKey(vanillaBiome).get();
        ResourceKey<Biome> replacementKey;

        // The x and z of the biome are divided by 64 to ensure custom biomes are large enough; going larger than this]
        // seems to make custom biomes too hard to find.
        if (vanillaKey == Biomes.END_MIDLANDS || vanillaKey == Biomes.END_BARRENS) {
            // Since the highlands picker is statically populated by InternalBiomeData, picker will never be null.
            WeightedBiomePicker highlandsPicker = InternalBiomeData.getEndBiomesMap().get(Biomes.END_HIGHLANDS);
            ResourceKey<Biome> highlandsKey = highlandsPicker.pickFromNoise(randomnessSource, biomeX/64.0, 0, biomeZ/64.0);

            if (vanillaKey == Biomes.END_MIDLANDS) {
                WeightedBiomePicker midlandsPicker = InternalBiomeData.getEndMidlandsMap().get(highlandsKey);
                replacementKey = (midlandsPicker == null) ? vanillaKey : midlandsPicker.pickFromNoise(randomnessSource, biomeX/64.0, 0, biomeZ/64.0);
            } else {
                WeightedBiomePicker barrensPicker = InternalBiomeData.getEndBarrensMap().get(highlandsKey);
                replacementKey = (barrensPicker == null) ? vanillaKey : barrensPicker.pickFromNoise(randomnessSource, biomeX/64.0, 0, biomeZ/64.0);
            }
        } else {
            // Since the main island and small islands pickers are statically populated by InternalBiomeData, picker will never be null.
            WeightedBiomePicker picker = InternalBiomeData.getEndBiomesMap().get(vanillaKey);
            replacementKey = picker.pickFromNoise(randomnessSource, biomeX*64.0, 0, biomeZ*64.0);
        }

        return biomeRegistry.get(replacementKey);
    }

    public static class SimpleRandomSource implements Context{
        private final ImprovedNoise sampler;
        private final Random random;
        public SimpleRandomSource(long seed){
            this.random = new Random(seed);
            this.sampler = new ImprovedNoise(random);
        }

        @Override
        public int nextRandom(int i) {
            return random.nextInt(i);
        }

        @Override
        public ImprovedNoise getBiomeNoise() {
            return sampler;
        }
    }
}