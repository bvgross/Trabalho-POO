package org.serratec.trabalhoFinal.modelos;

public class Funcionario extends Pessoa {
	private Cargo cargo;

public Funcionario(String nome, String cpf, String senha, Cargo cargo) {
	super(nome, cpf, senha);
	this.cargo = cargo;
	}
	
	
}
