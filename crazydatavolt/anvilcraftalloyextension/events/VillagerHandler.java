package com.crazydatavolt.anvilcraftalloyextension.events;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.register.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;
import java.util.Optional;

@EventBusSubscriber(modid = AnvilCraftAlloyExtension.MODID)
public class VillagerHandler {
    @SubscribeEvent
    public static void addTrade(VillagerTradesEvent event){
        if (event.getType() == VillagerProfession.TOOLSMITH){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(3).add((entity,randomSource)->new MerchantOffer(
                    new ItemCost(Items.EMERALD,8),
                    Optional.of(new ItemCost(ModItems.STEEL_INGOT.get(), 4)),
                    new ItemStack(ModItems.STEEL_UPGRADE_SMITHING_TEMPLATE.get(),1),
                    8,10,0f
            ));
        }
    }
}
