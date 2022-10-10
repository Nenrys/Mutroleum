package com.nenrys.mutroleum.world.feature;

import com.nenrys.mutroleum.Mutroleum;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    private static final int MUTROLEUM_ORE_VEINS_PER_CHUNK = 5;

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Mutroleum.MOD_ID);


    public static final RegistryObject<PlacedFeature> MUTROLEUM_ORE_PLACED = PLACED_FEATURES.register("mutroleum_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MUTROLEUM_ORE.getHolder().get(),
                    ModPlacedFeatures.commonOrePlacement(MUTROLEUM_ORE_VEINS_PER_CHUNK, //veinspershunk,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

}
