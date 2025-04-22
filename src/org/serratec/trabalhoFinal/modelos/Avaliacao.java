package org.serratec.trabalhoFinal.modelos;

import java.time.LocalDate;

public class Avaliacao  {
	private String aluno;
	private LocalDate data;
	private String personalTrainer;
	private String indicacao;
	private double peso;
	private double imc;
	private double altura;


	public Avaliacao(String aluno, LocalDate data, String personalTrainer, String indicacao, double peso,
			double altura) {
		this.aluno = aluno;
		this.data = data;
		this.personalTrainer = personalTrainer;
		this.indicacao = indicacao;
		this.peso = peso;
		this.altura = altura;
		this.imc = peso / (altura * altura);
	}

	public void exibirDados(){
		System.out.println("Avaliação:"
				+ "  | Aluno: " + aluno +
				" | Data: " + data + 
				" | Personal trainer: " + personalTrainer +
				" | Peso : " + peso +
				" | Altura : " + altura +
				" | IMC:  " + imc +
				" | Indicação: " + indicacao);
			}

	public String getAluno() {
		return aluno;
	}


}
