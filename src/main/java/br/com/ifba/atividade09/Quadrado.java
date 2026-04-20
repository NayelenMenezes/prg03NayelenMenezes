/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author mealf
 */
public class Quadrado extends FormaBidimensional {
    //atributo
    private double lado;
    
    //cosntrutor
    public Quadrado(double lado){
        this.lado = lado;
    }
    
    //get e set
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    //metodo que veio do forma2d
    @Override
    public double obterArea() {
        return lado * lado;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return String.format("Quadrado de lado %.2f", lado);
    }
}
