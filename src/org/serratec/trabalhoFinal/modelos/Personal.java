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
	
		
	}

		
	
}
