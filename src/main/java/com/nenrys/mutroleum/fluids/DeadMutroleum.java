package com.nenrys.mutroleum.fluids;

import com.nenrys.mutroleum.blocks.BlockRegistry;
import com.nenrys.mutroleum.items.ItemRegistry;
import com.nenrys.mutroleum.species.ICarrier;
import com.nenrys.mutroleum.species.Species;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class DeadMutroleum extends FlowableFluid implements ICarrier {

    public Species species;

    public DeadMutroleum() {
        super();
        species = new Species();
    }

    public Fluid getFlowing() {
        return FluidRegistry.FLOWING_DEAD_MUTROLEUM;
    }

    public Fluid getStill() {
        return FluidRegistry.STILL_DEAD_MUTROLEUM;
    }

    public Item getBucketItem() {
        return ItemRegistry.DEAD_MUTROLEUM_BUCKET;
    }

    @Override
    protected boolean isInfinite() { return false; }

    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.getBlock().hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    public int getFlowSpeed(WorldView world) {
        return 4;
    }

    public BlockState toBlockState(FluidState state) {
        return (BlockState) BlockRegistry.DEAD_MUTROLEUM.getDefaultState().with(FluidBlock.LEVEL, method_15741(state));
    }

    public boolean matchesType(Fluid fluid) {
        return fluid == FluidRegistry.STILL_DEAD_MUTROLEUM || fluid == FluidRegistry.FLOWING_DEAD_MUTROLEUM;
    }

    public int getLevelDecreasePerBlock(WorldView world) {
        return hasGene(species,2,3,'t') ? 2 : 1;
    }

    public int getTickRate(WorldView world) {
        return hasGene(species,2,3,'t') ? 5 : 20;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0f;
    }

    public static class Flowing extends DeadMutroleum {

        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL);
        }

        public boolean isStill(FluidState state) {
            return false;
        }

    }

    public static class Still extends DeadMutroleum {
        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isStill(FluidState state) {
            return true;
        }
    }

}
