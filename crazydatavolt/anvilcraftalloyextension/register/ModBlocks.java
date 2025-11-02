package com.crazydatavolt.anvilcraftalloyextension.register;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.blocks.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, AnvilCraftAlloyExtension.MODID);
    public static final DeferredRegister.Items BLOCKITEMS = DeferredRegister.createItems(MODID);

    public static final Supplier<Block> DEEPSLATE_ALUMINUM_ORE_BLOCK = BLOCKS.register("deepslate_aluminum_ore", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final DeferredItem<Item> DEEPSLATE_ALUMINUM_ORE_BLOCK_ITEM = BLOCKITEMS.register("deepslate_aluminum_ore",
            () -> new BlockItem(DEEPSLATE_ALUMINUM_ORE_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> RAW_ALUMINUM_BLOCK = BLOCKS.register("raw_aluminum_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> RAW_ALUMINUM_BLOCK_ITEM = BLOCKITEMS.register("raw_aluminum_block",
            () -> new BlockItem(RAW_ALUMINUM_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> ALUMINUM_BLOCK_ITEM = BLOCKITEMS.register("aluminum_block",
            () -> new BlockItem(ALUMINUM_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> ALUMINUM_PRESSURE_PLATE_BLOCK = BLOCKS.register("aluminum_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.GOLD,Block.Properties.ofFullCopy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)));
    public static final DeferredItem<Item> ALUMINUM_PRESSURE_PLATE_BLOCK_ITEM = BLOCKITEMS.register("aluminum_pressure_plate",
            () -> new BlockItem(ALUMINUM_PRESSURE_PLATE_BLOCK.get(), new Item.Properties()));


    public static final Supplier<Block> ROSE_GOLD_BLOCK = BLOCKS.register("rose_gold_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> ROSE_GOLD_BLOCK_ITEM = BLOCKITEMS.register("rose_gold_block",
            () -> new BlockItem(ROSE_GOLD_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Block> ROSE_GOLD_PRESSURE_PLATE_BLOCK = BLOCKS.register("rose_gold_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.GOLD, Block.Properties.ofFullCopy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)));
    public static final DeferredItem<Item> ROSE_GOLD_PRESSURE_PLATE_BLOCK_ITEM = BLOCKITEMS.register("rose_gold_pressure_plate",
            () -> new BlockItem(ROSE_GOLD_PRESSURE_PLATE_BLOCK.get(), new Item.Properties()));


    public static final Supplier<Block> PURPLE_GOLD_BLOCK = BLOCKS.register("purple_gold_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> PURPLE_GOLD_BLOCK_ITEM = BLOCKITEMS.register("purple_gold_block", () -> new BlockItem(PURPLE_GOLD_BLOCK.get(),new Item.Properties()));
    public static final Supplier<Block> PURPLE_GOLD_PRESSURE_PLATE_BLOCK = BLOCKS.register("purple_gold_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.GOLD, Block.Properties.ofFullCopy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)));
    public static final DeferredItem<Item> PURPLE_GOLD_PRESSURE_PLATE_BLOCK_ITEM = BLOCKITEMS.register("purple_gold_pressure_plate",
            () -> new BlockItem(PURPLE_GOLD_PRESSURE_PLATE_BLOCK.get(), new Item.Properties()));


    public static final Supplier<Block> ELECTRUM_BLOCK = BLOCKS.register("electrum_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> ELECTRUM_BLOCK_ITEM = BLOCKITEMS.register("electrum_block",
            () -> new BlockItem(ELECTRUM_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Block> ELECTRUM_PRESSURE_PLATE_BLOCK = BLOCKS.register("electrum_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.GOLD, Block.Properties.ofFullCopy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)));
    public static final DeferredItem<Item> ELECTRUM_PRESSURE_PLATE_BLOCK_ITEM = BLOCKITEMS.register("electrum_pressure_plate",
            () -> new BlockItem(ELECTRUM_PRESSURE_PLATE_BLOCK.get(), new Item.Properties()));


    public static final Supplier<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> STEEL_BLOCK_ITEM = BLOCKITEMS.register("steel_block",
            () -> new BlockItem(STEEL_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Block> STEEL_PRESSURE_PLATE_BLOCK = BLOCKS.register("steel_pressure_plate", () ->
            new PressurePlateBlock(BlockSetType.IRON, Block.Properties.ofFullCopy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)));
    public static final DeferredItem<Item> STEEL_PRESSURE_PLATE_BLOCK_ITEM = BLOCKITEMS.register("steel_pressure_plate",
            () -> new BlockItem(STEEL_PRESSURE_PLATE_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> EXPERIENCE_BLOCK = BLOCKS.register("experience_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GLOWSTONE)));
    public static final DeferredItem<Item> EXPERIENCE_BLOCK_ITEM = BLOCKITEMS.register("experience_block",
            () -> new BlockItem(EXPERIENCE_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> DEEPSLATE_RUBY_ORE_BLOCK = BLOCKS.register("deepslate_ruby_ore", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.EMERALD_ORE)));
    public static final DeferredItem<Item> DEEPSLATE_RUBY_ORE_BLOCK_ITEM = BLOCKITEMS.register("deepslate_ruby_ore",
            () -> new BlockItem(DEEPSLATE_RUBY_ORE_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Block> DEEPSLATE_TOPAZ_ORE_BLOCK = BLOCKS.register("deepslate_topaz_ore", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.EMERALD_ORE)));
    public static final DeferredItem<Item> DEEPSLATE_TOPAZ_ORE_BLOCK_ITEM = BLOCKITEMS.register("deepslate_topaz_ore",
            () -> new BlockItem(DEEPSLATE_TOPAZ_ORE_BLOCK.get(), new Item.Properties()));
    public static final Supplier<Block> DEEPSLATE_SAPPHIRE_ORE_BLOCK = BLOCKS.register("deepslate_sapphire_ore", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.EMERALD_ORE)));
    public static final DeferredItem<Item> DEEPSLATE_SAPPHIRE_ORE_BLOCK_ITEM = BLOCKITEMS.register("deepslate_sapphire_ore",
            () -> new BlockItem(DEEPSLATE_SAPPHIRE_ORE_BLOCK.get(), new Item.Properties()));



    public static final Supplier<Block> CAULDRON_PIPE_BLOCK = BLOCKS.register("cauldron_pipe", () ->
            new CauldronPipeBlock(Block.Properties.ofFullCopy(Blocks.CAULDRON)));
    public static final DeferredItem<Item> CAULDRON_PIPE_BLOCK_ITEM = BLOCKITEMS.register("cauldron_pipe",
            () -> new BlockItem(CAULDRON_PIPE_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> ALUMINUM_ITEM_FRAME_BLOCK = BLOCKS.register("aluminum_item_frame",
            () -> new AluminumItemFrameBlock(Block.Properties.of().noCollission().lightLevel(blockState->1)));
    public static final Supplier<Block> ALUMINUM_ITEM_FRAME_BLOCK_GLOW = BLOCKS.register("aluminum_item_frame_glow",
            () -> new AluminumItemFrameBlock(Block.Properties.of().noCollission().lightLevel(blockState->15)));
    public static final Supplier<Block> ALUMINUM_ITEM_FRAME_BLOCK_REDSTONE = BLOCKS.register("aluminum_item_frame_redstone",
            () -> new AluminumItemFrameBlockRedstone(Block.Properties.of().noCollission().lightLevel(blockState->1)));
    public static final Supplier<Block> ALUMINUM_ITEM_FRAME_BLOCK_AMETHYST = BLOCKS.register("aluminum_item_frame_amethyst",
            () -> new AluminumItemFrameBlockAmethyst(Block.Properties.of().noCollission().lightLevel(blockState->1)));
    public static final Supplier<Block> ALUMINUM_ITEM_FRAME_BLOCK_ENDER = BLOCKS.register("aluminum_item_frame_ender",
            () -> new AluminumItemFrameBlockEnder(Block.Properties.of().noCollission().lightLevel(blockState->1)));

    public static final DeferredItem<Item> ALUMINUM_ITEM_FRAME_BLOCK_ITEM = BLOCKITEMS.register("aluminum_item_frame", () -> new BlockItem(ALUMINUM_ITEM_FRAME_BLOCK.get(),new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_ITEM_FRAME_BLOCK_GLOW_ITEM = BLOCKITEMS.register("aluminum_item_frame_glow", () -> new BlockItem(ALUMINUM_ITEM_FRAME_BLOCK_GLOW.get(),new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_ITEM_FRAME_BLOCK_REDSTONE_ITEM = BLOCKITEMS.register("aluminum_item_frame_redstone", () -> new BlockItem(ALUMINUM_ITEM_FRAME_BLOCK_REDSTONE.get(),new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_ITEM_FRAME_BLOCK_AMETHYST_ITEM = BLOCKITEMS.register("aluminum_item_frame_amethyst", () -> new BlockItem(ALUMINUM_ITEM_FRAME_BLOCK_AMETHYST.get(),new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_ITEM_FRAME_BLOCK_ENDER_ITEM = BLOCKITEMS.register("aluminum_item_frame_ender", () -> new BlockItem(ALUMINUM_ITEM_FRAME_BLOCK_ENDER.get(),new Item.Properties()));


    public static final Supplier<Block> DRAGON_BREATH_CAULDRON = BLOCKS.register("dragon_breath_cauldron",
            () -> new DragonBreathCauldronBlock(Block.Properties.ofFullCopy(Blocks.LAVA_CAULDRON)));
}
