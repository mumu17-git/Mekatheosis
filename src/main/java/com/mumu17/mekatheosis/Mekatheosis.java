package com.mumu17.mekatheosis;

import com.mojang.logging.LogUtils;
import com.mumu17.mekatheosis.config.MekatheosisModConfig;
import com.mumu17.mekatheosis.effect.RadiationEffect;
import com.mumu17.mekatheosis.registries.MekatheosisEffects;
import com.mumu17.mekatheosis.registries.MekatheosisItems;
import mekanism.common.lib.effect.CustomEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(Mekatheosis.MODID)
public class Mekatheosis {
    public static final String MODID = "mekatheosis";
    public static final String MOD_NAME = "Mekatheosis";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Mekatheosis() {
        MekatheosisConfig.registerConfigs(ModLoadingContext.get());
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onConfigLoad);
        MekatheosisItems.ITEMS.register(modEventBus);
        MekatheosisEffects.EFFECTS.register(modEventBus);
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    private void onConfigLoad(ModConfigEvent configEvent) {
        ModConfig config = configEvent.getConfig();
        if (config.getModId().equals(MODID) && config instanceof MekatheosisModConfig mekConfig) {
            mekConfig.clearCache(configEvent);
        }
    }
}
