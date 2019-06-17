/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author zemljics
 */
public class GsonUTCDateAdapter implements JsonSerializer<Date>,JsonDeserializer<Date>
{
    private final DateFormat dateFormat;

    public GsonUTCDateAdapter()
    {
        //yyyy-MM-dd[[ ]['T']HH:mm[:ss][XXX]]
        //yyyy-MM-dd'T'HH:mm:ss

      dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);      //This is the format I need
      dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));                               //This is the key line which converts the date to UTC which cannot be accessed with the default serializer
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
