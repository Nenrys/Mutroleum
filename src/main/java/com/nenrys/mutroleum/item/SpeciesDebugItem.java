package com.nenrys.mutroleum.item;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.species.SpeciesItem;
import com.nenrys.mutroleum.species.Species;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpeciesDebugItem extends SpeciesItem {

    public SpeciesDebugItem(Properties p_41383_) {
        super(p_41383_);
    }



    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
       if (pStack.hasTag()) {
           String name = getSpeciesName(pStack);
           String genes = getStringGenes(pStack);

           pTooltipComponents.add(Component.literal(name + genes));
       }

       super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private String getStringGenes(ItemStack pStack) {
        String s1 = "_";
        for (Species.G_GENES genes : Species.G_GENES.values()) {
            s1 += getGene(pStack,"genesis", genes.toString()).toString();
        }
        return s1;
    }

    public void fillItemCategory(CreativeModeTab pGroup, NonNullList<ItemStack> pItems) {
        if (this.allowedIn(pGroup)) {
            pItems.add(this.getDefaultInstance());
        }
    }

}
