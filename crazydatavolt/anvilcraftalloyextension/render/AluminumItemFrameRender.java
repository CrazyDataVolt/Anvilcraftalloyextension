package com.crazydatavolt.anvilcraftalloyextension.render;

import com.crazydatavolt.anvilcraftalloyextension.blockentitys.AluminumItemFrameBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import static com.crazydatavolt.anvilcraftalloyextension.blocks.AluminumItemFrameBlock.FACING;

public class AluminumItemFrameRender implements BlockEntityRenderer<AluminumItemFrameBlockEntity> {
    public AluminumItemFrameRender(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(AluminumItemFrameBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemStack itemshow= blockEntity.getItemstack();
        if(!(itemshow.isEmpty())){
            poseStack.pushPose();
            poseStack.scale(0.5F,0.5F,0.5F);
            Direction direction= blockEntity.getBlockState().getValue(FACING).getOpposite();
            poseStack.translate(1F,1F,1F);
            float f=-direction.toYRot();
            poseStack.mulPose(Axis.YP.rotationDegrees(f));
            poseStack.translate(0F,0F,0.85);
            if (!(blockEntity.getLevel()==null)){
                Minecraft.getInstance().getItemRenderer().renderStatic(itemshow, ItemDisplayContext.FIXED,
                        LevelRenderer.getLightColor(blockEntity.getLevel(),blockEntity.getBlockPos()),
                        packedOverlay,poseStack,bufferSource,blockEntity.getLevel(),18754536);
            }
            poseStack.popPose();
        }
    }
}
