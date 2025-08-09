package com.mumu17.mekatheosis;

import mekanism.api.text.ILangEntry;
import net.minecraft.Util;
import net.minecraft.world.entity.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

public enum MekatheosisLang implements ILangEntry {

    MODULE_ENCHANTMENT_UNIT("module", "enchantment_unit");

    private final String key;

    MekatheosisLang(String type, String path) {
        this(Util.makeDescriptionId(type, Mekatheosis.rl(path)));
    }

    MekatheosisLang(String key) {
        this.key = key;
    }

    @Override
    public @NotNull String getTranslationKey() {
        return key;
    }
}
