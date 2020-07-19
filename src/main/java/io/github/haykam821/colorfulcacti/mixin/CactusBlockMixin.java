package io.github.haykam821.colorfulcacti.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.colorfulcacti.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;

@Mixin(CactusBlock.class)
public class CactusBlockMixin {
	@Redirect(method = "onScheduledTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"))
	private Block combineMixedHeights(BlockState state) {
		Block block = state.getBlock();
		if (block instanceof CactusBlock) {
			return (Block) (Object) this;
		}
		return block;
	}

	@Redirect(method = "canPlaceAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"))
	private Block allowDyedCacti(BlockState state) {
		Block block = state.getBlock();
		if (Main.DYED_CACTI.contains(block)) {
			return Blocks.CACTUS;
		}
		return block;
	}
}