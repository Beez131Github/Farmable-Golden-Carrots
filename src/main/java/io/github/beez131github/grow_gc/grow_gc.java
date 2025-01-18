package io.github.beez131github.grow_gc;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class grow_gc implements ModInitializer {
	public static final String MOD_ID = "grow_gc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public void onInitialize() {
		System.out.println("Growable golden carrots initialized!");
	}
}
