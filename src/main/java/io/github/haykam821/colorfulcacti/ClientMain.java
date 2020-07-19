package io.github.haykam821.colorfulcacti;

import io.github.haykam821.colorfulcacti.block.CactiTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;

public class ClientMain implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		for (CactiTypes type : CactiTypes.values()) {
			ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
				return type.block.getColor().getFireworkColor();
			}, type.block);
			ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
				return type.block.getColor().getFireworkColor();
			}, type.item);
		}
	}
}