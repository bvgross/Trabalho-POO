package org.serratec.trabalhoFinal.principal;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Cargo;
import org.serratec.trabalhoFinal.modelos.Funcionario;
import org.serratec.trabalhoFinal.modelos.Pessoa;

public class Menu {
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		
		int opcao = 0;
		
		do {
			System.out.println("===== Academia SerraFit =====");
			System.out.println("CPF:");
			String cpf = sc.nextLine();
			System.out.println("Senha:");
			String senha = sc.nextLine();

			

			System.out.println("""
						Seja bem vindo!

						Digite a opção desejada:
						""");
		} while (opcao == 5);
	}
}
