package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import javax.annotation.Nullable;

public class SteelBowItem extends BowItem {
    public SteelBowItem(Properties properties) {
        super(properties);
    }

    @Override
    protected void shootProjectile(
            LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target
    ) {
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity*1.5F, 0);
    }

}
