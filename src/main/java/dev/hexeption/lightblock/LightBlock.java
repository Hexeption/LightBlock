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

package dev.hexeption.lightblock;

import dev.hexeption.lightblock.block.BlockLight;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Settings;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LightBlock implements ModInitializer {

    public static final String MOD_ID = "lightblock";

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }


    public static final Block blockLight = new BlockLight(Settings.copy(Blocks.BARRIER).noCollision());

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(blockLight));

    public static final BlockItem blockLightItem = new BlockItem(blockLight, new Item.Settings().group(GROUP));

    public static final DefaultParticleType lightParticle = FabricParticleTypes.simple();

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, id("light_block"), blockLight);
        Registry.register(Registry.ITEM, id("light_block"), blockLightItem);
        Registry.register(Registry.PARTICLE_TYPE, id("light_block"), lightParticle);
    }

}
