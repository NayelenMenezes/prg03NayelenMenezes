/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade06.classe;

public class ContaBanco {
    //atributos da classe ContaBanco
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
   
    //abre conta, define se é corrente ou poupança e dá um bônus
    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if ("cc".equals(t)) {
            this.setSaldo(50);
        } else if ("cp".equals(t)) {
            this.setSaldo(150);
        }
    }
    
    //fecha a conta, mas só se o saldo estiver zerado
    public void fecharConta(){
        if (this.getSaldo() > 0){
            System.out.println("Conta não pode ser fechada porque ainda tem dinheiro");
        } else if (this.getSaldo() < 0){
            System.out.println("Conta não pode ser fechada porque tem débito");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso");
        }
    }
    
    //deposita só se a conta estiver aberta
    public void depositar(float valor){
        if (this.getStatus()){
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Deposito realizado");
        } else {
            System.out.println("Impossível realizar deposito");
        }
    }
    
    //saca dinheiro se o saldo na conta for suficiente
    public void sacar(float valor){
        if (this.getStatus()){
            if (this.getSaldo() >= valor){
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado");
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossivel realizar saque");
        }
    }
     
    //cobra uma taxa mensal
    public void pagarMensal(){
        int v = 0;
        if ("cc".equals(this.getTipo())) {
            v = 12;
        } else if ("cp".equals(this.getTipo())){
            v = 20;
        }
        if (this.getStatus()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga!");
        } else {
            System.out.println("Impossivel pagar mensalidade");
        }
    }
    
    //método construtor, define os valores iniciais da conta
    public void ContaBanco(){
        this.saldo = 0;
        this.status = false;
    }
    
    //métodos getter e setter de todos os atributos
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
     
}
