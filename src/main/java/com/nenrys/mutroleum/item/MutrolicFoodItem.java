package com.nenrys.mutroleum.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class MutrolicFoodItem extends Item {

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
