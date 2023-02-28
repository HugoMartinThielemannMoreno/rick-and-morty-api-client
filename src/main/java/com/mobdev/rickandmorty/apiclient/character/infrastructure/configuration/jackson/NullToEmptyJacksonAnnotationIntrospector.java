package com.mobdev.rickandmorty.apiclient.character.infrastructure.configuration.jackson;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.util.Collection;

/**
 * The type Null to empty jackson annotation introspector.
 *
 * @author HugoMartinThielemannMoreno
 */
public class NullToEmptyJacksonAnnotationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public Object findNullSerializer(Annotated a) {
        if (Collection.class.isAssignableFrom(a.getRawType())) {
            return EmptyCollectionSerializer.INSTANCE;
        }
        if (String.class.isAssignableFrom(a.getRawType())) {
            return EmptyStringSerializer.INSTANCE;
        }
        return super.findNullSerializer(a);
    }
}
