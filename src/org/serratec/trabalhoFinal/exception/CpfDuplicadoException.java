package org.serratec.trabalhoFinal.exception;

public class CpfDuplicadoException extends Exception{
	public CpfDuplicadoException(String cpf) {
		super("CPF já cadastrado: " + cpf);
	}

}
