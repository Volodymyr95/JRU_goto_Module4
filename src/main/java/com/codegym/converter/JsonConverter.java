package com.codegym.converter;

import com.codegym.models.Settings;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Converter;

import jakarta.persistence.AttributeConverter;


@Converter(autoApply = true)
public class JsonConverter implements AttributeConverter<Settings, String> {

    private final ObjectMapper MAPPER = new ObjectMapper();


    @Override
    public String convertToDatabaseColumn(Settings attribute) {
        try {
            return MAPPER.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed convert Setting to JSON");
        }
    }

    @Override
    public Settings convertToEntityAttribute(String dbData) {
        try {
            return MAPPER.readValue(dbData, Settings.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert JSON to Setting");
        }
    }
}
