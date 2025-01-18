package io.github.beez131github.grow_gc.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class GoldenCarrotCropBlock extends CropBlock {
	public static final int MAX_AGE = 6;
	public static final IntProperty AGE = IntProperty.of("age", 0, 6);

	public GoldenCarrotCropBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected ItemConvertible getSeedsItem() {
		return Items.GOLDEN_CARROT;
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
