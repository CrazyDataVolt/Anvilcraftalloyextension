package com.crazydatavolt.anvilcraftalloyextension.register;

import com.crazydatavolt.anvilcraftalloyextension.AnvilCraftAlloyExtension;
import com.crazydatavolt.anvilcraftalloyextension.effects.BleedingEffect;
import com.crazydatavolt.anvilcraftalloyextension.effects.FrozenEffect;
import com.crazydatavolt.anvilcraftalloyextension.effects.HitRecoverEffect;
import com.crazydatavolt.anvilcraftalloyextension.effects.RhapsodyBladeEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS=
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, AnvilCraftAlloyExtension.MODID);

    public static final Holder<MobEffect> HIT_RECOVER_EFFECT=MOB_EFFECTS.register("hit_recover",()->
            new HitRecoverEffect(MobEffectCategory.BENEFICIAL,0xFF5066));
    public static final Holder<MobEffect> RHAPSODY_BLADE_EFFECT=MOB_EFFECTS.register("rhapsody_blade",()->
            new RhapsodyBladeEffect(MobEffectCategory.BENEFICIAL,0x59CCA2));
    public static final Holder<MobEffect> BLEEDING_EFFECT=MOB_EFFECTS.register("bleeding",()->
            new BleedingEffect(MobEffectCategory.HARMFUL,0xFF0606));
    public static final Holder<MobEffect> FROZEN_EFFECT=MOB_EFFECTS.register("frozen",()->
            new FrozenEffect(MobEffectCategory.NEUTRAL,0xA8F7FF));
}
