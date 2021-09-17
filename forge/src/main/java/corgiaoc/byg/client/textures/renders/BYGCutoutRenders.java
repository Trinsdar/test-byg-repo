package corgiaoc.byg.client.textures.renders;


import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class BYGCutoutRenders {
    public static void renderCutOuts() {
        BYG.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        //Plants
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HORSEWEED, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_SAGE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MINI_CACTUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PRICKLY_PEAR_CACTUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WINTER_SUCCULENT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GLOWSTONE_LANTERN, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.NETHER_BRISTLE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WEEPING_ROOTS_PLANT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WEEPING_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_CHERRY_FOLIAGE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WHITE_CHERRY_FOLIAGE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TALL_PINK_ALLIUM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TALL_ALLIUM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TALL_EMBUR_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_WART, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_GEL_BLOCK, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_GEL_VINES, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_GEL_VINES_PLANT, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_GEL_BRANCH, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_SPROUTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_LILY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HANGING_BONE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.QUARTZ_CRYSTAL, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WAILING_BELL_BLOSSOM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WAILING_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WAILING_VINES, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SCORCHED_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SCORCHED_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BORIC_CAMPFIRE, RenderType.cutoutMipped());
        //Nether
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.OVERGROWN_NETHERRACK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MOSSY_NETHERRACK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SOUL_SHROOM_SPORE_END, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SOUL_SHROOM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.DEATH_CAP, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LAMENT_VINE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LAMENT_VINE_PLANT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LAMENT_SPROUTS, RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SUBZERO_CRYSTAL_CLUSTER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD, RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ARISIAN_BLOOM_BRANCH, RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TALL_CRIMSON_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CRIMSON_BERRY_BUSH, RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WARPED_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WARPED_CACTUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WARPED_CORAL_FAN, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WARPED_CORAL, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WARPED_CORAL_WALL_FAN, RenderType.cutoutMipped());

        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_SPROUT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_STALK_BLOCK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_NYLIUM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_FUNGUS, RenderType.cutoutMipped());

        //End
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IVIS_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IVIS_SPROUT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.NIGHTSHADE_SPROUTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ETHER_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ETHER_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.THEREAL_BELLFLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ETHER_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.NIGHTSHADE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_BULBIS_ODDITY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_BULBIS_SHELL, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BULBIS_ODDITY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BULBIS_SHELL, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.NIGHTSHADE_BERRY_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.NIGHTSHADE_ROOTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.VERMILION_SCULK_GROWTH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.THERIUM_LANTERN, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ODDITY_CACTUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ODDITY_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.THERIUM_CRYSTAL, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SHULKREN_MOSS_BLANKET, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SHULKREN_FUNGUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SHULKREN_VINE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SHULKREN_VINE_PLANT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CRYPTIC_CAMPFIRE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ENDER_LILY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CRYPTIC_BRAMBLE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IMPARIUS_MUSHROOM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FUNGAL_IMPARIUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IMPARIUS_VINE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IMPARIUS_VINE_PLANT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IMPARIUS_MUSHROOM_BRANCH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IMPARIUS_BUSH, RenderType.cutoutMipped());

        //Sea Plants
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CATTAIL, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.REEDS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TINY_LILYPADS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WATER_SILK, RenderType.translucent());

        //GlowCane
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_GLOWCANE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_GLOWCANE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_GLOWCANE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RED_GLOWCANE, RenderType.cutoutMipped());

        //Doors
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ASPEN_DOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BAOBAB_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CHERRY_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CIKA_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CYPRESS_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EBONY_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FIR_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HOLLY_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.JACARANDA_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAHOGANY_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MANGROVE_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAPLE_DOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PALM_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINE_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.REDWOOD_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SKYRIS_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WILLOW_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WITCH_HAZEL_DOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ZELKOVA_DOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_DOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LAMENT_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BULBIS_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ETHER_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.NIGHTSHADE_DOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IMPARIUS_DOOR, RenderType.cutoutMipped());

        //Trapdoors
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ASPEN_TRAPDOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BAOBAB_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CHERRY_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CIKA_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CYPRESS_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EBONY_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FIR_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HOLLY_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.JACARANDA_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAHOGANY_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MANGROVE_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAPLE_TRAPDOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PALM_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINE_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.REDWOOD_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SKYRIS_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WILLOW_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WITCH_HAZEL_TRAPDOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ZELKOVA_TRAPDOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EMBUR_TRAPDOOR, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LAMENT_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BULBIS_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ETHER_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.NIGHTSHADE_TRAPDOOR, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IMPARIUS_TRAPDOOR, RenderType.cutoutMipped());

        //Grass
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TALL_PRAIRIE_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PRAIRIE_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SHORT_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WINTER_GRASS, RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SHORT_BEACH_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BEACH_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WILTED_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WEED_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LEAF_PILE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CLOVER_PATCH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FLOWER_PATCH, RenderType.cutoutMipped());


        //Saplings
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ASPEN_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BAOBAB_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_ENCHANTED_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_SPRUCE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BROWN_BIRCH_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BROWN_OAK_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CYPRESS_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CIKA_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.EBONY_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FIR_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GREEN_ENCHANTED_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HOLLY_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.JACARANDA_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.INDIGO_JACARANDA_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FLOWERING_JACARANDA_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.JACARANDA_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.INDIGO_JACARANDA_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.JOSHUA_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAHOGANY_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MANGROVE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAPLE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.HOLLY_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ORANGE_BIRCH_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ORANGE_OAK_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ORANGE_SPRUCE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ORCHARD_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PALM_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PALO_VERDE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_CHERRY_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RED_BIRCH_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RED_MAPLE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RED_OAK_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RED_SPRUCE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.REDWOOD_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SILVER_MAPLE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SKYRIS_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WHITE_CHERRY_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WILLOW_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WITCH_HAZEL_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ZELKOVA_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.YELLOW_BIRCH_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.YELLOW_SPRUCE_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BROWN_ZELKOVA_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ARAUCARIA_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LAMENT_SAPLING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WITHERING_OAK_SAPLING, RenderType.cutoutMipped());

        //Mushrooms
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLACK_PUFF, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WEEPING_MILKCAP, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WOOD_BLEWIT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GREEN_MUSHROOM, RenderType.cutoutMipped());


        //FlowerBlocks
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ALLIUM_FLOWER_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ALPINE_BELLFLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.AMARANTH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ANGELICA, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.AZALEA, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BEGONIA, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BISTORT, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CALIFORNIA_POPPY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CROCUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLACK_ROSE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CYAN_AMARANTH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CYAN_ROSE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CYAN_TULIP, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.DAFFODIL, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.DELPHINIUM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FAIRY_SLIPPER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FIRECRACKER_FLOWER_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.FOXGLOVE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GOLDEN_SPINED_CACTUS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GREEN_TULIP, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GUZMANIA, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.INCAN_LILY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.IRIS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.JAPANESE_ORCHID, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.KOVAN_FLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LAZARUS_BELLFLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.LOLIPOP_FLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAGENTA_AMARANTH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MAGENTA_TULIP, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ORANGE_AMARANTH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ORANGE_DAISY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ORSIRIA_ROSE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PEACH_LEATHER_FLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_ALLIUM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_ANEMONE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_DAFFODIL, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PINK_ORCHID, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PROTEA_FLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_AMARANTH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_ORCHID, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_SAGE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_TULIP, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RED_CORNFLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RED_ORCHID, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.RICHEA, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ROSE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SNOWDROPS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SILVER_VASE_FLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TORCH_GINGER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.VIOLET_LEATHER_FLOWER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WHITE_ANEMONE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WHITE_SAGE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WINTER_CYCLAMEN, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WINTER_ROSE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.WINTER_SCILLA, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.YELLOW_DAFFODIL, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.YELLOW_TULIP, RenderType.cutoutMipped());

        //Other renders
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.AMETRINE_CLUSTER, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUE_GLOWSHROOM_BLOCK, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BORIC_FIRE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.CRYPTIC_FIRE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.THERIUM_GLASS, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.THERIUM_GLASS_PANE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ETHER_FOLIAGE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.VERMILION_SCULK_TENDRILS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.TALL_ETHER_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BULBIS_SPROUTS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BULBIS_ANOMALY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PURPLE_BULBIS_ANOMALY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.ETHER_BULB, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BAOBAB_FRUIT_BLOCK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLACK_ICE, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.AMETRINE_BLOCK, RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.BLUEBERRY_BUSH, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SYTHIAN_SCAFFOLDING, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.OVERGROWN_STONE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.OVERGROWN_DACITE, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.PRAIRIE_GRASS, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.MEADOW_GRASSBLOCK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.GLOWCELIUM, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.POISON_IVY, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(BYGBlocks.SKYRIS_VINE, RenderType.cutoutMipped());

        for (Block potBlock : BYGBlocks.flowerPotBlocks.values())
            ItemBlockRenderTypes.setRenderLayer(potBlock, RenderType.cutoutMipped());

        BYG.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
}
