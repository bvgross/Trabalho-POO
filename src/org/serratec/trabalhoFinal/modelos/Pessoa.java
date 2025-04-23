package org.serratec.trabalhoFinal.modelos;

import java.time.LocalDate;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String senha;

	public Pessoa(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

	public abstract void exibirDados();

	public void exibirDadosPessoais() {

	}

	public String getPersonalContratado() {
		return null;
	}

	public  void setPersonalContratado(String nomePersonalEscolhido) {};

	public LocalDate getDataMatricula() {
		return null;
	}


	public String getPlano() {
		return null;
	}
	
	public String getEspecialidade() {
		return null;
	}

	public String getCref() {
		return null;
	}
	public Cargo getCargo() {
		return null;
	}

	public abstract String getTipo();
}
