package com.crazydatavolt.anvilcraftalloyextension.blocks;

import com.crazydatavolt.anvilcraftalloyextension.blockentitys.AluminumItemFrameBlockEntity;
import com.crazydatavolt.anvilcraftalloyextension.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class AluminumItemFrameBlockEnder extends AluminumItemFrameBlock{


    public AluminumItemFrameBlockEnder(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof AluminumItemFrameBlockEntity bentity) {

            ItemStack iteminhand=player.getMainHandItem();

            if(bentity.stackisEmpty() && !(iteminhand.isEmpty())){
                bentity.addItem(player.getMainHandItem());
                return InteractionResult.SUCCESS;
            }else if(iteminhand.is(ModTags.Items.ALUMINUM_ITEM_FRAME)){
                ItemStack returnitem=bentity.getItemstack();
                player.addItem(returnitem);
                bentity.addItem(ItemStack.EMPTY);
                return InteractionResult.SUCCESS;
            }else{

                Direction clickedFace = hit.getDirection();

                for (int i = 1; i < 9; i++) {

                    BlockPos backPos = pos.relative(clickedFace.getOpposite(),i);
                    BlockState backState = level.getBlockState(backPos);

                    if(!(backState.is(ModTags.Blocks.ALUMINUM_ITEM_FRAME))){

                        Vec3 backHitVec = hit.getLocation().subtract(backPos.getX(), backPos.getY(), backPos.getZ());
                        BlockHitResult backHit = new BlockHitResult(backHitVec, clickedFace, backPos, false);
                        InteractionResult result = backState.useWithoutItem(level, player, backHit);

                        if(result.consumesAction()){
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> com, TooltipFlag flag) {
        com.add(Component.translatable("tooltip.anvilcraftalloyextension.aluminum_item_frame_ender"));
    }

}
