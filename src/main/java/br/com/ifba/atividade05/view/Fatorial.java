/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade05.view;
   
//define uma classe chamada "Fatorial"
public class Fatorial {
    private int valor;
    private int fatorial;
    private String formula;
    
    //define o calor e já realiza o cálculo
    public void setValor(int n){
        this.valor = n;
        int f = 1;
        String s = "";
        
        //caso especial se o numero for 0
        if (n == 0){
            f = 1;
            s = "0! = ";
        //se não for 0, passa por uma estrutura de repetição
        } else {
            for(int i = n; i > 1; i--){
                f *= i;
                s += i + " x ";
            }
            s += "1 = ";
        }
        
        this.fatorial = f;
        this.formula = s; 
    }
    
    //retorna resultado final
    public int getFatorial(){
        return this.fatorial;
    }
    
    //retorna o desenho da formula
    public String getFormula(){
        return this.formula;
    }
}
