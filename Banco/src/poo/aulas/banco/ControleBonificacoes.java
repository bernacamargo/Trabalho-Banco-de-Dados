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
public class ControleBonificacoes {
    private double totalBonificacoes = 0;
    
    public void registra(Funcionario f){
        this.totalBonificacoes += f.getBonificacao();
    }
    
    public double getTotalBonificacoes(){
        return this.totalBonificacoes;
    }
}
