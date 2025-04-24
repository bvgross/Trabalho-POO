package org.serratec.trabalhoFinal.modulos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.serratec.trabalhoFinal.modelos.Aluno;
import org.serratec.trabalhoFinal.modelos.Avaliacao;
import org.serratec.trabalhoFinal.modelos.Funcionario;
import org.serratec.trabalhoFinal.modelos.Personal;
import org.serratec.trabalhoFinal.modelos.Pessoa;
import org.serratec.trabalhoFinal.modelos.Plano;

public class Salvar {

	public static void salvar(List<?> lista) {
        //definindo o primeiro objeto da lista recebida para definir qual arquivo salvar
        Object primeiro = lista.get(0);

        if(primeiro instanceof Pessoa) { //se o primeiro objeto for uma pessoa
            List<Pessoa> pessoas = (List<Pessoa>) lista;
            try (FileWriter wr = new FileWriter("pessoas.csv")) {
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
                        if (!f.getTipo().equalsIgnoreCase("admin")) {
                            wr.write(tipo + "," + f.getNome() + "," + f.getCpf() + "," + f.getSenha() + "," +
                                f.getCargo() + ",\n");
                        }
                    }
                }

                System.out.println("Salvo com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(primeiro instanceof Plano) { //se o primeiro objeto for um plano
            List<Plano> planos = (List<Plano>) lista;
            try(FileWriter wr = new FileWriter("planos.csv")) {
                    for (Plano p : planos) {
                        wr.write(p.getNomePlano() + "," + p.getFrequencia() + "," + p.getPeriodicidade() + "," + p.getValor() + "," + p.getDescricaoPlano() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(primeiro instanceof Avaliacao) { //se o primeiro objeto for uma avaliação
            List<Avaliacao> avaliacoes = (List<Avaliacao>) lista;
            try(FileWriter wr = new FileWriter("avaliacoes.csv")) {
                for (Avaliacao a : avaliacoes) {
                    wr.write(a.getAluno() + "," + a.getData() + "," + a.getPersonalTrainer() + "," + a.getIndicacao() + "," + a.getPeso() + "," + a.getAltura() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
