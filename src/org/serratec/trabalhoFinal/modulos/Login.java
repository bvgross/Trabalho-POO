package org.serratec.trabalhoFinal.modulos;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Cargo;
import org.serratec.trabalhoFinal.modelos.Funcionario;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;
import org.serratec.trabalhoFinal.modelos.Plano;



public class Login {
	Scanner sc = new Scanner(System.in);
	public void login() throws Exception {
		//criando lista e populando com 1 de cada tipo de pessoa
		List<Pessoa> pessoas = Carregar.carregarPessoas();
		List<Avaliacao> avaliacoes = Carregar.carregarAvaliacoes();
		List<Plano> planos = Carregar.carregarPlanos();

        //usuários admin para demonstração
        Pessoa funcionarioAdmin = new Funcionario("ADMIN", "111", "1234", Cargo.ATENDENTE);
        funcionarioAdmin.setTipo("ADMIN");
        Pessoa funcionarioCoordenador = new Funcionario("COORD", "123", "1234", Cargo.COORDENADOR);
        Pessoa alunoAdmin = new Aluno("ADMIN", "222", "1234", LocalDate.now(), "admin");
        alunoAdmin.setTipo("ADMIN");
        Pessoa personalAdmin = new Personal("ADMIN", "333", "1234", "admin", "admin");
        personalAdmin.setTipo("ADMIN");
		pessoas.add(funcionarioAdmin);
		pessoas.add(funcionarioCoordenador);
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

    			String statusLogin = confefirLogin(pessoas, cpf, senha, avaliacoes, planos);
    			estaLogado = statusLogin.equals("ok");

    			if (statusLogin.equals("invalido")) {
    				System.out.println("\nCPF ou senha inválidos.\nDigite novamente abaixo.");
    			} else if (statusLogin.equals("acessoNegado")) {
    				System.out.println("\nAcesso negado para este tipo de funcionário.");
    				System.out.println("Pressione ENTER para continuar...");
    				sc.nextLine();
    			}
    		} while (!estaLogado);
    		LimparTela.Limpar();
    	}
    }

	public String confefirLogin(List<Pessoa> pessoas, String cpf, String senha, List<Avaliacao> avaliacoes, List<Plano> planos) throws Exception {
		 Scanner sc = new Scanner(System.in); // para esperar o ENTER

		 for (int i = 0; i < pessoas.size(); i++) {
		        Pessoa p = pessoas.get(i);

		        if (cpf.equals(p.getCpf()) && senha.equals(p.getSenha())) {
		            if (p instanceof Aluno) {
		                MenuAluno.menuAluno(pessoas, i, avaliacoes);
		                return "ok";

		            } else if (p instanceof Funcionario f) {
		                if (f.getCargo() == Cargo.ATENDENTE || f.getCargo() == Cargo.GERENTE) {
		                    MenuFuncionario.menuFuncionario(pessoas, planos, i, avaliacoes);
		                    return "ok";
		                } else {
		                    return "acessoNegado";
		                }

		            } else if (p instanceof Personal) {
		                MenuPersonal.menuPersonal(pessoas, i, avaliacoes);
		                return "ok";
		            }
		        }
		    }

		    return "invalido";
		}
}