package com.nenrys.mutroleum.species;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class dMBucket extends BucketItem {
    public dMBucket(Supplier<? extends Fluid> supplier, Properties builder) {
        super(supplier, builder);
    }
}
