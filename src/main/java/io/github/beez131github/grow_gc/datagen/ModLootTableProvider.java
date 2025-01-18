package io.github.beez131github.grow_gc.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import io.github.beez131github.grow_gc.block.ModBlocks;
import io.github.beez131github.grow_gc.block.custom.GoldenCarrotCropBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static io.github.beez131github.grow_gc.block.ModBlocks.GOLDEN_CARROT_CROP;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {

		BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.GOLDEN_CARROT_CROP)
			.properties(StatePredicate.Builder.create().exactMatch(GOLDEN_CARROT_CROP.AGE, GOLDEN_CARROT_CROP.MAX_AGE));
		this.addDrop(GOLDEN_CARROT_CROP, (ItemConvertible) this.cropDrops(GOLDEN_CARROT_CROP, Items.GOLDEN_CARROT, Items.GOLDEN_CARROT, builder2));


	}
}
