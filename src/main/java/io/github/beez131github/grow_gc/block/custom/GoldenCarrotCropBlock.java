package io.github.beez131github.grow_gc.block.custom;

import io.github.beez131github.grow_gc.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class GoldenCarrotCropBlock extends CropBlock {
	public static final int MAX_AGE = 7;
	public static final IntProperty AGE = IntProperty.of("age", 0, 7);

	public GoldenCarrotCropBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected ItemConvertible getSeedsItem() {
		return ModItems.ROOTED_GOLDEN_CARROT;
	}

	@Override
	public IntProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}
}
