package com.crazydatavolt.anvilcraftalloyextension.register;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.blockentitys.AluminumItemFrameBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITYS =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, AnvilCraftAlloyExtension.MODID);

    public static final Supplier<BlockEntityType<AluminumItemFrameBlockEntity>> ALUMINUM_ITEM_FRAME_BLOCK_ENTITY = BLOCK_ENTITYS.register("aluminumitemframeblock",
            () -> BlockEntityType.Builder.of(AluminumItemFrameBlockEntity::new,
                    ModBlocks.ALUMINUM_ITEM_FRAME_BLOCK.get(),
                    ModBlocks.ALUMINUM_ITEM_FRAME_BLOCK_GLOW.get(),
                    ModBlocks.ALUMINUM_ITEM_FRAME_BLOCK_REDSTONE.get(),
                    ModBlocks.ALUMINUM_ITEM_FRAME_BLOCK_AMETHYST.get(),
                    ModBlocks.ALUMINUM_ITEM_FRAME_BLOCK_ENDER.get()
            ).build(null));



}
