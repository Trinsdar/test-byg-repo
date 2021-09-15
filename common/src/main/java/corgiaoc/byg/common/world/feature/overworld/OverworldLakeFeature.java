package corgiaoc.byg.common.world.feature.overworld;

import corgiaoc.byg.common.world.OpenSimplexNoiseEnd;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.BlockHelper;
import corgiaoc.byg.util.FeatureHelper;
import corgiaoc.byg.util.MLBlockTags;
import corgiaoc.byg.util.ModMathHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;

import java.util.Random;

//Credits to BetterEnd & Pauelevs
public class OverworldLakeFeature extends Feature<NoneFeatureConfiguration> {
    private static final BlockState END_STONE = Blocks.STONE.defaultBlockState();
    private static final OpenSimplexNoiseEnd NOISE = new OpenSimplexNoiseEnd(15152);
    private static final BlockPos.MutableBlockPos POS = new BlockPos.MutableBlockPos();

    public OverworldLakeFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator chunkGenerator_, Random random,
                         BlockPos blockPos, NoneFeatureConfiguration config) {
        double radius = ModMathHelper.randRange(10.0, 20.0, random);
        double depth = radius * 0.5 * ModMathHelper.randRange(0.8, 1.2, random);
        int dist = ModMathHelper.floor(radius);
        int dist2 = ModMathHelper.floor(radius * 1.5);
        int bott = ModMathHelper.floor(depth);

        blockPos = FeatureHelper.getPosOnSurfaceWG(world, blockPos);
        if (blockPos.getY() < 10) return false;

        int waterLevel = blockPos.getY();

        BlockPos pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.north(dist).above(10), 20);
        if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
        waterLevel = ModMathHelper.min(pos.getY(), waterLevel);

        pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.south(dist).above(10), 20);
        if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
        waterLevel = ModMathHelper.min(pos.getY(), waterLevel);

        pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.east(dist).above(10), 20);
        if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
        waterLevel = ModMathHelper.min(pos.getY(), waterLevel);

        pos = FeatureHelper.getPosOnSurfaceRaycast(world, blockPos.west(dist).above(10), 20);
        if (Math.abs(blockPos.getY() - pos.getY()) > 5) return false;
        waterLevel = ModMathHelper.min(pos.getY(), waterLevel);
        BlockState state;

        int minX = blockPos.getX() - dist2;
        int maxX = blockPos.getX() + dist2;
        int minZ = blockPos.getZ() - dist2;
        int maxZ = blockPos.getZ() + dist2;
        int maskMinX = minX - 1;
        int maskMinZ = minZ - 1;

        boolean[][] mask = new boolean[maxX - minX + 3][maxZ - minZ + 3];
        for (int x = minX; x <= maxX; x++) {
            POS.setX(x);
            int mx = x - maskMinX;
            for (int z = minZ; z <= maxZ; z++) {
                POS.setZ(z);
                int mz = z - maskMinZ;
                if (!mask[mx][mz]) {
                    for (int y = waterLevel + 1; y <= waterLevel + 20; y++) {
                        POS.setY(y);
                        FluidState fluid = world.getFluidState(POS);
                        if (!fluid.isEmpty()) {
                            for (int i = -1; i < 2; i++) {
                                int px = mx + i;
                                for (int j = -1; j < 2; j++) {
                                    int pz = mz + j;
                                    mask[px][pz] = true;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }

        for (int x = minX; x <= maxX; x++) {
            POS.setX(x);
            int x2 = x - blockPos.getX();
            x2 *= x2;
            int mx = x - maskMinX;
            for (int z = minZ; z <= maxZ; z++) {
                POS.setZ(z);
                int z2 = z - blockPos.getZ();
                z2 *= z2;
                int mz = z - maskMinZ;
                if (!mask[mx][mz]) {
                    double size = 1;
                    for (int y = blockPos.getY(); y <= blockPos.getY() + 20; y++) {
                        POS.setY(y);
                        double add = y - blockPos.getY();
                        if (add > 5) {
                            size *= 0.8;
                            add = 5;
                        }
                        double r = (add * 1.8 + radius * (NOISE.eval(x * 0.2, y * 0.2, z * 0.2) * 0.25 + 0.75)) - 1.0 / size;
                        if (r > 0) {
                            r *= r;
                            if (x2 + z2 <= r) {
                                state = world.getBlockState(POS);
                                if (state.is(BlockTags.BASE_STONE_OVERWORLD)) {
                                    BlockHelper.setWithoutUpdate(world, POS, Blocks.AIR.defaultBlockState());
                                }
                                pos = POS.below();
                                if (world.getBlockState(pos).is(BlockTags.BASE_STONE_OVERWORLD)) {
                                    state = world.getBiome(pos).getGenerationSettings().getSurfaceBuilderConfig().getTopMaterial();
                                    if (y > waterLevel + 1)
                                        BlockHelper.setWithoutUpdate(world, pos, state);
                                    else if (y > waterLevel)
                                        BlockHelper.setWithoutUpdate(world, pos, random.nextBoolean() ? state : Blocks.GRAVEL.defaultBlockState());
                                    else
                                        BlockHelper.setWithoutUpdate(world, pos, Blocks.GRAVEL.defaultBlockState());
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        double aspect = ((double) radius / (double) depth);

        for (int x = blockPos.getX() - dist; x <= blockPos.getX() + dist; x++) {
            POS.setX(x);
            int x2 = x - blockPos.getX();
            x2 *= x2;
            int mx = x - maskMinX;
            for (int z = blockPos.getZ() - dist; z <= blockPos.getZ() + dist; z++) {
                POS.setZ(z);
                int z2 = z - blockPos.getZ();
                z2 *= z2;
                int mz = z - maskMinZ;
                if (!mask[mx][mz]) {
                    for (int y = blockPos.getY() - bott; y < blockPos.getY(); y++) {
                        POS.setY(y);
                        double y2 = (double) (y - blockPos.getY()) * aspect;
                        y2 *= y2;
                        double r = radius * (NOISE.eval(x * 0.2, y * 0.2, z * 0.2) * 0.25 + 0.75);
                        double rb = r * 1.2;
                        r *= r;
                        rb *= rb;
                        if (y2 + x2 + z2 <= r) {
                            state = world.getBlockState(POS);
                            if (canReplace(state)) {
                                state = world.getBlockState(POS.above());
                                state = canReplace(state) ? (y < waterLevel ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState()) : state;
                                BlockHelper.setWithoutUpdate(world, POS, state);
                            }
                            pos = POS.below();
                            if (world.getBlockState(pos).getBlock().is(BlockTags.BASE_STONE_OVERWORLD)) {
                                BlockHelper.setWithoutUpdate(world, pos, Blocks.GRAVEL.defaultBlockState());
                            }
                            pos = POS.above();
                            while (canReplace(state = world.getBlockState(pos)) && !state.isAir() && state.getFluidState().isEmpty()) {
                                BlockHelper.setWithoutUpdate(world, pos, pos.getY() < waterLevel ? Blocks.WATER : Blocks.AIR);
                                pos = pos.above();
                            }
                        }
                        // Make border
                        else if (y < waterLevel && y2 + x2 + z2 <= rb) {
                            if (world.isEmptyBlock(POS.above())) {
                                state = world.getBiome(POS).getGenerationSettings().getSurfaceBuilderConfig().getTopMaterial();
                                BlockHelper.setWithoutUpdate(world, POS, random.nextBoolean() ? state : Blocks.GRAVEL.defaultBlockState());
                                BlockHelper.setWithoutUpdate(world, POS.below(), END_STONE);
                            } else {
                                BlockHelper.setWithoutUpdate(world, POS, Blocks.GRAVEL.defaultBlockState());
                                BlockHelper.setWithoutUpdate(world, POS.below(), END_STONE);
                            }
                        }
                    }
                }
            }
        }

        BlockHelper.fixBlocks(world, new BlockPos(minX - 2, waterLevel - 2, minZ - 2), new BlockPos(maxX + 2, blockPos.getY() + 20, maxZ + 2));

        return true;
    }

    private boolean canReplace(BlockState state) {
        return state.getMaterial().isReplaceable()
                || state.is(BlockTags.BASE_STONE_OVERWORLD)
                || state.is(BlockTags.FLOWERS)
                || state.is(MLBlockTags.ORES) // Handles floating ores
                || state.is(Blocks.PODZOL) // Handles other blocks that could be left floating
                || state.is(Blocks.COARSE_DIRT) // Handles other blocks that could be left floating
                || state.is(Blocks.DIRT) // Handles other blocks that could be left floating
                || state.is(Blocks.GRAVEL)
                || state.is(Blocks.GRASS)
                || state.is(Blocks.GRASS_BLOCK)
                || state.is(BYGBlocks.OVERGROWN_STONE)
                || state.is(BYGBlocks.WEED_GRASS)
                || state.is(BYGBlocks.SHORT_GRASS)
                || state.getMaterial().equals(Material.PLANT)
                || state.getMaterial().equals(Material.WATER_PLANT)
                || state.getMaterial().equals(Material.REPLACEABLE_WATER_PLANT);
    }
}