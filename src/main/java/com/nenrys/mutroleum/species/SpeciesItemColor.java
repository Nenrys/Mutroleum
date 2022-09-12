package com.nenrys.mutroleum.species;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

public class SpeciesItemColor implements ItemColor {


    @Override
    public int getColor(ItemStack pStack, int pTintIndex) {
        //return pTintIndex == 0 ? SpeciesColor.colorFromGene(pStack)[0] : SpeciesColor.colorFromGene(pStack)[1];
        return 0;
    }



}
