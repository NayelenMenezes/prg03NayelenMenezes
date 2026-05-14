/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author mealf
 */
public class StringUtil {
    // Verifica se a string é nula ou composta apenas por espaços
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Verifica se a string contém apenas números (útil para quantidade)
    public static boolean isNumeric(String str) {
        if (str == null) return false;
        return str.matches("\\d+");
    }
}
