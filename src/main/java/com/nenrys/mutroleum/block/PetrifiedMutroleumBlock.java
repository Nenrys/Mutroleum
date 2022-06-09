package com.nenrys.mutroleum.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class PetrifiedMutroleumBlock extends Block {

    public static final BooleanProperty HEATED = BooleanProperty.create("heated");

    public static final List<BlockPos> BLOCK_OFFSETS = BlockPos.betweenClosedStream(
            -1, -1, -1, 1, 1, 1).toList();

    public PetrifiedMutroleumBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HEATED,false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder);
        stateBuilder.add(HEATED);
    }

    //for testing, remove soon, check daylightsensor
    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player p_60506_, InteractionHand p_60507_, BlockHitResult p_60508_) {
        level.setBlock(blockPos, blockState.setValue(HEATED, !blockState.getValue(HEATED)), 3);
        return super.use(blockState, level, blockPos, p_60506_, p_60507_, p_60508_);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {

        if (blockState.getValue(HEATED)) {
            for (BlockPos blockpos_off : BLOCK_OFFSETS) {
                if (serverLevel.getBlockState(blockPos.offset(blockpos_off)).is(Blocks.LAVA)) {
                    blockState.setValue(HEATED,true);
                }
            }
        }

    }
}
