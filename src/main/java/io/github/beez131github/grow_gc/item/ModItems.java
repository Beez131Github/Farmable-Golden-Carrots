package io.github.beez131github.grow_gc.item;

import io.github.beez131github.grow_gc.GrowGc;;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

	// Rooted Golden Carrot Keys
	public static final Item ROOTED_GOLDEN_CARROT = registerItem("rooted_golden_carrot", new Item(new Item.Settings()
		.registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GrowGc.MOD_ID, "rooted_golden_carrot")))
		.maxCount(1)
	));

	public static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(GrowGc.MOD_ID, name), item);
	}

	// Method to add item to item group
	public static void registerModItems() {
		GrowGc.LOGGER.info("Registering Mod Items for " + GrowGc.MOD_ID);
	}
}
