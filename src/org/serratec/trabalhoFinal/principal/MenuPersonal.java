package org.serratec.trabalhoFinal.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Pessoa;

public class MenuPersonal {

	public static void menuPersonal(List<Pessoa> pessoas,int i, List<Avaliacao> avaliacoes) {
		Scanner sc = new Scanner(System.in);
		Pessoa personalAtual = pessoas.get(i);
		int opcao;
		do {
			String nome = personalAtual.getNome();
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
			case 1 -> visualizarAlunos(pessoas, personalAtual);
			case 2 -> registrarAvaliacao(avaliacoes, pessoas, personalAtual);
			case 3 -> visualizarAvaliacoes(avaliacoes, personalAtual);
			case 4 -> System.out.println("Encerrando aplicação...");
			default -> System.out.println("Opção inválida, digite novamente!");

			}

		} while(opcao != 4);
	}

	private static void visualizarAvaliacoes(List<Avaliacao> avaliacoes, Pessoa personalAtual) {
		for (Avaliacao a : avaliacoes) {
			if(a.getPersonalTrainer().equalsIgnoreCase(personalAtual.getNome())){
				a.exibirDados();
			}
		}
	}

	private static void registrarAvaliacao(List<Avaliacao> avaliacoes, List<Pessoa> pessoas, Pessoa personalAtual) {
		Scanner sc = new Scanner(System.in);
		List<Integer> indices = new ArrayList<>();
		int indiceAluno = 0;
		System.out.println("\nAlunos cadastrados:\n-------------------");
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getPersonalContratado() != null &&
					pessoas.get(i).getTipo().equalsIgnoreCase("aluno") &&
					pessoas.get(i).getPersonalContratado().equalsIgnoreCase(personalAtual.getNome())) {
				System.out.print((indiceAluno + 1) + ". ");
				pessoas.get(i).exibirDados();
				indices.add(i);
				indiceAluno++;
			}
		}
		System.out.println("-------------------");
		System.out.println("Nenhum aluno inscrito com você.");
		if (indiceAluno == 0) return;
		System.out.println("Escolha o número do alunp: ");
		int escolhaAluno = sc.nextInt();
		sc.nextLine();
		String nome = pessoas.get(indices.get(escolhaAluno-1)).getNome();
		System.out.println("Digite a altura do Aluno: ");
		double altura = sc.nextDouble();
		sc.nextLine();
		System.out.println("Digite o peso do aluno: ");
		double peso = sc.nextDouble();
		sc.nextLine();
		System.out.println("Digite a indicação para o aluno:  ");
		String indicacao = sc.nextLine();
		avaliacoes.add(new Avaliacao(nome, LocalDate.now(),personalAtual.getNome(), indicacao, peso, altura ));
		Salvar.salvar(avaliacoes);
	}

	private static void visualizarAlunos(List<Pessoa> pessoas, Pessoa personalAtual) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getPersonalContratado() != null) {
                if (pessoa.getTipo().equalsIgnoreCase("Aluno") && pessoa.getPersonalContratado().equalsIgnoreCase(personalAtual.getNome())) {
                    pessoa.exibirDadosPessoais();
                }
            }
        }
    }
}
