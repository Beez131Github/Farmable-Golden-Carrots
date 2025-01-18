package io.github.beez131github.grow_gc.block;

import io.github.beez131github.grow_gc.block.custom.GoldenCarrotCropBlock;
import io.github.beez131github.grow_gc.grow_gc;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

	public static final Block GOLDEN_CARROT_CROP = registerBlockWithoutBlockItem
		("golden_carrot_crop", new GoldenCarrotCropBlock(AbstractBlock.Settings.create()
			.noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(DyeColor.YELLOW)));


	private static Block registerBlockWithoutBlockItem(String name, Block block) {
		return Registry.register(Registries.BLOCK, Identifier.of(grow_gc.MOD_ID, name), block);
	}

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(grow_gc.MOD_ID, name), block);
	}

	private static void registerBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, Identifier.of(grow_gc.MOD_ID, name),
			new BlockItem(block, new Item.Settings()));
	}

	public static void registerModBlocks() {
		grow_gc.LOGGER.info("Registering Mod Blocks for " + grow_gc.MOD_ID);
	}
}

