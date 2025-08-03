package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.HoneyBottleItem;

public class TeaItem extends HoneyBottleItem {
    public TeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

}
