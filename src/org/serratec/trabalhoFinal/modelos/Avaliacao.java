package org.serratec.trabalhoFinal.modelos;

import java.time.LocalDate;

public class Avaliacao  {
	private String aluno;
	private LocalDate data;
	private String personalTrainer;
	private String descricao;

	public Avaliacao(String aluno, LocalDate data, String personalTrainer, String descricao) {
		super();
		this.aluno = aluno;
		this.data = data;
		this.personalTrainer = personalTrainer;
		this.descricao = descricao;
	}


}
