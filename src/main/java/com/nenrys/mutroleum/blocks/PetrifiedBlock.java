package com.nenrys.mutroleum.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.function.ToIntFunction;

public class PetrifiedBlock extends Block {

    public static final BooleanProperty GLOWING;

    public PetrifiedBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(GLOWING, false));
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        if(shouldGlow(world,pos)) {
            this.glow(state, world, pos);
        }
    }

    protected void glow(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(GLOWING, true));
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        if (world.getDimension().isUltrawarm()) {
            world.removeBlock(pos, false);
        } else {
            world.setBlockState(pos, Blocks.WATER.getDefaultState());
            world.updateNeighbor(pos, Blocks.WATER, pos);
        }
    }

    private boolean shouldGlow(BlockView world, BlockPos pos) {
        boolean b1 = false;

        BlockPos.Mutable mutable = pos.mutableCopy();
        BlockState blockstate;

        if(!world.getBlockState(pos).get(GLOWING)) {
            for(int i = -1; i< 2; i++) {
                for(int j = -1; j< 2; j++) {
                    for(int k = -1; k<2; k++) {
                        mutable.set(i+pos.getX(),j+pos.getY(),k+pos.getZ());
                        blockstate = world.getBlockState(mutable);

                        if(blockstate.getFluidState().isIn(FluidTags.LAVA)) {
                            b1=true;
                            break;
                        }
                        if(b1) break;
                    }
                    if(b1) break;
                }
            }
        }

        return b1;
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        if(state.get(GLOWING)) {
            melt(state, world, pos);
        } else {
            super.afterBreak(world, player, pos, state, blockEntity, stack);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GLOWING);
    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.damage(DamageSource.HOT_FLOOR, 1.0F);
        }

        super.onSteppedOn(world, pos, entity);
    }

    static {
        GLOWING = BooleanProperty.of("glowing");
    }
}
