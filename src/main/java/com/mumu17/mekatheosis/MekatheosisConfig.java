package com.mumu17.mekatheosis;

import com.mumu17.mekatheosis.config.GearConfig;
import com.mumu17.mekatheosis.config.MekatheosisConfigHelper;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;

public class MekatheosisConfig {

    private MekatheosisConfig() {
    }

    public static final GearConfig gear = new GearConfig();

    public static void registerConfigs(ModLoadingContext modLoadingContext) {
        ModContainer modContainer = modLoadingContext.getContainer();
        MekatheosisConfigHelper.registerConfig(modContainer, gear);
    }
}
