package com.nenrys.mutroleum.blockentities.Screenhandling;

import com.nenrys.mutroleum.blockentities.BlockEntityRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class TestBlockScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public TestBlockScreenHandler(int syncId, PlayerInventory playerinventory) {
        this(syncId, playerinventory, new SimpleInventory(1));
    }

    public TestBlockScreenHandler(int syncId, PlayerInventory playerinventory, Inventory inventory) {
        super(BlockEntityRegistry.TEST_SCREEN_HANDLER, syncId);
        checkSize(inventory, 1);
        this.inventory = inventory;
        inventory.onOpen(playerinventory.player);

        int m;
        int l;
        for(m = 0; m < 1; ++m) {
            for(l = 0; l< 1; ++l) {
                this.addSlot(new Slot(inventory, l+m*3, 143+l*18, 34+m*18));
            }
        }

        //playerinventory

        for(m=0; m< 3; ++m) {
            for(l=0; l<9; ++l) {
                this.addSlot(new Slot(playerinventory, l+m*9+9, 8+l*18, 84+m*18));
            }
        }

        for(m=0; m<9; ++m) {
            this.addSlot(new Slot(playerinventory, m, 8+m*18, 142));
        }
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
}
