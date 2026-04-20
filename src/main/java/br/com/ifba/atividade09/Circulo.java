/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author mealf
 */
public class Circulo extends FormaBidimensional {
    //atributo
    private double raio;
    
    //construtor
    public Circulo(double raio) {
        this.raio = raio;
    }
    
    //get e set
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    //metodo que veio do forma2d
    @Override
    public double obterArea() {
        return Math.PI * Math.pow(raio, 2);
    }
    
    //metodo toSting
    @Override
    public String toString() {
        return String.format("Circulo de raio %.2f", raio);
    }
}
