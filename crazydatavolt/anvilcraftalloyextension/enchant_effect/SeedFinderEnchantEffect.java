package com.crazydatavolt.anvilcraftalloyextension.enchant_effect;

import com.crazydatavolt.anvilcraftalloyextension.tags.ModTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.stream.Collectors;

public class SeedFinderEnchantEffect implements EnchantmentEntityEffect {
    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 vec3) {

        if (!(entity instanceof Player)) return;

        BlockPos pos = BlockPos.containing(vec3);

        List<Item> items = BuiltInRegistries.ITEM.getOrCreateTag(ModTags.Items.SEED_FINDABLE)
                .stream()
                .filter(Holder::isBound)
                .map(Holder::value)
                .collect(Collectors.toSet())
                .stream()
                .toList();

        RandomSource random = level.getRandom();

        ItemEntity seedEntity = new ItemEntity(
                level,
                pos.getX() + 0.5,
                pos.getY() + 1.1,
                pos.getZ() + 0.5,
                new ItemStack(items.get(random.nextInt(items.size())))
        );

        seedEntity.setDeltaMovement(
                (Math.random() - 0.5) * 0.1,
                (Math.random() * 0.1) + 0.15,
                (Math.random() - 0.5) * 0.1
        );

        level.addFreshEntity(seedEntity);
    }

    public static final MapCodec<SeedFinderEnchantEffect> CODEC = MapCodec.unit(SeedFinderEnchantEffect::new);

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
