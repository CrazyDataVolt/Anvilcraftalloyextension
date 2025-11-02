package com.crazydatavolt.anvilcraftalloyextension.events;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.register.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = AnvilCraftAlloyExtension.MODID)
public class EffectRhapsodyBladeHandler {
    @SubscribeEvent
    public static void WhenHurt(LivingDamageEvent.Post event){
        LivingEntity target = event.getEntity();
        DamageSource source = event.getSource();
        Entity sourceEntity = source.getEntity();

        if (!(sourceEntity instanceof LivingEntity)) return;

        if(((LivingEntity) sourceEntity).hasEffect(ModEffects.RHAPSODY_BLADE_EFFECT)){
            int level=1+((LivingEntity) sourceEntity).getEffect(ModEffects.RHAPSODY_BLADE_EFFECT).getAmplifier();
            target.setHealth(target.getHealth()-2*level);
        }
    }




}
