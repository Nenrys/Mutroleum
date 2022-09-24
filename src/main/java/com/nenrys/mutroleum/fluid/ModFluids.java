package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.block.ModBlocks;
import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModFluids {

   public static final DeferredRegister<Fluid> FLUIDS =
           DeferredRegister.create(ForgeRegistries.FLUIDS, Mutroleum.MOD_ID);

   public static final RegistryObject<FlowingFluid> SOURCE_DM_WHITE = FLUIDS.register("source_dm_white", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_WHITE));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_LIGHT_GRAY = FLUIDS.register("source_dm_light_gray", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_LIGHT_GRAY));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_GRAY = FLUIDS.register("source_dm_gray", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_GRAY));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_BLACK = FLUIDS.register("source_dm_black", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_BLACK));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_PINK = FLUIDS.register("source_dm_pink", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_PINK));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_RED = FLUIDS.register("source_dm_red", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_RED));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_MAGENTA = FLUIDS.register("source_dm_magenta", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_MAGENTA));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_PURPLE = FLUIDS.register("source_dm_purple", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_PURPLE));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_BLUE = FLUIDS.register("source_dm_blue", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_BLUE));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_LIGHT_BLUE = FLUIDS.register("source_dm_light_blue", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_LIGHT_BLUE));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_CYAN = FLUIDS.register("source_dm_cyan", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_CYAN));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_GREEN = FLUIDS.register("source_dm_green", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_GREEN));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_LIME = FLUIDS.register("source_dm_lime", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_LIME));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_YELLOW = FLUIDS.register("source_dm_yellow", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_YELLOW));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_ORANGE = FLUIDS.register("source_dm_orange", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_ORANGE));
   public static final RegistryObject<FlowingFluid> SOURCE_DM_BROWN = FLUIDS.register("source_dm_brown", () -> new ForgeFlowingFluid.Source(ModFluids.DM_PROPS_BROWN));


   public static final RegistryObject<FlowingFluid> FLOWING_DM_WHITE = FLUIDS.register("flowing_dm_white", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_WHITE));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_LIGHT_GRAY = FLUIDS.register("flowing_dm_light_gray", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_LIGHT_GRAY));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_GRAY = FLUIDS.register("flowing_dm_gray", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_GRAY));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_BLACK = FLUIDS.register("flowing_dm_black", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_BLACK));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_PINK = FLUIDS.register("flowing_dm_pink", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_PINK));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_RED = FLUIDS.register("flowing_dm_red", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_RED));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_MAGENTA = FLUIDS.register("flowing_dm_magenta", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_MAGENTA));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_PURPLE = FLUIDS.register("flowing_dm_purple", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_PURPLE));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_BLUE = FLUIDS.register("flowing_dm_blue", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_BLUE));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_LIGHT_BLUE = FLUIDS.register("flowing_dm_light_blue", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_LIGHT_BLUE));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_CYAN = FLUIDS.register("flowing_dm_cyan", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_CYAN));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_GREEN = FLUIDS.register("flowing_dm_green", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_GREEN));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_LIME = FLUIDS.register("flowing_dm_lime", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_LIME));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_YELLOW = FLUIDS.register("flowing_dm_yellow", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_YELLOW));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_ORANGE = FLUIDS.register("flowing_dm_orange", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_ORANGE));
   public static final RegistryObject<FlowingFluid> FLOWING_DM_BROWN = FLUIDS.register("flowing_dm_brown", () -> new ForgeFlowingFluid.Flowing(ModFluids.DM_PROPS_BROWN));

   public static final ForgeFlowingFluid.Properties DM_PROPS_WHITE = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_WHITE, SOURCE_DM_WHITE, FLOWING_DM_WHITE).block(ModBlocks.DM_BLOCK_WHITE).bucket(ModItems.DM_BUCKET_WHITE);
   public static final ForgeFlowingFluid.Properties DM_PROPS_LIGHT_GRAY = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_LIGHT_GRAY, SOURCE_DM_LIGHT_GRAY, FLOWING_DM_LIGHT_GRAY).block(ModBlocks.DM_BLOCK_LIGHT_GRAY).bucket(ModItems.DM_BUCKET_LIGHT_GRAY);
   public static final ForgeFlowingFluid.Properties DM_PROPS_GRAY = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_GRAY, SOURCE_DM_GRAY, FLOWING_DM_GRAY).block(ModBlocks.DM_BLOCK_GRAY).bucket(ModItems.DM_BUCKET_GRAY);
   public static final ForgeFlowingFluid.Properties DM_PROPS_BLACK = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_BLACK, SOURCE_DM_BLACK, FLOWING_DM_BLACK).block(ModBlocks.DM_BLOCK_BLACK).bucket(ModItems.DM_BUCKET_BLACK);
   public static final ForgeFlowingFluid.Properties DM_PROPS_PINK = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_PINK, SOURCE_DM_PINK, FLOWING_DM_PINK).block(ModBlocks.DM_BLOCK_PINK).bucket(ModItems.DM_BUCKET_PINK);
   public static final ForgeFlowingFluid.Properties DM_PROPS_RED = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_RED, SOURCE_DM_RED, FLOWING_DM_RED).block(ModBlocks.DM_BLOCK_RED).bucket(ModItems.DM_BUCKET_RED);
   public static final ForgeFlowingFluid.Properties DM_PROPS_MAGENTA = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_MAGENTA, SOURCE_DM_MAGENTA, FLOWING_DM_MAGENTA).block(ModBlocks.DM_BLOCK_MAGENTA).bucket(ModItems.DM_BUCKET_MAGENTA);
   public static final ForgeFlowingFluid.Properties DM_PROPS_PURPLE = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_PURPLE, SOURCE_DM_PURPLE, FLOWING_DM_PURPLE).block(ModBlocks.DM_BLOCK_PURPLE).bucket(ModItems.DM_BUCKET_PURPLE);
   public static final ForgeFlowingFluid.Properties DM_PROPS_BLUE = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_BLUE, SOURCE_DM_BLUE, FLOWING_DM_BLUE).block(ModBlocks.DM_BLOCK_BLUE).bucket(ModItems.DM_BUCKET_BLUE);
   public static final ForgeFlowingFluid.Properties DM_PROPS_LIGHT_BLUE = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_LIGHT_BLUE, SOURCE_DM_LIGHT_BLUE, FLOWING_DM_LIGHT_BLUE).block(ModBlocks.DM_BLOCK_LIGHT_BLUE).bucket(ModItems.DM_BUCKET_LIGHT_BLUE);
   public static final ForgeFlowingFluid.Properties DM_PROPS_CYAN = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_CYAN, SOURCE_DM_CYAN, FLOWING_DM_CYAN).block(ModBlocks.DM_BLOCK_CYAN).bucket(ModItems.DM_BUCKET_CYAN);
   public static final ForgeFlowingFluid.Properties DM_PROPS_GREEN = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_GREEN, SOURCE_DM_GREEN, FLOWING_DM_GREEN).block(ModBlocks.DM_BLOCK_GREEN).bucket(ModItems.DM_BUCKET_GREEN);
   public static final ForgeFlowingFluid.Properties DM_PROPS_LIME = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_LIME, SOURCE_DM_LIME, FLOWING_DM_LIME).block(ModBlocks.DM_BLOCK_LIME).bucket(ModItems.DM_BUCKET_LIME);
   public static final ForgeFlowingFluid.Properties DM_PROPS_YELLOW = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_YELLOW, SOURCE_DM_YELLOW, FLOWING_DM_YELLOW).block(ModBlocks.DM_BLOCK_YELLOW).bucket(ModItems.DM_BUCKET_YELLOW);
   public static final ForgeFlowingFluid.Properties DM_PROPS_ORANGE = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_ORANGE, SOURCE_DM_ORANGE, FLOWING_DM_ORANGE).block(ModBlocks.DM_BLOCK_ORANGE).bucket(ModItems.DM_BUCKET_ORANGE);
   public static final ForgeFlowingFluid.Properties DM_PROPS_BROWN = new DM_Properties(ModFluidTypes.DM_FLUID_TYPE_BROWN, SOURCE_DM_BROWN, FLOWING_DM_BROWN).block(ModBlocks.DM_BLOCK_BROWN).bucket(ModItems.DM_BUCKET_BROWN);


   public static class DM_Properties extends ForgeFlowingFluid.Properties {

      public DM_Properties(Supplier<? extends FluidType> fluidType, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing) {
         super(fluidType, still, flowing);
         this.slopeFindDistance(2).levelDecreasePerBlock(2);
      }
   }

   public static void register(IEventBus eventBus) {
       FLUIDS.register(eventBus);
   }
}
