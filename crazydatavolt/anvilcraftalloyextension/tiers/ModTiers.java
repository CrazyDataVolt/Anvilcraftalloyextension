package com.crazydatavolt.anvilcraftalloyextension.tiers;

import com.crazydatavolt.anvilcraftalloyextension.register.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;


public class ModTiers {
    public static final Tier ROSEGOLD =new CustomTier(128, 12F, 1F,25, BlockTags.INCORRECT_FOR_STONE_TOOL, () -> Ingredient.of(ModItems.ROSEGOLD_INGOT));
    public static final Tier PURPLEGOLD =new CustomTier(128, 12F, 1F,25, BlockTags.INCORRECT_FOR_STONE_TOOL, () -> Ingredient.of(ModItems.PURPLEGOLD_INGOT));
    public static final Tier ELECTRUM =new CustomTier(72, 12F, 2F,25, BlockTags.INCORRECT_FOR_STONE_TOOL, () -> Ingredient.of(ModItems.ELECTRUM_INGOT));
    public static final Tier STEEL =new CustomTier(1200, 7F, 2.5F,12, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, () -> Ingredient.of(ModItems.STEEL_INGOT));


}
