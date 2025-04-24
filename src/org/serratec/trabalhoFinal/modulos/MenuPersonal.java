package org.serratec.trabalhoFinal.modulos;

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
            LimparTela.Limpar();
			String nome = personalAtual.getNome();
			System.out.println("\n========== Personal Trainer " + nome + "! ==========");
			System.out.println("""
					Digite a opção desejada: 
					1. Visualizar alunos.
					2. Registrar avaliações dos alunos.
					3. Visualizar lista de avaliações.
					4. Visualizar avaliação por período.
					5. Sair.
							""");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1 -> visualizarAlunos(pessoas, personalAtual);
			case 2 -> registrarAvaliacao(avaliacoes, pessoas, personalAtual);
			case 3 -> visualizarAvaliacoes(avaliacoes, personalAtual);
			case 4 -> visualizarAvaliacoesPorPeriodo(avaliacoes, personalAtual);
			case 5 -> {System.out.println("Encerrando aplicação...");
			return; } // retorna para Login
			default -> System.out.println("Opção inválida, digite novamente!");

			}

		} while(opcao != 5);
	}

	private static void visualizarAvaliacoesPorPeriodo(List<Avaliacao> avaliacoes, Pessoa personalAtual) {
		LimparTela.Limpar();
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a data inicial (AAAA-MM-DD): ");
		LocalDate dataInicial = LocalDate.parse(sc.nextLine());
		System.out.println("Digite a data final (AAAA-MM-DD): ");
		LocalDate dataFinal = LocalDate.parse(sc.nextLine());

		System.out.println("\nAvaliações entre " + dataInicial + " e " + dataFinal + ":\n");

		boolean encontrou = false;
		for (Avaliacao a : avaliacoes) {
			if (a.getPersonalTrainer().equalsIgnoreCase(personalAtual.getNome()) &&
					(a.getData().isEqual(dataInicial) || a.getData().isAfter(dataInicial)) &&
					(a.getData().isEqual(dataFinal) || a.getData().isBefore(dataFinal))) {
				a.exibirDados();
				System.out.println();
				encontrou = true;
			}
		}

		if (!encontrou) System.out.println("Nenhuma avaliação encontrada nesse período.");
		System.out.println("\nAperte enter para continuar...");
		sc.nextLine();
	}

	private static void visualizarAvaliacoes(List<Avaliacao> avaliacoes, Pessoa personalAtual) {
        LimparTela.Limpar();
        Scanner sc = new Scanner(System.in);
		for (Avaliacao a : avaliacoes) {
			if(a.getPersonalTrainer().equalsIgnoreCase(personalAtual.getNome())){
				a.exibirDados();
                System.out.println("\n");
			}
		}
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
	}

	private static void registrarAvaliacao(List<Avaliacao> avaliacoes, List<Pessoa> pessoas, Pessoa personalAtual) {
        LimparTela.Limpar();
		Scanner sc = new Scanner(System.in);
        List<Integer> indices = new ArrayList<>();
        int indiceAluno = 0;
        System.out.println("\nAlunos cadastrados:\n-------------------");
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getPersonalContratado() != null &&
                pessoas.get(i).getPersonalContratado().equalsIgnoreCase(personalAtual.getNome()) &&
                pessoas.get(i).getTipo().equalsIgnoreCase("Aluno")) {
                System.out.print((indiceAluno + 1) + ". ");
                pessoas.get(i).exibirDados();
                indices.add(i);
                indiceAluno++;
            }
        }
        int escolhaAluno = 0;
        boolean alunoValido = true;
        do{
            System.out.println("-------------------");
            System.out.println("Escolha o número do aluno: ");
            escolhaAluno = sc.nextInt();
            sc.nextLine();
            if(escolhaAluno < 1 || escolhaAluno > indiceAluno) {
                System.out.println("Aluno inválido, digite novamente!");
                alunoValido = false;
            } else {alunoValido = true;}
        } while (!alunoValido);
        String nomeAlunoEscolhido = pessoas.get(indices.get(escolhaAluno-1)).getNome();

		System.out.println("Digite a altura do Aluno: ");
		double altura = sc.nextDouble();
		sc.nextLine();
		System.out.println("Digite o peso do aluno: ");
		double peso = sc.nextDouble();
		sc.nextLine();
		System.out.println("Digite a indicação para o aluno:  ");
		String indicacao = sc.nextLine();
		avaliacoes.add(new Avaliacao(nomeAlunoEscolhido, LocalDate.now(),personalAtual.getNome(), indicacao, peso, altura ));
		Salvar.salvar(avaliacoes);
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
	}

	private static void visualizarAlunos(List<Pessoa> pessoas, Pessoa personalAtual) {
        LimparTela.Limpar();
        Scanner sc = new Scanner(System.in);
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getPersonalContratado() != null) {
                if (pessoa.getTipo().equalsIgnoreCase("Aluno") && pessoa.getPersonalContratado().equalsIgnoreCase(personalAtual.getNome())) {
                    pessoa.exibirDadosPessoais();
                }
            }
        }
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
    }
}
