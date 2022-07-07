package com.capgemini.pcshop.data;

import com.capgemini.pcshop.exception.PartsMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class PartsMapper {

    private ObjectMapper objectMapper;

    public PartsMapper() {
        SimpleModule simpleModule = new SimpleModule();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public String toCollectionDto(Collection<Part> parts) throws PartsMappingException {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("parts", new ArrayList<>(parts));
            return jsonObject.toString();
        } catch (JSONException e) {
            throw new PartsMappingException("Parts mapping exception", e);
        }
    }
}
