package com.nenrys.mutroleum.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class MutrolicFoodItem extends Item {

    public static final FoodProperties FRUIT_NON_CARRIER = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.5F).alwaysEat().build();
    public static final FoodProperties FRUIT_CARRIER = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1F).alwaysEat().build();


    @Nullable
    private final FoodProperties carrier_foodProperties;

    public MutrolicFoodItem(Properties pProperties, FoodProperties carrierfoodprops) {
        super(pProperties);
        this.carrier_foodProperties = carrierfoodprops;
    }

    @Override
    public FoodProperties getFoodProperties(ItemStack stack, LivingEntity entity) {
        if (entity != null) {
            return entity.getMainHandItem().is(stack.getItem()) ? this.getFoodProperties() : this.carrier_foodProperties;
        }
        //should not happen
       return Foods.APPLE;
    }

}
