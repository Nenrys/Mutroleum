package com.nenrys.mutroleum.item;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.fluid.ModFluids;
import com.nenrys.mutroleum.misc.ModCreativeModeTab;
import com.nenrys.mutroleum.species.OrganismColor;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mutroleum.MOD_ID);

    //placeholder condition for longer burn time
    public static final RegistryObject<Item> P_MUTROLEUM = ITEMS.register("p_mutroleum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB)){
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                    return itemStack.getCount() < 5 ? 800 : 3200;
                }
            }

    );

    public static final RegistryObject<Item> SPECIES_DEBUGGER = ITEMS.register("species_debugger",
            () -> new SpeciesDebugItem(new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1)));

    public static final RegistryObject<Item> MUTROLIC_FRUIT = ITEMS.register("mutrolic_fruit",
            () -> new MutrolicFoodItem(new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).food(MutrolicFoodItem.FRUIT_NON_CARRIER), MutrolicFoodItem.FRUIT_CARRIER));

   // public static final RegistryObject<Item> DEAD_MUTROLEUM_BUCKET = ITEMS.register("dead_mutroleum_bucket",
     //       () -> new BucketItem(() -> Fluids.EMPTY, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1)));

    public static final RegistryObject<BucketItem> DM_BUCKET_WHITE = ITEMS.register("dm_bucket_white", () -> new BucketItem(ModFluids.SOURCE_DM_WHITE, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_LIGHT_GRAY = ITEMS.register("dm_bucket_light_gray", () -> new BucketItem(ModFluids.SOURCE_DM_LIGHT_GRAY, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_GRAY = ITEMS.register("dm_bucket_gray", () -> new BucketItem(ModFluids.SOURCE_DM_GRAY, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_BLACK = ITEMS.register("dm_bucket_black", () -> new BucketItem(ModFluids.SOURCE_DM_BLACK, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_PINK = ITEMS.register("dm_bucket_pink", () -> new BucketItem(ModFluids.SOURCE_DM_PINK, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_RED = ITEMS.register("dm_bucket_red", () -> new BucketItem(ModFluids.SOURCE_DM_RED, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_MAGENTA = ITEMS.register("dm_bucket_magenta", () -> new BucketItem(ModFluids.SOURCE_DM_MAGENTA, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_PURPLE = ITEMS.register("dm_bucket_purple", () -> new BucketItem(ModFluids.SOURCE_DM_PURPLE, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_BLUE = ITEMS.register("dm_bucket_blue", () -> new BucketItem(ModFluids.SOURCE_DM_BLUE, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_LIGHT_BLUE = ITEMS.register("dm_bucket_light_blue", () -> new BucketItem(ModFluids.SOURCE_DM_LIGHT_BLUE, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_CYAN = ITEMS.register("dm_bucket_cyan", () -> new BucketItem(ModFluids.SOURCE_DM_CYAN, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_GREEN = ITEMS.register("dm_bucket_green", () -> new BucketItem(ModFluids.SOURCE_DM_GREEN, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_LIME = ITEMS.register("dm_bucket_lime", () -> new BucketItem(ModFluids.SOURCE_DM_LIME, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_YELLOW = ITEMS.register("dm_bucket_yellow", () -> new BucketItem(ModFluids.SOURCE_DM_YELLOW, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_ORANGE = ITEMS.register("dm_bucket_orange", () -> new BucketItem(ModFluids.SOURCE_DM_ORANGE, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<BucketItem> DM_BUCKET_BROWN = ITEMS.register("dm_bucket_brown", () -> new BucketItem(ModFluids.SOURCE_DM_BROWN, new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB).stacksTo(1).craftRemainder(Items.BUCKET)));

    //autogenerated items, do not change __0__
    //autogenerated items, do not change __0__
	public static final RegistryObject<Item> BIOSTATIC_RELIC = ITEMS.register("biostatic_relic", 
		() -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB)));
	public static final RegistryObject<Item> C_MUTROLEUM = ITEMS.register("c_mutroleum", 
		() -> new Item(new Item.Properties().tab(ModCreativeModeTab.MUTROLEUM_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
