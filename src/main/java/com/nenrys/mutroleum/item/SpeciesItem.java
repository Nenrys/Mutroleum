package com.nenrys.mutroleum.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SpeciesItem extends Item {
    public SpeciesItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
        if(level.isClientSide) {
            player.displayClientMessage(Component.literal(""+player.getHealth()),true);
        }
        return super.use(level, player, p_41434_);
    }

}
