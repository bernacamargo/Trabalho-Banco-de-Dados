/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poo.aulas.utils;

import poo.aulas.banco.*;

/**
 *
 * @author Bernardo Camargo
 */

public class BancoPrincipal {
    
    public static void main(String[] args) throws Exception {
        
        // Bancos
        Banco b = new Banco("Banco do Brasil", 30);
        
        // Clientes
        Cliente c1 = new Cliente("Jimi Hendrix", "Rua y", "99999999999");
        Cliente c2 = new Cliente("Led Zeppelin","Rua x", "1111111111");
        Cliente c3 = new Cliente("Steve Jobs", "Rua z", "123456789");
        
        // Contas Correntes
        ContaCorrente cc1 = new ContaCorrente(c1, 1000, 52355);
        ContaCorrente cc2 = new ContaCorrente(c2, 300, 848543);
        ContaCorrente cc3 = new ContaCorrente(c3, 500000, 545775);
        ContaCorrente cc4 = new ContaCorrente(c3, 50, 312655);

        // Contas Poupança
        ContaPoupanca cp1 = new ContaPoupanca(c1, 300, 312657);
        ContaPoupanca cp2 = new ContaPoupanca(c2, 300, 312657);
        ContaPoupanca cp3 = new ContaPoupanca(c3, 1000000, 312655);

        // Adiciona contas ao banco
        b.addContaCorrente(cc1);        
        b.addContaCorrente(cc2);
        b.addContaCorrente(cc3);
        
        b.addContaPoupanca(cp1);
        b.addContaPoupanca(cp2);
        b.addContaPoupanca(cp3);

        // Tenta realizar um depósito e caso seja um valor invalido chama o catch() 
        // finalizando o programa com uma mensagem amigável ao usuario
        try{
            cc1.deposita(100);            
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("========\nDeposito de R$100,00 para " + cc1.getTitular()+ " realizado com sucesso!\n========\n");
        }

        // Exibe dados conta cc1
        System.out.println("===============\nExibir conta\n===============");
        cc1.exibeConta();
        
        // Tenta realizar um saque e caso seja um valor invalido ou o saque seja maior que o saldo chama o catch() 
        // finalizando o programa com uma mensagem amigável ao usuario        
        try{
            cc1.saca(50);
            //cc1.saca(-50); 
            //Valor negativo para testes...
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("\n\nSaque de R$50,00 realizado com sucesso!\n");
        }
        
        // Exibe todas as contas de um banco.
        System.out.println("\n======================\nExibir todas as contas\n======================");
        
        b.visualizarContas();
        
        System.out.println("\n===================================\nBuscar conta cc1 no Banco do Brasil\n===================================");
        
        if(b.buscaConta(cc1)){
            System.out.println("Conta encontrada\n");
        }
        else {
            System.out.println("Conta não existe no "+b.getNome()+"\n");
        }
        
        System.out.println("\n===================================\nBuscar conta cc4 no Banco do Brasil\n===================================");
        
        // Busca pela conta cc4 no banco
        if(b.buscaConta(cc4)){
            System.out.println("Conta encontrada");
        }
        else {
            System.out.println("Conta não existe no "+b.getNome());
        }
        
        System.out.println("\n=====================\nAtualizador de contas\n=====================");

        // Atualiza o saldo da conta de acordo com a taxa passada
        AtualizadorContas ac = new AtualizadorContas(0.01);

        ac.roda(cc1);
        
        System.out.println("\n=====================\nBonificação\n=====================");
        
        // Exibe a bonificação de um gerente
        Gerente gerente = new Gerente("Bernardo Camargo", "Gerente", "45546826843", 14500);
        System.out.println("Nome: " + gerente.getNome() + "\nCargo: "+gerente.getCargo()+"\nSalario: R$" + gerente.getSalario());
        
        System.out.println("Bonificação do Gerente " + gerente.getNome() + " é de R$" + gerente.getBonificacao());
    }
}
