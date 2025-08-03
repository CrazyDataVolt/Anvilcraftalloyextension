package com.crazydatavolt.anvilcraftalloyextension.blocks;

import com.crazydatavolt.anvilcraftalloyextension.blockentitys.AluminumItemFrameBlockEntity;
import com.crazydatavolt.anvilcraftalloyextension.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class AluminumItemFrameBlockRedstone extends AluminumItemFrameBlock{

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public AluminumItemFrameBlockRedstone(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED,Boolean.FALSE));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof AluminumItemFrameBlockEntity bentity) {

            //Direction clickedFace = hit.getDirection();
            //BlockPos backPos = pos.relative(clickedFace.getOpposite());
            //BlockState backState = level.getBlockState(backPos);
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
                level.setBlock(pos, state.setValue(POWERED, Boolean.TRUE), 3);


                level.scheduleTick(pos, this, 2);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true; // 声明此方块是红石信号源
    }

    @Override
    protected int getSignal(BlockState state, BlockGetter blockAccess, BlockPos pos, Direction side) {
        if(state.getValue(POWERED)){
            return 15;
        }else{
            return 0;
        }
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(POWERED)) {
            level.setBlock(pos, state.setValue(POWERED, Boolean.FALSE), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,POWERED);
    }
}
