package io.github.beez131github.grow_gc.block;

import io.github.beez131github.grow_gc.GrowGc;
import io.github.beez131github.grow_gc.block.custom.GoldenCarrotCropBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModBlocks {

	// Define a RegistryKey for your block
	public static final RegistryKey<Block> GOLDEN_CARROT_CROP_KEY = RegistryKey.of(
		Registries.BLOCK.getKey(),
		Identifier.of(GrowGc.MOD_ID, "golden_carrot_crop")
	);

	// Register your block using the key
	public static final Block GOLDEN_CARROT_CROP = registerBlockWithoutBlockItem(
		"golden_carrot_crop",
		new GoldenCarrotCropBlock(AbstractBlock.Settings.create()
			.noCollision()
			.ticksRandomly()
			.breakInstantly()
			.sounds(BlockSoundGroup.CROP)
			.pistonBehavior(PistonBehavior.DESTROY)
			.mapColor(DyeColor.YELLOW)
			.key(GOLDEN_CARROT_CROP_KEY)) // Apply the key here
	);

	private static Block registerBlockWithoutBlockItem(String name, Block block) {
		return Registry.register(Registries.BLOCK, Identifier.of(GrowGc.MOD_ID, name), block);
	}

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(GrowGc.MOD_ID, name), block);
	}

	private static void registerBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, Identifier.of(GrowGc.MOD_ID, name),
			new BlockItem(block, new Item.Settings()));
	}

	public static void registerModBlocks() {
		GrowGc.LOGGER.info("Registering Mod Blocks for " + GrowGc.MOD_ID);
	}
}
