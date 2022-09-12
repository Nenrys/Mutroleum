package com.nenrys.mutroleum.species;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public abstract class SpeciesItem extends Item{

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

    public void setSpecies(ItemStack stack, Species species) {
        setSpeciesName(stack, species.getName());

        for (Species.GENES genes : Species.GENES.values()) {
            setGene(stack, genes, species.getGene(genes));
        }

        for (Species.ATTRIBUTES atr : Species.ATTRIBUTES.values()) {
            setAttribute(stack, atr, species.getAttribute(atr));
        }

    }

    private void setSpeciesName(ItemStack stack, String name) {
        stack.getOrCreateTag().putString("name", name);
    }

    public void setGene(ItemStack stack, Species.GENES genes, Species.GENE gene) {
        CompoundTag tag = stack.getTag();

        tag.putInt(genes.toString(), gene.ordinal());

        stack.setTag(tag);
    }

    public void setAttribute(ItemStack stack, Species.ATTRIBUTES atr, int valofatr) {
        CompoundTag tag = stack.getTag();

        tag.putInt(atr.toString(), valofatr);

        stack.setTag(tag);
    }

    public int getAttribute(ItemStack stack, Species.ATTRIBUTES atr) {
        return stack.getTag().getInt(atr.toString());
    }

    public Species.GENE getGene(ItemStack stack, Species.GENES genes) {

        int gene = stack.getTag().getInt(genes.toString());

        return Species.GENE.values()[gene];
    }

    public String getSpeciesName(ItemStack stack) {
        return stack.getTag().getString("name");
    }
}
