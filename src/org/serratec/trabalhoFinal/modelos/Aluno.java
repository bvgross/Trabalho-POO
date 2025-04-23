package org.serratec.trabalhoFinal.modelos;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	private LocalDate dataMatricula;
	private String plano;
	private String personalContratado;
	private String tipo = "Aluno";

	public Aluno(String nome, String cpf, String senha, LocalDate dataMatricula, String plano) {
		super(nome, cpf, senha);
		this.dataMatricula = dataMatricula;
		this.plano = plano;
	}

    public String getTipo() {
        return tipo;
    }

    @Override
	public String getPlano() {
		return plano;
	}

    @Override
    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

	@Override
	public void exibirDados() {
		System.out.println("Nome: " + getNome() +
				" | CPF: " + getCpf() +
				" | Data da matrícula: " + dataMatricula +
				" | Plano: " + plano +
				" | Personal Contratado: " + personalContratado);

	}

	@Override
	public void exibirDadosPessoais() {
		System.out.println("Nome: " + getNome() +
				" | CPF: " + getCpf() +
				" | Data da matrícula: " + dataMatricula +
				" | Plano: " + plano );

	}

    @Override
	public String getPersonalContratado() {
		return personalContratado;
	}

    @Override
	public void setPersonalContratado(String personalContratado) {
		this.personalContratado = personalContratado;
	}

}
