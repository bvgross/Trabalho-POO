package org.serratec.trabalhoFinal.principal;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Frequencia;
import org.serratec.trabalhoFinal.modelos.Periodicidade;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;
import org.serratec.trabalhoFinal.modelos.Plano;

public class MenuFuncionario {

	public static void menuFuncionario(List<Pessoa> pessoas, List<Plano> planos, int i) {
		Scanner sc = new Scanner(System.in);
        Pessoa funcionarioAtual = pessoas.get(i);
		int opcao;
		do {
			String nome = funcionarioAtual.getNome();
			System.out.println("\n========== Bem vindo(a), " + nome + "! ==========");
			System.out.println("""
					Digite a opção desejada:
					1. Cadastrar novo plano.
					2. Cadastrar novo aluno.
					3. Cadastrar novo personal trainer.
					4. Emitir relatórios.
					5. Valor total a receber no mês.
					6. Sair.
							""");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1 -> cadastrarPlano(planos);
			case 2 -> cadastrarAluno(pessoas, planos);
			case 3 -> cadastrarPersonal(pessoas);
			case 4 -> emitirRelatorios(pessoas, planos);
			case 5 -> calcularFaturamentoMensal();
			case 6 -> System.out.println("Encerrando aplicação...");
			default -> System.out.println("Opção inválida, digite novamente!");

			}

		} while (opcao != 6);
	}

	private static void cadastrarPlano(List<Plano> planos){
		Scanner sc = new Scanner(System.in);
		System.out.println("---------- Novo Plano ----------");
		System.out.println("Nome: ");
		String nomePlano = sc.nextLine();

		System.out.print("""
				\nEscolha a frequência semanal do plano:
				1. Semana inteira
				2. Segunda a sexta
				3. Segunda, quarta e sexta
				4. Terça e quinta
				""");
		int escolha = 0;
		Frequencia frequencia = null;

		do { 
			escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
			case 1 -> frequencia = Frequencia.SEMANA_INTEIRA;
			case 2 -> frequencia = Frequencia.SEG_SEXTA;
			case 3 -> frequencia = Frequencia.SEG_QUAR_SEXTA;
			case 4 -> frequencia = Frequencia.TER_QUINTA;
			default -> System.out.println("Opção inválida. Digite novamente. ");
			}
		} while (escolha < 1 || escolha > 4);

		System.out.println("""
				\nEscolha a válidade do plano:
				1. Anual
				2. Semestral
				3. Trimestral
				4. Mensal
				5. Quinzenal
				6. Semanal
				""");
		int periodo = 0;
		Periodicidade periodicidade = null;

		do {
			periodo = sc.nextInt();
			sc.nextLine();

			switch (periodo) {
			case 1 -> periodicidade = Periodicidade.ANUAL;
			case 2 -> periodicidade = Periodicidade.SEMESTRAL;
			case 3 -> periodicidade = Periodicidade.TRIMESTRAL;
			case 4 -> periodicidade = Periodicidade.MENSAL;
			case 5 -> periodicidade = Periodicidade.QUINZENAL;
			case 6 -> periodicidade = Periodicidade.SEMANAL;
			default -> System.out.println("Opção inválida. Digite novamente. ");

			}


		}while (periodo < 1 || periodo > 6);

		System.out.println("\nValor do plano: R$ ");
		double valor = sc.nextDouble();
		sc.nextLine();

		System.out.println("\nDescrição do plano: ");
		String descricao = sc.nextLine();

		planos.add(new Plano(nomePlano, frequencia, periodicidade, valor, descricao));
		System.out.println("\nPLANO CADASTRADO.");
		sc.nextLine();
        Salvar.salvar(planos);
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
	}


	private static void cadastrarAluno(List<Pessoa> pessoas, List<Plano> listaPlanos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do Aluno: ");
		String nome = sc.nextLine();
		System.out.println("Digite o CPF do Aluno: ");
		String cpf = sc.nextLine();
		System.out.println("Digite a senha do Aluno: ");
		String senha = sc.nextLine();
		System.out.print("\nPlanos:\n-------------------\n");
		for (int i = 0; i < listaPlanos.size(); i++) {
			System.out.print((i + 1) + ". ");
			listaPlanos.get(i).exibirDados();
		}
		System.out.println("Escolha o número do plano: ");
		int escolhaPlano = sc.nextInt();
		sc.nextLine();
        pessoas.add(new Aluno(nome, cpf, senha, LocalDate.now(), listaPlanos.get(escolhaPlano - 1).getNomePlano()));
        System.out.println("ALUNO CADASTRADO.");
		sc.nextLine();
        Salvar.salvar(pessoas);
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
	}

	private static void cadastrarPersonal(List<Pessoa> pessoas) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do Personal: ");
		String nome = sc.nextLine();
		System.out.println("Digite o CPF do Personal: ");
		String cpf = sc.nextLine();
		System.out.println("Digite a senha do Personal: ");
		String senha = sc.nextLine();
		System.out.println("Digite a especialidade: ");
		String especialidade = sc.nextLine();
		System.out.println("Digite o CREF: ");
		String cref = sc.nextLine();
		pessoas.add(new Personal(nome, cpf, senha, especialidade, cref));
		System.out.println("PERSONAL CADASTRADO.");
		sc.nextLine();
        Salvar.salvar(pessoas);
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
	}

	private static void emitirRelatorios(List<Pessoa> pessoas, List<Plano> planos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nLista de pessoas cadastradas:\n");
		for (int i = 0; i < pessoas.size(); i++) {
			pessoas.get(i).exibirDados();
		}

		System.out.println("\nLista de planos:\n");
		for (int i = 0; i < planos.size(); i++) {
			planos.get(i).exibirDados();
		}

		System.out.println("\nAperte enter para continuar...");
		sc.nextLine();
	}

	private static void calcularFaturamentoMensal() {

	}
}
