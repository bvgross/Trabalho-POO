package org.serratec.trabalhoFinal.modelos;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	private LocalDate dataMatricula;
	private Plano plano;
	private String personalContratado;
	
	public Aluno(String nome, String cpf, String senha, LocalDate dataMatricula, Plano plano,
			String personalContratado) {
		super(nome, cpf, senha);
		this.dataMatricula = dataMatricula;
		this.plano = plano;
		this.personalContratado = personalContratado;
	}

	@Override
	public void exibirDados() {
		System.out.println("Exiba as informações: ");
		
	}
	
}
