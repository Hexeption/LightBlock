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
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;

/**
 * LParticles
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 06:03 pm
 */
public class LParticles {

    public static final DefaultParticleType lightParticle_0 = register("light_block_0", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_1 = register("light_block_1", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_2 = register("light_block_2", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_3 = register("light_block_3", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_4 = register("light_block_4", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_5 = register("light_block_5", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_6 = register("light_block_6", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_7 = register("light_block_7", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_8 = register("light_block_8", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_9 = register("light_block_9", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_10 = register("light_block_10", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_11 = register("light_block_11", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_12 = register("light_block_12", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_13 = register("light_block_13", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_14 = register("light_block_14", FabricParticleTypes.simple());
    public static final DefaultParticleType lightParticle_15 = register("light_block_15", FabricParticleTypes.simple());

    public static void init() {

    }

    protected static DefaultParticleType register(String name, DefaultParticleType particle) {
        return Registry.register(Registry.PARTICLE_TYPE, LightBlock.id(name), particle);
    }
}
