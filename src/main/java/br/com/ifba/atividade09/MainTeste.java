/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.ifba.atividade09;

/**
 *
 * @author mealf
 */
public class MainTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //cria um vetor do tipo Forma
        Forma[] forma = new Forma[6];
        
        //peenche o vetor com objetos de diferentes classes
        forma[0] = new Circulo(6);
        forma[1] = new Quadrado(3);
        forma[2] = new Triangulo(2, 5);
        forma[3] = new Esfera(4);
        forma[4] = new Cubo(7);
        forma[5] = new Piramide(3, 5);
       
        //percorre o vetor
        for(Forma f : forma){
            //mostra a descrição do toString
            System.out.println(f);
            
            //verifica se é bidimensional
            if(f instanceof FormaBidimensional){
                //informa que f é 2d
                FormaBidimensional f2 = (FormaBidimensional) f;
                System.out.println("Area: " + f2.obterArea());
            } 
            //verifica se é tridimensional
            else if (f instanceof FormaTridimensional){
                //informa que f é 3d
                FormaTridimensional f3 = (FormaTridimensional) f;
                System.out.println("Area: " + f3.obterArea());
                System.out.println("Volume: " + f3.obterVolume());
            }
            System.out.println("-----------------");
        }
    }
}
