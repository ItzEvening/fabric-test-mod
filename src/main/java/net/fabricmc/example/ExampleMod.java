package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Settings;
import net.minecraft.sound.SoundEvent;
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

	public static FoodComponent baconFood = new FoodComponent.Builder().hunger(1).saturationModifier(0.6f).alwaysEdible().build();
	public static Settings baconSettings = new Item.Settings().group(ItemGroup.FOOD).food(baconFood);
	public static final Item BACON = new Item(baconSettings);

	public static FoodComponent cookedBaconFood = new FoodComponent.Builder().hunger(2).saturationModifier(2.0f).alwaysEdible().build();
	public static Settings cookedBaconSettings = new Item.Settings().group(ItemGroup.FOOD).food(cookedBaconFood);
	public static final Item COOKED_BACON = new Item(cookedBaconSettings);

	public static FoodComponent tacoFood = new FoodComponent.Builder().hunger(5).saturationModifier(8.0f).alwaysEdible().build();
	public static Settings tacoSettings = new Item.Settings().group(ItemGroup.FOOD).food(tacoFood);
	public static final Item TACO = new Item(tacoSettings);

	public static FoodComponent tacoDiskFood = new FoodComponent.Builder().hunger(2).saturationModifier(4.0f).alwaysEdible().build();
	public static Identifier tacoSongIdentifier = new Identifier("modid:taco_song");
	public static SoundEvent tacoSound = new SoundEvent(tacoSongIdentifier);
	public static Settings tacoDiskSettings = new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.RARE).maxCount(1).food(tacoDiskFood);
	public static final Item TACO_DISK = new ModMusicDiscItem(15, tacoSound, tacoDiskSettings);

	public static Identifier birdSongIdentifier = new Identifier("modid:bird");
	public static SoundEvent birdSound = new SoundEvent(birdSongIdentifier);
	public static final Item BIRD_DISK = ModMusicDiscItem.addDisk(birdSongIdentifier);

	public static Identifier enoughSongIdentifier = new Identifier("modid:enough");
	public static SoundEvent enoughSound = new SoundEvent(enoughSongIdentifier);
	public static final Item ENOUGH_DISK = ModMusicDiscItem.addDisk(enoughSongIdentifier);

	public static Identifier lemonadeSongIdentifier = new Identifier("modid:lemonade");
	public static SoundEvent lemonadeSound = new SoundEvent(lemonadeSongIdentifier);
	public static final Item LEMONADE_DISK = ModMusicDiscItem.addDisk(lemonadeSongIdentifier);

	public static Identifier makingSongIdentifier = new Identifier("modid:making");
	public static SoundEvent makingSound = new SoundEvent(makingSongIdentifier);
	public static final Item MAKING_DISK = ModMusicDiscItem.addDisk(makingSongIdentifier);

	public static Identifier mediocreSongIdentifier = new Identifier("modid:mediocre");
	public static SoundEvent mediocreSound = new SoundEvent(mediocreSongIdentifier);
	public static final Item MEDIOCRE_DISK = ModMusicDiscItem.addDisk(mediocreSongIdentifier);

	public static Identifier missingSongIdentifier = new Identifier("modid:missing");
	public static SoundEvent missingSound = new SoundEvent(missingSongIdentifier);
	public static final Item MISSING_DISK = ModMusicDiscItem.addDisk(missingSongIdentifier);

	public static Identifier overitSongIdentifier = new Identifier("modid:overit");
	public static SoundEvent overitSound = new SoundEvent(overitSongIdentifier);
	public static final Item OVERIT_DISK = ModMusicDiscItem.addDisk(overitSongIdentifier);

	public static Identifier pourSongIdentifier = new Identifier("modid:pour");
	public static SoundEvent pourSound = new SoundEvent(pourSongIdentifier);
	public static final Item POUR_DISK = ModMusicDiscItem.addDisk(pourSongIdentifier);

	public static Identifier primeSongIdentifier = new Identifier("modid:prime");
	public static SoundEvent primeSound = new SoundEvent(primeSongIdentifier);
	public static final Item PRIME_DISK = ModMusicDiscItem.addDisk(primeSongIdentifier);

	public static Identifier sleepoverSongIdentifier = new Identifier("modid:sleepover");
	public static SoundEvent sleepoverSound = new SoundEvent(sleepoverSongIdentifier);
	public static final Item SLEEPOVER_DISK = ModMusicDiscItem.addDisk(sleepoverSongIdentifier);

	public static Identifier somewhereSongIdentifier = new Identifier("modid:somewhere");
	public static SoundEvent somewhereSound = new SoundEvent(somewhereSongIdentifier);
	public static final Item SOMEWHERE_DISK = ModMusicDiscItem.addDisk(somewhereSongIdentifier);

	public static Identifier stormSongIdentifier = new Identifier("modid:storm");
	public static SoundEvent stormSound = new SoundEvent(stormSongIdentifier);
	public static final Item STORM_DISK = ModMusicDiscItem.addDisk(stormSongIdentifier);

	public static Identifier swigSongIdentifier = new Identifier("modid:swig");
	public static SoundEvent swigSound = new SoundEvent(swigSongIdentifier);
	public static final Item SWIG_DISK = ModMusicDiscItem.addDisk(swigSongIdentifier);

	public static Identifier tophatSongIdentifier = new Identifier("modid:tophat");
	public static SoundEvent tophatSound = new SoundEvent(tophatSongIdentifier);
	public static final Item TOPHAT_DISK = ModMusicDiscItem.addDisk(tophatSongIdentifier);

	public static Identifier maskSongIdentifier = new Identifier("modid:mask");
	public static SoundEvent maskSound = new SoundEvent(maskSongIdentifier);
	public static final Item MASK_DISK = ModMusicDiscItem.addDisk(maskSongIdentifier);

	public static Identifier maskSusSongIdentifier = new Identifier("modid:mask_sus");
	public static SoundEvent maskSusSound = new SoundEvent(maskSusSongIdentifier);
	public static final Item MASK_SUS_DISK = ModMusicDiscItem.addDisk(maskSusSongIdentifier);

	public static Identifier roadtripSongIdentifier = new Identifier("modid:roadtrip");
	public static SoundEvent roadtripSound = new SoundEvent(roadtripSongIdentifier);
	public static final Item ROADTRIP_DISK = ModMusicDiscItem.addDisk(roadtripSongIdentifier);

	public static Identifier roadtripSusSongIdentifier = new Identifier("modid:roadtrip_sus");
	public static SoundEvent roadtripSusSound = new SoundEvent(roadtripSusSongIdentifier);
	public static final Item ROADTRIP_SUS_DISK = ModMusicDiscItem.addDisk(roadtripSusSongIdentifier);

	public static Identifier clothesSongIdentifier = new Identifier("modid:clothes");
	public static SoundEvent clothesSound = new SoundEvent(clothesSongIdentifier);
	public static final Item CLOTHES_DISK = ModMusicDiscItem.addDisk(clothesSongIdentifier);

	public static Identifier clothesSusSongIdentifier = new Identifier("modid:clothes_sus");
	public static SoundEvent clothesSusSound = new SoundEvent(clothesSusSongIdentifier);
	public static final Item CLOTHES_SUS_DISK = ModMusicDiscItem.addDisk(clothesSusSongIdentifier);

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("modid", "bacon"), BACON);
		Registry.register(Registry.ITEM, new Identifier("modid", "cooked_bacon"), COOKED_BACON);
		Registry.register(Registry.ITEM, new Identifier("modid", "taco"), TACO);

		Registry.register(Registry.SOUND_EVENT, tacoSongIdentifier, tacoSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_taco"), TACO_DISK);

		Registry.register(Registry.SOUND_EVENT, birdSongIdentifier, birdSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_bird"), BIRD_DISK);

		Registry.register(Registry.SOUND_EVENT, enoughSongIdentifier, enoughSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_enough"), ENOUGH_DISK);

		Registry.register(Registry.SOUND_EVENT, lemonadeSongIdentifier, lemonadeSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_lemonade"), LEMONADE_DISK);

		Registry.register(Registry.SOUND_EVENT, makingSongIdentifier, makingSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_making"), MAKING_DISK);

		Registry.register(Registry.SOUND_EVENT, mediocreSongIdentifier, mediocreSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_mediocre"), MEDIOCRE_DISK);

		Registry.register(Registry.SOUND_EVENT, missingSongIdentifier, missingSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_missing"), MISSING_DISK);

		Registry.register(Registry.SOUND_EVENT, overitSongIdentifier, overitSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_overit"), OVERIT_DISK);

		Registry.register(Registry.SOUND_EVENT, pourSongIdentifier, pourSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_pour"), POUR_DISK);

		Registry.register(Registry.SOUND_EVENT, primeSongIdentifier, primeSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_prime"), PRIME_DISK);

		Registry.register(Registry.SOUND_EVENT, sleepoverSongIdentifier, sleepoverSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_sleepover"), SLEEPOVER_DISK);

		Registry.register(Registry.SOUND_EVENT, somewhereSongIdentifier, somewhereSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_somewhere"), SOMEWHERE_DISK);

		Registry.register(Registry.SOUND_EVENT, stormSongIdentifier, stormSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_storm"), STORM_DISK);

		Registry.register(Registry.SOUND_EVENT, swigSongIdentifier, swigSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_swig"), SWIG_DISK);

		Registry.register(Registry.SOUND_EVENT, tophatSongIdentifier, tophatSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_tophat"), TOPHAT_DISK);

		Registry.register(Registry.SOUND_EVENT, maskSongIdentifier, maskSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_mask"), MASK_DISK);

		Registry.register(Registry.SOUND_EVENT, maskSusSongIdentifier, maskSusSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_mask_sus"), MASK_SUS_DISK);

		Registry.register(Registry.SOUND_EVENT, roadtripSongIdentifier, roadtripSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_roadtrip"), ROADTRIP_DISK);

		Registry.register(Registry.SOUND_EVENT, roadtripSusSongIdentifier, roadtripSusSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_roadtrip_sus"), ROADTRIP_SUS_DISK);

		Registry.register(Registry.SOUND_EVENT, clothesSongIdentifier, clothesSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_clothes"), CLOTHES_DISK);

		Registry.register(Registry.SOUND_EVENT, clothesSusSongIdentifier, clothesSusSound);
		Registry.register(Registry.ITEM, new Identifier("modid", "music_disc_clothes_sus"), CLOTHES_SUS_DISK);
	}
}
