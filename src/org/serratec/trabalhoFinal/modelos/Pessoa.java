package org.serratec.trabalhoFinal.modelos;

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
	
	
}
