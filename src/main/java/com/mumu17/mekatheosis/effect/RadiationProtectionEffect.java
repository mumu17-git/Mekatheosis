package com.mumu17.mekatheosis.effect;

import mekanism.common.lib.radiation.RadiationManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class RadiationProtectionEffect extends MobEffect {

    public static final String RADIATION_PROTECTION_TAG = "mekatheosis:radiation_protection";

    public RadiationProtectionEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x64C8FF);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            entity.getPersistentData().putBoolean(RADIATION_PROTECTION_TAG, true);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}