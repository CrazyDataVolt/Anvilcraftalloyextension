package com.crazydatavolt.anvilcraftalloyextension.tags;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> ALUMINUM_ITEM_FRAME=createTag("aluminum_item_frame");
        public static final TagKey<Block> TOOLS=createTag("tools");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(AnvilCraftAlloyExtension.MODID,name));
        }
    }

    public static class Items{
        public static final TagKey<Item> ALUMINUM_ITEM_FRAME=createTag("aluminum_item_frame");

        public static final TagKey<Item> SEEDS_FROM_HOE=createTag("seeds_from_hoe");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(AnvilCraftAlloyExtension.MODID,name));
        }

    }
}
