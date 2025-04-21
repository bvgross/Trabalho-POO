package org.serratec.trabalhoFinal.modelos;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	private LocalDate dataMatricula;
	private String plano;
	private String personalContratado;
	
	

	public Aluno(String nome, String cpf, String senha, LocalDate dataMatricula, String plano,
			String personalContratado) {
		super(nome, cpf, senha);
		this.dataMatricula = dataMatricula;
		this.plano = plano;
		this.personalContratado = personalContratado;
	}



	@Override
	public void exibirDados() {
		System.out.println("Nome: " + getNome() +
				" | Data da matrícula: " + dataMatricula +
				" | Plano: " + plano +
				" | Personal Contratado: " + personalContratado);
		
	}
	
}
