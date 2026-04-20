/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author mealf
 */
public class Piramide extends FormaTridimensional{
    //atributos
    private double ladoBase;
    private double altura;
    
    //construtor
    public Piramide(double ladoBase, double altura){
        this.ladoBase = ladoBase;
        this.altura = altura;
    }
    
    //get e set
    public double getLadoBase() {
        return ladoBase;
    }

    public void setLadoBase(double ladoBase) {
        this.ladoBase = ladoBase;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //metodos que vieram do forma3d
    @Override
    public double obterArea() {
        //area da base (lado * lado)
        double areaBase = Math.pow(ladoBase, 2);
        
        //area lateral (4 triangulos). 
        //primeiro calcula a altura do triangulo lateral (apotema) usando pitagoras
        double apotema = Math.sqrt(Math.pow(altura, 2) + Math.pow(ladoBase / 2, 2));
        double areaLateral = 2 * ladoBase * apotema;
        
        return areaBase + areaLateral;
    }

    @Override
    public double obterVolume() {
        //formula: (area da base * altura) / 3
        return (Math.pow(ladoBase, 2) * altura) / 3.0;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return String.format("Objeto: Piramide | Lado da Base: %.2f | Altura: %.2f", ladoBase, altura);
    }
   
}
