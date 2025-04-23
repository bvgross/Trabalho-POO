package org.serratec.trabalhoFinal.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Funcionario;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;

public class Salvar {

	public static void salvar(List<Pessoa>pessoas, List<Avaliacao>avaliacoes) {
		try (FileWriter wr = new FileWriter("pessoas.csv")) {
			wr.write("tipo,nome,cpf,senha,info1,info2\n");

			for (Pessoa p : pessoas) {
				String tipo = p.getTipo();

				if (tipo.equals("Aluno")) {
					Aluno a = (Aluno) p;
					wr.write(tipo + "," + a.getNome() + "," + a.getCpf() + "," + a.getSenha() + "," +
							a.getDataMatricula() + "," + a.getPlano() + ","+ a.getPersonalContratado() +"\n");

				} else if (tipo.equals("Personal")) {
					Personal per = (Personal) p;
					wr.write(tipo + "," + per.getNome() + "," + per.getCpf() + "," + per.getSenha() + "," +
							per.getEspecialidade() + "," + per.getCref() + "\n");

				} else if (tipo.equals("Funcionario")) {
					Funcionario f = (Funcionario) p;
					wr.write(tipo + "," + f.getNome() + "," + f.getCpf() + "," + f.getSenha() + "," +
							f.getCargo() + ",\n");
				}
			}

			System.out.println("Salvo com sucesso.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//		try(FileWriter wr = new FileWriter("pessoas.csv")){
	//			
	//			
	//			
	//			System.out.println("Teste Funcionario");
	//			wr.write("nome,cpf,senha,cargo\n");
	//			for (Pessoa p : pessoas) {
	//				wr.write(p.getNome()+","+p.getCpf()+","+p.getSenha()+","+p.getEspecialidade()+"\n");
	//			}
	//		
	//		} catch(IOException e) {
	//			e.printStackTrace();
	//		}
	//		System.out.println("Salvo com sucesso.");
	//	}
}
