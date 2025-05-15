package com.example.projet.util;

import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileManager {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                    return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
                }
            })
            .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                @Override
                public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext context) {
                    return new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
                }
            })
            .setPrettyPrinting()
            .create();

    public static <T> T charger(String chemin, Type type) {
        try (Reader reader = new FileReader(chemin)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> void sauvegarder(T data, String chemin) {
        try (Writer writer = new FileWriter(chemin)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
