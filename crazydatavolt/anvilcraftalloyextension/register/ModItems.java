package com.crazydatavolt.anvilcraftalloyextension.register;


import com.crazydatavolt.anvilcraftalloyextension.items.*;
import com.crazydatavolt.anvilcraftalloyextension.tiers.ModTiers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> INSTRUCTION_BOOK = ITEMS.register("instruction_book", () -> new InstructionBookItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).fireResistant()));

    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROSEGOLD_INGOT = ITEMS.register("rosegold_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ROSEGOLD_NUGGET = ITEMS.register("rosegold_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ROSEGOLD_SWORD = ITEMS.register("rosegold_sword",
            () -> new SwordItem(ModTiers.ROSEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSEGOLD,3F, -2.4F))));
    public static final DeferredItem<Item> ROSEGOLD_PICKAXE = ITEMS.register("rosegold_pickaxe",
            () -> new PickaxeItem(ModTiers.ROSEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSEGOLD,1.0F, -2.8F))));
    public static final DeferredItem<Item> ROSEGOLD_AXE = ITEMS.register("rosegold_axe",
            () -> new AxeItem(ModTiers.ROSEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSEGOLD,5.0F, -3.0F))));
    public static final DeferredItem<Item> ROSEGOLD_SHOVEL = ITEMS.register("rosegold_shovel",
            () -> new ShovelItem(ModTiers.ROSEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSEGOLD,1.5F, -3.0F))));
    public static final DeferredItem<Item> ROSEGOLD_HOE = ITEMS.register("rosegold_hoe",
            () -> new HoeItem(ModTiers.ROSEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSEGOLD,-3.0F, 0.0F))));
    public static final DeferredItem<Item> ROSEGOLD_APPLE = ITEMS.register("rosegold_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 0), 1.0f)
            .build())));


    public static final DeferredItem<Item> PURPLEGOLD_INGOT = ITEMS.register("purplegold_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLEGOLD_NUGGET = ITEMS.register("purplegold_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLEGOLD_SWORD = ITEMS.register("purplegold_sword",
            () -> new SwordItem(ModTiers.PURPLEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLEGOLD, 3F, -2.4F))));
    public static final DeferredItem<Item> PURPLEGOLD_PICKAXE = ITEMS.register("purplegold_pickaxe",
            () -> new PickaxeItem(ModTiers.PURPLEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLEGOLD, 1.0F, -2.8F))));
    public static final DeferredItem<Item> PURPLEGOLD_AXE = ITEMS.register("purplegold_axe",
            () -> new AxeItem(ModTiers.PURPLEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLEGOLD, 5.0F, -3.0F))));
    public static final DeferredItem<Item> PURPLEGOLD_SHOVEL = ITEMS.register("purplegold_shovel",
            () -> new ShovelItem(ModTiers.PURPLEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLEGOLD, 1.5F, -3.0F))));
    public static final DeferredItem<Item> PURPLEGOLD_HOE = ITEMS.register("purplegold_hoe",
            () -> new HoeItem(ModTiers.PURPLEGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLEGOLD, -3.0F, 0.0F))));
    public static final DeferredItem<Item> PURPLEGOLD_APPLE = ITEMS.register("purplegold_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 0), 1.0f)
            .build())));


    public static final DeferredItem<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ELECTRUM_NUGGET = ITEMS.register("electrum_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ELECTRUM_SWORD = ITEMS.register("electrum_sword",
            () -> new SwordItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ELECTRUM, 3F, -2.4F))));
    public static final DeferredItem<Item> ELECTRUM_PICKAXE = ITEMS.register("electrum_pickaxe",
            () -> new PickaxeItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ELECTRUM, 1.0F, -2.8F))));
    public static final DeferredItem<Item> ELECTRUM_AXE = ITEMS.register("electrum_axe",
            () -> new AxeItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ELECTRUM, 5.0F, -3.0F))));
    public static final DeferredItem<Item> ELECTRUM_SHOVEL = ITEMS.register("electrum_shovel",
            () -> new ShovelItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ELECTRUM, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ELECTRUM_HOE = ITEMS.register("electrum_hoe",
            () -> new HoeItem(ModTiers.ELECTRUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ELECTRUM, -3.0F, 0.0F))));
    public static final DeferredItem<Item> ELECTRUM_APPLE = ITEMS.register("electrum_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0), 1.0f)
            .build())));


    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(ModTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.STEEL, 3.0F, -2.4F))));

    public static final DeferredItem<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
            () -> new PickaxeItem(ModTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.STEEL, 1.0F, -2.8F))));

    public static final DeferredItem<Item> STEEL_AXE = ITEMS.register("steel_axe",
            () -> new AxeItem(ModTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.STEEL, 5.0F, -3.0F))));

    public static final DeferredItem<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
            () -> new ShovelItem(ModTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.STEEL, 1.5F, -3.0F))));

    public static final DeferredItem<Item> STEEL_HOE = ITEMS.register("steel_hoe",
            () -> new HoeItem(ModTiers.STEEL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.STEEL, -3F, 0.0F))));

    public static final DeferredItem<Item> STEEL_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("steel_upgrade_smithing_template", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STEEL_BOW = ITEMS.register("steel_bow",
            () -> new SteelBowItem(new Item.Properties().durability(1200)));

    public static final DeferredItem<Item> STEEL_SHIELD = ITEMS.register("steel_shield",
            () -> new SteelShieldItem(new Item.Properties().durability(1200)));

    public static final DeferredItem<Item> COAL_DUST = ITEMS.register("coal_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BREEZE_DUST = ITEMS.register("breeze_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDER_DUST = ITEMS.register("ender_dust", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PEARL = ITEMS.register("pearl", () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> FLOWER_FERTILIZER = ITEMS.register("flower_fertilizer", () -> new FlowerFertilizerItem(new Item.Properties()));
    public static final DeferredItem<Item> STAR_TOTEM = ITEMS.register("star_totem", () -> new StarTotemItem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static final DeferredItem<Item> POTATO_BEEF_STEW = ITEMS.register("potato_beef_stew", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(13).saturationModifier(18.8F).usingConvertsTo(Items.BOWL).build())));

    public static final DeferredItem<Item> POTATO_PANCAKE = ITEMS.register("potato_pancake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(6).saturationModifier(6f).build())));
    public static final DeferredItem<Item> PUMPKIN_PANCAKE = ITEMS.register("pumpkin_pancake", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(8).saturationModifier(8f).build())));



    public static final DeferredItem<Item> AZALEA_TEA = ITEMS.register("azalea_tea", () -> new TeaItem(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 14400, 0), 1.0f)
            .build())));
    public static final DeferredItem<Item> CHERRY_TEA = ITEMS.register("cherry_tea", () -> new TeaItem(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1800, 0), 1.0f)
            .build())));
    public static final DeferredItem<Item> CRIMSON_TEA = ITEMS.register("crimson_tea", () -> new TeaItem(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(ModEffects.HIT_RECOVER_EFFECT, 1800, 0), 1.0f)
            .build())));
    public static final DeferredItem<Item> WARPED_TEA = ITEMS.register("warped_tea", () -> new TeaItem(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(ModEffects.RHAPSODY_BLADE_EFFECT, 1800, 0), 1.0f)
            .build())));

/*

    public <T> Properties component(DataComponentType<T> com,T value){
        CommonHooks.validateComponent(value);
        if(this.components()==null){
            this.components = DataComponentMap.builder().addAll(DataComponents.COMMON_ITEM_COMPONENTS);
        }
        this.components .set(com,value);
    }

    public DataComponentMap components() {
        return this.components();
    }

 */
}
