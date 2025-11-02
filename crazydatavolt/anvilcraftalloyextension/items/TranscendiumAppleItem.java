package com.crazydatavolt.anvilcraftalloyextension.items;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;

import java.util.List;

public class TranscendiumAppleItem extends Item {

public TranscendiumAppleItem(Properties properties) {
    super(properties);
}

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (stack.has(DataComponents.FOOD)) {
            entity.eat(world, stack.copy());
            if (!entity.level().isClientSide() && entity instanceof Player player) {
                ItemEnchantments itemenchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
                var all_enchant_level=0;
                for (Object2IntMap.Entry<Holder<Enchantment>> entry : itemenchantments.entrySet()) {
                    all_enchant_level+=entry.getIntValue();
                }
                all_enchant_level=Math.min(all_enchant_level,80);
                player.getCooldowns().addCooldown(this, 600-(int) Math.floor(all_enchant_level*6.25));
            }
        }
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        if (!entity.level().isClientSide() && entity instanceof Player) {
            ItemEnchantments itemenchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
            var all_enchant_count=0;
            for (Object2IntMap.Entry<Holder<Enchantment>> entry : itemenchantments.entrySet()) {
                all_enchant_count+=1;
            }
            all_enchant_count=Math.min(all_enchant_count,16);
            return 32-all_enchant_count;
        }else{
            return 32;
        }
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> component, TooltipFlag flag) {
        if (Screen.hasShiftDown()){
            component.add(Component.translatable("tooltip.anvilcraftalloyextension.transcendium_apple.shift1").withColor(0xFCE25F));
            component.add(Component.translatable("tooltip.anvilcraftalloyextension.transcendium_apple.shift2").withColor(0xFCE25F));
            component.add(Component.translatable("tooltip.anvilcraftalloyextension.transcendium_apple.shift3").withColor(0xFCE25F));
        }else{
            component.add(Component.translatable("tooltip.anvilcraftalloyextension.transcendium_apple.normal1").withColor(0xFCE25F));
            component.add(Component.translatable("tooltip.anvilcraftalloyextension.transcendium_apple.normal2").withColor(0xFCE25F));
        }
    }



    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return new ItemStack(this);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
