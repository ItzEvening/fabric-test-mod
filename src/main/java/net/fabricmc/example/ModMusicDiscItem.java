package net.fabricmc.example;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModMusicDiscItem extends MusicDiscItem {

    public ModMusicDiscItem(int comparatorOutput, SoundEvent sound, Item.Settings settings) 
    {
        super(comparatorOutput, sound, settings);
    }

    public static ModMusicDiscItem addDisk(Identifier id)
    {
        SoundEvent theSound = new SoundEvent(id);
        Settings theSettings = new Item.Settings().group(ItemGroup.MISC).rarity(Rarity.RARE).maxCount(1);
        return new ModMusicDiscItem(15, theSound, theSettings);
    }
}
