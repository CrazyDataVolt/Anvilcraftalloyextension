package com.crazydatavolt.anvilcraftalloyextension.enchant_effect;

import com.crazydatavolt.anvilcraftalloyextension.tags.ModTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.dubhe.anvilcraft.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

public record MiningEnchantEffect(int number) implements EnchantmentEntityEffect {
    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 vec3) {

        if (!(entity instanceof Player player)) return;
        if (!level.getBlockState(BlockPos.containing(vec3)).is(ModTags.Blocks.MINEING_ENCHANT_SUPPOT)) return;
        if (player.isCrouching()) return;

        int max = (enchantmentLevel * number) + 1;

        chainMine(
                level,
                player,
                BlockPos.containing(vec3),
                max,
                item.itemStack(),
                item.onBreak()
        );
    }

    public static final MapCodec<MiningEnchantEffect> CODEC = RecordCodecBuilder.mapCodec(it ->
            it.group(
                    Codec.INT.optionalFieldOf("number", 3).forGetter(MiningEnchantEffect::number)
            ).apply(it, MiningEnchantEffect::new)
    );

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }

    private static void chainMine(ServerLevel level, Player player, BlockPos sourceBlock, int max, ItemStack tool, Consumer<Item> onBreak) {
        BlockPos.breadthFirstTraversal(
                sourceBlock,
                Integer.MAX_VALUE,
                max,
                Util::acceptDirections,
                blockPos -> {
                    BlockState blockState = level.getBlockState(blockPos);
                    if (blockState.is(ModTags.Blocks.MINEING_ENCHANT_SUPPOT)) {
                        BlockEntity blockEntity = level.getBlockEntity(blockPos);
                        level.removeBlock(blockPos, false);
                        if (!player.isCreative()) {
                            blockState.getBlock().playerDestroy(level, player, blockPos, blockState, blockEntity, tool);
                        }
                        if (!sourceBlock.equals(blockPos)) {
                            tool.hurtAndBreak(1, level, player, onBreak);
                        }
                        return true;
                    }
                    return sourceBlock.equals(blockPos);
                }
        );
    }
}
