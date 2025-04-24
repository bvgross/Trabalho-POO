package org.serratec.trabalhoFinal.principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Cargo;
import org.serratec.trabalhoFinal.modelos.Frequencia;
import org.serratec.trabalhoFinal.modelos.Funcionario;
import org.serratec.trabalhoFinal.modelos.Periodicidade;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;
import org.serratec.trabalhoFinal.modelos.Plano;

public class Carregar {
	public static List<Pessoa> carregarPessoas() {
		//lista de pessoas.
		List<Pessoa> pessoas = new ArrayList<>();
		try(BufferedReader br = new BufferedReader (new FileReader("pessoas.csv")) ) {
			String linha;
				while((linha = br.readLine()) != null) {
				String[] partes = linha.split(",");
				String tipo = partes [0];

				switch(tipo) {
				case "Aluno" -> {
					String nome = partes[1];
					String cpf = partes[2];
					String senha = partes[3];
					LocalDate dataMatricula = LocalDate.parse(partes[4]);
					String plano = partes[5];
                    Pessoa aluno = new Aluno(nome, cpf, senha, dataMatricula, plano);
					pessoas.add(aluno);
                    aluno.setPersonalContratado(partes[6]);
				}

				case "Personal" -> {
					String nome = partes[1];
					String cpf = partes [2];
					String senha = partes [3];
					String especialidade = partes [4];
					String cref = partes [5];
					pessoas.add(new Personal(nome, cpf, senha, especialidade, cref));
				}
				case "Funcionario" -> {
					String nome = partes [1];
					String cpf = partes [2];
					String senha = partes [3];
					Cargo cargo = Cargo.valueOf(partes[4]);
					pessoas.add(new Funcionario(nome, cpf, senha, cargo));
				}

				}

			}

			System.out.println("Lista de pessoas carregadas. ");
			
		}

		catch(IOException e) {
			System.out.println("CSV não encontrado, começando com uma lista vazia.");
		} 
		return pessoas;
	}

	//Lista de avaliações.
	public static List<Avaliacao> carregarAvaliacoes() {
		List<Avaliacao> avaliacoes = new ArrayList<>();
		try(BufferedReader br = new BufferedReader (new FileReader("avaliacoes.csv"))){
			String linha;
			while((linha = br.readLine()) != null) {
				String[] partes = linha.split(",");
				String aluno = partes[0];
				LocalDate data = LocalDate.parse(partes[1]);
				String personalTrainer = partes[2];
				String indicacao = partes[3];
				double peso = Double.parseDouble(partes[4]);
				double altura = Double.parseDouble(partes[5]);
				avaliacoes.add(new Avaliacao(aluno, data, personalTrainer, indicacao, peso, altura));

			}

			System.out.println("Lista de avaliações carregada. ");
		
		}

		catch(IOException e) {
			System.out.println("CSV não encontrado, começando com uma lista vazia.");
			
		}
		return avaliacoes;
	}
	//lista de planos.
	public static List<Plano> carregarPlanos() {
		List<Plano> planos = new ArrayList<>();
		try(BufferedReader br = new BufferedReader (new FileReader("planos.csv")) ) {
			String linha;
			while((linha = br.readLine()) != null) {
				String[] partes = linha.split(",");	
				String nomePlano = partes[0];
				Frequencia frequencia = Frequencia.valueOf(partes[1]);
				Periodicidade periodicidade = Periodicidade.valueOf(partes[2]);
				double valor = Double.parseDouble(partes[3]);
				String descricaoPlano = partes [4];
				planos.add(new Plano(nomePlano, frequencia, periodicidade, valor, descricaoPlano));
			}
			System.out.println("Lista de planos carregada. ");
		}

		catch(IOException e) {
			System.out.println("CSV não encontrado, começando com uma lista vazia.");

		}
		return planos;
	}

}
