package org.serratec.trabalhoFinal.modelos;

public class Funcionario extends Pessoa {
	private Cargo cargo;
	private String tipo;

public Funcionario(String nome, String cpf, String senha, Cargo cargo) {
	super(nome, cpf, senha);
	this.cargo = cargo;
	}

    @Override
    public Cargo getCargo() {
	    return cargo;
    }

    @Override
    public void exibirDados() {
	    System.out.println("Nome: " + getNome() +
			" | Cargo: " + cargo);
    }

    public String getTipo() {
	    return tipo;
    }

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    
}
