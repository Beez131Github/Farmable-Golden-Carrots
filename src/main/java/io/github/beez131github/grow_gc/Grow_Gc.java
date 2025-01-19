package io.github.beez131github.grow_gc;

import io.github.beez131github.grow_gc.block.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Grow_Gc implements ModInitializer {
	public static final String MOD_ID = "grow_gc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final String NAMESPACE = "grow_gc";
	public static final net.minecraft.util.Identifier VERIFICATION_CHANNEL = net.minecraft.util.Identifier.of(NAMESPACE, "verification");

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		LOGGER.info("Grow_Gc mod initialized!");
	}

}
