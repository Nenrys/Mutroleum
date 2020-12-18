package com.nenrys.mutroleum.registries;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.blocks.BlockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.impl.biome.modification.BiomeModificationContextImpl;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class MutrOreRegistry {

    private static ConfiguredFeature<?, ?> ORE_MUTR_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockRegistry.MUTROLEUM_ORE.getDefaultState(), 12))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    48)))
            .spreadHorizontally()
            .repeat(10);

    public static void init() {
        RegistryKey<ConfiguredFeature<?, ?>> oreMutrOverworld = RegistryKey
                .of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier(Mutroleum.getId(), "ore_mutr_overworld"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreMutrOverworld.getValue(), ORE_MUTR_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreMutrOverworld);
    }
}
