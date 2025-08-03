package com.crazydatavolt.anvilcraftalloyextension.blocks;

import com.crazydatavolt.anvilcraftalloyextension.blockentitys.AluminumItemFrameBlockEntity;
import com.crazydatavolt.anvilcraftalloyextension.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class AluminumItemFrameBlockAmethyst extends AluminumItemFrameBlock{

    public AluminumItemFrameBlockAmethyst(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        player.playSound(SoundEvents.AMETHYST_BLOCK_BREAK, 0.8F, 1F);
        if (blockentity instanceof AluminumItemFrameBlockEntity bentity) {

            Direction clickedFace = hit.getDirection();
            BlockPos backPos = pos.relative(clickedFace.getOpposite());
            BlockState backState = level.getBlockState(backPos);
            ItemStack iteminhand=player.getMainHandItem();

            if(bentity.stackisEmpty() && !(iteminhand.isEmpty())){
                bentity.addItem(iteminhand);
                return InteractionResult.SUCCESS;
            }else if(iteminhand.is(ModTags.Items.ALUMINUM_ITEM_FRAME)){
                ItemStack returnitem=bentity.getItemstack();
                player.addItem(returnitem);
                bentity.addItem(ItemStack.EMPTY);
                return InteractionResult.SUCCESS;
            }else if(!(backState.is(ModTags.Blocks.ALUMINUM_ITEM_FRAME))){
                Vec3 backHitVec = hit.getLocation().subtract(backPos.getX(), backPos.getY(), backPos.getZ());
                BlockHitResult backHit = new BlockHitResult(backHitVec, clickedFace, backPos, false);
                return backState.useWithoutItem(level, player, backHit);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
