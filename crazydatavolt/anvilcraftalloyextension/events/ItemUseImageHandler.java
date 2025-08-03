package com.crazydatavolt.anvilcraftalloyextension.events;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.register.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
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
                ModItems.STEEL_SHIELD.get(),
                ResourceLocation.withDefaultNamespace("blocking"),
                (p_174575_, p_174576_, p_174577_, p_174578_) -> p_174577_ != null && p_174577_.isUsingItem() && p_174577_.getUseItem() == p_174575_ ? 1.0F : 0.0F
        );
    }
}
