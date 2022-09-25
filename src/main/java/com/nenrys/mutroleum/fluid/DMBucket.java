package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.species.OrganismColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class DMBucket extends BucketItem implements ItemColor{
    public DMBucket(Supplier<? extends Fluid> supplier, Properties builder) {
        super(supplier, builder);
    }


    @Override
    public int getColor(ItemStack pStack, int pTintIndex) {
        return (pTintIndex > 0) ? OrganismColor.LIGHT_BLUE.hexcol : 0;
    }

}
