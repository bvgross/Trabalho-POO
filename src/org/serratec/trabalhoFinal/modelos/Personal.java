package org.serratec.trabalhoFinal.modelos;

public class Personal extends Pessoa {
	private String especialidade;
	private String cref;
	private String tipo;
	
	public Personal(String nome, String cpf, String senha, String especialidade, String cref) {
		super(nome, cpf, senha);
		this.especialidade = especialidade;
		this.cref = cref;
		this.tipo = "Personal";
	}

	@Override
	public void exibirDados() {
	System.out.println("Nome: " + getNome() +
			 " | CREF: " + cref +
			 " | Especialidade: " + especialidade);
		
	}

    @Override
	public String getEspecialidade() {
		return especialidade;
	}

    @Override
	public String getCref() {
		return cref;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
		
	}

	
	}




	
