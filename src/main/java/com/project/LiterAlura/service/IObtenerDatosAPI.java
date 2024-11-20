package com.project.LiterAlura.service;

public interface IObtenerDatosAPI {

    <T> T obtenerDatos(String json, Class<T> clase);
}
