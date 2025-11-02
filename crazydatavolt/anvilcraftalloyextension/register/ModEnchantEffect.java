package com.crazydatavolt.anvilcraftalloyextension.register;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.enchant_effect.FertileEnchantEffect;
import com.crazydatavolt.anvilcraftalloyextension.enchant_effect.MiningEnchantEffect;
import com.crazydatavolt.anvilcraftalloyextension.enchant_effect.SeedFinderEnchantEffect;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModEnchantEffect {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCHANTMENT_EFFECTS=
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, AnvilCraftAlloyExtension.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> FERTILE_ENCHANT_EFFECT =
            ENCHANTMENT_EFFECTS.register("fertile",() -> FertileEnchantEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> SEED_FINDER_ENCHANT_EFFECT =
            ENCHANTMENT_EFFECTS.register("seed_finder",() -> SeedFinderEnchantEffect.CODEC);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> MINING_ENCHANT_EFFECT =
            ENCHANTMENT_EFFECTS.register("mining",() -> MiningEnchantEffect.CODEC);


    public static final DeferredRegister<DataComponentType<?>> ENCHANTMENT_EFFECTS_TRIGGER =
            DeferredRegister.create(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, AnvilCraftAlloyExtension.MODID);
}
