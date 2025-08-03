package com.crazydatavolt.anvilcraftalloyextension;

import net.minecraft.world.item.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.crazydatavolt.anvilcraftalloyextension.register.ModBlockEntity.BLOCK_ENTITYS;
import static com.crazydatavolt.anvilcraftalloyextension.register.ModBlocks.*;
import static com.crazydatavolt.anvilcraftalloyextension.register.ModEffects.MOB_EFFECTS;
import static com.crazydatavolt.anvilcraftalloyextension.register.ModItems.*;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AnvilCraftAlloyExtension.MODID)
public class AnvilCraftAlloyExtension {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "anvilcraftalloyextension";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();









    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TABS.register("items_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.anvilcraftalloyextension"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ROSEGOLD_INGOT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(INSTRUCTION_BOOK.get());

                output.accept(RAW_ALUMINUM.get());
                output.accept(ALUMINUM_INGOT.get());
                output.accept(ALUMINUM_NUGGET.get());
                output.accept(DEEPSLATE_ALUMINUM_ORE_BLOCK_ITEM.get());
                output.accept(RAW_ALUMINUM_BLOCK_ITEM.get());
                output.accept(ALUMINUM_BLOCK_ITEM.get());

                output.accept(ROSEGOLD_INGOT.get());
                output.accept(ROSEGOLD_NUGGET.get());
                output.accept(ROSEGOLD_SWORD.get());
                output.accept(ROSEGOLD_PICKAXE.get());
                output.accept(ROSEGOLD_AXE.get());
                output.accept(ROSEGOLD_SHOVEL.get());
                output.accept(ROSEGOLD_HOE.get());
                output.accept(ROSEGOLD_APPLE.get());
                output.accept(ROSEGOLD_BLOCK_ITEM.get());

                output.accept(PURPLEGOLD_INGOT.get());
                output.accept(PURPLEGOLD_NUGGET.get());
                output.accept(PURPLEGOLD_SWORD.get());
                output.accept(PURPLEGOLD_PICKAXE.get());
                output.accept(PURPLEGOLD_AXE.get());
                output.accept(PURPLEGOLD_SHOVEL.get());
                output.accept(PURPLEGOLD_HOE.get());
                output.accept(PURPLEGOLD_APPLE.get());
                output.accept(PURPLE_GOLD_BLOCK_ITEM.get());

                output.accept(ELECTRUM_INGOT.get());
                output.accept(ELECTRUM_NUGGET.get());
                output.accept(ELECTRUM_SWORD.get());
                output.accept(ELECTRUM_PICKAXE.get());
                output.accept(ELECTRUM_AXE.get());
                output.accept(ELECTRUM_SHOVEL.get());
                output.accept(ELECTRUM_HOE.get());
                output.accept(ELECTRUM_APPLE.get());
                output.accept(ELECTRUM_BLOCK_ITEM.get());

                output.accept(STEEL_INGOT.get());
                output.accept(STEEL_NUGGET.get());
                output.accept(STEEL_SWORD.get());
                output.accept(STEEL_PICKAXE.get());
                output.accept(STEEL_AXE.get());
                output.accept(STEEL_SHOVEL.get());
                output.accept(STEEL_HOE.get());
                output.accept(STEEL_UPGRADE_SMITHING_TEMPLATE.get());
                output.accept(STEEL_BOW.get());
                output.accept(STEEL_SHIELD.get());
                output.accept(STEEL_BLOCK_ITEM.get());

                output.accept(COAL_DUST.get());
                output.accept(AMETHYST_DUST.get());
                output.accept(ENDER_DUST.get());
                output.accept(PEARL.get());

                output.accept(FLOWER_FERTILIZER.get());

                output.accept(POTATO_PANCAKE.get());
                output.accept(PUMPKIN_PANCAKE.get());

                output.accept(POTATO_BEEF_STEW.get());
                output.accept(AZALEA_TEA.get());
                output.accept(CHERRY_TEA.get());
                output.accept(CRIMSON_TEA.get());
                output.accept(WARPED_TEA.get());

                output.accept(EXPANSION_BARREL_BLOCK_ITEM.get());

                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_GLOW_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_REDSTONE_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_AMETHYST_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_ENDER_ITEM.get());

                output.accept(STAR_TOTEM.get());
            }).build());


    public AnvilCraftAlloyExtension(IEventBus Bus,ModContainer Container){
        ITEMS.register(Bus);
        BLOCKS.register(Bus);
        BLOCKITEMS.register(Bus);
        BLOCK_ENTITYS.register(Bus);
        MOB_EFFECTS.register(Bus);
        CREATIVE_MODE_TABS.register(Bus);
    }
}