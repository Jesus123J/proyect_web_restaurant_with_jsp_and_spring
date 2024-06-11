/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.utp.management_web_application.config;

/**
 *
 * @author Jesus Gutierrez
 */
public enum ConfigConnection {

    BASE_URL("http://localhost:9091");

    private final String nombre;

    private ConfigConnection(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
}
