package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.block.ModBlocks;
import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

   public static final DeferredRegister<Fluid> FLUIDS =
           DeferredRegister.create(ForgeRegistries.FLUIDS, Mutroleum.MOD_ID);

   public static final RegistryObject<FlowingFluid> SOURCE_DM = FLUIDS.register("source_dm",
           () -> new ForgeFlowingFluid.Source(ModFluids.TEST_WATER_PROPS));
   public static final RegistryObject<FlowingFluid> FLOWING_DM = FLUIDS.register("flowing_dm",
           () -> new ForgeFlowingFluid.Flowing(ModFluids.TEST_WATER_PROPS));

   public static final ForgeFlowingFluid.Properties TEST_WATER_PROPS = new ForgeFlowingFluid.Properties(
           ModFluidTypes.DM_FLUID_TYPE, SOURCE_DM, FLOWING_DM).block(ModBlocks.DM_BLOCK)
           .bucket(ModItems.DM_BUCKET).slopeFindDistance(2).levelDecreasePerBlock(2); //change flowingdist etc


   public static void register(IEventBus eventBus) {
       FLUIDS.register(eventBus);
   }
}
