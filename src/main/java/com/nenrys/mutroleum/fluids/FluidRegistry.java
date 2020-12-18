package com.nenrys.mutroleum.fluids;

import com.nenrys.mutroleum.Mutroleum;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class FluidRegistry {

    private static final Map<String, Fluid> fluidmap = new HashMap<>();

    public static final FlowableFluid STILL_DEAD_MUTROLEUM = new DeadMutroleum.Still();
    public static final FlowableFluid FLOWING_DEAD_MUTROLEUM = new DeadMutroleum.Flowing();

    public static void init() {

        fluidmap.put("dead_mutr",STILL_DEAD_MUTROLEUM);
        fluidmap.put("flowing_dead_mutr", FLOWING_DEAD_MUTROLEUM);


        fluidmap.keySet().forEach(identifier -> {
            Registry.register(Registry.FLUID, new Identifier(Mutroleum.getId(),
                    identifier), fluidmap.get(identifier));
        });

    }
}
