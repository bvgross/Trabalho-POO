package org.serratec.trabalhoFinal.modelos;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	private LocalDate dataMatricula;
	private String planos;
	private String personalContratado;
	
	

	public Aluno(String nome, String cpf, String senha, LocalDate dataMatricula, String planos,
			String personalContratado) {
		super(nome, cpf, senha);
		this.dataMatricula = dataMatricula;
		this.planos = planos;
		this.personalContratado = personalContratado;
	}



	@Override
	public void exibirDados() {
		System.out.println("Nome aluno: " + getNome() +
				" | Data da matrícula: " + dataMatricula +
				" | Planos: " + planos +
				" | Personal Contratado: " + personalContratado);
		
	}
	
}
