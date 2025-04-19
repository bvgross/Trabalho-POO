package org.serratec.trabalhoFinal.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.*;

public class Menu {
	Scanner sc = new Scanner(System.in);
	public void menu() {
		//criando lista e populando com 1 de cada tipo de pessoa
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Funcionario("Pedro", "111", "1234", Cargo.GERENTE));
		pessoas.add(new Aluno("Ana", "222", "1234",
				LocalDate.parse("2025-03-15"), Plano.MENSAL_TOTAL, "Joãozinho"));
		pessoas.add(new Personal("Gabriela", "333", "1234", "Spinning", "254-5/6"));

		boolean estaLogado;
		System.out.println("===== Academia SerraFit =====\n");
		do {

			//pedindo cpf e senha
			System.out.println("CPF:");
			String cpf = sc.nextLine();
			System.out.println("Senha:");
			String senha = sc.nextLine();

			//conferindo se esrá estaLogado e se sim iniciando os sub-menus
			estaLogado = confefirLogin(pessoas, cpf, senha);
			if (!estaLogado) {
				System.out.println("\nCPF ou senha inválidos.\nDigite novamente abaixo.");
			}
		} while (!estaLogado);
	}

	/* ----------------------------------
    IMPLEMENTAÇÃO DAS FUNCÕES SEGUNDÁRIAS
    ---------------------------------- */
	public boolean confefirLogin(List<Pessoa> pessoas, String cpf, String senha) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (cpf.equals(pessoas.get(i).getCpf()) && senha.equals(pessoas.get(i).getSenha())) {
				if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("aluno")) {
					menuAluno(pessoas, i); //sub-menu dos alunos
					return true;
				} else if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("funcionario")) {
					menuFuncionario(); //sub-menu dos funcionarios
					return true;
				} else {
					menuPersonal(); //sub-menu dos personais
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

	public void menuFuncionario() {
		System.out.println("Funcionário!!");
	}

	public void menuPersonal() {
		System.out.println("Personal!!");
	}
}
