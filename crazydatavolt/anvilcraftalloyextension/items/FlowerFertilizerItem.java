package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;

public class FlowerFertilizerItem extends Item {

public FlowerFertilizerItem(Properties properties) {
    super(properties);
}

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();

        // 检查方块是否在 #flowers 标签内
        if (state.is(BlockTags.FLOWERS)) {
            if (!level.isClientSide()) {
                // 获取方块的掉落物
                List<ItemStack> drops = Block.getDrops(state, (ServerLevel) level, pos, level.getBlockEntity(pos));

                // 随机生成 5~9 份掉落物
                Random random = new Random();
                int dropCount = 5 + random.nextInt(5); // 5 ~ 9

                // 生成掉落物
                for (int i = 0; i < dropCount; i++) {
                    for (ItemStack drop : drops) {
                        Block.popResource(level, pos, drop.copy());
                    }
                }
                // 消耗物品
                stack.shrink(1);
            }
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }
}
