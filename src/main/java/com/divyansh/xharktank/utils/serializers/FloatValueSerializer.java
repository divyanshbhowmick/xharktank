package com.divyansh.xharktank.utils.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Locale;

public class FloatValueSerializer
        extends JsonSerializer<Float> {

    @Override
    public void serialize(Float value, JsonGenerator generator, SerializerProvider serializers)
            throws IOException {
        generator.writeNumber(String.format(Locale.US, "%.f", value));
    }
}