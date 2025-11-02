package com.crazydatavolt.anvilcraftalloyextension;

import com.crazydatavolt.anvilcraftalloyextension.util.ModCauldronInteractionMap;
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
import static com.crazydatavolt.anvilcraftalloyextension.register.ModEnchantEffect.ENCHANTMENT_EFFECTS;
import static com.crazydatavolt.anvilcraftalloyextension.register.ModEnchantEffect.ENCHANTMENT_EFFECTS_TRIGGER;
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
            .icon(() -> ROSE_GOLD_INGOT.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(INSTRUCTION_BOOK.get());

                output.accept(RAW_ALUMINUM.get());
                output.accept(ALUMINUM_INGOT.get());
                output.accept(ALUMINUM_NUGGET.get());
                output.accept(DEEPSLATE_ALUMINUM_ORE_BLOCK_ITEM.get());
                output.accept(RAW_ALUMINUM_BLOCK_ITEM.get());
                output.accept(ALUMINUM_BLOCK_ITEM.get());
                output.accept(ALUMINUM_PRESSURE_PLATE_BLOCK_ITEM.get());

                output.accept(ROSE_GOLD_INGOT.get());
                output.accept(ROSE_GOLD_NUGGET.get());
                output.accept(ROSE_GOLD_SWORD.get());
                output.accept(ROSE_GOLD_PICKAXE.get());
                output.accept(ROSE_GOLD_AXE.get());
                output.accept(ROSE_GOLD_SHOVEL.get());
                output.accept(ROSE_GOLD_HOE.get());
                output.accept(ROSE_GOLD_APPLE.get());
                output.accept(ROSE_GOLD_BLOCK_ITEM.get());
                output.accept(ROSE_GOLD_PRESSURE_PLATE_BLOCK_ITEM.get());

                output.accept(PURPLE_GOLD_INGOT.get());
                output.accept(PURPLE_GOLD_NUGGET.get());
                output.accept(PURPLE_GOLD_SWORD.get());
                output.accept(PURPLE_GOLD_PICKAXE.get());
                output.accept(PURPLE_GOLD_AXE.get());
                output.accept(PURPLE_GOLD_SHOVEL.get());
                output.accept(PURPLE_GOLD_HOE.get());
                output.accept(PURPLE_GOLD_APPLE.get());
                output.accept(PURPLE_GOLD_BLOCK_ITEM.get());
                output.accept(PURPLE_GOLD_PRESSURE_PLATE_BLOCK_ITEM.get());

                output.accept(ELECTRUM_INGOT.get());
                output.accept(ELECTRUM_NUGGET.get());
                output.accept(ELECTRUM_SWORD.get());
                output.accept(ELECTRUM_PICKAXE.get());
                output.accept(ELECTRUM_AXE.get());
                output.accept(ELECTRUM_SHOVEL.get());
                output.accept(ELECTRUM_HOE.get());
                output.accept(ELECTRUM_APPLE.get());
                output.accept(ELECTRUM_BLOCK_ITEM.get());
                output.accept(ELECTRUM_PRESSURE_PLATE_BLOCK_ITEM.get());

                output.accept(STEEL_INGOT.get());
                output.accept(STEEL_NUGGET.get());
                output.accept(STEEL_SWORD.get());
                output.accept(STEEL_PICKAXE.get());
                output.accept(STEEL_AXE.get());
                output.accept(STEEL_SHOVEL.get());
                output.accept(STEEL_HOE.get());

                output.accept(STEEL_HELMET.get());
                output.accept(STEEL_CHESTPLATE.get());
                output.accept(STEEL_LEGGINGS.get());
                output.accept(STEEL_BOOTS.get());

                output.accept(STEEL_UPGRADE_SMITHING_TEMPLATE.get());
                output.accept(STEEL_BOW.get());
                output.accept(STEEL_CROSSBOW.get());
                output.accept(STEEL_SHIELD.get());

                output.accept(STEEL_BLOCK_ITEM.get());
                output.accept(STEEL_PRESSURE_PLATE_BLOCK_ITEM.get());

                output.accept(BREEZE_UPGRADE_SMITHING_TEMPLATE.get());
                output.accept(BREEZE_BOW.get());
                output.accept(BREEZE_CROSSBOW.get());
                output.accept(BREEZE_SHIELD.get());
                output.accept(BREEZE_CORE.get());
                output.accept(STORM_CROSSBOW.get());

                output.accept(EXPERIENCE_SHARD.get());
                output.accept(EXPERIENCE_BLOCK_ITEM.get());

                output.accept(DEEPSLATE_RUBY_ORE_BLOCK_ITEM.get());
                output.accept(DEEPSLATE_TOPAZ_ORE_BLOCK_ITEM.get());
                output.accept(DEEPSLATE_SAPPHIRE_ORE_BLOCK_ITEM.get());

                output.accept(COAL_DUST.get());
                output.accept(AMETHYST_DUST.get());
                output.accept(ENDER_DUST.get());
                output.accept(PEARL.get());
                output.accept(SHULKER_SHELL_SHARD.get());
                output.accept(FLOWER_FERTILIZER.get());

                output.accept(POTATO_BEEF_STEW.get());
                output.accept(ANCIENT_SALAD.get());

                output.accept(AZALEA_TEA.get());
                output.accept(CHERRY_TEA.get());
                output.accept(CRIMSON_TEA.get());
                output.accept(WARPED_TEA.get());
                output.accept(HONEY_BERRY_DRINK.get());

                output.accept(TRANSCENDIUM_APPLE.get());

                output.accept(CAULDRON_PIPE_BLOCK_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_GLOW_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_REDSTONE_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_AMETHYST_ITEM.get());
                output.accept(ALUMINUM_ITEM_FRAME_BLOCK_ENDER_ITEM.get());

                output.accept(LIFE_CRYSTAL.get());
            }).build());


    public AnvilCraftAlloyExtension(IEventBus Bus,ModContainer Container){
        ITEMS.register(Bus);
        BLOCKS.register(Bus);
        BLOCKITEMS.register(Bus);
        BLOCK_ENTITYS.register(Bus);
        MOB_EFFECTS.register(Bus);
        ENCHANTMENT_EFFECTS.register(Bus);
        ENCHANTMENT_EFFECTS_TRIGGER.register(Bus);
        CREATIVE_MODE_TABS.register(Bus);
        ModCauldronInteractionMap.initInteractionMap();
    }
}