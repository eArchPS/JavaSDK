/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author zemljics
 */
public final class JsonHelper
{
    private static Gson _gson = null;    
    private static ObjectMapper mapper = null;
    
    static 
    {
        mapper = new ObjectMapper();        
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        
        _gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonUTCDateAdapter()).create();
    }
    
    private JsonHelper(){}
            
    private static class GsonUTCDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date>
    {
        private final DateFormat dateFormat;

        public GsonUTCDateAdapter()
        {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        }

        @Override
        public JsonElement serialize(Date t, java.lang.reflect.Type type, JsonSerializationContext jsc)
        {
            return new JsonPrimitive(dateFormat.format(t));
        }

        @Override
        public Date deserialize(JsonElement je, java.lang.reflect.Type type, JsonDeserializationContext jdc) throws JsonParseException
        {
            try
            {
                return dateFormat.parse(je.getAsString());
            }
            catch (java.text.ParseException ex)
            {
                throw new JsonParseException(ex);
            }
        }
    }
    
    public static <T> String ToJson(T aObject) throws Exception
    {
        return mapper.writeValueAsString(aObject);
    }
    
    public static <T> T FromJson(String aJson, Class aClass) throws Exception
    {
        return (T)mapper.readValue(aJson, aClass);
    }
}
