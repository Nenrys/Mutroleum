package com.nenrys.mutroleum.fluid;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class DMBUCKET extends BucketItem {
    public DMBUCKET(Supplier<? extends Fluid> supplier, Properties builder) {
        super(supplier, builder);
    }
}
