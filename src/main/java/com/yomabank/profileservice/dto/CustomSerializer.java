package com.yomabank.profileservice.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object o, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        this.serializeWithType(o,jgen,serializerProvider);
        jgen.writeEndObject();
    }
}
