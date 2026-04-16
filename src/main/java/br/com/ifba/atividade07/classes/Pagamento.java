/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.atividade07.classes;

/**
 *
 * @author mealf
 */

public interface Pagamento {
    //Define como o cálculo será feito
    public double calcularTotal();
    //Define a ação de saída/impressão
    public void imprimirRecibo();
}
