package com.nenrys.mutroleum.world.feature;

import com.nenrys.mutroleum.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreConfiguration.TargetBlockState> MUTROLEUM_ORE_TARGET_LIST =
            List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MUTROLEUM_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.MUTROLEUM_ORE_DEEPSLATE.get().defaultBlockState()));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MUTROLEUM_ORE_FEATURE = FeatureUtils.register(
            "mutroleum_ore", Feature.ORE, new OreConfiguration(MUTROLEUM_ORE_TARGET_LIST, 6));

}
