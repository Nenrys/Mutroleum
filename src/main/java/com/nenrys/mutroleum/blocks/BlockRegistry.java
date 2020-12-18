package com.nenrys.mutroleum.blocks;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.blockentities.BlockEntityRegistry;
import com.nenrys.mutroleum.fluids.FluidRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class BlockRegistry {

    private static String id = "mutroleum";

    //string = identifier
    private static Map<String,Block> blockmap= new HashMap<>();

    public static final Block MUTROLEUM_ORE = new MutrOre(FabricBlockSettings.of(Material.STONE).hardness(3.0f).requiresTool());
    public static final Block PETRIFIED_MUTR_BLOCK = new PetrifiedBlock(FabricBlockSettings.of(Material.METAL).requiresTool()
            .strength(5.0f,2.0f).ticksRandomly().luminance(createLightLevelFromBlockState(12, PetrifiedBlock.GLOWING)));
    public static final Block TESTING_BLOCK = new TestingBlock(FabricBlockSettings.of(Material.STONE));


    public static final Block DEAD_MUTROLEUM = new FluidBlock(FluidRegistry.STILL_DEAD_MUTROLEUM, FabricBlockSettings.copy(Blocks.WATER)){};


    public static void registerBlocks() {

        blockmap.put("mutroleum_ore",MUTROLEUM_ORE);
        blockmap.put("petrified_mutr_block", PETRIFIED_MUTR_BLOCK);
        blockmap.put(BlockEntityRegistry.TEST_BLOCK.getPath(), TESTING_BLOCK);

        blockmap.keySet().forEach(identifier -> {
            Registry.register(Registry.BLOCK, new Identifier(id, identifier), blockmap.get(identifier));
            Registry.register(Registry.ITEM, new Identifier(id, identifier), new BlockItem(blockmap.get(identifier), new Item.Settings().group(Mutroleum.ITEM_GROUP)));
        });

        Registry.register(Registry.BLOCK, new Identifier(id, "dead_mutr_block"), DEAD_MUTROLEUM);

    }



    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel, BooleanProperty property) {
        return (blockState) -> {
            return (Boolean)blockState.get(property) ? litLevel : 0;
        };
    }
}
