package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import javax.annotation.Nullable;
import java.util.List;

public class BreezeBowItem extends BowItem {
    public BreezeBowItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(
            LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target
    ) {
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity*1.25F, 0);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<net.minecraft.network.chat.Component> component, TooltipFlag flag) {
        component.add(Component.translatable("tooltip.anvilcraftalloyextension.steel_bow"));
        component.add(Component.translatable("tooltip.anvilcraftalloyextension.breeze_bow"));
    }
}
