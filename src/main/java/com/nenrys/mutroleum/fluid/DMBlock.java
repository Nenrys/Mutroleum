package com.nenrys.mutroleum.fluid;

import com.nenrys.mutroleum.effects.DamageSources;
import com.nenrys.mutroleum.effects.MutroleumEffects;
import com.nenrys.mutroleum.item.SpeciesDebugItem;
import com.nenrys.mutroleum.species.OrganismColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.Vec3;

import java.util.function.Supplier;

public class DMBlock extends LiquidBlock {

    //public static final IntegerProperty COLOR = IntegerProperty.create("color", 0, 15);

    public DMBlock(Supplier<? extends FlowingFluid> pFluid, Properties pProperties) {
        super(pFluid, pProperties);
        //this.registerDefaultState(this.getStateDefinition().any().setValue(COLOR, OrganismColor.PURPLE.ordinal()));
    }

    //temporary solution for testing.
    /*
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);

        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MutroleumEffects.MUTROLEUM_TAINT.get(), 80, 1));
            }
        }
    }

     */

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        //pEntity.setIsInPowderSnow(true);
        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                if (!((LivingEntity) pEntity).hasEffect(MutroleumEffects.MUTROLEUM_TAINT.get())) {
                    ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MutroleumEffects.MUTROLEUM_TAINT.get(), 80, 0));

                }

                if (!(((Player) pEntity).getItemBySlot(EquipmentSlot.OFFHAND).getItem() instanceof SpeciesDebugItem)) { //temp, check if holding speciesitem
                    if (((LivingEntity) pEntity).hasEffect(MutroleumEffects.MUTROLEUM_TAINT.get()) &&
                            (!(((Player) pEntity).getMainHandItem().getItem() instanceof SpeciesDebugItem))) {
                        pEntity.hurt(DamageSources.MUTROLEUM_DAMAGE, 3F);
                    } else {
                        pEntity.hurt(DamageSources.MUTROLEUM_DAMAGE, 1.5F);
                    }
                }
            }
        }

    }
}
