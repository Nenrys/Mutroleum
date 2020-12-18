package com.nenrys.mutroleum.fluids;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.blocks.BlockRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class FluidRendering {

    //might use instead of blockatlas
    //public static final Identifier BLOCK_ATLAS_TEXTURE = new Identifier("textures/atlas/blocks.png");

    public static void fluidInit() {
        setupfluidRendering(FluidRegistry.STILL_DEAD_MUTROLEUM, FluidRegistry.FLOWING_DEAD_MUTROLEUM,
                new Identifier("minecraft", "water"), 0xCE06C5);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                FluidRegistry.STILL_DEAD_MUTROLEUM, FluidRegistry.FLOWING_DEAD_MUTROLEUM);

        System.out.println("fluidInit is Called");
    }

    public static void setupfluidRendering(final Fluid still,final Fluid flowing, final Identifier textureFluidId,final int color) {
        final Identifier stillSpriteId = new Identifier(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_still");
        final Identifier flowingSpriteId = new Identifier(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_flow");


        //might use own atlas
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((spriteAtlasTexture, registry) -> {
            registry.register(stillSpriteId);
            registry.register(flowingSpriteId);
        });

        final Identifier fluidId = Registry.FLUID.getId(still);
        final Identifier listenerId = new Identifier(fluidId.getNamespace(), fluidId.getPath() + "_reload_listener");

        final Sprite[] fluidSprites = {null, null};

        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {

            @Override
            public Identifier getFabricId() {
                return listenerId;
            }

            @Override
            public void apply(ResourceManager manager) {
                final Function<Identifier, Sprite> atlas = MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
            fluidSprites[0] = atlas.apply(stillSpriteId);
            fluidSprites[1] = atlas.apply(flowingSpriteId);
            }
        });

        final FluidRenderHandler renderHandler = new FluidRenderHandler() {
            @Override
            public Sprite[] getFluidSprites(@Nullable BlockRenderView blockRenderView, @Nullable BlockPos blockPos, FluidState fluidState) {
                return fluidSprites;
            }

            @Override
            public int getFluidColor(@Nullable BlockRenderView view, @Nullable BlockPos pos, FluidState state) {
                return color;
            }
        };

        FluidRenderHandlerRegistry.INSTANCE.register(still, renderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(flowing, renderHandler);

    }
}
