package com.nenrys.mutroleum.event;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.fluid.ModFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Mutroleum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvent {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {

       // ItemBlockRenderTypes.setRenderLayer(ModFluids.DEAD_MUTROLEUM_BLOCK.get(), RenderType.translucent());

        //clientRegisterFluids();

    }

    private static void clientRegisterFluids() {
        for (RegistryObject<Fluid> fluidreg : ModFluids.FLUIDS.getEntries()) {
            ItemBlockRenderTypes.setRenderLayer(fluidreg.get(), RenderType.translucent());
        }
    }
}
