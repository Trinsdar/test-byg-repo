package corgiaoc.byg.mixin.forge;

import corgiaoc.byg.common.properties.blocks.nether.scorched.ScorchedPlantBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraftforge.common.IForgeShearable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ScorchedPlantBlock.class)
public abstract class MixinScorchedPlantBlock extends BushBlock implements IForgeShearable {
    public MixinScorchedPlantBlock(Properties p_i48437_1_) {
        super(p_i48437_1_);
    }
}
