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

    public static final RegistryObject<FluidType> DM_FLUID_TYPE_WHITE = register("dm_fluid_type_white", OrganismColor.WHITE.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_LIGHT_GRAY = register("dm_fluid_type_light_gray", OrganismColor.LIGHT_GRAY.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_GRAY = register("dm_fluid_type_gray", OrganismColor.GRAY.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_BLACK = register("dm_fluid_type_black", OrganismColor.BLACK.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_PINK = register("dm_fluid_type_pink", OrganismColor.PINK.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_RED = register("dm_fluid_type_red", OrganismColor.RED.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_MAGENTA = register("dm_fluid_type_magenta", OrganismColor.MAGENTA.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_PURPLE = register("dm_fluid_type_purple", OrganismColor.PURPLE.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_BLUE = register("dm_fluid_type_blue", OrganismColor.BLUE.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_LIGHT_BLUE = register("dm_fluid_type_light_blue", OrganismColor.LIGHT_BLUE.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_CYAN = register("dm_fluid_type_cyan", OrganismColor.CYAN.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_GREEN = register("dm_fluid_type_green", OrganismColor.GREEN.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_LIME = register("dm_fluid_type_lime", OrganismColor.LIME.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_YELLOW = register("dm_fluid_type_yellow", OrganismColor.YELLOW.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_ORANGE = register("dm_fluid_type_orange", OrganismColor.ORANGE.hexcol);
    public static final RegistryObject<FluidType> DM_FLUID_TYPE_BROWN = register("dm_fluid_type_brown", OrganismColor.BROWN.hexcol);

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
