package com.nenrys.mutroleum.blockentities;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.blockentities.Screenhandling.TestBlockScreenHandler;
import com.nenrys.mutroleum.blockentities.Screenhandling.TestHandledScreen;
import com.nenrys.mutroleum.blocks.BlockRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class BlockEntityRegistry {

    private static Map<String, BlockEntityType<? extends BlockEntity>> entitymap = new HashMap<>();

    public static final BlockEntityType<TestBlockEntity> TEST_BLOCK_ENTITY = BlockEntityType.Builder.create(TestBlockEntity::new, BlockRegistry.TESTING_BLOCK).build(null);
    public static final Identifier TEST_BLOCK = new Identifier(Mutroleum.getId(), "testing_block");

    public static final ScreenHandlerType<TestBlockScreenHandler> TEST_SCREEN_HANDLER
            = ScreenHandlerRegistry.registerSimple(BlockEntityRegistry.TEST_BLOCK,
            TestBlockScreenHandler::new);

    public static void init() {

        entitymap.put(TEST_BLOCK.getPath(),TEST_BLOCK_ENTITY);

        entitymap.keySet().forEach( identifier -> {
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Mutroleum.getId(), identifier), entitymap.get(identifier));
        });

    }

    public static void clientInit(){
        ScreenRegistry.register(TEST_SCREEN_HANDLER, TestHandledScreen::new);
    }

}
