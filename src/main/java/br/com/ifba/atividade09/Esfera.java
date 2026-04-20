/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author mealf
 */
public class Esfera extends FormaTridimensional {
    //atributo
    private double raio;
    
    //Construtor
    public Esfera(double raio){
        this.raio = raio;
    }
    
    //get e set
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
    //metodos que vieram do forma3d
    @Override
    public double obterArea() {
        //formula: 4 * PI * raio^2
        return 4 * Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double obterVolume() {
        //formula: (4/3) * PI * raio^3
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
    }
    
    //metodo toString
    @Override
    public String toString() {
        return String.format("Objeto: Esfera | Raio: %.2f", raio);
    }
    
}
