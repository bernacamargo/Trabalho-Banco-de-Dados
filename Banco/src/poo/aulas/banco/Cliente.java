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
public class Cliente {
    private String nome;
    private String endereco;
    private final String cpf;
    
    public Cliente() {
        this.nome = "";
        this.endereco = "";
        this.cpf = "";
    }
    
    public Cliente(String nome, String endereco, String cpf){
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
}
