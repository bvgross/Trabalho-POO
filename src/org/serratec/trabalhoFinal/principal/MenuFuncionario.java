package org.serratec.trabalhoFinal.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Frequencia;
import org.serratec.trabalhoFinal.modelos.Periodicidade;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;
import org.serratec.trabalhoFinal.modelos.Planos;

public class MenuFuncionario {

	public static void menuFuncionario(List<Pessoa> pessoas, List<Planos> planos, int i) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		do {
            String nome = pessoas.get(i).getNome();
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

	private static void cadastrarPlano(List<Planos> planos){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o plano: ");
		String nomePlano = sc.nextLine();
		
		System.out.print("""
			------------ Escolha a frequência do plano ------------
			1. Semana inteira
			2. Segunda a sexta
			3. Segunda, quarta e sexta
			4. Terça e quinta\n
			""");
		
		int escolha = 0;
		Frequencia opcao = null;
		
		do { 
			escolha = sc.nextInt();
			sc.nextLine();
			
			
			switch (escolha) {
			case 1 -> opcao = Frequencia.SEMANA_INTEIRA;
			case 2 -> opcao = Frequencia.SEG_SEXTA;
			case 3 -> opcao = Frequencia.SEG_QUAR_SEXTA;
			case 4 -> opcao = Frequencia.TER_QUINTA;
			default -> System.out.println("Opção inválida. Digite novamente. ");
			}
		} while (escolha < 1 || escolha > 4);
		
		
		System.out.println("""
			------------ Escolha o período do plano ------------
			1. Anual
			2. Semestral
			3. Trimestral
			4. Mensal
			5. Quinzenal
			6. Semanal\n
			""");
			int periodo = 0;
			Periodicidade opcoes = null;
			
		do {
			
			periodo = sc.nextInt();
			sc.nextLine();
			
			switch (periodo) {
			case 1 -> opcoes = Periodicidade.ANUAL;
			case 2 -> opcoes = Periodicidade.SEMESTRAL;
			case 3 -> opcoes = Periodicidade.TRIMESTRAL;
			case 4 -> opcoes = Periodicidade.MENSAL;
			case 5 -> opcoes = Periodicidade.QUINZENAL;
			case 6 -> opcoes = Periodicidade.SEMANAL;
			default -> System.out.println("Opção inválida. Digite novamente. ");
			
			}
			
						
		}while (periodo < 1 || periodo > 6);
		
		System.out.println("Qual o valor do plano: R$ ");
		double valor = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Descrição do plano: ");
		String descricao = sc.nextLine();
		
		planos.add(new Planos(nomePlano, opcao, opcoes, valor, descricao));
        System.out.println("Plano cadastrado.");
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
	}


	private static void cadastrarAluno(List<Pessoa> pessoas, List<Planos> listaPlanos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do Aluno: ");
		String nome = sc.nextLine();
		System.out.println("Digite o CPF do Aluno: ");
		String cpf = sc.nextLine();
		System.out.println("Digite a senha do Aluno: ");
		String senha = sc.nextLine();
		System.out.print("Planos:\n ");
		for (int i = 0; i < listaPlanos.size(); i++) {
			System.out.print((i + 1) + ". ");
			listaPlanos.get(i).exibirDados();
		}
		System.out.println("Escolha o número do plano: ");
		int escolhaPlano = sc.nextInt();
		sc.nextLine();
		List<Integer> indices = new ArrayList<>();
		int indicePersonal = 0;
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("Personal")) {
				System.out.print((indicePersonal + 1) + ". ");
				pessoas.get(i).exibirDados();
				indices.add(i);
				indicePersonal++;
			}
		}
		System.out.println("Escolha o número do personal: ");
		int escolhaPersonal = sc.nextInt();
		sc.nextLine();

		pessoas.add(new Aluno(nome, cpf, senha, LocalDate.now(), listaPlanos.get(escolhaPlano - 1).getNomePlano(),
				pessoas.get(indices.get(escolhaPersonal - 1)).getNome()));
        System.out.println("Aluno cadastrado.");
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
        System.out.println("Personal cadastrado.");
        System.out.println("\nAperte enter para continuar...");
        sc.nextLine();
	}

	private static void emitirRelatorios(List<Pessoa> pessoas, List<Planos> planos) {
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
