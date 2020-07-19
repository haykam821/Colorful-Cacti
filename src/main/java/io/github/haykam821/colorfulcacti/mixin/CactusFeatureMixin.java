package io.github.haykam821.colorfulcacti.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import io.github.haykam821.colorfulcacti.block.CactiTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.CactusFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

@Mixin(CactusFeature.class)
public class CactusFeatureMixin {
	@Unique
	public BlockState getCactusAtHeight(int y) {
		CactiTypes type = CactiTypes.values()[y % CactiTypes.values().length];
		return type.block.getDefaultState();
	}

	@Inject(method = "generate", at = @At(value = "INVOKE", target = "net/minecraft/world/IWorld.setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD)
	public void generateColoredCacti(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> generator, Random random, BlockPos startPos, DefaultFeatureConfig config, CallbackInfoReturnable<Boolean> ci, int index, BlockPos basePos, int height, int cactusY) {
		world.setBlockState(basePos.up(cactusY), this.getCactusAtHeight(basePos.getY()), 2);
	}
}