package corgiaoc.byg.common.world.structure.village.villagepools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.ProcessorLists;

public class SkyrisVillagePools {
   public static final JigsawPattern SkyrisVillageJigsaw = JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("byg:village/skyris/town_centers"),
           new ResourceLocation("empty"),
           ImmutableList.of(Pair.of(JigsawPiece.legacy("byg:village/skyris/town_centers/skyris_meeting_point_1", ProcessorLists.MOSSIFY_10_PERCENT), 25),
                   Pair.of(JigsawPiece.legacy("byg:village/skyris/town_centers/skyris_meeting_point_2", ProcessorLists.MOSSIFY_10_PERCENT), 25),
                   Pair.of(JigsawPiece.legacy("byg:village/skyris/town_centers/skyris_meeting_point_3", ProcessorLists.MOSSIFY_10_PERCENT), 25),
                   Pair.of(JigsawPiece.legacy("byg:village/skyris/town_centers/skyris_meeting_point_4", ProcessorLists.MOSSIFY_10_PERCENT), 25)), JigsawPattern.PlacementBehaviour.RIGID));

   public static void init() {
   }

   static {
      //Normal
      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("byg:village/skyris/streets"),
              new ResourceLocation("byg:village/skyris/terminators"),
              ImmutableList.of(Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_corner_01"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_corner_02"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_straight_01"), 4),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_straight_02"), 4),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_straight_03"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_crossroad_01"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_crossroad_02"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_crossroad_03"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_square_01"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_square_02"), 3),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/streets/skyris_turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      
      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("byg:village/skyris/houses"),
              new ResourceLocation("byg:village/skyris/terminators"),
              ImmutableList.of(Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_small_house_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_small_house_2"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_small_house_3"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_small_house_4"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_small_house_5"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_small_house_6"), 1),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_medium_house_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_butcher_shop_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_tool_smith_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_fletcher_house_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_butcher_shop_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_armorer_1"), 1),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_fisher_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_cartographer_house_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_library_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_mason_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_weaponsmith_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_temple_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_large_farm_1", ProcessorLists.FARM_DESERT), 11),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_animal_pen_1"), 2),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/houses/skyris_animal_pen_2"), 2),
                      Pair.of(JigsawPiece.empty(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
      
      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("byg:village/skyris/terminators"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.legacy("byg:village/skyris/terminators/s_terminator_01"), 1),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/terminators/s_terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      
      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("byg:village/skyris/decor"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.legacy("byg:village/skyris/skyris_lamp_1"), 10),
                      Pair.of(JigsawPiece.feature(Features.PATCH_BERRY_DECORATED), 4),
                      Pair.of(JigsawPiece.feature(Features.PILE_HAY), 4),
                      Pair.of(JigsawPiece.empty(), 6)), JigsawPattern.PlacementBehaviour.RIGID));
      
      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("byg:village/skyris/villagers"),
              new ResourceLocation("empty"),
              ImmutableList.of(Pair.of(JigsawPiece.legacy("byg:village/skyris/villagers/baby"), 1),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/villagers/baby"), 1),
                      Pair.of(JigsawPiece.legacy("byg:village/skyris/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));

//      //Zombie
//      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/desert/zombie/streets"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/corner_01"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/corner_02"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/straight_01"), 4), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/straight_02"), 4), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/straight_03"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/crossroad_01"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/crossroad_02"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/crossroad_03"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/square_01"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/square_02"), 3), Pair.of(JigsawPiece.legacy("village/desert/zombie/streets/turn_01"), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
//      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/desert/zombie/houses"), new ResourceLocation("village/desert/zombie/terminators"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_2", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_3", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_4", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_5", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_6", ProcessorLists.ZOMBIE_DESERT), 1), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_7", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_small_house_8", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_medium_house_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/zombie/houses/desert_medium_house_2", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_butcher_shop_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_tool_smith_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_fletcher_house_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_shepherd_house_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_armorer_1", ProcessorLists.ZOMBIE_DESERT), 1), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_fisher_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_tannery_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_cartographer_house_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_library_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_mason_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_weaponsmith_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_temple_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_temple_2", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_large_farm_1", ProcessorLists.ZOMBIE_DESERT), 7), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_farm_1", ProcessorLists.ZOMBIE_DESERT), 4), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_farm_2", ProcessorLists.ZOMBIE_DESERT), 4), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_animal_pen_1", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.legacy("village/desert/houses/desert_animal_pen_2", ProcessorLists.ZOMBIE_DESERT), 2), Pair.of(JigsawPiece.empty(), 5)), JigsawPattern.PlacementBehaviour.RIGID));
//      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/desert/zombie/terminators"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/desert/terminators/terminator_01"), 1), Pair.of(JigsawPiece.legacy("village/desert/zombie/terminators/terminator_02"), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
//      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/desert/zombie/decor"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/desert/desert_lamp_1", ProcessorLists.ZOMBIE_DESERT), 10), Pair.of(JigsawPiece.feature(Features.PATCH_CACTUS), 4), Pair.of(JigsawPiece.feature(Features.PILE_HAY), 4), Pair.of(JigsawPiece.empty(), 10)), JigsawPattern.PlacementBehaviour.RIGID));
//      JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation("village/desert/zombie/villagers"), new ResourceLocation("empty"), ImmutableList.of(Pair.of(JigsawPiece.legacy("village/desert/zombie/villagers/nitwit"), 1), Pair.of(JigsawPiece.legacy("village/desert/zombie/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
//      
   }
}
