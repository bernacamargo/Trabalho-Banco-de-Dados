/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.aulas.banco;

/**
 *
 * @author Bernardo Camargo
 */
public abstract class Conta {
    protected int numero;
    protected double saldo;
    protected double limite;
    protected Cliente titular; // = new Cliente();
    protected static int qtdContas=0;

    public String getTitular() {
        return this.titular.getNome();
    }
 
    public void setTitular(String nome) {
         this.titular.setNome(nome);
    }
    
    public static int getTotalContas(){
        return Conta.qtdContas;
    }

    
    public boolean saca (double valor) throws SaldoInsuficienteException {
        if(saldo - valor < 0 && this.limite > saldo - valor){
            throw new SaldoInsuficienteException("Saldo Insuficiente, tente um valor menor");
        }
        else {
            saldo = saldo - valor;
            return true;
        }
    }
    
    public boolean deposita (double valor) throws Exception {
        saldo = saldo+valor;
        return true;
    }

        
    public boolean transfere (Conta destino, double valor) throws SaldoInsuficienteException, Exception {
        this.saca(valor);
        destino.deposita(valor);
        return true;
    }

   
        
    public void exibeConta(){
        System.out.println("Titular: "+this.titular.getNome());
        System.out.println("Número da conta: "+this.numero);
        System.out.println("Saldo: "+this.saldo);
        System.out.println("Limite: "+this.limite);
    }
    
    public void atualiza(double taxa){
        this.saldo *= (1-taxa);
    }
    
    public double getSaldo(){
        return this.saldo;
    }
}
