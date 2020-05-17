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

package dev.hexeption.lightblock.particle;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.DefaultParticleType;

/**
 * LightParticle
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 04:34 pm
 */
public class LightParticle extends SpriteBillboardParticle {

    protected LightParticle(ClientWorld world, double x, double y, double z, ItemConvertible itemConvertible) {
        super(world, x, y, z);
        this.setSprite(MinecraftClient.getInstance().getItemRenderer().getModels().getSprite(itemConvertible));
        this.gravityStrength = 0.0F;
        this.maxAge = 40;
        this.collidesWithWorld = false;
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.TERRAIN_SHEET;
    }

    public float getSize(float tickDelta) {
        return 0.5F;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {

        private Item theItem;

        public Factory(Item item) {
            theItem = item;
        }

        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new LightParticle(world, x, y, z, theItem);
        }
    }
}
