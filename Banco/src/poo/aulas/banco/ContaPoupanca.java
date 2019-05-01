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
public class ContaPoupanca extends Conta{
    protected static int qtdContasPoupanca=0;

    public ContaPoupanca(){
        this.limite = 0;
        this.numero = 0;
        this.saldo = 0;
        this.titular = new Cliente();
        Conta.qtdContas++;
        ContaPoupanca.qtdContasPoupanca++;
    }

    public ContaPoupanca(Cliente cliente, double limite, int numero){
        this.limite = limite;
        this.numero = numero;
        this.saldo = 0;
        this.titular = cliente;
        Conta.qtdContas++;
        ContaPoupanca.qtdContas++;
    }
            
    public static int getTotalContaPoupanca(){
        return ContaPoupanca.qtdContasPoupanca;
    } 
    
    @Override
    public boolean saca (double valor) throws SaldoInsuficienteException, ValorInvalidoException  {
        if(valor <= 0){
            throw new ValorInvalidoException("Insira um valor maior que zero para efetuar o saque.", valor);
        }
        else if(saldo - valor < 0 && this.limite > saldo - valor){
            throw new SaldoInsuficienteException("Saldo Insuficiente, tente um valor menor.");
        }
        else {
            saldo -= valor;
            return true;
        }
    }
    
    @Override    
    public boolean deposita (double valor) throws Exception {
        if(valor < 0){
            throw new Exception("Insira um valor maior que zero para efetuar o deposito.");
        }
        else{
            this.saldo += valor;
            return true;        
        }

    }
        
    @Override
    public boolean transfere (Conta destino, double valor) throws SaldoInsuficienteException, Exception {
        this.saca(valor);
        destino.deposita(valor);
        return true;
    }

    @Override
    public void atualiza(double taxa){
        this.saldo *= 1 - (taxa*3);
    }

    
}
