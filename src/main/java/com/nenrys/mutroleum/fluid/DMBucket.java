package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.species.ISpeciesItem;
import com.nenrys.mutroleum.species.OrganismColor;
import com.nenrys.mutroleum.species.Species;
import com.nenrys.mutroleum.species.SpeciesItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class DMBucket extends BucketItem implements ISpeciesItem {

    private Species.GENE colgene1;
    private Species.GENE colgene2;

    public DMBucket(Supplier<? extends Fluid> supplier, Properties builder, OrganismColor color) {
        super(supplier, builder);

        this.colgene1 = Species.GENE.values()[col2gene(color, true)];
        this.colgene2 = Species.GENE.values()[col2gene(color, false)];
    }

    @Override
    public ItemStack getDefaultInstance() {
        Species species = new Species();
        ItemStack stack = super.getDefaultInstance();
        setSpecies(stack, species);



        return stack;
    }

    public void fillItemCategory(CreativeModeTab pGroup, NonNullList<ItemStack> pItems) {
        if (this.allowedIn(pGroup)) {
            pItems.add(this.getDefaultInstance());
        }
    }

    private int col2gene(OrganismColor color, boolean first) {
        if (first) {
            return color.ordinal()/4;
        } else{
            return color.ordinal()%4;
        }
    }

}
