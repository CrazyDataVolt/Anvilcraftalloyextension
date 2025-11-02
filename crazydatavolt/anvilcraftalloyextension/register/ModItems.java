package com.crazydatavolt.anvilcraftalloyextension.register;


import com.crazydatavolt.anvilcraftalloyextension.items.*;
import com.crazydatavolt.anvilcraftalloyextension.tiers.ModArmorMateral;
import com.crazydatavolt.anvilcraftalloyextension.tiers.ModTiers;
import dev.dubhe.anvilcraft.init.item.ModComponents;
import dev.dubhe.anvilcraft.item.property.component.Eternal;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Objects;

import static com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> INSTRUCTION_BOOK = ITEMS.register("instruction_book", () -> new InstructionBookItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).fireResistant()));

    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROSE_GOLD_INGOT = ITEMS.register("rose_gold_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ROSE_GOLD_NUGGET = ITEMS.register("rose_gold_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ROSE_GOLD_SWORD = ITEMS.register("rose_gold_sword",
            () -> new SwordItem(ModTiers.ROSE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSE_GOLD,3F, -2.4F))));
    public static final DeferredItem<Item> ROSE_GOLD_PICKAXE = ITEMS.register("rose_gold_pickaxe",
            () -> new PickaxeItem(ModTiers.ROSE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSE_GOLD,1.0F, -2.8F))));
    public static final DeferredItem<Item> ROSE_GOLD_AXE = ITEMS.register("rose_gold_axe",
            () -> new AxeItem(ModTiers.ROSE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSE_GOLD,5.0F, -3.0F))));
    public static final DeferredItem<Item> ROSE_GOLD_SHOVEL = ITEMS.register("rose_gold_shovel",
            () -> new ShovelItem(ModTiers.ROSE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSE_GOLD,1.5F, -3.0F))));
    public static final DeferredItem<Item> ROSE_GOLD_HOE = ITEMS.register("rose_gold_hoe",
            () -> new HoeItem(ModTiers.ROSE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.ROSE_GOLD,-3.0F, 0.0F))));
    public static final DeferredItem<Item> ROSE_GOLD_APPLE = ITEMS.register("rose_gold_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(4).saturationModifier(3f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 0), 1.0f)
            .build())));


    public static final DeferredItem<Item> PURPLE_GOLD_INGOT = ITEMS.register("purple_gold_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_GOLD_NUGGET = ITEMS.register("purple_gold_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_GOLD_SWORD = ITEMS.register("purple_gold_sword",
            () -> new SwordItem(ModTiers.PURPLE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLE_GOLD, 3F, -2.4F))));
    public static final DeferredItem<Item> PURPLE_GOLD_PICKAXE = ITEMS.register("purple_gold_pickaxe",
            () -> new PickaxeItem(ModTiers.PURPLE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLE_GOLD, 1.0F, -2.8F))));
    public static final DeferredItem<Item> PURPLE_GOLD_AXE = ITEMS.register("purple_gold_axe",
            () -> new AxeItem(ModTiers.PURPLE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLE_GOLD, 5.0F, -3.0F))));
    public static final DeferredItem<Item> PURPLE_GOLD_SHOVEL = ITEMS.register("purple_gold_shovel",
            () -> new ShovelItem(ModTiers.PURPLE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLE_GOLD, 1.5F, -3.0F))));
    public static final DeferredItem<Item> PURPLE_GOLD_HOE = ITEMS.register("purple_gold_hoe",
            () -> new HoeItem(ModTiers.PURPLE_GOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.PURPLE_GOLD, -3.0F, 0.0F))));
    public static final DeferredItem<Item> PURPLE_GOLD_APPLE = ITEMS.register("purple_gold_apple", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(4).saturationModifier(3f)
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
            .alwaysEdible().nutrition(4).saturationModifier(3f)
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

    public static final DeferredItem<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
            () -> new ArmorItem(ModArmorMateral.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))
            ));
    public static final DeferredItem<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
            () -> new ArmorItem(ModArmorMateral.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))
            ));
    public static final DeferredItem<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
            () -> new ArmorItem(ModArmorMateral.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))
            ));
    public static final DeferredItem<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
            () -> new ArmorItem(ModArmorMateral.STEEL_ARMOR_MATERIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))
            ));

    public static final DeferredItem<Item> STEEL_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("steel_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.translatable("upgrade.anvilcraftalloyextension.steel_upgrade.can_use_on").withStyle(ChatFormatting.BLUE),
            Component.translatable("upgrade.anvilcraftalloyextension.steel_upgrade.need_material").withStyle(ChatFormatting.BLUE),
            Component.translatable("upgrade.anvilcraftalloyextension.steel_upgrade").withStyle(ChatFormatting.GRAY),
            Component.translatable("upgrade.anvilcraftalloyextension.steel_upgrade.use_on_description"),
            Component.translatable("upgrade.anvilcraftalloyextension.steel_upgrade.material_description"),
            List.of(
                    Objects.requireNonNull(ResourceLocation.tryBuild("anvilcraftalloyextension", "item/empty_slot_bow")),
                    Objects.requireNonNull(ResourceLocation.tryBuild("anvilcraftalloyextension", "item/empty_slot_crossbow")),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_shield")
            ),
            List.of(
                    ResourceLocation.withDefaultNamespace("item/empty_slot_ingot")
            )
    ));
    public static final DeferredItem<Item> STEEL_BOW = ITEMS.register("steel_bow",
            () -> new SteelBowItem(new Item.Properties().durability(1200)));
    public static final DeferredItem<Item> STEEL_CROSSBOW = ITEMS.register("steel_crossbow",
            () -> new SteelCrossBowItem(new Item.Properties().durability(1200)));
    public static final DeferredItem<Item> STEEL_SHIELD = ITEMS.register("steel_shield",
            () -> new SteelShieldItem(new Item.Properties().durability(1200)));


    public static final DeferredItem<Item> BREEZE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("breeze_upgrade_smithing_template", () -> new SmithingTemplateItem(
            Component.translatable("upgrade.anvilcraftalloyextension.breeze_upgrade.can_use_on").withStyle(ChatFormatting.BLUE),
            Component.translatable("upgrade.anvilcraftalloyextension.breeze_upgrade.need_material").withStyle(ChatFormatting.BLUE),
            Component.translatable("upgrade.anvilcraftalloyextension.breeze_upgrade").withStyle(ChatFormatting.GRAY),
            Component.translatable("upgrade.anvilcraftalloyextension.breeze_upgrade.use_on_description"),
            Component.translatable("upgrade.anvilcraftalloyextension.breeze_upgrade.material_description"),
            List.of(
                    Objects.requireNonNull(ResourceLocation.tryBuild("anvilcraftalloyextension", "item/empty_slot_bow")),
                    Objects.requireNonNull(ResourceLocation.tryBuild("anvilcraftalloyextension", "item/empty_slot_crossbow")),
                    ResourceLocation.withDefaultNamespace("item/empty_armor_slot_shield")
            ),
            List.of(
                    Objects.requireNonNull(ResourceLocation.tryBuild("anvilcraftalloyextension", "item/empty_slot_rod"))
            )
    ));
    public static final DeferredItem<Item> BREEZE_BOW = ITEMS.register("breeze_bow",
            () -> new BreezeBowItem(new Item.Properties().durability(1600)));
    public static final DeferredItem<Item> BREEZE_CROSSBOW = ITEMS.register("breeze_crossbow",
            () -> new BreezeCrossBowItem(new Item.Properties().durability(1600)));
    public static final DeferredItem<Item> BREEZE_SHIELD = ITEMS.register("breeze_shield",
            () -> new BreezeShieldItem(new Item.Properties().durability(1600)));

    public static final DeferredItem<Item> BREEZE_CORE = ITEMS.register("breeze_core", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STORM_CROSSBOW = ITEMS.register("storm_crossbow",
            () -> new StormCrossBowItem(new Item.Properties().durability(2000)));

    public static final DeferredItem<Item> EXPERIENCE_SHARD = ITEMS.register("experience_shard", () -> new ExperienceShardItem(new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));

    public static final DeferredItem<Item> COAL_DUST = ITEMS.register("coal_dust", () -> new CanBurnItem(800,new Item.Properties()));
    public static final DeferredItem<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDER_DUST = ITEMS.register("ender_dust", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PEARL = ITEMS.register("pearl", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SHULKER_SHELL_SHARD = ITEMS.register("shulker_shell_shard", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FLOWER_FERTILIZER = ITEMS.register("flower_fertilizer", () -> new FlowerFertilizerItem(new Item.Properties()));

    public static final DeferredItem<Item> POTATO_BEEF_STEW = ITEMS.register("potato_beef_stew", () -> new Item(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .nutrition(13).saturationModifier(1.36F).usingConvertsTo(Items.BOWL).build())));
    public static final DeferredItem<Item> ANCIENT_SALAD = ITEMS.register("ancient_salad", () -> new Item(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .nutrition(13).saturationModifier(1.36F).usingConvertsTo(Items.BOWL).build())));

    public static final DeferredItem<Item> AZALEA_TEA = ITEMS.register("azalea_tea", () -> new DrinkItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 14400, 0), 1.0f)
            .build())));
    public static final DeferredItem<Item> CHERRY_TEA = ITEMS.register("cherry_tea", () -> new DrinkItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1800, 0), 1.0f)
            .build())));
    public static final DeferredItem<Item> CRIMSON_TEA = ITEMS.register("crimson_tea", () -> new DrinkItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(ModEffects.HIT_RECOVER_EFFECT, 1800, 0), 1.0f)
            .build())));
    public static final DeferredItem<Item> WARPED_TEA = ITEMS.register("warped_tea", () -> new DrinkItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(ModEffects.RHAPSODY_BLADE_EFFECT, 1800, 0), 1.0f)
            .build())));
    public static final DeferredItem<Item> HONEY_BERRY_DRINK = ITEMS.register("honey_berry_drink", () -> new DrinkItem(new Item.Properties().stacksTo(16).food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(2).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1.0f)
            .build())));

    public static final DeferredItem<Item> TRANSCENDIUM_APPLE = ITEMS.register("transcendium_apple", () -> new TranscendiumAppleItem(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant().food(new FoodProperties.Builder()
            .nutrition(20).saturationModifier(0.5F).alwaysEdible().build())
            .component(ModComponents.ETERNAL, Eternal.INSTANCE)
    ));

    public static final DeferredItem<Item> LIFE_CRYSTAL = ITEMS.register("life_crystal", () -> new LifeCrystalItem(new Item.Properties()));

}
