package com.crazydatavolt.anvilcraftalloyextension.tiers;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.register.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMateral {

    public static final Holder<ArmorMaterial> STEEL_ARMOR_MATERIAL = register("steel",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribut->{
                attribut.put(ArmorItem.Type.HELMET, 2);
                attribut.put(ArmorItem.Type.CHESTPLATE, 7);
                attribut.put(ArmorItem.Type.LEGGINGS, 5);
                attribut.put(ArmorItem.Type.BOOTS, 2);
                attribut.put(ArmorItem.Type.BODY, 4);
            }),12,2f,0f, ModItems.STEEL_INGOT);

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantablility, float toughness, float knockbackResistance, Supplier<Item> ingredientItem){

        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(AnvilCraftAlloyExtension.MODID,name);
        Holder<SoundEvent> equipSound =  SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient =() -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type,Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()){
            typeMap.put(type,typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,location,
                new ArmorMaterial(typeProtection,enchantablility,equipSound,ingredient,layers,toughness,knockbackResistance));
    }
}
