package corgiaoc.byg.common.world.feature.overworld.pumpkins;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.PumpkinConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.Random;

public class LargePumpkin1 extends Feature<PumpkinConfig> {

    public LargePumpkin1(Codec<PumpkinConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random random, BlockPos pos, PumpkinConfig config) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();


        if (world.getBlockState(pos.below()) != config.getPumpkinProvider().getState(random, pos) || !world.getBlockState(pos.below()).canOcclude())
            return false;

        if (posY - 1 < world.getMaxBuildHeight()) {
            setPumpkinState(mutable.set(posX, posY + 1, posZ), random, config, world);
            setPumpkinState(mutable.set(posX - 1, posY, posZ), random, config, world);
            setPumpkinState(mutable.set(posX + 1, posY, posZ), random, config, world);
            setPumpkinState(mutable.set(posX + 1, posY, posZ + 1), random, config, world);
            setPumpkinState(mutable.set(posX, posY, posZ + 1), random, config, world);
            setPumpkinState(mutable.set(posX, posY, posZ - 1), random, config, world);
        }
        return true;
    }

    private void setPumpkinState(BlockPos pos, Random rand, PumpkinConfig config, WorldGenLevel world) {
        if (world.isEmptyBlock(pos) || FeatureUtil.isPlant(world, pos)) {
            world.setBlock(pos, config.getPumpkinProvider().getState(rand, pos), 2);
        }
    }
}