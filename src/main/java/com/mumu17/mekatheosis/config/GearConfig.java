package com.mumu17.mekatheosis.config;

import mekanism.api.math.FloatingLong;
import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedFloatingLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class GearConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;

    public final CachedFloatingLongValue mekaSuitEnergyUsageEnchantmentUnit;

    public GearConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Gear Config. This config is synced from server to client.").push("gear");

        mekaSuitEnergyUsageEnchantmentUnit = CachedFloatingLongValue.define(this, builder, "Energy usage (Joules) of MekaSuit per tick of using enchantment unit.",
                "energyUsageEnchantmentUnit", FloatingLong.createConst(500));

        configSpec = builder.build();
    }


    @Override
    public String getFileName() {
        return "gear";
    }

    @Override
    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }

    @Override
    public boolean addToContainer() {
        return false;
    }
}
