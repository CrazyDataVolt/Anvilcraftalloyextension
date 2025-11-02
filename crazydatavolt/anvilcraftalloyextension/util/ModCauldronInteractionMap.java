package com.crazydatavolt.anvilcraftalloyextension.util;

import com.crazydatavolt.anvilcraftalloyextension.blocks.DragonBreathCauldronBlock;
import com.crazydatavolt.anvilcraftalloyextension.register.ModBlocks;
import dev.dubhe.anvilcraft.block.Layered4LevelCauldronBlock;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;

public class ModCauldronInteractionMap {
    public static final CauldronInteraction.InteractionMap DRAGON_BREATH = CauldronInteraction.newInteractionMap("dragon_breath");

    public ModCauldronInteractionMap() {
    }

    public static void initInteractionMap() {
        Map<Item, CauldronInteraction> DragonBreathInteractionMap = DRAGON_BREATH.map();
        DragonBreathInteractionMap.put(Items.GLASS_BOTTLE, (state, level, pos, player, hand, stack) -> {
            if (!level.isClientSide()) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, Items.DRAGON_BREATH.getDefaultInstance()));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                Layered4LevelCauldronBlock.lowerFillLevel(state, level, pos);
                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        });
        DragonBreathInteractionMap.put(Items.DRAGON_BREATH, (state, level, pos, player, hand, stack) -> {
            if (((DragonBreathCauldronBlock) ModBlocks.DRAGON_BREATH_CAULDRON.get()).isFull(state)) {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            } else {
                if (!level.isClientSide()) {
                    player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                    player.awardStat(Stats.FILL_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    level.setBlockAndUpdate(pos, state.cycle(DragonBreathCauldronBlock.LEVEL));
                    level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS);
                    level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide());
            }
        });


        Map<Item, CauldronInteraction> emptyInteractionMap = CauldronInteraction.EMPTY.map();
        emptyInteractionMap.put(Items.DRAGON_BREATH, (state, level, pos, player, hand, stack) -> {
            if (!level.isClientSide()) {
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                level.setBlockAndUpdate(pos, ModBlocks.DRAGON_BREATH_CAULDRON.get().defaultBlockState());
                level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS);
                level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return ItemInteractionResult.sidedSuccess(level.isClientSide());
        });
    }
}
