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

package dev.hexeption.lightblock.mixin;

import dev.hexeption.lightblock.block.BlockLight;
import dev.hexeption.lightblock.registry.LBlocks;
import dev.hexeption.lightblock.registry.LParticles;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.class_5269;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * MixinClientWorld
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 05:15 pm
 */
@Mixin(ClientWorld.class)
@Environment(EnvType.CLIENT)
public abstract class MixinClientWorld extends World {

    @Shadow
    @Final
    private List<AbstractClientPlayerEntity> players;

    @Shadow
    @Final
    private MinecraftClient client;

    protected MixinClientWorld(class_5269 arg, DimensionType dimensionType, Supplier<Profiler> supplier, boolean bl, boolean bl2, long l) {
        super(arg, dimensionType, supplier, bl, bl2, l);
    }

    @Inject(method = "randomBlockDisplayTick", at = @At("RETURN"))
    private void randomBlockDisplayTick(int xCenter, int yCenter, int zCenter, int radius, Random random, boolean spawnBarrierParticles, Mutable pos, CallbackInfo ci) {
        int i = xCenter + this.random.nextInt(radius) - this.random.nextInt(radius);
        int j = yCenter + this.random.nextInt(radius) - this.random.nextInt(radius);
        int k = zCenter + this.random.nextInt(radius) - this.random.nextInt(radius);
        pos.set(i, j, k);
        BlockState blockState = this.getBlockState(pos);
        assert this.client.player != null;
        this.client.player.getItemsHand().forEach(itemStack -> {
            if (itemStack.isItemEqual(LBlocks.blockLight_0.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_1.asItem().getStackForRender()) ||
                itemStack.isItemEqual(LBlocks.blockLight_2.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_3.asItem().getStackForRender()) ||
                itemStack.isItemEqual(LBlocks.blockLight_4.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_5.asItem().getStackForRender()) ||
                itemStack.isItemEqual(LBlocks.blockLight_6.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_7.asItem().getStackForRender()) ||
                itemStack.isItemEqual(LBlocks.blockLight_8.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_9.asItem().getStackForRender()) ||
                itemStack.isItemEqual(LBlocks.blockLight_10.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_11.asItem().getStackForRender()) ||
                itemStack.isItemEqual(LBlocks.blockLight_12.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_13.asItem().getStackForRender()) ||
                itemStack.isItemEqual(LBlocks.blockLight_14.asItem().getStackForRender()) || itemStack.isItemEqual(LBlocks.blockLight_15.asItem().getStackForRender())) {
                if (blockState.getBlock() == LBlocks.blockLight_0 || blockState.getBlock() == LBlocks.blockLight_1 ||
                    blockState.getBlock() == LBlocks.blockLight_2 || blockState.getBlock() == LBlocks.blockLight_3 ||
                    blockState.getBlock() == LBlocks.blockLight_4 || blockState.getBlock() == LBlocks.blockLight_5 ||
                    blockState.getBlock() == LBlocks.blockLight_6 || blockState.getBlock() == LBlocks.blockLight_7 ||
                    blockState.getBlock() == LBlocks.blockLight_8 || blockState.getBlock() == LBlocks.blockLight_9 ||
                    blockState.getBlock() == LBlocks.blockLight_10 || blockState.getBlock() == LBlocks.blockLight_11 ||
                    blockState.getBlock() == LBlocks.blockLight_12 || blockState.getBlock() == LBlocks.blockLight_13 ||
                    blockState.getBlock() == LBlocks.blockLight_14 || blockState.getBlock() == LBlocks.blockLight_15) {
                    switch (blockState.get(BlockLight.lightLevel)) {
                        case 0:
                            this.addParticle(LParticles.lightParticle_0, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 1:
                            this.addParticle(LParticles.lightParticle_1, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 2:
                            this.addParticle(LParticles.lightParticle_2, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 3:
                            this.addParticle(LParticles.lightParticle_3, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 4:
                            this.addParticle(LParticles.lightParticle_4, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 5:
                            this.addParticle(LParticles.lightParticle_5, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 6:
                            this.addParticle(LParticles.lightParticle_6, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 7:
                            this.addParticle(LParticles.lightParticle_7, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 8:
                            this.addParticle(LParticles.lightParticle_8, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 9:
                            this.addParticle(LParticles.lightParticle_9, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 10:
                            this.addParticle(LParticles.lightParticle_10, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 11:
                            this.addParticle(LParticles.lightParticle_11, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 12:
                            this.addParticle(LParticles.lightParticle_12, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 13:
                            this.addParticle(LParticles.lightParticle_13, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 14:
                            this.addParticle(LParticles.lightParticle_14, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                        case 15:
                            this.addParticle(LParticles.lightParticle_15, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
                            break;
                    }
                }
            }
        });
    }

}
