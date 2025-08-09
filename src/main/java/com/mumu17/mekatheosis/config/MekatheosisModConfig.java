package com.mumu17.mekatheosis.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.mumu17.mekatheosis.Mekatheosis;
import mekanism.common.config.IMekanismConfig;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.config.ConfigFileTypeHandler;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.util.function.Function;

public class MekatheosisModConfig extends ModConfig {

    private static final MekatheosisConfigFileTypeHandler MEK_TOML = new MekatheosisConfigFileTypeHandler();

    private final IMekanismConfig mekatheosisConfig;

    public MekatheosisModConfig(ModContainer container, IMekanismConfig config) {
        super(config.getConfigType(), config.getConfigSpec(), container, Mekatheosis.MOD_NAME + "/" + config.getFileName() + ".toml");
        this.mekatheosisConfig = config;
    }

    @Override
    public ConfigFileTypeHandler getHandler() {
        return MEK_TOML;
    }

    public void clearCache(ModConfigEvent event) {
        mekatheosisConfig.clearCache(event instanceof ModConfigEvent.Unloading);
    }

    private static class MekatheosisConfigFileTypeHandler extends ConfigFileTypeHandler {

        private static Path getPath(Path configBasePath) {
            //Intercept server config path reading for Mekanism configs and reroute it to the normal config directory
            if (configBasePath.endsWith("serverconfig")) {
                return FMLPaths.CONFIGDIR.get();
            }
            return configBasePath;
        }

        @Override
        public Function<ModConfig, CommentedFileConfig> reader(Path configBasePath) {
            return super.reader(getPath(configBasePath));
        }

        @Override
        public void unload(Path configBasePath, ModConfig config) {
            super.unload(getPath(configBasePath), config);
        }
    }
}