package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StarTotemItem extends Item {

public StarTotemItem(Properties properties) {
    super(properties);
}

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 4), player);
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 4), player);
        player.getCooldowns().addCooldown(this, 240);

        player.playSound(SoundEvents.TOTEM_USE, 1F, 1F);

        int particleCount=128;
        for (int i = 0; i <= particleCount; i++) {
            level.addParticle(
                    ParticleTypes.TOTEM_OF_UNDYING,
                    player.getX(), player.getY()+0.5, player.getZ(),
                    (Math.random()-0.5)*3, (Math.random()-0.5)*3, (Math.random()-0.5)*3
            );
        }
        ItemStack itemstack = player.getItemInHand(hand);
        itemstack.shrink(1);
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
