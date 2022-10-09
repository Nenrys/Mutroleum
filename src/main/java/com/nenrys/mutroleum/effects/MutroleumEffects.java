package com.nenrys.mutroleum.effects;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.species.OrganismColor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MutroleumEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Mutroleum.MOD_ID);

    public static final RegistryObject<MobEffect> MUTROLEUM_TAINT = MOB_EFFECTS.register(
            "mutroleum_taint", () -> new MutroleumTaintEffect(MobEffectCategory.NEUTRAL, OrganismColor.PURPLE.hexcol){});

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
