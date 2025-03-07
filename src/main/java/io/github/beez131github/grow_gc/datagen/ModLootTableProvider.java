package io.github.beez131github.grow_gc.datagen;

import io.github.beez131github.grow_gc.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import io.github.beez131github.grow_gc.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
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
		BlockStatePropertyLootCondition.Builder fullyGrownCondition = BlockStatePropertyLootCondition.builder(GOLDEN_CARROT_CROP)
			.properties(StatePredicate.Builder.create().exactMatch(GoldenCarrotCropBlock.AGE, GoldenCarrotCropBlock.MAX_AGE));

		this.add(ModBlocks.GOLDEN_CARROT_CROP, block ->
			LootTable.builder()
				.pool(
					// Loot pool for dropping 1 rooted golden carrot (default drop for all stages)
					LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(ModItems.ROOTED_GOLDEN_CARROT)
							.apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
						)
						.conditionally(SurvivesExplosionLootCondition.builder())
				)
				.pool(
					// Loot pool for dropping 1 additional golden carrot when fully grown
					LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(Items.GOLDEN_CARROT))
						.conditionally(fullyGrownCondition)
						.conditionally(SurvivesExplosionLootCondition.builder())
				)
				.pool(
					// Loot pool for dropping 1-4 rooted golden carrots when fully grown
					LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(ModItems.ROOTED_GOLDEN_CARROT)
							.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 4)))
						)
						.conditionally(fullyGrownCondition)
						.conditionally(SurvivesExplosionLootCondition.builder())
				)
		);
	}



}
