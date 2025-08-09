package com.mumu17.mekatheosis.config;

import com.mumu17.mekatheosis.Mekatheosis;
import mekanism.common.config.IMekanismConfig;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class MekatheosisConfigHelper {
    private MekatheosisConfigHelper() {
    }

    public static final Path CONFIG_DIR = FMLPaths.getOrCreateGameRelativePath(FMLPaths.CONFIGDIR.get().resolve(Mekatheosis.MOD_NAME));

    public static void registerConfig(ModContainer modContainer, IMekanismConfig config) {
        MekatheosisModConfig modConfig = new MekatheosisModConfig(modContainer, config);
        if (config.addToContainer()) {
            modContainer.addConfig(modConfig);
        }
    }
}
