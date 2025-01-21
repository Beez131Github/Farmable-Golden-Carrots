package io.github.beez131github.grow_gc.item;

import io.github.beez131github.grow_gc.GrowGc;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModItems {
	// Register the item using the correct identifier
	public static final Item ROOTED_GOLDEN_CARROT = registerItem(
		"rooted_golden_carrot",
		new Item(new Item.Settings())
	);

	private static Item registerItem(String name, Item item) {
		Identifier id = Identifier.of(GrowGc.MOD_ID, name); // Create the identifier
		RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id); // Create the registry key

		// Update the Item.Settings to include the registry key
		Item.Settings settings = new Item.Settings()
			.registryKey(key); // Explicitly set the registry key in the settings

		// Register the item using the registry key
		return Registry.register(
			Registries.ITEM, // The registry to register to
			key,             // The registry key
			new Item(settings) // Create the item with updated settings
		);
	}


	// Method to register all mod items
	public static void registerModItems() {
		GrowGc.LOGGER.info("Registering Mod Items for " + GrowGc.MOD_ID);
	}
}
