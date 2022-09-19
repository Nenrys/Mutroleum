package com.nenrys.mutroleum.fluid;

import com.mojang.math.Vector3f;
import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.species.OrganismColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation DM_OVERLAY_RL = new ResourceLocation("block/water_flow");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Mutroleum.MOD_ID);

    public static final RegistryObject<FluidType> DM_FLUID_TYPE = register("dm_fluid_type", OrganismColor.PURPLE.hexcol);

    private static RegistryObject<FluidType> register(String name, int tint) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL,
                DM_OVERLAY_RL, 0xFF000000+tint, new Vector3f(224f/255f, 56f/255f, 208f/255f),
                FluidType.Properties.create().density(15).viscosity(5).sound(SoundAction.get("drink"),
                SoundEvents.HONEY_DRINK)));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}
