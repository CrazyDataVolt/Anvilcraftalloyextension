package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class CanBurnItem extends Item {
    private final int burnTime;
    public CanBurnItem(int burntime,Properties properties) {
        super(properties);
        this.burnTime = burntime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @org.jetbrains.annotations.Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
