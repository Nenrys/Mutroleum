package com.nenrys.mutroleum;

import com.nenrys.mutroleum.blockentities.BlockEntityRegistry;
import com.nenrys.mutroleum.fluids.FluidRendering;
import net.fabricmc.api.ClientModInitializer;

public class MutroleumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRendering.fluidInit();

        BlockEntityRegistry.clientInit();
    }
}
