package com.nenrys.mutroleum.item;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.species.SpeciesItem;
import com.nenrys.mutroleum.species.Species;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpeciesDebugItem extends SpeciesItem {

    public SpeciesDebugItem(Properties p_41383_) {
        super(p_41383_);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        //IHasSpecies species = (IHasSpecies) itemstack.getItem();
        //Species.GENE gene = species.getGene(itemstack, "genesis" ,Species.G_GENES.P_COLOR1.toString());

        //gene = gene == Species.GENE.N ? Species.GENE.A : Species.GENE.N;

        //species.setGene(itemstack, "genesis", Species.G_GENES.P_COLOR1.toString(), gene);

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
       if (pStack.hasTag()) {
           String name = getSpeciesName(pStack);
           String genes = getGenesString(pStack);
           String atr = getAtrString(pStack);

           pTooltipComponents.add(Component.literal(name + genes + atr));
       }

       super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private String getGenesString(ItemStack pStack) {
        String s1 = "_";
        for (Species.GENES genes : Species.GENES.values()) {
            s1 += getGene(pStack, genes).toString();
        }
        return s1;
    }

    private String getAtrString(ItemStack pStack) {
        String s1 = "_";
        for (Species.ATTRIBUTES atr : Species.ATTRIBUTES.values()) {
            s1 += "" + getAttribute(pStack, atr);
        }
        return s1;
    }

}
