package org.example;

import java.util.List;

public class AlunoController {

    private final AlunoDAO alunoDAO;

    public AlunoController() {
        this.alunoDAO = new AlunoDAO();
    }

    public void adicionarAluno(Aluno aluno) {
        alunoDAO.inserirAluno(aluno);
    }

    public Aluno buscarAlunoPorMatricula(int matricula) {
        return alunoDAO.obterAlunoPorMatricula(matricula);
    }

    public void atualizarAluno(Aluno aluno) {
        alunoDAO.atualizarAluno(aluno);
    }

    public void removerAluno(int matricula) {
        alunoDAO.apagarAluno(matricula);
    }

    public void close() {
        alunoDAO.close();
    }
// alteração aqui em baixo também
    public List<Aluno> listarAlunos() {
        return null;
    }
}