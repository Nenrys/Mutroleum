package com.nenrys.mutroleum.world.feature;

import com.google.common.base.Suppliers;
import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    private static final int MUTROLEUM_ORE_VEIN_SIZE = 10;

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Mutroleum.MOD_ID);

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }


    //for end and nether ore, copy.
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MUTROLEUM_ORE =
            Suppliers.memoize(() -> List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MUTROLEUM_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.MUTROLEUM_ORE_DEEPSLATE.get().defaultBlockState())
            ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MUTROLEUM_ORE = CONFIGURED_FEATURES.register("mutroleum_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_MUTROLEUM_ORE.get(), MUTROLEUM_ORE_VEIN_SIZE)));
}
