package corgiaoc.byg.common.world.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class QuartzSpikeConfig implements FeatureConfiguration {

    public static final Codec<QuartzSpikeConfig> CODEC = RecordCodecBuilder.create((codecRecorder) -> {
        return codecRecorder.group(BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((config) -> {
            return config.blockProvider;
        })).apply(codecRecorder, QuartzSpikeConfig::new);
    });


    private final BlockStateProvider blockProvider;

    public QuartzSpikeConfig(BlockStateProvider blockProvider) {
        this.blockProvider = blockProvider;
    }

    public BlockStateProvider getBlockProvider() {
        return this.blockProvider;
    }


    public static class Builder {
        private BlockStateProvider blockProvider = new SimpleStateProvider(Blocks.SMOOTH_QUARTZ.defaultBlockState());

        public Builder setBlock(Block block) {
            this.blockProvider = new SimpleStateProvider(block.defaultBlockState());
            return this;
        }

        public Builder setBlock(BlockState state) {
            this.blockProvider = new SimpleStateProvider(state);
            return this;
        }


        public QuartzSpikeConfig build() {
            return new QuartzSpikeConfig(this.blockProvider);
        }
    }
}
