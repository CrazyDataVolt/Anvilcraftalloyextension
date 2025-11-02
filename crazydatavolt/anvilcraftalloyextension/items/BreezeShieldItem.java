package com.crazydatavolt.anvilcraftalloyextension.items;

import com.crazydatavolt.anvilcraftalloyextension.register.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BreezeShieldItem extends ShieldItem {

    public BreezeShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player && player.getCooldowns().isOnCooldown(this)){
            player.getCooldowns().addCooldown(this,0);
            ExplosionDamageCalculator noDamageExplosion=new noExplosionDamageCalculator();
            level.explode(entity, null, noDamageExplosion,player.getX(),player.getY()+1,player.getZ(),5.0F,false, Level.ExplosionInteraction.NONE);
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(ModItems.STEEL_INGOT) || super.isValidRepairItem(toRepair, repair);
    }

    public class noExplosionDamageCalculator extends ExplosionDamageCalculator{
        @Override
        public boolean shouldBlockExplode(Explosion explosion, BlockGetter reader, BlockPos pos, BlockState state, float power) {
            return false;
        }
        @Override
        public boolean shouldDamageEntity(Explosion explosion, Entity entity) {
            return false;
        }
        @Override
        public float getKnockbackMultiplier(Entity entity) {
            return 2.0F;
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> component, TooltipFlag flag) {
        component.add(Component.translatable("tooltip.anvilcraftalloyextension.steel_shield"));
        component.add(Component.translatable("tooltip.anvilcraftalloyextension.breeze_shield"));
    }
}
