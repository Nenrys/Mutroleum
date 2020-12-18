package com.nenrys.mutroleum.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.logging.Logger;

public class MutrTestItem extends Item {
    public MutrTestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient()) {
            user.sendMessage(new LiteralText("Testing"),false);
            System.out.println("Testing");
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
