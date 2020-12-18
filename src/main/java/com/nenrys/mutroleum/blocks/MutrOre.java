package com.nenrys.mutroleum.blocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class MutrOre extends OreBlock {
    public MutrOre(Settings settings) {
        super(settings);
    }

    @Override
    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, 7, 14);
    }
}
