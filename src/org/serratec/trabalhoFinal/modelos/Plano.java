package org.serratec.trabalhoFinal.modelos;

import java.util.List;

public class Plano implements GerarRelatorio{
	private String nomePlano;
	private Frequencia frequencia;
	private Periodicidade periodicidade;	
	private double valor;
	private String descricaoPlano;


	public Plano(String nomePlano, Frequencia frequencia, Periodicidade periodicidade, double valor,
			String descricaoPlano) {

		this.nomePlano = nomePlano;
		this.frequencia = frequencia;
		this.periodicidade = periodicidade;
		this.valor = valor;
		this.descricaoPlano = descricaoPlano;
	}


	public void exibirDados() {
		System.out.println("Plano: "  + nomePlano + "\nDescrição do plano contratado:  " + descricaoPlano +
				"\nValor: R$ " + valor + "\nFrquência: " + frequencia + "\nVálidade do plano: " + periodicidade + "\n-------------------");

	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricaoPlano() {
		return descricaoPlano;
	}

	public String getNomePlano() {
		return nomePlano;
	}


	@Override
	public void gerar(List<Pessoa>pessoas, List<Plano>planos) {
		for (Plano plano : planos) {
			plano.exibirDados();
		int contador = 0;
			for(Pessoa pessoa : pessoas) {
				if(pessoa.getPlano().equalsIgnoreCase(getNomePlano())) {
					pessoa.getNome();
					contador++;
				}
			}
			System.out.println("Total de pessoas inlcuídas no plano: " + contador);
		}		
	}


}
