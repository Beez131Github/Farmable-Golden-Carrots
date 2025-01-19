package io.github.beez131github.grow_gc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import io.github.beez131github.grow_gc.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.HolderLookup;
import io.github.beez131github.grow_gc.block.custom.GoldenCarrotCropBlock;

import java.util.concurrent.CompletableFuture;

import static io.github.beez131github.grow_gc.block.ModBlocks.GOLDEN_CARROT_CROP;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(GOLDEN_CARROT_CROP)
			.properties(StatePredicate.Builder.create().exactMatch(GoldenCarrotCropBlock.AGE, GoldenCarrotCropBlock.MAX_AGE));

		// Pass both seed and crop items
		this.addDrop(GOLDEN_CARROT_CROP, cropDrops(GOLDEN_CARROT_CROP, Items.GOLDEN_CARROT, Items.GOLDEN_CARROT, builder));
	}

}
