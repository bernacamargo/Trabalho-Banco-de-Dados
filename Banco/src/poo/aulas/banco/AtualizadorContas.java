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
public class AtualizadorContas {
    private final double taxa;
    private double saldoTotal = 0;
    
    public AtualizadorContas(double taxa){
        this.taxa = taxa;
    }
    
    public void roda(Conta c){
        System.out.println("Saldo anterior: "+c.getSaldo());
        c.atualiza(taxa);
        this.saldoTotal += c.getSaldo();
        System.out.println("Saldo final: "+this.saldoTotal);
    }
    
    public double getSaldoTotal(){
        return this.saldoTotal;
    }
    
    
    
    
}
