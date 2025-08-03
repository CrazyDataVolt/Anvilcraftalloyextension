package com.crazydatavolt.anvilcraftalloyextension.items;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;

import java.util.Arrays;
import java.util.List;

public class InstructionBookItem extends Item {
    int page=0;
    int cooltimer_ws=0;
    int cooltimer_ad=0;
    int jumptimer=0;
    boolean jump=false;
    int cooltime_ws=13;
    int cooltime_ad=13;
    int jumptime=24;
    int chapter_choose=1;
    int[] chapter = {0,2,7,16,19};//每个章节的起始页数

    public InstructionBookItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> component, TooltipFlag flag) {

        ApplyText(component);

        LocalPlayer player = Minecraft.getInstance().player;

        if (!(page==1)){
            if (hasDDown()){
                page+=1;
                if(isAtChapterStartPage()){
                    player.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), 0.75F, 1.2F);
                }else{
                    player.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), 0.75F, 1.0F);
                }
            }else if(hasADown()){
                page-=1;
                player.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), 0.75F, 1.0F);
            }
            page=Math.clamp(page,0,Integer.parseInt(I18n.get("tooltip.anvilcraftalloyextension.bookinfo.maxpage")));

            if (Screen.hasShiftDown()){
                chapter_choose=getCurrentChapterIndex();
                page=1;
                player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.75F, 0.8F);
            }

        }else{
            if (hasDDown()){
                page=chapter[chapter_choose];
                player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.75F, 1.0F);
            }else if(hasADown()){
                page-=1;
                player.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), 0.75F, 1.0F);
            }
            page=Math.clamp(page,0,Integer.parseInt(I18n.get("tooltip.anvilcraftalloyextension.bookinfo.maxpage")));

            if (hasSDown()){
                chapter_choose+=1;
                player.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), 0.75F, 1.0F);
            }else if(hasWDown()){
                chapter_choose-=1;
                player.playSound(SoundEvents.NOTE_BLOCK_HAT.value(), 0.75F, 1.0F);
            }
            chapter_choose=Math.clamp(chapter_choose,1,Integer.parseInt(I18n.get("tooltip.anvilcraftalloyextension.bookinfo.maxchapter")));

            if (cooltimer_ws>0){
                cooltimer_ws-=1;
            }

            for (int i = 1; i < chapter.length; i++) {
                if (i==chapter_choose){
                    component.add(Component.translatable("tooltip.anvilcraftalloyextension.chaptername"+String.valueOf(i)).withStyle(ChatFormatting.YELLOW));
                }
                else{
                    component.add(Component.translatable("tooltip.anvilcraftalloyextension.chaptername"+String.valueOf(i)).withStyle(ChatFormatting.GRAY));
                }
            }
        }

        if (cooltimer_ad>0){
            cooltimer_ad-=1;
        }

        jumptimer+=1;
        if(jumptimer==jumptime){
            jumptimer=0;
            jump=!jump;
        }

        if(jump){
            component.add(Component.literal("          §6◀ A     "+PageToDot(getPageInChapterPosition(),getCurrentChapterLength())+"     §6D ▶          "));
        }else{
            component.add(Component.literal("          §6◁ A     "+PageToDot(getPageInChapterPosition(),getCurrentChapterLength())+"     §6D ▷          "));
        }
    }

    public void ApplyText(List<Component> com) {// 给出tooptip
        int p=Integer.parseInt(I18n.get("tooltip.anvilcraftalloyextension.bookpage"+String.valueOf(page)+".needline"));
        for (int i = 1; i < p+1; i++) {
            com.add(Component.translatable("tooltip.anvilcraftalloyextension.bookpage"+String.valueOf(page)+".line"+String.valueOf(i)));
        }
    }//很蠢，很有效。要不是游戏总是把换行符识别成乱码我TMD才不用这个蠢办法！

    public int getPageInChapterPosition() {//获取当前页在章节内的相对位置
        int chapterIndex = getCurrentChapterIndex();
        return page - chapter[chapterIndex];
    }

    public int getCurrentChapterLength() {// 检测当前章节长度
        int chapterIndex = getCurrentChapterIndex();

        if (chapterIndex == chapter.length - 1) {
            return Integer.parseInt(I18n.get("tooltip.anvilcraftalloyextension.bookinfo.maxpage")) - chapter[chapterIndex] + 1;
        } else {
            return chapter[chapterIndex + 1] - chapter[chapterIndex];
        }
    }

    private int getCurrentChapterIndex() {// 从后向前查找当前页所属的章节
        for (int i = chapter.length - 1; i >= 0; i--) {
            if (page >= chapter[i]) {
                return i;
            }
        }
        return 0; // 默认返回第0章
    }

    public boolean isAtChapterStartPage() {// 检测当前页是不是任何章节的起始页
        for (int chapterStart : chapter) {
            if (page == chapterStart) {
                return true;
            }
        }
        return false;
    }

    public static String PageToDot(int page,int cmaxpage) {
        char[] chars = new char[cmaxpage];
        Arrays.fill(chars, '□');
        chars[page] = '0';
        String dotline =new String(chars).replace("0", "§r§e□§r§8");
        return "§r§8"+dotline+"§r";
    }

    public boolean hasADown() {
        boolean a= cooltimer_ad==0 && InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(),InputConstants.KEY_A);
        if (a){cooltimer_ad=cooltime_ad;}
        return a;
    }

    public boolean hasDDown() {
        boolean d= cooltimer_ad==0 && InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(),InputConstants.KEY_D);
        if (d){cooltimer_ad=cooltime_ad;}
        return d;
    }

    public boolean hasWDown() {
        boolean w= cooltimer_ws==0 && InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(),InputConstants.KEY_W);
        if (w){cooltimer_ws=cooltime_ws;}
        return w;
    }

    public boolean hasSDown() {
        boolean s= cooltimer_ws==0 && InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(),InputConstants.KEY_S);
        if (s){cooltimer_ws=cooltime_ws;}
        return s;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (context.getLevel().isClientSide()) {
            context.getPlayer().sendSystemMessage(Component.translatable("tooltip.anvilcraftalloyextension.bookuse"));
        }
        return InteractionResult.PASS;
    }


}
