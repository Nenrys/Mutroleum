package com.nenrys.mutroleum.species;

import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public interface IHasSpecies {

    String getSpeciesName (@Nullable ItemStack stack);

    void setSpeciesName(@Nullable ItemStack stack, String name);

    Species.GENE getGene(@Nullable ItemStack stack, String chrom, String gene);

    void setGene(@Nullable ItemStack stack, String chrom, String gene, Species.GENE atcg);
}
