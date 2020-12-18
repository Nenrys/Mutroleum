package com.nenrys.mutroleum.registries;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.blocks.BlockRegistry;
import com.nenrys.mutroleum.items.ItemRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.impl.content.registry.FuelRegistryImpl;
import net.minecraft.item.Item;

import java.util.logging.Logger;

public class FuelRecipes {

    public static void init() {

        FuelRegistry.INSTANCE.add(ItemRegistry.PETRIFIED_MUTR,800);
        FuelRegistry.INSTANCE.add(BlockRegistry.PETRIFIED_MUTR_BLOCK, 800*9);
    }

}
