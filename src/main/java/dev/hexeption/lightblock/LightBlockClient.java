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

import dev.hexeption.lightblock.particle.LightParticle.Factory;
import dev.hexeption.lightblock.registry.LBlocks;
import dev.hexeption.lightblock.registry.LParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

@Environment(EnvType.CLIENT)
public class LightBlockClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_0, new Factory(LBlocks.blockLight_0.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_1, new Factory(LBlocks.blockLight_1.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_2, new Factory(LBlocks.blockLight_2.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_3, new Factory(LBlocks.blockLight_3.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_4, new Factory(LBlocks.blockLight_4.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_5, new Factory(LBlocks.blockLight_5.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_6, new Factory(LBlocks.blockLight_6.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_7, new Factory(LBlocks.blockLight_7.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_8, new Factory(LBlocks.blockLight_8.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_9, new Factory(LBlocks.blockLight_9.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_10, new Factory(LBlocks.blockLight_10.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_11, new Factory(LBlocks.blockLight_11.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_12, new Factory(LBlocks.blockLight_12.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_13, new Factory(LBlocks.blockLight_13.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_14, new Factory(LBlocks.blockLight_14.asItem()));
        ParticleFactoryRegistry.getInstance().register(LParticles.lightParticle_15, new Factory(LBlocks.blockLight_15.asItem()));
    }
}
