package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExperienceShardItem extends Item {

public ExperienceShardItem(Properties properties) {
    super(properties);
}

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        if (player.isCrouching()){
            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.7F, 0.8F);
            itemstack.shrink(1);
            player.giveExperiencePoints(8);
            return InteractionResultHolder.consume(itemstack);
        }else{
            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.7F, 1.0F);
            var num=itemstack.getCount();
            itemstack.shrink(num);
            player.giveExperiencePoints(8*num);
            return InteractionResultHolder.consume(itemstack);
        }
    }
}
