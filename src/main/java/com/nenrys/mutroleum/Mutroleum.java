package com.nenrys.mutroleum;

import com.nenrys.mutroleum.blockentities.BlockEntityRegistry;
import com.nenrys.mutroleum.blocks.BlockRegistry;
import com.nenrys.mutroleum.fluids.FluidRegistry;
import com.nenrys.mutroleum.items.ItemRegistry;
import com.nenrys.mutroleum.registries.FuelRecipes;
import com.nenrys.mutroleum.registries.MutrOreRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Mutroleum implements ModInitializer {

    private static String id = "mutroleum";

    //public static final Item PETRIFIED_MUTR = new Item(new FabricItemSettings().group(Mutroleum.ITEM_GROUP));

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(id, "mutroleum_tab"),() -> new ItemStack(ItemRegistry.PETRIFIED_MUTR));

    @Override
    public void onInitialize() {

        BlockRegistry.registerBlocks();
        ItemRegistry.registerItems();

        FuelRecipes.init();
        MutrOreRegistry.init();
        FluidRegistry.init();

        BlockEntityRegistry.init();

    }

    public static String getId() { return id; }


}
