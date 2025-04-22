package org.serratec.trabalhoFinal.modelos;

public class Personal extends Pessoa {

	private String especialidade;
	private String cref;
	
	public Personal(String nome, String cpf, String senha, String especialidade, String cref) {
		super(nome, cpf, senha);
		this.especialidade = especialidade;
		this.cref = cref;
	}

	@Override
	public void exibirDados() {
	System.out.println("Nome: " + getNome() +
			 " | CREF: " + cref +
			 " | Especialidade: " + especialidade);
		
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getCref() {
		return cref;
	}

		
	
}
