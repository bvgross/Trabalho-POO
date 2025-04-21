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
import org.serratec.trabalhoFinal.modelos.Planos;

public class Menu {
	Scanner sc = new Scanner(System.in);
	public void menu() {
		//criando lista e populando com 1 de cada tipo de pessoa
		List<Planos> planos = new ArrayList<>();
		planos.add(new Planos("Total", Frequencia.SEMANA_INTEIRA, Periodicidade.ANUAL, 189.90, "Combo Total"));		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Funcionario("Pedro", "111", "1234", Cargo.GERENTE));
		pessoas.add(new Aluno("Ana", "222", "1234",
				LocalDate.parse("2025-03-15"), planos.get(0).getNomePlano(),"Joãozinho"));
		pessoas.add(new Personal("Gabriela", "333", "1234", "Spinning", "254-5/6"));
		pessoas.add(new Personal("Bruno", "444", "1234", "Crossfit", "444-4/4"));
		pessoas.add(new Personal("Lucas", "555", "1234", "Jump", "254-5/6"));
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
			estaLogado = confefirLogin(pessoas, cpf, senha, avaliacoes, planos);
			if (!estaLogado) {
				System.out.println("\nCPF ou senha inválidos.\nDigite novamente abaixo.");
			}
		} while (!estaLogado);
	}

	/* ----------------------------------
    IMPLEMENTAÇÃO DAS FUNCÕES SEGUNDÁRIAS
    ---------------------------------- */
	public boolean confefirLogin(List<Pessoa> pessoas, String cpf, String senha, List<Avaliacao> avaliacoes, List<Planos> planos) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (cpf.equals(pessoas.get(i).getCpf()) && senha.equals(pessoas.get(i).getSenha())) {
				if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("aluno")) {
					MenuAluno.menuAluno(pessoas, i); //sub-menu dos alunos
					return true;
				} else if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("funcionario")) {
					MenuFuncionario.menuFuncionario(pessoas, planos); //sub-menu dos funcionarios
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
