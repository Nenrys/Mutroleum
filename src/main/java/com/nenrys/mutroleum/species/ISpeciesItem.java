package com.nenrys.mutroleum.species;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public interface ISpeciesItem {

    default void setSpeciesName(ItemStack stack, String name) {
        stack.getOrCreateTag().putString("name", name);
    }

    default void setGene(ItemStack stack, Species.GENES genes, Species.GENE gene) {
        CompoundTag tag = stack.getTag();

        tag.putInt(genes.toString(), gene.ordinal());

        stack.setTag(tag);
    }

    default String getSpeciesName(ItemStack stack) {
        return stack.getTag().getString("name");
    }

    default Species.GENE getGene(ItemStack stack, Species.GENES genes) {

        int gene = stack.getTag().getInt(genes.toString());

        return Species.GENE.values()[gene];
    }

    default void setSpecies(ItemStack stack, Species species) {
        setSpeciesName(stack, species.getName());

        for (Species.GENES genes : Species.GENES.values()) {
            setGene(stack, genes, species.getGene(genes));
        }

        for (Species.ATTRIBUTES atr : Species.ATTRIBUTES.values()) {
            setAttribute(stack, atr, species.getAttribute(atr));
        }

    }

    default void setAttribute(ItemStack stack, Species.ATTRIBUTES atr, int valofatr) {
        CompoundTag tag = stack.getTag();

        tag.putInt(atr.toString(), valofatr);

        stack.setTag(tag);
    }

    default int getAttribute(ItemStack stack, Species.ATTRIBUTES atr) {
        return stack.getTag().getInt(atr.toString());
    }

}
