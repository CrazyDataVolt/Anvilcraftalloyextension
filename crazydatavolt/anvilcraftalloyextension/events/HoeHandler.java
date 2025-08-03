package com.crazydatavolt.anvilcraftalloyextension.events;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;
import java.util.stream.Collectors;



@EventBusSubscriber(modid = AnvilCraftAlloyExtension.MODID)
public class HoeHandler {
    @SubscribeEvent
    public static void WhenHoeUse(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack=event.getItemStack();
        int enchantmentlevel=PickaxeHandler.getEnchantmentLevel(stack,"anvilcraftalloyextension:seed_finder");

        if ((enchantmentlevel>0) && (event.getLevel() instanceof ServerLevel level) && (stack.is(ItemTags.HOES))){

            RandomSource random = level.getRandom();
            float probability = 0.1f * enchantmentlevel;
            BlockPos pos = event.getPos();

            if ((random.nextFloat() <= probability)&&(level.getBlockState(pos).is(BlockTags.DIRT))){
                List<Item> items = List.of();
                items = BuiltInRegistries.ITEM.getOrCreateTag(ModTags.Items.SEEDS_FROM_HOE)
                        .stream()
                        .filter(Holder::isBound)
                        .map(Holder::value)
                        .collect(Collectors.toSet())
                        .stream()
                        .toList();

                ItemStack seed = new ItemStack(items.get(random.nextInt(items.size())));

                ItemEntity seedEntity = new ItemEntity(
                        level,
                        pos.getX() + 0.5,
                        pos.getY() + 1.0,
                        pos.getZ() + 0.5,
                        seed
                );

                seedEntity.setDeltaMovement(
                        (Math.random() - 0.5) * 0.1,
                        (Math.random() * 0.1) + 0.15,
                        (Math.random() - 0.5) * 0.1
                );
                level.addFreshEntity(seedEntity);
            }
        }
    }
}
