package com.project.LiterAlura.service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;

public class API {

    
    public String obtenerDatos(String url){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();
        
        HttpResponse <String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } 
        catch (HttpTimeoutException  error) {
            System.out.println("Error del Servidor: Tiempo de Respuesta Agotado" + response.statusCode());
        } catch (UnknownHostException  error) {
            System.out.println("Error: El recurso no pudo ser encontrado " + response.statusCode());
        } catch (ConnectException  error) {
            System.out.println("Error del Servidor: Error de Conexion " + response.statusCode());
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }  catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } 

        String json = response.body();
        return json;

    }

}
