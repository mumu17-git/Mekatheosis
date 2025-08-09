package com.mumu17.mekatheosis.registries;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.mumu17.mekatheosis.Mekatheosis;
import mekanism.common.item.*;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import mekanism.common.resource.IResource;
import mekanism.common.resource.PrimaryResource;
import mekanism.common.resource.ResourceType;
import mekanism.common.util.EnumUtils;
import net.minecraft.world.item.Item;

public class MekatheosisItems {

    private MekatheosisItems() {
    }

    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(Mekatheosis.MODID);

}
