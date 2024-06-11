/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.management_web_application.config;

/**
 *
 * @author Jesus Gutierrez
 */
public enum PathPermitidos {
    VALOR1("/admin"),
    VALOR2("/manager"),
    VALOR3("/employee");

    private final String valor;

    PathPermitidos(String valor) {
        this.valor = valor;
    }

    public static boolean verificar(String valor) {
        for (PathPermitidos v : PathPermitidos.values()) {
            if (v.valor.equals(valor)) {
                return true;
            }
        }
        return false;
    }
}
