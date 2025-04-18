package org.serratec.trabalhoFinal.modelos;

public class Funcionario extends Pessoa {
	private String cargo;

public Funcionario(String nome, String cpf, String senha, String cargo) {
	super(nome, cpf, senha);
	this.cargo = cargo;
	}
	
	
}
