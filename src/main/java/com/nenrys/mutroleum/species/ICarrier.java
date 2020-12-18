package com.nenrys.mutroleum.species;

import net.minecraft.nbt.CompoundTag;

public interface ICarrier {

    default boolean hasGene(Species species, int chrom, int gene, char s) {
        return species.genes[chrom].charAt(gene)==s;
    }

    default boolean sameSpecies(Species sp1, Species sp2) {
        return sp1.genes.equals(sp2.genes);
    }

}
