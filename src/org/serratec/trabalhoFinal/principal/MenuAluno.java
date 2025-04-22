package org.serratec.trabalhoFinal.principal;

import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Pessoa;

public class MenuAluno {
		
	public static void menuAluno(List<Pessoa> pessoas, int i) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		do {
            String nome = pessoas.get(i).getNome();
            System.out.println("\n========== Bem vindo(a), " + nome + "! ==========");
			System.out.println("""
					Digite a opção desejada: 
					1. Visualizar dados pessoais e plano contratado.
					2. Contratar Personal Trainer.
					3. Visualizar avaliação física.
					4. Sair.
							""");
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1 -> pessoas.get(i).exibirDados(); 
			case 2 -> System.out.println("Personal contratado: ");			
			case 3 -> System.out.println("Avaliação física: ");
			case 4 -> System.out.println("Encerrando aplicação.");
			default -> System.out.println("Opção inválida, digite novamente!");
			}

		}while (opcao !=4);
	}
	
}
