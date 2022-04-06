package net.fabricmc.example;

import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;

public class ModMusicDiscItem extends MusicDiscItem {

    public ModMusicDiscItem(int comparatorOutput, SoundEvent sound, Item.Settings settings) 
    {
        super(comparatorOutput, sound, settings);
    }
}
