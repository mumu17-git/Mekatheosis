package com.mumu17.mekatheosis.effect;

import mekanism.common.lib.radiation.RadiationManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class RadiationEffect extends MobEffect {

    public RadiationEffect() {
        super(MobEffectCategory.HARMFUL, 0x98D982);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        RadiationManager radiationManager = RadiationManager.get();
        if (!entity.level().isClientSide) {
            CompoundTag tags = entity.getPersistentData();
            if (tags.contains(RadiationProtectionEffect.RADIATION_PROTECTION_TAG) && tags.getBoolean(RadiationProtectionEffect.RADIATION_PROTECTION_TAG)) {
                entity.getPersistentData().putBoolean(RadiationProtectionEffect.RADIATION_PROTECTION_TAG, false);
                return;
            }
            radiationManager.radiate(entity, 0.01D + 0.01D * amplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}