package org.serratec.trabalhoFinal.modelos;

public class Plano {
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
	
	
}
