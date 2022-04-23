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
        
        JsonObject jsonObject = JsonHelper.asObject(jsonElement, "loot table");
        if(jsonObject.has("type") && jsonObject.has("pools") && JsonHelper.getString(jsonObject, "type").equals("minecraft:entity"))
        {
            //System.out.println(JsonHelper.getString(jsonObject, "type"));

            com.google.gson.JsonArray poolArray = jsonObject.getAsJsonArray("pools");
            boolean alreadyInjected = false;
            boolean foundCreeperDiscPool = false;

            com.google.gson.JsonArray targetEntries = null;
            com.google.gson.JsonArray targetConditions = null;

            for(int i = 0; i < poolArray.size(); i++)
            {
                com.google.gson.JsonObject focusedPool = (com.google.gson.JsonObject)poolArray.get(i);
                com.google.gson.JsonArray daEntries = focusedPool.getAsJsonArray("entries");
                com.google.gson.JsonArray daConditions = focusedPool.getAsJsonArray("conditions");
                for(int j = 0; j < daEntries.size(); j++)
                {
                    JsonObject entry = (JsonObject)daEntries.get(j);
                    JsonElement daName = entry.get("name");
                    if(daName != null && daName.getAsString().equals("minecraft:creeper_drop_music_discs"))
                    {
                        System.out.println("Got it!");
                        targetEntries = daEntries;
                        targetConditions = daConditions;
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
                //adds taco and annies discs to default drops
                JsonObject defaultDiscEntry = new JsonObject();
                defaultDiscEntry.addProperty("type", "minecraft:tag");
                defaultDiscEntry.addProperty("name", "modid:creeper_drop_mod_discs");
                defaultDiscEntry.addProperty("expand", true);
                targetEntries.add((JsonElement)defaultDiscEntry);

                System.out.println("Before");
                System.out.println(targetConditions.size());

                //forms condition for creeper being named dream
                JsonObject dreamCondition = inverseNameCondition("Dream");
                
                //forms condition for creeper being named clayton ray huff
                JsonObject claytonCondition = inverseNameCondition("Clayton Ray Huff");

                //adds the inverted dream condition to default disc pool
                JsonObject defaultDiscCondition = new JsonObject();
                defaultDiscCondition.addProperty("condition", "minecraft:inverted");
                defaultDiscCondition.add("term", dreamCondition);
                targetConditions.add(defaultDiscCondition);

                //adds the inverted clayton condition to default disc pool
                defaultDiscCondition = new JsonObject();
                defaultDiscCondition.addProperty("condition", "minecraft:inverted");
                defaultDiscCondition.add("term", claytonCondition);
                targetConditions.add(defaultDiscCondition);

                System.out.println("After");
                System.out.println(targetConditions.size());

                LootTable.Serializer huh = new LootTable.Serializer();
                info.setReturnValue(huh.deserialize(jsonElement, type, jsonDeserializationContext));
            }
        }
    }

    private JsonObject inverseNameCondition(String name)
    {
        JsonObject output = new JsonObject();
        JsonObject predicate;

        output.addProperty("condition", "minecraft:entity_properties");
        predicate = new JsonObject();
        predicate.addProperty("nbt", "{CustomName:'{\"text\":\"" + name + "\"}'}");
        output.add("predicate", predicate);
        output.addProperty("entity", "this");

        return output;
    }
}
