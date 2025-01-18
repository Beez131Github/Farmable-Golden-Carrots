package io.github.beez131github.grow_gc;

import io.github.beez131github.grow_gc.block.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.beez131github.


public class grow_gc implements ModInitializer {
	public static final String MOD_ID = "grow_gc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void OnInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_CARROT_CROP, RenderLayer.getCutout());
	}

	public void onInitialize() {
		System.out.println("Growable golden carrots initialized!");
	}
}
