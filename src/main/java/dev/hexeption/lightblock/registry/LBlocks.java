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

package dev.hexeption.lightblock.registry;

import dev.hexeption.lightblock.LightBlock;
import dev.hexeption.lightblock.block.BlockLight;
import java.util.function.Function;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

/**
 * LBlocks
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 06:01 pm
 */
public class LBlocks {

    public static final Block blockLight_0 = register("light_block_0", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 0));
    public static final Block blockLight_1 = register("light_block_1", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 1));
    public static final Block blockLight_2 = register("light_block_2", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 2));
    public static final Block blockLight_3 = register("light_block_3", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 3));
    public static final Block blockLight_4 = register("light_block_4", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 4));
    public static final Block blockLight_5 = register("light_block_5", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 5));
    public static final Block blockLight_6 = register("light_block_6", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 6));
    public static final Block blockLight_7 = register("light_block_7", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 7));
    public static final Block blockLight_8 = register("light_block_8", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 8));
    public static final Block blockLight_9 = register("light_block_9", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 9));
    public static final Block blockLight_10 = register("light_block_10", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 10));
    public static final Block blockLight_11 = register("light_block_11", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 11));
    public static final Block blockLight_12 = register("light_block_12", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 12));
    public static final Block blockLight_13 = register("light_block_13", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 13));
    public static final Block blockLight_14 = register("light_block_14", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 14));
    public static final Block blockLight_15 = register("light_block_15", new BlockLight(Settings.copy(Blocks.BARRIER).noCollision(), 15));


    public static void init() {

    }

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
        return register(name, block, new BlockItem(block, settings));
    }

    static <T extends Block> T register(String name, T block) {
        return register(name, block, new Item.Settings().group(LightBlock.GROUP));
    }

    static <T extends Block> T register(String name, T block, Function<T, BlockItem> itemFactory) {
        return register(name, block, itemFactory.apply(block));
    }

    static <T extends Block> T register(String name, T block, BlockItem item) {
        T b = Registry.register(Registry.BLOCK, LightBlock.id(name), block);
        if (item != null) {
            LItems.register(name, item);
        }
        return b;
    }
}
