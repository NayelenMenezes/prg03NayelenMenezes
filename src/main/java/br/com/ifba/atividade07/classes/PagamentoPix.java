/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.classes;

/**
 *
 * @author mealf
 */
//PagamentoPix implementa a interface Pagamento
public class PagamentoPix implements Pagamento{
    //armazena o valor inicial
    private double valor;
    
    //o construtor inicializa o objeto já recebendo o valor
    public PagamentoPix (double valor){
        this.valor = valor;
    }
    
    //faz o calculo aplicando um cashback de 2% sobre o valor
    @Override
    public double calcularTotal() {
        return this.valor * 0.98;
    }
    
    //exibe o texto e chama o cálculo final
    @Override
    public void imprimirRecibo() {
        System.out.println("RECIBO");
        System.out.println("Valor Final: R$ " + calcularTotal());
    }
    
    //permite que outras classes consultem o valor guardado
    public double getValor() {
        return valor;
    }
    
    //permite alterar o valor do pagamento após o objeto ter sido criado
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
