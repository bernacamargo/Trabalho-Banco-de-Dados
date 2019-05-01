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
public class Presidente extends Gerente {

    public Presidente(String nome, String cargo, String cpf, double salario) {
        super(nome, cargo, cpf, salario);
    }
    
    @Override
    public double getBonificacao(){
        return super.getBonificacao() + 1000;
    }
}
