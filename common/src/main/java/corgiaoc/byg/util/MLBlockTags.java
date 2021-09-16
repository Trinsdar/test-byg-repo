package corgiaoc.byg.util;

import me.shedaniel.architectury.platform.Platform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class MLBlockTags {

    public static final String MOD_LOADER_TAG_TARGET = Platform.isFabric() ? "c" : "forge";

    public static final Tag.Named<Block> NETHERRACK = createTag("netherrack");
    public static final Tag.Named<Block> DIRT = createTag("dirt");
    public static final Tag.Named<Block> END_STONES = createTag("end_stones");
    public static final Tag.Named<Block> ORES = createTag("ores");
    public static final Tag.Named<Block> BOOKSHELVES = createTag("bookshelves");
    public static final Tag.Named<Block> STONE = createTag("stone");

    public static Tag.Named<Block> createTag(String path) {
        return ExpectPlatformUtils.createBlockTag(new ResourceLocation(MOD_LOADER_TAG_TARGET, path));
    }
}
