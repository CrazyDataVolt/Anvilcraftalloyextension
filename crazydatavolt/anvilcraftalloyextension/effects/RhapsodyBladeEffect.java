package com.crazydatavolt.anvilcraftalloyextension.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class RhapsodyBladeEffect extends MobEffect {

    public RhapsodyBladeEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return false;
    }
}
