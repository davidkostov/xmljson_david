package com.clouway.translators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class JsonTranslator {

    private ObjectMapper mapper;

    public JsonTranslator() {
        mapper = new ObjectMapper();
    }

    public void toJsonFile(Object obj, String fileName) throws IOException {
        mapper.writeValue(new File(fileName), obj);
    }

    public String toJsonString(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

    public <T> T toObjectFromFile(File file, Class<T> type) throws IOException {
        return mapper.readValue(file, type);
    }

    public <T> T toObjectFromFile(File file, TypeReference typeRef) throws IOException {
        return mapper.readValue(file, typeRef);
    }

    public <T> T toObjectFromString(String jsonString, Class<T> type) throws IOException {
        return mapper.readValue(jsonString, type);
    }

    public <T> T toObjectFromString(String jsonString, TypeReference typeRef) throws IOException {
        return mapper.readValue(jsonString, typeRef);
    }

}
