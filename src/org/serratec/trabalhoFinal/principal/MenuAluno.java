package org.serratec.trabalhoFinal.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Pessoa;

public class MenuAluno {

	public static void menuAluno(List<Pessoa> pessoas, int i, List<Avaliacao> avaliacoes) {
		Scanner sc = new Scanner(System.in);
		Pessoa alunoAtual = pessoas.get(i);
		int opcao;
		do {
			String nome = alunoAtual.getNome();
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
			case 1 -> alunoAtual.exibirDadosPessoais(); 
			case 2 -> contratarPersonal(pessoas, alunoAtual);			
			case 3 -> exibirAvaliacao(avaliacoes, alunoAtual);
			case 4 -> System.out.println("Encerrando aplicação.");
			default -> System.out.println("Opção inválida, digite novamente!");
			}

		}while (opcao !=4);
	}
	private static void contratarPersonal(List<Pessoa> pessoas, Pessoa alunoAtual) {
		Scanner sc = new Scanner(System.in);
		List<Integer> indices = new ArrayList<>();
		int indicePersonal = 0;
		System.out.println("\nPersonais cadastrados:\n-------------------");
		for (int i1 = 0; i1 < pessoas.size(); i1++) {
			if (pessoas.get(i1).getClass().getSimpleName().equalsIgnoreCase("Personal")) {
				System.out.print((indicePersonal + 1) + ". ");
				pessoas.get(i1).exibirDados();
				indices.add(i1);
				indicePersonal++;
			}
		}
		System.out.println("-------------------");
		System.out.println("Escolha o número do personal: ");
		int escolhaPersonal = sc.nextInt();
		sc.nextLine();
		String nomePersonalEscolhido = pessoas.get(indices.get(escolhaPersonal-1)).getNome();
		alunoAtual.setPersonalContratado( nomePersonalEscolhido );
		System.out.println("Personal contratado: " + nomePersonalEscolhido  );
	}

	private static void exibirAvaliacao(List<Avaliacao> avaliacoes, Pessoa alunoAtual) {
		for (Avaliacao avaliacao : avaliacoes) {
			if(avaliacao.getAluno().equalsIgnoreCase(alunoAtual.getNome())){
				avaliacao.exibirDados();
			}

		}
	}
}
