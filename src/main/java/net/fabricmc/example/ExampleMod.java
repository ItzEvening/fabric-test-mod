package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item.Settings;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static FoodComponent tacoFood = new FoodComponent.Builder().hunger(5).saturationModifier(4.0f).alwaysEdible().build();
	public static Settings tacoSettings = new Item.Settings().group(ItemGroup.FOOD).food(tacoFood);
	public static final Item TACO = new Item(tacoSettings);

	public static Identifier tacoSongIdentifier = new Identifier("modid:taco_song");
	public static SoundEvent tacoSound = new SoundEvent(tacoSongIdentifier);
	public static Settings tacoDiskSettings = new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.RARE).maxCount(1);
	public static final Item TACO_DISK = new ModMusicDiscItem(15, tacoSound, tacoDiskSettings);

	public static final TagKey<Item> MOD_DISK_TAG = TagKey.of(Registry.ITEM_KEY, new Identifier("modid", "creeper_drop_music_discs"));
	public static final Identifier AWWW_MAN = EntityType.CREEPER.getLootTableId();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("modid", "taco"), TACO);
		Registry.register(Registry.SOUND_EVENT, tacoSongIdentifier, tacoSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "taco_disk"), TACO_DISK);

		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
			if (AWWW_MAN.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder().rolls(ConstantLootNumberProvider.create(1))
				.with(TagEntry.builder(MOD_DISK_TAG));

				table.pool(poolBuilder);
			}
		});
	}
}
