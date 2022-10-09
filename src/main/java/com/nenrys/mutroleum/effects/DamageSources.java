package com.nenrys.mutroleum.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DamageSources {

    public static final DamageSource MUTROLEUM_DAMAGE = (new DamageSource("mutroleum_source")).bypassArmor();

}
