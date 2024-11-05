package org.example;

import java.util.List;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        // Estabelecer conexão e criar as tabelas
        BancoDeDados.conectar();
        BancoDeDados.criarTabelaAluno();
        BancoDeDados.criarTabelaEstagio();

        // Criar um AlunoController
        AlunoController alunoController = new AlunoController();
        EstagioController estagioController = new EstagioController();

        // Criar uma instância de Aluno com as informações fornecidas
        Aluno aluno = new Aluno();
        aluno.setNome("ALCIONE GUIMARÃES");
        aluno.setMatricula(20210106);
        aluno.setEmail("alcione4guimaraes@gmail.com");
        aluno.setCurso("Técnico em Enfermagem");
        aluno.setTelefone("21936671473");
        aluno.setDataNascimento("18/05/1998");
        aluno.setTurno("Manhã");
        aluno.setInstituicao("Instituto Paulo Apóstolo");
        aluno.setObservacao("ALUNA TRANQUILA BOM ÊXITO NAS ATIVIDADES.");

        // Adicionar o aluno ao banco de dados
        alunoController.adicionarAluno(aluno);

        // Criar um estágio para Alcione
        Estagio estagio = new Estagio();
        estagio.setLocal("Casa de Repouso Sodalício");
        estagio.setSupervisor("Leila Avila");
        estagio.setHorarios("07:30 - 12:30");
        estagio.setInstituicao("Instituto Paulo Apóstolo");
        estagio.setEndereco("Estrada do Rio Grande, 2116, Taquara");
        estagio.setPeriodo("01/03/2024 a 30/04/2024");

        // Listar alunos e estagios para verificar se foi inserido corretamente
        alunoController.listarAlunos();
        estagioController.listarEstagios();

        // Adicionar o estágio ao banco de dados e associá-lo à matrícula de Alcione (20210106)
        estagioController.adicionarEstagio(estagio, 20210106);


        // Fechar as conexões
        alunoController.close();
        estagioController.close();
        BancoDeDados.desconectar();
    }
}
