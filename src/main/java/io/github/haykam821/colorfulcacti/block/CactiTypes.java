package io.github.haykam821.colorfulcacti.block;

import io.github.haykam821.colorfulcacti.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum CactiTypes {
	WHITE("white_cactus", DyeColor.WHITE),
	ORANGE("orange_cactus", DyeColor.ORANGE),
	MAGENTA("magenta_cactus", DyeColor.MAGENTA),
	LIGHT_BLUE("light_blue_cactus", DyeColor.LIGHT_BLUE),
	YELLOW("yellow_cactus", DyeColor.YELLOW),
	LIME("lime_cactus", DyeColor.LIME),
	PINK("pink_cactus", DyeColor.PINK),
	GRAY("gray_cactus", DyeColor.GRAY),
	LIGHT_GRAY("light_gray_cactus", DyeColor.LIGHT_GRAY),
	CYAN("cyan_cactus", DyeColor.CYAN),
	PURPLE("purple_cactus", DyeColor.PURPLE),
	BLUE("blue_cactus", DyeColor.BLUE),
	BROWN("brown_cactus", DyeColor.BROWN),
	GREEN("green_cactus", DyeColor.GREEN),
	RED("red_cactus", DyeColor.RED),
	BLACK("black_cactus", DyeColor.BLACK);

	public DyedCactusBlock block;
	public Item item;
	public FlowerPotBlock flowerPot;

	private CactiTypes(String path, DyeColor color) {
		Identifier id = new Identifier(Main.MOD_ID, path);

		this.block = new DyedCactusBlock(color, FabricBlockSettings.copyOf(Blocks.CACTUS).materialColor(color));
		Registry.register(Registry.BLOCK, id, this.block);

		this.item = new BlockItem(this.block, new Item.Settings().group(ItemGroup.DECORATIONS));
		Registry.register(Registry.ITEM, id, this.item);

		// Flower pot
		Identifier flowerPotId = new Identifier(Main.MOD_ID, "potted_" + path);

		this.flowerPot = new FlowerPotBlock(this.block, FabricBlockSettings.copy(Blocks.POTTED_CACTUS));
		Registry.register(Registry.BLOCK, flowerPotId, this.flowerPot);
	}

	public static void initialize() {
		return;
	}
}