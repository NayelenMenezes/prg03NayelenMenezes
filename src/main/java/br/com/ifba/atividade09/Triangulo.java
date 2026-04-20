/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author mealf
 */
public class Triangulo extends FormaBidimensional {
    //atributo
    private double base;
    private double altura;
    
    //construtor
    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }
    
    //get e set
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //metodo que veio do forma2d
    @Override
    public double obterArea() {
        return (base * altura) / 2;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return String.format("Objeto: Triangulo | Lado da Base: %.2f | Altura: %.2f", base, altura);
    }
}
