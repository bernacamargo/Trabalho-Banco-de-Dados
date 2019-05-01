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
public class ValorInvalidoException extends RuntimeException {
    private final double valor;
    
    ValorInvalidoException(String message, double valor){
        super(message);
        this.valor = valor;
    }
    
    public double getValor(){
        return this.valor;
    }
}
