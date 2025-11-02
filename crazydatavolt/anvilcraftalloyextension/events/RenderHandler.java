package com.crazydatavolt.anvilcraftalloyextension.events;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.register.ModBlockEntity;
import com.crazydatavolt.anvilcraftalloyextension.render.AluminumItemFrameRender;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;


@EventBusSubscriber(modid = AnvilCraftAlloyExtension.MODID)
public class RenderHandler {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(
                ModBlockEntity.ALUMINUM_ITEM_FRAME_BLOCK_ENTITY.get(),
                AluminumItemFrameRender::new
        );
    }

}
