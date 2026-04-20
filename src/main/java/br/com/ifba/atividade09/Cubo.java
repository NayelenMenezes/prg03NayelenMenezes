/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author mealf
 */
public class Cubo extends FormaTridimensional {
    //atributo
    private double lado;
    
    //construtor
    public Cubo(double lado){
        this.lado = lado;
    }
    
    //get e set
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    //metodos que vieram do forma3d
    @Override
    public double obterArea() {
        //formula do volume = 6 * lado^2
        return 6 * Math.pow(lado, 2);
    }

    @Override
    public double obterVolume() {
        //formula do volume = lado^3
        return Math.pow(lado, 3);
    }
    
    //metodo toString
    @Override
    public String toString() {
        return String.format("Objeto: Cubo | Lado: %.2f", lado);        
    }
}
