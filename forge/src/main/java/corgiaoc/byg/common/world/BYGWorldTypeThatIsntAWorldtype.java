package corgiaoc.byg.common.world;

import com.mojang.serialization.Lifecycle;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeSource;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeSource;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.OverworldBiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraftforge.common.world.ForgeWorldType;

public class BYGWorldTypeThatIsntAWorldtype extends ForgeWorldType {
    public BYGWorldTypeThatIsntAWorldtype() {
        super(null);
    }

    @Override
    public ChunkGenerator createChunkGenerator(Registry<Biome> biomeRegistry, Registry<NoiseGeneratorSettings> dimensionSettingsRegistry, long seed, String generatorSettings) {
        return new NoiseBasedChunkGenerator(new OverworldBiomeSource(seed, false, false, biomeRegistry), seed, () -> dimensionSettingsRegistry.getOrThrow(NoiseGeneratorSettings.OVERWORLD));
    }

    public static MappedRegistry<LevelStem> getDefaultSimpleRegistry(Registry<DimensionType> lookUpRegistryDimensionType, Registry<Biome> registry, Registry<NoiseGeneratorSettings> dimensionSettings, long seed) {
        MappedRegistry<LevelStem> simpleregistry = new MappedRegistry<>(Registry.LEVEL_STEM_REGISTRY, Lifecycle.stable());
        simpleregistry.register(LevelStem.OVERWORLD, new LevelStem(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.OVERWORLD_LOCATION), new NoiseBasedChunkGenerator(new BYGNetherBiomeSource(registry, seed), seed, () -> dimensionSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD))), Lifecycle.stable());

        simpleregistry.register(LevelStem.NETHER, new LevelStem(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.NETHER_LOCATION), new NoiseBasedChunkGenerator(new BYGNetherBiomeSource(registry, seed), seed, () -> dimensionSettings.getOrThrow(NoiseGeneratorSettings.NETHER))), Lifecycle.stable());

        simpleregistry.register(LevelStem.END, new LevelStem(() -> lookUpRegistryDimensionType.getOrThrow(DimensionType.END_LOCATION), new NoiseBasedChunkGenerator(new BYGEndBiomeSource(registry, seed), seed, () -> dimensionSettings.getOrThrow(NoiseGeneratorSettings.END))), Lifecycle.stable());

        return simpleregistry;
    }

    @Override
    public WorldGenSettings createSettings(RegistryAccess dynamicRegistries, long seed, boolean generateStructures, boolean generateLoot, String generatorSettings) {
        return new HideWorldType(seed, generateStructures, generateLoot, getDefaultSimpleRegistry(dynamicRegistries.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY), dynamicRegistries.registryOrThrow(Registry.BIOME_REGISTRY), dynamicRegistries.registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY), seed));
    }

    public static class HideWorldType extends WorldGenSettings {

        public HideWorldType(long seed, boolean generateFeatures, boolean bonusChest, MappedRegistry<LevelStem> dimensionSimpleRegistry) {
            super(seed, generateFeatures, bonusChest, dimensionSimpleRegistry);
        }

        @Override
        public boolean isDebug() {
            return true;
        }
    }
}
