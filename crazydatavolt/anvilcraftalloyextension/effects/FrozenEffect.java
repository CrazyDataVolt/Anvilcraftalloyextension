package com.crazydatavolt.anvilcraftalloyextension.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FrozenEffect extends MobEffect {
    int timer;
    public FrozenEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if(timer<160){
            timer+=amplifier+1;
        }
        livingEntity.setTicksFrozen(timer);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }

    @Override
    public void onEffectAdded(LivingEntity livingEntity, int amplifier) {
        timer=livingEntity.getTicksFrozen();
    }
}
