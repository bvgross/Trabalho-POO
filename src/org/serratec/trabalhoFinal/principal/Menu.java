package org.serratec.trabalhoFinal.principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Cargo;
import org.serratec.trabalhoFinal.modelos.Frequencia;
import org.serratec.trabalhoFinal.modelos.Funcionario;
import org.serratec.trabalhoFinal.modelos.Periodicidade;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;
import org.serratec.trabalhoFinal.modelos.Plano;

public class Menu {
	Scanner sc = new Scanner(System.in);
	public void menu() {
		//criando lista e populando com 1 de cada tipo de pessoa
		List<Pessoa> pessoas = Carregar.carregarPessoas();
		List<Avaliacao> avaliacoes = Carregar.carregarAvaliacoes();
		List<Plano> planos = Carregar.carregarPlanos();
		
		pessoas.add(new Funcionario("Atendente", "111", "1234", Cargo.ATENDENTE));
		boolean estaLogado;
		System.out.println("\n===== Academia SerraFit =====\n");
		do {
            System.out.println("LOGIN");
			System.out.println("CPF:");
			String cpf = sc.nextLine();
			System.out.println("Senha:");
			String senha = sc.nextLine();

			estaLogado = confefirLogin(pessoas, cpf, senha, avaliacoes, planos); //conferindo se esrá estaLogado e se sim iniciando os sub-menus
			if (!estaLogado) {
				System.out.println("\nCPF ou senha inválidos.\nDigite novamente abaixo.");
			}
		} while (!estaLogado);
	}

	public boolean confefirLogin(List<Pessoa> pessoas, String cpf, String senha, List<Avaliacao> avaliacoes, List<Plano> planos) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (cpf.equals(pessoas.get(i).getCpf()) && senha.equals(pessoas.get(i).getSenha())) {
				if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("aluno")) {
					MenuAluno.menuAluno(pessoas, i, avaliacoes); //sub-menu dos alunos
					return true;
				} else if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("funcionario")) {
					MenuFuncionario.menuFuncionario(pessoas, planos, i); //sub-menu dos funcionarios
					return true; 
				} else {
					MenuPersonal.menuPersonal(pessoas, i, avaliacoes); //sub-menu dos personais
					return true;
				}
			}
		}
		return false;
	}

}
