package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.block.ModBlocks;
import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, Mutroleum.MOD_ID);


    public static final RegistryObject<FlowingFluid> DEAD_MUTROLEUM_FLUID
            = FLUIDS.register("dead_mutroleum", () -> new ForgeFlowingFluid.Source(ModFluids.DEAD_MUTROLEUM_PROPERTIES));

    public static final RegistryObject<FlowingFluid> DEAD_MUTROLEUM_FLOWING
            = FLUIDS.register("dead_mutroleum_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.DEAD_MUTROLEUM_PROPERTIES));


    public static final ForgeFlowingFluid.Properties DEAD_MUTROLEUM_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ModFluids.DEAD_MUTROLEUM_FLUID.get(), () -> ModFluids.DEAD_MUTROLEUM_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .color(0xbfb92dc3).overlay(WATER_OVERLAY_RL).temperature(5).viscosity(5)).slopeFindDistance(2)
            .levelDecreasePerBlock(2).block( () -> ModFluids.DEAD_MUTROLEUM_BLOCK.get()).bucket(() -> ModItems.DEAD_MUTROLEUM_BUCKET.get());

    public static final RegistryObject<LiquidBlock> DEAD_MUTROLEUM_BLOCK = ModBlocks.BLOCKS.register("dead_mutroleum",
            () -> new LiquidBlock(() -> ModFluids.DEAD_MUTROLEUM_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f)));



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
