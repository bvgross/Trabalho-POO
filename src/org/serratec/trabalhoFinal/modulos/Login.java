package org.serratec.trabalhoFinal.modulos;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.*;

public class Login {
	Scanner sc = new Scanner(System.in);
	public void login() {
		//criando lista e populando com 1 de cada tipo de pessoa
		List<Pessoa> pessoas = Carregar.carregarPessoas();
		List<Avaliacao> avaliacoes = Carregar.carregarAvaliacoes();
		List<Plano> planos = Carregar.carregarPlanos();

        //usuários admin para demonstração
        Pessoa funcionarioAdmin = new Funcionario("ADMIN", "111", "1234", Cargo.ATENDENTE);
        funcionarioAdmin.setTipo("ADMIN");
        Pessoa alunoAdmin = new Aluno("ADMIN", "222", "1234", LocalDate.now(), "admin");
        alunoAdmin.setTipo("ADMIN");
        Pessoa personalAdmin = new Personal("ADMIN", "333", "1234", "admin", "admin");
        personalAdmin.setTipo("ADMIN");
		pessoas.add(funcionarioAdmin);
        pessoas.add(alunoAdmin);
        pessoas.add(personalAdmin);

        while (true) { // loop principal do sistema
    		boolean estaLogado;
            LimparTela.Limpar();
            System.out.println("###### Para fins demonstrativos ######\n" +
                "Login de funcionário administrador -> CPF: 111 e SENHA: 1234\n" +
                "Login de aluno administrador -> CPF: 222 e SENHA: 1234\n" +
                "Login de personal administrador -> CPF: 333 e SENHA: 1234");
    		System.out.println("\n===== Academia SerraFit =====\n");

    		do {
    			System.out.println("LOGIN");
    			System.out.println("CPF:");
    			String cpf = sc.nextLine();
    			System.out.println("Senha:");
    			String senha = sc.nextLine();

    			// submenus (aluno, funcionario ou personal) são chamados aqui
    			estaLogado = confefirLogin(pessoas, cpf, senha, avaliacoes, planos);

    			if (!estaLogado) {
    				System.out.println("\nCPF ou senha inválidos.\nDigite novamente abaixo.");
    			}
    		} while (!estaLogado);
        }
	}

	public boolean confefirLogin(List<Pessoa> pessoas, String cpf, String senha, List<Avaliacao> avaliacoes, List<Plano> planos) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (cpf.equals(pessoas.get(i).getCpf()) && senha.equals(pessoas.get(i).getSenha())) {
				if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("aluno")) {
					MenuAluno.menuAluno(pessoas, i, avaliacoes); //sub-menu dos alunos
					return true;
				} else if (pessoas.get(i).getClass().getSimpleName().equalsIgnoreCase("funcionario")) {
					MenuFuncionario.menuFuncionario(pessoas, planos, i, avaliacoes); //sub-menu dos funcionarios
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
