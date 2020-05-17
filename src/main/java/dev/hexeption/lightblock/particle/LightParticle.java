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

import dev.hexeption.lightblock.LightBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.world.World;

/**
 * LightParticle
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 04:34 pm
 */
public class LightParticle extends SpriteBillboardParticle {

    protected LightParticle(World world, double x, double y, double z, ItemConvertible itemConvertible) {
        super(world, x, y, z);
        this.setSprite(MinecraftClient.getInstance().getItemRenderer().getModels().getSprite(itemConvertible));
        this.gravityStrength = 0.0F;
        this.maxAge = 80;
        this.collidesWithWorld = false;
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.TERRAIN_SHEET;
    }

    public float getSize(float tickDelta) {
        return 0.5F;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {

        public Factory() {
        }

        public Particle createParticle(DefaultParticleType defaultParticleType, World world, double d, double e, double f, double g, double h, double i) {
            return new LightParticle(world, d, e, f, LightBlock.blockLightItem.asItem());
        }
    }
}
