package com.project.LiterAlura.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObtenerDatosAPI implements IObtenerDatosAPI {
    
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {

        try {
           return objectMapper.readValue(json, clase);

        } catch (JsonParseException e) {
            System.out.println("Error de Serializacion: La respuesta de la API no llego en formato json");
            return null;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e); 
        }
    }

}
