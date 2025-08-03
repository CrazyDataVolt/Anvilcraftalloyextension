package com.crazydatavolt.anvilcraftalloyextension.events;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import javax.annotation.Nullable;
import java.util.Optional;

@EventBusSubscriber(modid = AnvilCraftAlloyExtension.MODID)
public class PickaxeHandler {
    @SubscribeEvent
    public static void WhenRightClick(PlayerInteractEvent.RightClickBlock event){
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        Level level =event.getLevel();
        BlockPos click_pos=event.getPos();

        int enchantmentlevel=getEnchantmentLevel(stack,"anvilcraftalloyextension:ore_finder");

        if(!(enchantmentlevel==0)){
            if (level.isClientSide) {
                BlockPos orePos = findNearestOre(level, click_pos, Math.min(enchantmentlevel,4) * 4+8);
                if (click_pos == orePos) {
                    Vec3 clickVec = Vec3.atCenterOf(click_pos);
                    level.addParticle(
                            ParticleTypes.ANGRY_VILLAGER,
                            clickVec.x, clickVec.y, clickVec.z,
                            0, 0, 0 // 无额外速度
                    );
                } else {
                    drawParticleLine(level, player.blockPosition(), orePos, ParticleTypes.END_ROD);
                }
            }
        }
    }




    public static int getEnchantmentLevel(ItemStack stack, String key) {

        ItemEnchantments itemenchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

        for (Object2IntMap.Entry<Holder<Enchantment>> entry : itemenchantments.entrySet()) {
            @Nullable ResourceKey<Enchantment> enchantmentKey = entry.getKey().getKey();
            String info=enchantmentKey.toString();
            if (info.contains(key)) {
                return entry.getIntValue();
            }
        }
        return 0;
    }

    private static BlockPos findNearestOre(Level level, BlockPos centerPos, int radius) {
        Optional<BlockPos> pos_o=BlockPos.findClosestMatch(centerPos,radius,radius, p -> level.getBlockState(p).is(Tags.Blocks.ORES));
        if (pos_o.isPresent()){
            return pos_o.get();
        }else{
            return centerPos;
        }

    }

    public static void drawParticleLine(Level level, BlockPos start, BlockPos end, ParticleOptions particleType) {
        // 将BlockPos转换为精确坐标（方块中心点）
        Vec3 startVec = Vec3.atCenterOf(start);
        Vec3 endVec = Vec3.atCenterOf(end);

        // 计算两点之间的方向和距离
        Vec3 direction = endVec.subtract(startVec);
        double distance = direction.length();
        direction = direction.normalize(); // 单位化方向向量

        // 粒子密度控制（每0.5格一个粒子）
        double step = 0.5;
        int particleCount = (int) (distance / step);

        // 生成沿线粒子
        for (int i = 0; i <= particleCount; i++) {
            double ratio = i * step / distance;
            Vec3 currentPos = startVec.add(direction.scale(ratio * distance));

            // 在客户端生成粒子
            if (level.isClientSide) {
                level.addParticle(
                        particleType,
                        currentPos.x, currentPos.y, currentPos.z,
                        0, 0, 0 // 无额外速度
                );
            }
        }
    }
}
