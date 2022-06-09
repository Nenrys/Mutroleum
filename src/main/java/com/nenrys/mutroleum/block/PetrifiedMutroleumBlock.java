package com.nenrys.mutroleum.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class PetrifiedMutroleumBlock extends Block {

    public static final BooleanProperty HEATED = BooleanProperty.create("heated");

    public static final Iterable<BlockPos> BLOCK_OFFSETS = BlockPos.betweenClosed(
            -1, -1, -1, 1, 1, 1);

    public PetrifiedMutroleumBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HEATED,false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder);
        stateBuilder.add(HEATED);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {

        if (!blockState.getValue(HEATED)) {
            for (BlockPos blockpos_off : BLOCK_OFFSETS) {
                if (serverLevel.getBlockState(blockPos.offset(blockpos_off)).getFluidState().is(FluidTags.LAVA)) {
                    serverLevel.setBlock(blockPos, blockState.setValue(HEATED,true), 2);
                }
            }
        }

    }
}


