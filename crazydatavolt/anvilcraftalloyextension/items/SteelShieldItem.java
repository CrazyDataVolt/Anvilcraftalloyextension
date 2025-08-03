package com.crazydatavolt.anvilcraftalloyextension.items;

import com.crazydatavolt.anvilcraftalloyextension.register.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;

public class SteelShieldItem extends ShieldItem {

    public SteelShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player){
            player.getCooldowns().addCooldown(this,0);
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(ModItems.STEEL_INGOT) || super.isValidRepairItem(toRepair, repair);
    }


}
