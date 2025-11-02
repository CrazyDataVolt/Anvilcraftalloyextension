package com.crazydatavolt.anvilcraftalloyextension.blocks;

import com.crazydatavolt.anvilcraftalloyextension.tags.ModTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class CauldronPipeBlock extends DirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public CauldronPipeBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
    }



    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        Direction inputdir=state.getValue(FACING).getOpposite();
        Direction outputdir=state.getValue(FACING);
        BlockPos inputpos=pos.relative(inputdir);
        BlockPos outputpos=pos.relative(outputdir);
        BlockState inputstate=level.getBlockState(inputpos);
        BlockState outputstate=level.getBlockState(outputpos);

        if(!(level.hasNeighborSignal(pos)) && outputstate.is(Blocks.CAULDRON) && inputstate.is(ModTags.Blocks.CAULDRON_PIPE_SUPPORT)){
            if(inputstate.getBlock() instanceof AbstractCauldronBlock cauldron && cauldron.isFull(inputstate)){
                level.setBlock(outputpos, inputstate, Block.UPDATE_ALL);
                level.setBlock(inputpos, outputstate, Block.UPDATE_ALL);
            }
        }
        level.scheduleTick(pos, this, 4);
    }


    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, 0); //安排首次tick，让tick开始反复执行
        }
    }

    @Override
    protected VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        switch (p_154346_.getValue(FACING).getAxis()) {
            case X:
            default:
                return X_AXIS_AABB;
            case Z:
                return Z_AXIS_AABB;
            case Y:
                return Y_AXIS_AABB;
        }
    }
    protected static final VoxelShape Y_AXIS_AABB = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(4.0, 4.0, 0.0, 12.0, 12.0, 16.0);
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 4.0, 4.0, 16.0, 12.0, 12.0);


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> com, TooltipFlag flag) {
        com.add(Component.translatable("tooltip.anvilcraftalloyextension.cauldron_pipe"));
    }

    /*----------------------*/

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
        return blockstate.is(this) && blockstate.getValue(FACING) == direction
                ? this.defaultBlockState().setValue(FACING, direction.getOpposite())
                : this.defaultBlockState().setValue(FACING, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return null;
    }
}
