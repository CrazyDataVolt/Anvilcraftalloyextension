package com.crazydatavolt.anvilcraftalloyextension.blocks;

import com.crazydatavolt.anvilcraftalloyextension.util.ModCauldronInteractionMap;
import dev.dubhe.anvilcraft.block.Layered4LevelCauldronBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class DragonBreathCauldronBlock extends Layered4LevelCauldronBlock {

    public DragonBreathCauldronBlock(Properties pProperties) {
        super(pProperties, ModCauldronInteractionMap.DRAGON_BREATH);
    }


    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        CauldronInteraction interaction = this.interactions.map().get(stack.getItem());
        return interaction == null ? ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION : interaction.interact(state, level, pos, player, hand, stack);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
    }

    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return new ItemStack(Items.CAULDRON);
    }
}
