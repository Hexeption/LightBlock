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

import dev.hexeption.lightblock.LightBlock;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * MixinClientWorld
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 17/05/2020 - 05:15 pm
 */
@Mixin(ClientWorld.class)
public abstract class MixinClientWorld extends World {

    @Shadow
    @Final
    private List<AbstractClientPlayerEntity> players;

    @Shadow
    @Final
    private MinecraftClient client;

    protected MixinClientWorld(LevelProperties levelProperties, DimensionType dimensionType,
        BiFunction<World, Dimension, ChunkManager> chunkManagerProvider, Profiler profiler,
        boolean isClient) {
        super(levelProperties, dimensionType, chunkManagerProvider, profiler, isClient);
    }

    @Redirect(method = "doRandomBlockDisplayTicks", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;asItem()Lnet/minecraft/item/Item;"))
    private Item doRandomBlockDisplayTicks(Block block) {
        if (block.asItem() == Blocks.BARRIER.asItem() || block.asItem() == LightBlock.blockLightItem.asItem()) {
            return Blocks.BARRIER.asItem();
        }
        return block.asItem();
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
            if (itemStack.isItemEqual(LightBlock.blockLight.asItem().getStackForRender()) && blockState.getBlock() == LightBlock.blockLight) {
                this.addParticle(LightBlock.lightParticle, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D, 0.0D, 0.0D, 0.0D);
            }
        });
    }

}
