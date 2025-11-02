package com.crazydatavolt.anvilcraftalloyextension.events;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.register.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;


@EventBusSubscriber(modid = AnvilCraftAlloyExtension.MODID)
public class ItemUseImageHandler {

    @SubscribeEvent
    public static void onModelRegistry(ModelEvent.RegisterAdditional event) {
        ItemProperties.register(
            ModItems.STEEL_BOW.get(),
                ResourceLocation.withDefaultNamespace("pull"),
                (stack, level, entity, seed) -> {
                if (entity == null) {
                    return 0.0F;
                } else {
                    return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
                }
                }
        );
        ItemProperties.register(
                ModItems.STEEL_BOW.get(),
                ResourceLocation.withDefaultNamespace("pulling"),
                (stack, level, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F

        );


        ItemProperties.register(
                ModItems.STEEL_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("pull"),
                (p_351682_, p_351683_, p_351684_, p_351685_) -> {
                    if (p_351684_ == null) {
                        return 0.0F;
                    } else {
                        return CrossbowItem.isCharged(p_351682_)
                                ? 0.0F
                                : (float)(p_351682_.getUseDuration(p_351684_) - p_351684_.getUseItemRemainingTicks())
                                / (float)CrossbowItem.getChargeDuration(p_351682_, p_351684_);
                    }
                }
        );
        ItemProperties.register(
                ModItems.STEEL_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174605_, p_174606_, p_174607_, p_174608_) -> p_174607_ != null
                        && p_174607_.isUsingItem()
                        && p_174607_.getUseItem() == p_174605_
                        && !CrossbowItem.isCharged(p_174605_)
                        ? 1.0F
                        : 0.0F
        );
        ItemProperties.register(
                ModItems.STEEL_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("charged"),
                (p_275891_, p_275892_, p_275893_, p_275894_) -> CrossbowItem.isCharged(p_275891_) ? 1.0F : 0.0F
        );
        ItemProperties.register(
                ModItems.STEEL_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("firework"),
                (p_329796_, p_329797_, p_329798_, p_329799_) -> {
                    ChargedProjectiles chargedprojectiles = p_329796_.get(DataComponents.CHARGED_PROJECTILES);
                    return chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
                });


        ItemProperties.register(
                ModItems.STEEL_SHIELD.get(),
                ResourceLocation.withDefaultNamespace("blocking"),
                (p_174575_, p_174576_, p_174577_, p_174578_) -> p_174577_ != null && p_174577_.isUsingItem() && p_174577_.getUseItem() == p_174575_ ? 1.0F : 0.0F
        );




        ItemProperties.register(
                ModItems.BREEZE_BOW.get(),
                ResourceLocation.withDefaultNamespace("pull"),
                (stack, level, entity, seed) -> {
                    if (entity == null) {
                        return 0.0F;
                    } else {
                        return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
                    }
                }
        );
        ItemProperties.register(
                ModItems.BREEZE_BOW.get(),
                ResourceLocation.withDefaultNamespace("pulling"),
                (stack, level, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F

        );


        ItemProperties.register(
                ModItems.BREEZE_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("pull"),
                (p_351682_, p_351683_, p_351684_, p_351685_) -> {
                    if (p_351684_ == null) {
                        return 0.0F;
                    } else {
                        return CrossbowItem.isCharged(p_351682_)
                                ? 0.0F
                                : (float)(p_351682_.getUseDuration(p_351684_) - p_351684_.getUseItemRemainingTicks())
                                / (float)CrossbowItem.getChargeDuration(p_351682_, p_351684_);
                    }
                }
        );
        ItemProperties.register(
                ModItems.BREEZE_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174605_, p_174606_, p_174607_, p_174608_) -> p_174607_ != null
                        && p_174607_.isUsingItem()
                        && p_174607_.getUseItem() == p_174605_
                        && !CrossbowItem.isCharged(p_174605_)
                        ? 1.0F
                        : 0.0F
        );
        ItemProperties.register(
                ModItems.BREEZE_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("charged"),
                (p_275891_, p_275892_, p_275893_, p_275894_) -> CrossbowItem.isCharged(p_275891_) ? 1.0F : 0.0F
        );
        ItemProperties.register(
                ModItems.BREEZE_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("firework"),
                (p_329796_, p_329797_, p_329798_, p_329799_) -> {
            ChargedProjectiles chargedprojectiles = p_329796_.get(DataComponents.CHARGED_PROJECTILES);
            return chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });


        ItemProperties.register(
                ModItems.BREEZE_SHIELD.get(),
                ResourceLocation.withDefaultNamespace("blocking"),
                (p_174575_, p_174576_, p_174577_, p_174578_) -> p_174577_ != null && p_174577_.isUsingItem() && p_174577_.getUseItem() == p_174575_ ? 1.0F : 0.0F
        );




        ItemProperties.register(
                ModItems.STORM_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("pull"),
                (p_351682_, p_351683_, p_351684_, p_351685_) -> {
                    if (p_351684_ == null) {
                        return 0.0F;
                    } else {
                        return CrossbowItem.isCharged(p_351682_)
                                ? 0.0F
                                : (float)(p_351682_.getUseDuration(p_351684_) - p_351684_.getUseItemRemainingTicks())
                                / (float)CrossbowItem.getChargeDuration(p_351682_, p_351684_);
                    }
                }
        );
        ItemProperties.register(
                ModItems.STORM_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174605_, p_174606_, p_174607_, p_174608_) -> p_174607_ != null
                        && p_174607_.isUsingItem()
                        && p_174607_.getUseItem() == p_174605_
                        && !CrossbowItem.isCharged(p_174605_)
                        ? 1.0F
                        : 0.0F
        );
        ItemProperties.register(
                ModItems.STORM_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("charged"),
                (p_275891_, p_275892_, p_275893_, p_275894_) -> CrossbowItem.isCharged(p_275891_) ? 1.0F : 0.0F
        );
        ItemProperties.register(
                ModItems.STORM_CROSSBOW.get(),
                ResourceLocation.withDefaultNamespace("firework"),
                (p_329796_, p_329797_, p_329798_, p_329799_) -> {
                    ChargedProjectiles chargedprojectiles = p_329796_.get(DataComponents.CHARGED_PROJECTILES);
                    return chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
                });

    }
}
