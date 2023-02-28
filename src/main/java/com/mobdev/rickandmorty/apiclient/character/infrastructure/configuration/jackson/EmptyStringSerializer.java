package com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * The type Empty string serializer.
 *
 * @author HugoMartinThielemannMoreno
 */
public class EmptyStringSerializer extends StdSerializer<String> {
    /**
     * The constant INSTANCE.
     */
    public static final EmptyStringSerializer INSTANCE = new EmptyStringSerializer();

    /**
     * Instantiates a new Empty string serializer.
     */
    protected EmptyStringSerializer() {
        super(String.class);
    }

    @Override
    public void serialize(String string, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString("");
    }
}