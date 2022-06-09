package com.nenrys.mutroleum.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    //placeholder effects
    public static final FoodProperties FRUIT_NON_CARRIER = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.5F).alwaysEat().build();
    public static final FoodProperties FRUIT_CARRIER = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1F).alwaysEat().build();

}
