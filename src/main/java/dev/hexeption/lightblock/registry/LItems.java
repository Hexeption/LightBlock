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
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

/**
 * LItems
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 06:02 pm
 */
public class LItems {

    static Item.Settings newSettings() {
        return new Item.Settings().group(LightBlock.GROUP);
    }

    public static void init() {

    }

    protected static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, LightBlock.id(name), item);
    }
}
