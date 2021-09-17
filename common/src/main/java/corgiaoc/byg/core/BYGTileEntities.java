package corgiaoc.byg.core;

import com.mojang.datafixers.types.Type;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.tileentities.HypogealImperiumTE;
import corgiaoc.byg.mixin.access.BlockEntityTypeBuilderAccess;
import me.shedaniel.architectury.platform.Platform;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BYGTileEntities {

    public static final Map<ResourceLocation, BlockEntityType<?>> BLOCK_ENTITIES = new LinkedHashMap<>();

    public static final BlockEntityType<HypogealImperiumTE> HYPOGEAL  = register("hypogeal", BlockEntityType.Builder.of(HypogealImperiumTE::new, BYGBlocks.HYPOGEAL_IMPERIUM));


    private static <T extends BlockEntity> BlockEntityType<T> register(String key, BlockEntityType.Builder<T> builder) {
        if (((BlockEntityTypeBuilderAccess) (Object) builder).getValidBlocks().isEmpty()) {
            BYG.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", (Object) key);
        }

        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        BlockEntityType<T> blockEntityType = builder.build(type);
        if (Platform.isFabric())
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(BYG.MOD_ID, key), blockEntityType);
        BLOCK_ENTITIES.put(new ResourceLocation(BYG.MOD_ID, key), blockEntityType);
        return blockEntityType;
    }
}