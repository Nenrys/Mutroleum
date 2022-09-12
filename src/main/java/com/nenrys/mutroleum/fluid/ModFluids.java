package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.block.ModBlocks;
import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModFluids {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, Mutroleum.MOD_ID);

    /*
    //White, light gray, gray, black
    public static final RegistryObject<FlowingFluid> dM_WHITE = getFluidRegistry("white", ModFluids.PROPERTIES_WHITE);
    public static final RegistryObject<FlowingFluid> dM_WHITE_FLOWING = getFlowingRegistry("white", ModFluids.PROPERTIES_WHITE);
    public static final ForgeFlowingFluid.Properties PROPERTIES_WHITE = getFluidProperties(dM_WHITE, dM_WHITE_FLOWING, 0xf9ffff3);

    public static final RegistryObject<FlowingFluid> dM_LIGHT_GRAY = getFluidRegistry("light_gray", ModFluids.PROPERTIES_LIGHT_GRAY);
    public static final RegistryObject<FlowingFluid> dM_LIGHT_GRAY_FLOWING = getFlowingRegistry("light_gray", ModFluids.PROPERTIES_LIGHT_GRAY);
    public static final ForgeFlowingFluid.Properties PROPERTIES_LIGHT_GRAY = getFluidProperties(dM_LIGHT_GRAY, dM_LIGHT_GRAY_FLOWING, 0x9c9d973);

    public static final RegistryObject<FlowingFluid> dM_GRAY = getFluidRegistry("gray", ModFluids.PROPERTIES_GRAY);
    public static final RegistryObject<FlowingFluid> dM_GRAY_FLOWING = getFlowingRegistry("gray", ModFluids.PROPERTIES_GRAY);
    public static final ForgeFlowingFluid.Properties PROPERTIES_GRAY = getFluidProperties(dM_GRAY, dM_GRAY_FLOWING, 0x474f523);

    public static final RegistryObject<FlowingFluid> dM_BLACK = getFluidRegistry("black", ModFluids.PROPERTIES_BLACK);
    public static final RegistryObject<FlowingFluid> dM_BLACK_FLOWING = getFlowingRegistry("black", ModFluids.PROPERTIES_BLACK);
    public static final ForgeFlowingFluid.Properties PROPERTIES_BLACK = getFluidProperties(dM_BLACK, dM_BLACK_FLOWING, 0x1d1c213);

    //Pink, red, magenta, purple
    public static final RegistryObject<FlowingFluid> dM_PINK = getFluidRegistry("pink", ModFluids.PROPERTIES_PINK);
    public static final RegistryObject<FlowingFluid> dM_PINK_FLOWING = getFlowingRegistry("pink", ModFluids.PROPERTIES_PINK);
    public static final ForgeFlowingFluid.Properties PROPERTIES_PINK = getFluidProperties(dM_PINK, dM_PINK_FLOWING, 0x38caa3);

    public static final RegistryObject<FlowingFluid> dM_RED = getFluidRegistry("red", ModFluids.PROPERTIES_RED);
    public static final RegistryObject<FlowingFluid> dM_RED_FLOWING = getFlowingRegistry("red", ModFluids.PROPERTIES_RED);
    public static final ForgeFlowingFluid.Properties PROPERTIES_RED = getFluidProperties(dM_RED, dM_RED_FLOWING, 0xb02e263);

    public static final RegistryObject<FlowingFluid> dM_MAGENTA = getFluidRegistry("magenta", ModFluids.PROPERTIES_MAGENTA);
    public static final RegistryObject<FlowingFluid> dM_MAGENTA_FLOWING = getFlowingRegistry("magenta", ModFluids.PROPERTIES_MAGENTA );
    public static final ForgeFlowingFluid.Properties PROPERTIES_MAGENTA = getFluidProperties(dM_MAGENTA, dM_MAGENTA_FLOWING, 0xc64fbd3);

    public static final RegistryObject<FlowingFluid> dM_PURPLE = getFluidRegistry("purple", ModFluids.PROPERTIES_PURPLE);
    public static final RegistryObject<FlowingFluid> dM_PURPLE_FLOWING = getFlowingRegistry("purple", ModFluids.PROPERTIES_PURPLE);
    public static final ForgeFlowingFluid.Properties PROPERTIES_PURPLE = getFluidProperties(dM_PURPLE, dM_PURPLE_FLOWING, 0x8932b73);

    //Blue, light blue, cyan, green
    public static final RegistryObject<FlowingFluid> dM_BLUE = getFluidRegistry("blue", ModFluids.PROPERTIES_BLUE);
    public static final RegistryObject<FlowingFluid> dM_BLUE_FLOWING = getFlowingRegistry("blue", ModFluids.PROPERTIES_BLUE);
    public static final ForgeFlowingFluid.Properties PROPERTIES_BLUE = getFluidProperties(dM_BLUE, dM_BLUE_FLOWING, 0x3c44a93);

    public static final RegistryObject<FlowingFluid> dM_LIGHT_BLUE = getFluidRegistry("light_blue", ModFluids.PROPERTIES_LIGHT_BLUE);
    public static final RegistryObject<FlowingFluid> dM_LIGHT_BLUE_FLOWING = getFlowingRegistry("light_blue", ModFluids.PROPERTIES_LIGHT_BLUE);
    public static final ForgeFlowingFluid.Properties PROPERTIES_LIGHT_BLUE = getFluidProperties(dM_LIGHT_BLUE, dM_LIGHT_BLUE_FLOWING, 0x3ab3da3);

    public static final RegistryObject<FlowingFluid> dM_CYAN = getFluidRegistry("cyan", ModFluids.PROPERTIES_CYAN);
    public static final RegistryObject<FlowingFluid> dM_CYAN_FLOWING = getFlowingRegistry("cyan", ModFluids.PROPERTIES_CYAN);
    public static final ForgeFlowingFluid.Properties PROPERTIES_CYAN = getFluidProperties(dM_CYAN, dM_CYAN_FLOWING, 0x169c9d3);

    public static final RegistryObject<FlowingFluid> dM_GREEN = getFluidRegistry("green", ModFluids.PROPERTIES_GREEN);
    public static final RegistryObject<FlowingFluid> dM_GREEN_FLOWING = getFlowingRegistry("green", ModFluids.PROPERTIES_GREEN);
    public static final ForgeFlowingFluid.Properties PROPERTIES_GREEN = getFluidProperties(dM_GREEN, dM_GREEN_FLOWING, 0x5d7c153);

    //Lime, yellow, orange, brown
    public static final RegistryObject<FlowingFluid> dM_LIME = getFluidRegistry("lime", ModFluids.PROPERTIES_LIME);
    public static final RegistryObject<FlowingFluid> dM_LIME_FLOWING = getFlowingRegistry("lime", ModFluids.PROPERTIES_LIME);
    public static final ForgeFlowingFluid.Properties PROPERTIES_LIME = getFluidProperties(dM_LIME, dM_LIME_FLOWING, 0x80c71f3);

    public static final RegistryObject<FlowingFluid> dM_YELLOW = getFluidRegistry("yellow", ModFluids.PROPERTIES_YELLOW);
    public static final RegistryObject<FlowingFluid> dM_YELLOW_FLOWING = getFlowingRegistry("yellow", ModFluids.PROPERTIES_YELLOW);
    public static final ForgeFlowingFluid.Properties PROPERTIES_YELLOW = getFluidProperties(dM_YELLOW, dM_YELLOW_FLOWING, 0xffd83d3);

    public static final RegistryObject<FlowingFluid> dM_ORANGE = getFluidRegistry("orange", ModFluids.PROPERTIES_ORANGE);
    public static final RegistryObject<FlowingFluid> dM_ORANGE_FLOWING = getFlowingRegistry("orange", ModFluids.PROPERTIES_ORANGE);
    public static final ForgeFlowingFluid.Properties PROPERTIES_ORANGE = getFluidProperties(dM_ORANGE, dM_ORANGE_FLOWING, 0xf9801d3);

    public static final RegistryObject<FlowingFluid> dM_BROWN = getFluidRegistry("brown", ModFluids.PROPERTIES_BROWN);
    public static final RegistryObject<FlowingFluid> dM_BROWN_FLOWING = getFlowingRegistry("brown", ModFluids.PROPERTIES_BROWN);
    public static final ForgeFlowingFluid.Properties PROPERTIES_BROWN = getFluidProperties(dM_BROWN, dM_BROWN_FLOWING, 0x8254323);





    public static final RegistryObject<LiquidBlock> DEAD_MUTROLEUM_BLOCK = ModBlocks.BLOCKS.register("dead_mutroleum",
            () -> new LiquidBlock(() -> ModFluids.dM_PURPLE.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f)));

     */

    public static RegistryObject<FlowingFluid> getFluidRegistry(String sColor, ForgeFlowingFluid.Properties properties) {
        return FLUIDS.register("dead_mutroleum_" + sColor, () -> new ForgeFlowingFluid.Source(properties));
    }

    public static RegistryObject<FlowingFluid> getFlowingRegistry(String color, ForgeFlowingFluid.Properties properties) {
        return FLUIDS.register("dead_mutroleum_flowing_"+color, () -> new ForgeFlowingFluid.Flowing(properties));
    }

    /*
    public static ForgeFlowingFluid.Properties getFluidProperties(RegistryObject<FlowingFluid> still, RegistryObject<FlowingFluid> flowing, int color) {
        return new ForgeFlowingFluid.Properties(
                () -> still.get(), () -> flowing.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
                .color(color).overlay(WATER_OVERLAY_RL).temperature(5).viscosity(5)).slopeFindDistance(2)
                .levelDecreasePerBlock(2).block( () -> ModFluids.DEAD_MUTROLEUM_BLOCK.get()).bucket(() -> {

                    ItemStack stack = ModItems.DEAD_MUTROLEUM_BUCKET.get().getDefaultInstance();

                    //return ;
                    return null;
                });
    }

     */

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
