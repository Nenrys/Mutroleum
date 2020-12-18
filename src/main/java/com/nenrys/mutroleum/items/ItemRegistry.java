package com.nenrys.mutroleum.items;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.fluids.FluidRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {

    private static Map<String, Item> itemmap = new HashMap<>();

    public static final Item PETRIFIED_MUTR = new Item(new FabricItemSettings().group(Mutroleum.ITEM_GROUP));
    public static final Item MUTR_TEST_ITEM = new MutrTestItem(new FabricItemSettings().group(Mutroleum.ITEM_GROUP));
    public static final Item DEAD_MUTROLEUM_BUCKET = new BucketItem(FluidRegistry.STILL_DEAD_MUTROLEUM, new FabricItemSettings()
            .group(Mutroleum.ITEM_GROUP).recipeRemainder(Items.BUCKET).maxCount(1));


    public static void registerItems() {

        itemmap.put("petrified_mutr",PETRIFIED_MUTR);
        itemmap.put("mutr_test_item", MUTR_TEST_ITEM);
        itemmap.put("dead_mutr_bucket", DEAD_MUTROLEUM_BUCKET);

        itemmap.keySet().forEach(identifier -> {
            Registry.register(Registry.ITEM, new Identifier(Mutroleum.getId(), identifier), itemmap.get(identifier));
        });
    }

}
