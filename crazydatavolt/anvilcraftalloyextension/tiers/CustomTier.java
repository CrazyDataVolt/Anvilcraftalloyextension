package com.crazydatavolt.anvilcraftalloyextension.tiers;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class CustomTier implements Tier {
    private final int uses;          // 耐久度
    private final float speed;       // 挖掘速度
    private final float damage;      // 攻击伤害加成
    private final TagKey<Block> unbreakbale;   // 挖掘能力（BlockTag）
    private final int enchantment;   // 附魔能力
    private final Supplier<Ingredient> repairMaterial; // 修复材料

    public CustomTier(int uses, float speed, float damage, int enchantment, TagKey<Block> unbreakbale, Supplier<Ingredient> repairMaterial) {
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.unbreakbale = unbreakbale;
        this.enchantment = enchantment;
        this.repairMaterial = repairMaterial;
    }

    // 实现 Tier 接口方法
    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return unbreakbale;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantment;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}
