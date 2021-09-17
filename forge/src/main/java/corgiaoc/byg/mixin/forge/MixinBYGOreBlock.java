package corgiaoc.byg.mixin.forge;

import corgiaoc.byg.common.properties.blocks.BYGOreBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BYGOreBlock.class)
public abstract class MixinBYGOreBlock extends OreBlock implements IForgeBlock {
    public MixinBYGOreBlock(Properties p_i48357_1_) {
        super(p_i48357_1_);
    }

    @Override
    public int getHarvestLevel(BlockState state) {
        return 3;
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }
}
