package org.serratec.trabalhoFinal.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Cargo;
import org.serratec.trabalhoFinal.modelos.Funcionario;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;
import org.serratec.trabalhoFinal.modelos.Plano;

public class Menu {
	Scanner sc = new Scanner(System.in);
	public void menu() {
		//criando lista e populando com 1 de cada tipo de pessoa
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Funcionario("Pedro", "111", "1234", Cargo.GERENTE));
		pessoas.add(new Aluno("Ana", "222", "1234",
				LocalDate.parse("2025-03-15"), Plano.MENSAL1, "Joãozinho"));
		pessoas.add(new Personal("Gabriela", "333", "1234", "Spinning", "254-5/6"));
		List<Avaliacao> avaliacoes = new ArrayList<>();
		boolean estaLogado;
		System.out.println("===== Academia SerraFit =====\n");
		do {

			//pedindo cpf e senha
			System.out.println("CPF:");
			String cpf = sc.nextLine();
			System.out.println("Senha:");
			String senha = sc.nextLine();

			//conferindo se esrá estaLogado e se sim iniciando os sub-menus
			estaLogado = confefirLogin(pessoas, cpf, senha, avaliacoes);
			if (!estaLogado) {
				System.out.println("\nCPF ou senha inválidos.\nDigite novamente abaixo.");
			}
		} while (!estaLogado);
	}

	/* ----------------------------------
    IMPLEMENTAÇÃO DAS FUNCÕES SEGUNDÁRIAS
    ---------------------------------- */
	public boolean confefirLogin(List<Pessoa> pessoas, String cpf, String senha, List<Avaliacao> avaliacoes ) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (cpf.equals(pessoas.get(i).getCpf()) && senha.equals(pessoas.get(i).getSenha())) {
				if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("aluno")) {
					menuAluno(pessoas, i); //sub-menu dos alunos
					return true;
				} else if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("funcionario")) {
					menuFuncionario(pessoas); //sub-menu dos funcionarios
					return true; 
				} else {
					menuPersonal(pessoas, i,  avaliacoes); //sub-menu dos personais
					return true;
				}
			}
		}
		return false;
	}

	public void menuAluno(List<Pessoa> pessoas, int i) {
		int opcao;
		do {

			System.out.println("""
					========= Bem vindo, Aluno! ========= 
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

	public void menuFuncionario(List<Pessoa> pessoas) {
		int opcao;
		do {
			System.out.println("""
					========= Bem vindo! ========= 
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
			case 1 -> cadastrarPlano();
			case 2 -> cadastrarAluno(pessoas);
			case 3 -> cadastrarPersonal(pessoas);
			case 4 -> emitirRelatorios();
			case 5 -> calcularFaturamentoMensal();
			case 6 -> System.out.println("Encerrando aplicação...");
			default -> System.out.println("Opção inválida, digite novamente!");

			}
			
		} while(opcao != 6);
	}
	private void cadastrarPlano(){

	}

	private void cadastrarAluno(List<Pessoa> pessoas) {
		System.out.println("Digite o nome do Aluno: ");
		String nome = sc.nextLine();
		System.out.println("Digite o CPF do Aluno: ");
		String cpf = sc.nextLine();
		System.out.println("Digite a senha do Aluno: ");
		String senha = sc.nextLine();
		System.out.println("Digite o plano do Aluno (MENSAL1, MENSAL2): "); //Criar exibir plano
		String planoTemp = sc.nextLine(). toUpperCase();
		Plano plano = Plano.valueOf(planoTemp);
		System.out.println("Digite o Personal contratado: "); //criar exibir personal
		String personal = sc.nextLine();
		pessoas.add(new Aluno(nome, cpf, senha, LocalDate.now(), plano, personal));
	}

	private void cadastrarPersonal(List<Pessoa> pessoas) {
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
	}

	private void emitirRelatorios(){}

	private void calcularFaturamentoMensal() {}


	public void menuPersonal(List<Pessoa> pessoas,int i, List<Avaliacao> avaliacoes) {
		int opcao;
		do {
			System.out.println("""
					========= Bem vindo Personal! ========= 
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

	private void visualizarAvaliacoes(List<Pessoa> pessoas,int i, List<Avaliacao> avaliacoes) {
		for (Avaliacao avaliacao : avaliacoes) {
			avaliacao.exibirDados();
		}
	}

	private void registrarAvaliacao(List<Pessoa> pessoas,int i, List<Avaliacao> avaliacoes) {
		System.out.println("Digite o nome do Aluno: ");
		String nome = sc.nextLine();
		System.out.println("Digite a descrição da avaliação: ");
		String descricao = sc.nextLine();
		avaliacoes.add(new Avaliacao(nome, LocalDate.now(),pessoas.get(i).getNome(), descricao));
		
	}

	private void visualizarAlunos(List<Pessoa> pessoas,int i) {
		/*visuAvAlunos*/
		
	}
	
}
