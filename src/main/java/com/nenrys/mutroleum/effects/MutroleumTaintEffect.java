package com.nenrys.mutroleum.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class MutroleumTaintEffect extends MobEffect {
    protected MutroleumTaintEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (this == MutroleumEffects.MUTROLEUM_TAINT.get()) {
            pLivingEntity.hurt(DamageSource.OUT_OF_WORLD, 1.0F);
        }
    }
}
