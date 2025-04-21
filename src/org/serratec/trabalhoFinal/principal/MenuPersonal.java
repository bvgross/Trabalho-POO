package org.serratec.trabalhoFinal.principal;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Pessoa;

public class MenuPersonal {
	
	public static void menuPersonal(List<Pessoa> pessoas,int i, List<Avaliacao> avaliacoes) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		do {
            String nome = pessoas.get(i).getNome();
            System.out.println("\n========== Bem vindo(a), " + nome + "! ==========");
			System.out.println("""
					Digite a opção desejada: 
					1. Visualizar alunos.
					2. Registrar avaliações dos alunos.
					3. Visualizar lista de avaliações.
					4. Sair.
							""");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1 -> visualizarAlunos(pessoas, i);
			case 2 -> registrarAvaliacao(pessoas, i,avaliacoes);
			case 3 -> visualizarAvaliacoes(pessoas, i,avaliacoes);
			case 4 -> System.out.println("Encerrando aplicação...");
			default -> System.out.println("Opção inválida, digite novamente!");

			}

		} while(opcao != 4);
	}

	private static void visualizarAvaliacoes(List<Pessoa> pessoas,int i, List<Avaliacao> avaliacoes) {
		
		for (Avaliacao avaliacao : avaliacoes) {
			avaliacao.exibirDados();
		}
	}

	private static void registrarAvaliacao(List<Pessoa> pessoas,int i, List<Avaliacao> avaliacoes) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do Aluno: ");
		String nome = sc.nextLine();
		System.out.println("Digite a descrição da avaliação: ");
		String descricao = sc.nextLine();
		avaliacoes.add(new Avaliacao(nome, LocalDate.now(),pessoas.get(i).getNome(), descricao));

	}

	private static void visualizarAlunos(List<Pessoa> pessoas,int i) {
		/*visuAvAlunos*/

	}
}
