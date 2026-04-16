/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.classes;

/**
 *
 * @author mealf
 */

//PagamentoCartao implementa a interface Pagamento
public class PagamentoCartao implements Pagamento {
    //armazena o valor inicial
    private double valor;
    
    //o construtor inicializa o objeto já recebendo o valor
    public PagamentoCartao(double valor){
        this.valor = valor;
    }
    
    //faz o calculo aplicando uma taxa de 5% sobre o valor
    @Override
    public double calcularTotal() {
        return this.valor * 1.05;
    }
    
    //exibe o texto e chama o cálculo final
    @Override
    public void imprimirRecibo() {
        System.out.println("RECIBO");
        System.out.println("Valor final: R$ " + calcularTotal());
    }
    
    //permite que outras classes consultem o valor guardado
    public double getValorCartao() {
        return valor;
    }
    
    //permite alterar o valor do pagamento após o objeto ter sido criado
    public void setValorConta(double valor) {
        this.valor = valor;
    }
}
