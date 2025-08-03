package com.crazydatavolt.anvilcraftalloyextension.register;


import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.blocks.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, AnvilCraftAlloyExtension.MODID);
    public static final DeferredRegister.Items BLOCKITEMS = DeferredRegister.createItems(MODID);

    public static final Supplier<Block> DEEPSLATE_ALUMINUM_ORE_BLOCK = BLOCKS.register("deepslate_aluminum_ore", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
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

    public static final Supplier<Block> ROSEGOLD_BLOCK = BLOCKS.register("rosegold_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> ROSEGOLD_BLOCK_ITEM = BLOCKITEMS.register("rosegold_block",
            () -> new BlockItem(ROSEGOLD_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> PURPLE_GOLD_BLOCK = BLOCKS.register("purplegold_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> PURPLE_GOLD_BLOCK_ITEM = BLOCKITEMS.register("purplegold_block", () -> new BlockItem(PURPLE_GOLD_BLOCK.get(),new Item.Properties()));

    public static final Supplier<Block> ELECTRUM_BLOCK = BLOCKS.register("electrum_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> ELECTRUM_BLOCK_ITEM = BLOCKITEMS.register("electrum_block",
            () -> new BlockItem(ELECTRUM_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> STEEL_BLOCK = BLOCKS.register("steel_block", () ->
            new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
    public static final DeferredItem<Item> STEEL_BLOCK_ITEM = BLOCKITEMS.register("steel_block",
            () -> new BlockItem(STEEL_BLOCK.get(), new Item.Properties()));

    public static final Supplier<Block> EXPANSION_BARREL_BLOCK = BLOCKS.register("expansion_barrel",
            () -> new ExpansionBarrelBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
    public static final DeferredItem<Item> EXPANSION_BARREL_BLOCK_ITEM = BLOCKITEMS.register("expansion_barrel", () -> new BlockItem(EXPANSION_BARREL_BLOCK.get(),new Item.Properties()));

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






}
