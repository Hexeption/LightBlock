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

import dev.hexeption.lightblock.LightBlock;
import net.minecraft.block.BarrierBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
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

    public BlockLight(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(lightLevel, 0));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
        if (context.isHolding(LightBlock.blockLightItem.asItem()) || context.isHolding(Items.STICK)) {
            return super.getOutlineShape(state, view, pos, context);
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

    @Override
    public int getLuminance(BlockState state) {
        return state.get(lightLevel);
    }
}
