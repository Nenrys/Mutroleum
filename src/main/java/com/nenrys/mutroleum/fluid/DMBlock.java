package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.species.OrganismColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class DMBlock extends LiquidBlock {

    //public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 15);

    public DMBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        super(pFluid, pProperties);
        //this.registerDefaultState(this.getStateDefinition().any().setValue(COLOR, OrganismColor.PURPLE.ordinal()));
    }

    /*
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(COLOR);
    }

     */
}
