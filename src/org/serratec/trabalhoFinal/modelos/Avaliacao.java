package org.serratec.trabalhoFinal.modelos;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Avaliacao implements GerarRelatorio {
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
		DecimalFormat df = new DecimalFormat ("#.#");
		System.out.println("Avaliação de :" + aluno +
				  " | Data: " + data + 
				  "\nPersonal trainer: " + personalTrainer +
				  "\nPeso : " + peso +
				  " | Altura : " + altura +
				  " | IMC:  " + df.format(imc) +
				  "\nIndicação : " + indicacao);
			}

	public String getAluno() {
		return aluno;
	}

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public LocalDate getData() {
        return data;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

	@Override
	public void exibir() {
		
		
	}
}
