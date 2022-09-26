package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.effects.MutroleumEffects;
import com.nenrys.mutroleum.species.OrganismColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
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

    //temporary solution for testing.
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);

        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.POISON, 80));
                ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MutroleumEffects.MUTROLEUM_TAINT.get(), 80, 1));
            }
        }
    }
}
