/*******************************************************************************
 * Template for Fabric Mods
 * Copyright (C) 2020  Hexeption (Keir Davis)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package dev.hexeption.lightblock.block;

import dev.hexeption.lightblock.registry.LBlocks;
import net.minecraft.block.BarrierBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

/**
 * BlockLight
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 16/05/2020 - 02:14 pm
 */
public class BlockLight extends BarrierBlock {

    public static final IntProperty lightLevel = IntProperty.of("light", 0, 15);

    public BlockLight(Settings settings, int defaultLight) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(lightLevel, defaultLight));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (context.isHolding(LBlocks.blockLight_0.asItem()) || context.isHolding(LBlocks.blockLight_1.asItem()) ||
            context.isHolding(LBlocks.blockLight_2.asItem()) || context.isHolding(LBlocks.blockLight_3.asItem()) ||
            context.isHolding(LBlocks.blockLight_4.asItem()) || context.isHolding(LBlocks.blockLight_5.asItem()) ||
            context.isHolding(LBlocks.blockLight_6.asItem()) || context.isHolding(LBlocks.blockLight_7.asItem()) ||
            context.isHolding(LBlocks.blockLight_8.asItem()) || context.isHolding(LBlocks.blockLight_9.asItem()) ||
            context.isHolding(LBlocks.blockLight_10.asItem()) || context.isHolding(LBlocks.blockLight_11.asItem()) ||
            context.isHolding(LBlocks.blockLight_12.asItem()) || context.isHolding(LBlocks.blockLight_13.asItem()) ||
            context.isHolding(LBlocks.blockLight_14.asItem()) || context.isHolding(LBlocks.blockLight_15.asItem())) {
            return super.getOutlineShape(state, world, pos, context);
        } else {
            return VoxelShapes.empty();
        }
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(lightLevel);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(lightLevel) + 1 == 16) {
            world.setBlockState(pos, state.with(lightLevel, 0));
        } else {
            world.setBlockState(pos, state.with(lightLevel, state.get(lightLevel) + 1));
        }
        return ActionResult.SUCCESS;
    }
}
