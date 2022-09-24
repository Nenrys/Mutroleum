package com.nenrys.mutroleum.species;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public abstract class SpeciesItem extends Item implements ISpeciesItem{

    public SpeciesItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getDefaultInstance() {
        Species species = new Species();
        ItemStack stack = super.getDefaultInstance();
        setSpecies(stack, species);
        return stack;
    }

    public void fillItemCategory(CreativeModeTab pGroup, NonNullList<ItemStack> pItems) {
        if (this.allowedIn(pGroup)) {
            pItems.add(this.getDefaultInstance());
        }
    }
}
