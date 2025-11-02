package com.crazydatavolt.anvilcraftalloyextension.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

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
        Player player= context.getPlayer();

        if (state.is(BlockTags.FLOWERS)) {

            int particleCount=16;
            for (int i = 0; i <= particleCount; i++) {
                level.addParticle(
                        ParticleTypes.CHERRY_LEAVES,
                        pos.getX()-0.2+Math.random()*1.4, pos.getY()+Math.random(), pos.getZ()-0.2+Math.random()*1.4,
                        0,-1,0
                );
            }
            state = level.getBlockState(pos);

            player.playSound(SoundEvents.BONE_MEAL_USE, 0.8F, 1F);

            if (!level.isClientSide()) {
                ItemStack drops = state.getBlock().getCloneItemStack(level, pos, state);
                if (!(drops.isEmpty())) {
                    Random random = new Random();
                    int dropCount = 5 + random.nextInt(5);
                    drops.setCount(dropCount);
                    Block.popResource(level, pos, drops.copy());
                    stack.shrink(1);
                }
            }
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }
}
