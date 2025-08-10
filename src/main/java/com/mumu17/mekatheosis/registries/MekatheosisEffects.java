package com.mumu17.mekatheosis.registries;

import com.mumu17.mekatheosis.Mekatheosis;
import com.mumu17.mekatheosis.effect.RadiationEffect;
import com.mumu17.mekatheosis.effect.RadiationProtectionEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MekatheosisEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Mekatheosis.MODID);

    public static final RegistryObject<MobEffect> RADIATION_EFFECT =
            EFFECTS.register("radiation", RadiationEffect::new);

    public static final RegistryObject<MobEffect> RADIATION_PROTECTION_EFFECT =
            EFFECTS.register("radiation_protection", RadiationProtectionEffect::new);
}
