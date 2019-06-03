package com.example.netflix_clone;

import com.example.netflix_clone.model.Currency;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyDeSerializer implements JsonDeserializer<List<Currency>> {
    @Override
    public List<Currency> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        /*JsonObject jsonObject = json.getAsJsonObject().getAsJsonObject("Currency");
        List<Currency> list = new ArrayList<>();
        for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            List<NestedObject2> nestedObject2List = new ArrayList<>();
            //here deserialize each NestedObject2 and put it in the list
            list.add(new NestedObject1(entry.getKey(), nestedObject2List));
        }
        return list;*/
        return null;
    }
}
