package com.nenrys.mutroleum.misc;

import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MUTROLEUM_TAB = new CreativeModeTab("mutroleumtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.P_MUTROLEUM.get());
        }
    };
}
