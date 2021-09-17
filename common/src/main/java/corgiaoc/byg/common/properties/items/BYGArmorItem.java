package corgiaoc.byg.common.properties.items;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class BYGArmorItem extends ArmorItem {
    private final BYGArmorTiers material;
    public BYGArmorItem(BYGArmorTiers materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
        this.material = materialIn;
    }

    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return BYG.MOD_ID + ":textures/models/armor/" + getBYGArmorMaterial().getName() + "_layer_" + (slot == EquipmentSlot.LEGS ? 2 : 1) + ".png";
    }

    public BYGArmorTiers getBYGArmorMaterial() {
        return this.material;
    }
}
