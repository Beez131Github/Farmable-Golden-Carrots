package io.github.beez131github.grow_gc.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import io.github.beez131github.grow_gc.block.ModBlocks;
import io.github.beez131github.grow_gc.block.custom.GoldenCarrotCropBlock;
import net.minecraft.data.client.*;
import net.minecraft.data.client.model.BlockStateModelGenerator;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

		blockStateModelGenerator.registerCrop(ModBlocks.GOLDEN_CARROT_CROP, GoldenCarrotCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {

	}
}
