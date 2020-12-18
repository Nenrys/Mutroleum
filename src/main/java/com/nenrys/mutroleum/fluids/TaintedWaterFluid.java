package com.nenrys.mutroleum.fluids;

import net.minecraft.fluid.FlowableFluid;

public abstract class TaintedWaterFluid extends FlowableFluid {
    @Override
    protected boolean isInfinite() {
        return false;
    }


}
