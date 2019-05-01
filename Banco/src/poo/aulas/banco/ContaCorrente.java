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
public class ContaCorrente extends Conta implements Tributavel{
    protected static int qtdContasCorrente = 0;
    
    public ContaCorrente(){
        this.limite = 0;
        this.numero = 0;
        this.saldo = 0;
        this.titular = new Cliente();
        Conta.qtdContas++;
        ContaCorrente.qtdContasCorrente++;
    }

    public ContaCorrente(Cliente cliente, double limite, int numero){
        this.limite = limite;
        this.numero = numero;
        this.saldo = 0;
        this.titular = cliente;
        Conta.qtdContas++;
        ContaCorrente.qtdContas++;
    }
    
    public static int getTotalContaCorrente(){
        return ContaCorrente.qtdContasCorrente;
    } 
    
    @Override
    public double calculaTributos(){
        return getSaldo() * 0.01;
    }
    
    @Override
    public boolean saca (double valor) throws SaldoInsuficienteException, ValorInvalidoException  {
        if(valor <= 0){
            throw new ValorInvalidoException("Insira um valor maior que zero para efetuar o saque", valor);
        }
        else if(saldo - valor < 0 && this.limite > saldo - valor){
            throw new SaldoInsuficienteException("Saldo Insuficiente, tente um valor menor");
        }
        else {
            saldo = saldo - valor;
            return true;
        }
    }
    
    @Override    
    public boolean deposita (double valor) throws Exception {
        if(valor < 0){
            throw new Exception("Insira um valor maior que zero para efetuar o deposito");
        }
        else{
            this.saldo += valor;
            this.saldo -= 0.10; //Retira 10 centavos por deposito
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
        this.saldo *= 1 - (taxa*2);
    }

    
}
