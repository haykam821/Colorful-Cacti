package io.github.haykam821.colorfulcacti;

import io.github.haykam821.colorfulcacti.block.CactiTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
	public static final String MOD_ID = "colorfulcacti";

	private static final Identifier DYED_CACTI_ID = new Identifier(MOD_ID, "dyed_cacti");
	public static final Tag<Block> DYED_CACTI = TagRegistry.block(DYED_CACTI_ID);

	@Override
	public void onInitialize() {
		CactiTypes.initialize();
	}
}