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
public class Banco {
    private final String nome;
    private final ContaCorrente contasCorrente[];
    private final ContaPoupanca contasPoupanca[];
    private final int ncontas;
    private int qtdContasCorrente=0;
    private int qtdContasPoupanca=0;
    
    
    public Banco (String nome, int ncontas) {
        this.nome = nome;
        this.contasCorrente = new ContaCorrente[ncontas];
        this.contasPoupanca = new ContaPoupanca[ncontas];
        this.ncontas = ncontas;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void addContaCorrente(ContaCorrente conta){
        if(this.qtdContasCorrente <= this.ncontas){
            this.contasCorrente[this.qtdContasCorrente] = conta;
            this.qtdContasCorrente++;            
        }
        else{
            System.out.println("Número de contas do banco "+this.nome+" excedido.");
        }
    }
    
    public void addContaPoupanca(ContaPoupanca conta){
        if(this.qtdContasPoupanca <= this.ncontas){
            this.contasPoupanca[this.qtdContasPoupanca] = conta;
            this.qtdContasPoupanca++;            
        }
        else{
            System.out.println("Número de contas do banco "+this.nome+" excedido.");
        }
    }
    
    public boolean buscaConta(Conta c){
        for(int i=0; i < this.qtdContasCorrente; i++){
            if(this.contasCorrente[i] == c)
                return true;
        }
        for(int i=0; i < this.qtdContasPoupanca; i++){
            if(this.contasPoupanca[i] == c)
                return true;
        }
        
        return false;
    }
    
    public void visualizarContas(){
        System.out.println("===================================");
        System.out.println(this.nome);
        System.out.println("Número de contas utilizadas: "+ (this.qtdContasCorrente+this.qtdContasPoupanca));
        System.out.println("Número de contas disponíveis: "+(this.ncontas-(this.qtdContasCorrente+this.qtdContasPoupanca)));
        System.out.println("Número de contas disponíveis: "+(this.ncontas-(this.qtdContasCorrente+this.qtdContasPoupanca)));
        System.out.println("Total de Contas Corrente: "+this.qtdContasCorrente);
        System.out.println("Total de Contas Poupança: "+this.qtdContasPoupanca);
        System.out.println("===================================");
        System.out.println("\n");        
        System.out.println("Contas Corrente");
        System.out.println("----------------------------");
        for(int i=0; i < this.qtdContasCorrente; i++){
            this.contasCorrente[i].exibeConta();
            System.out.println("----------------------------");
        }
        System.out.println("\n");        
        System.out.println("Contas Poupança");
        System.out.println("----------------------------");
        for(int i=0; i < this.qtdContasPoupanca; i++){
            this.contasPoupanca[i].exibeConta();
            System.out.println("----------------------------");
        }
        
    }
}
