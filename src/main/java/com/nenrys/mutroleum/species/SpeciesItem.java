package com.nenrys.mutroleum.species;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SpeciesItem extends Item implements IHasSpecies{

    public SpeciesItem(Properties pProperties) {
        super(pProperties);
    }

    public String getSpeciesName(ItemStack stack) {
        return stack.getTag().getString("name");
    }

    @Override
    public ItemStack getDefaultInstance() {
        Species species = new Species();
        ItemStack stack = super.getDefaultInstance();
        setSpecies(stack, species);
        return stack;
    }

    @Override
    public void setSpeciesName(@Nullable ItemStack stack, String name) {
        stack.getOrCreateTag().putString("name", name);
    }

    public Species.GENE getGene(ItemStack stack, String chrom, String gene) {

        String atcg = stack.getTag().getString(gene);

        for (Species.GENE g : Species.GENE.values()) {
            if (g.toString().equals(atcg)){
                return g;
            }
        }
        return Species.GENE.N;
    }

    public void setGene(ItemStack stack, String chrom, String gene,  Species.GENE atcg) {
        CompoundTag tag = stack.getTag();

        tag.putString(gene, atcg.toString());

        stack.setTag(tag);
    }

    public void setSpecies(ItemStack stack, Species species) {
        setSpeciesName(stack, species.getName());

        for (Species.G_GENES genes : Species.G_GENES.values()) {
            setGene(stack, "genesis",genes.toString() ,species.getGene("genesis", genes.toString()));
        }


    }

}
