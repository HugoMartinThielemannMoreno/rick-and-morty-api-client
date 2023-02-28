package com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration.jackson;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Collection;

/**
 * The type Empty collection serializer.
 *
 * @author HugoMartinThielemannMoreno
 */
public class EmptyCollectionSerializer extends StdSerializer<Collection> {
    /**
     * The constant INSTANCE.
     */
    public static final EmptyCollectionSerializer INSTANCE = new EmptyCollectionSerializer();

    /**
     * Instantiates a new Empty collection serializer.
     */
    protected EmptyCollectionSerializer() {
        super(Collection.class);
    }

    @Override
    public void serialize(Collection collection, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeEndArray();
    }
}
