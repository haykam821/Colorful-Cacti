package io.github.haykam821.colorfulcacti.block;

import net.minecraft.block.Block;
import net.minecraft.block.CactusBlock;
import net.minecraft.util.DyeColor;

public class DyedCactusBlock extends CactusBlock {
	private DyeColor color;

	public DyedCactusBlock(DyeColor color, Block.Settings settings) {
		super(settings);
		this.color = color;
	}

	public DyeColor getColor() {
		return this.color;
	}
}