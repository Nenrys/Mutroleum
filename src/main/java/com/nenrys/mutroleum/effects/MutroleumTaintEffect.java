package com.nenrys.mutroleum.effects;

import com.nenrys.mutroleum.item.ModItems;
import com.nenrys.mutroleum.item.SpeciesDebugItem;
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

            //temporary, if not holding species item
            if (!(pLivingEntity.getMainHandItem().getItem() instanceof SpeciesDebugItem)) {
                pLivingEntity.hurt(DamageSources.MUTROLEUM_DAMAGE, 1.0F);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return (this == MutroleumEffects.MUTROLEUM_TAINT.get());
    }
}
