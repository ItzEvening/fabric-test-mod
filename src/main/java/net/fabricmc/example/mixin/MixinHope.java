package net.fabricmc.example.mixin;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.loot.LootTable;
import net.minecraft.util.JsonHelper;

@Mixin(LootTable.Serializer.class)
public class MixinHope {

    @Inject(at = @At("HEAD"), method = "deserialize", cancellable = true)
    private void injectLootTable(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext, CallbackInfoReturnable<LootTable> info)
    {
        com.google.gson.JsonArray targetEntries = null;
        
        JsonObject jsonObject = JsonHelper.asObject(jsonElement, "loot table");
        if(jsonObject.has("type") && jsonObject.has("pools") && JsonHelper.getString(jsonObject, "type").equals("minecraft:entity"))
        {
            //System.out.println(JsonHelper.getString(jsonObject, "type"));

            com.google.gson.JsonArray poolArray = jsonObject.getAsJsonArray("pools");
            boolean alreadyInjected = false;
            boolean foundCreeperDiscPool = false;

            for(int i = 0; i < poolArray.size(); i++)
            {
                com.google.gson.JsonArray daEntries = ((com.google.gson.JsonObject)poolArray.get(i)).getAsJsonArray("entries");
                for(int j = 0; j < daEntries.size(); j++)
                {
                    JsonObject entry = (JsonObject)daEntries.get(j);
                    JsonElement daName = entry.get("name");
                    if(daName != null && daName.getAsString().equals("minecraft:creeper_drop_music_discs"))
                    {
                        System.out.println("Got it!");
                        targetEntries = daEntries;
                        foundCreeperDiscPool = true;
                    }
                    else if(daName != null && daName.getAsString().equals("modid:creeper_drop_mod_discs"))
                    {
                        foundCreeperDiscPool = true;
                        alreadyInjected = true;
                        System.out.println("Bip");
                    }
                }
            }

            if(!alreadyInjected && foundCreeperDiscPool)
            {
                JsonObject newEntry = new JsonObject();
                newEntry.addProperty("type", "minecraft:tag");
                newEntry.addProperty("name", "modid:creeper_drop_mod_discs");
                newEntry.addProperty("expand", true);

                targetEntries.add((JsonElement)newEntry);

                LootTable.Serializer huh = new LootTable.Serializer();
                info.setReturnValue(huh.deserialize(jsonElement, type, jsonDeserializationContext));
            }
        }
    }
}
