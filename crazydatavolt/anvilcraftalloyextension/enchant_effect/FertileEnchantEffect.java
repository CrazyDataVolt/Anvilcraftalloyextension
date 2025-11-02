package com.crazydatavolt.anvilcraftalloyextension.enchant_effect;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class FertileEnchantEffect implements EnchantmentEntityEffect {
    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 vec3) {

        if (!(entity instanceof Player player)) return;

        BlockPos pos = BlockPos.containing(vec3);
        BlockState state = level.getBlockState(pos);

        if (!(player.isCrouching()) && state.getBlock() instanceof BonemealableBlock bonemealableblock && bonemealableblock.isValidBonemealTarget(level, pos, state)) {
            boolean anySuccess = false;

            for (int i = 0; i < enchantmentLevel; i++) {
                state = level.getBlockState(pos);
                if (bonemealableblock.isBonemealSuccess(level, level.random, pos, state)) {
                    bonemealableblock.performBonemeal(level, level.random, pos, state);
                    level.levelEvent(1505, pos, 15);
                    anySuccess = true;
                }
            }
            if(anySuccess){
                ItemStack tool = item.itemStack();
                tool.hurtAndBreak(1, level, player, item.onBreak());
            }
        }
    }

    public static final MapCodec<FertileEnchantEffect> CODEC = MapCodec.unit(FertileEnchantEffect::new);

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
