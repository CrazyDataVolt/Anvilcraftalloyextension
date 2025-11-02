package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LifeCrystalItem extends Item {

public LifeCrystalItem(Properties properties) {
    super(properties);
}

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemstack = player.getItemInHand(usedHand);
        player.playSound(SoundEvents.PLAYER_LEVELUP, 0.8F, 1.0F);
        itemstack.shrink(1);
        double health = player.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
        player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(health+2);
        player.heal(2);
        return InteractionResultHolder.consume(itemstack);
    }
}
