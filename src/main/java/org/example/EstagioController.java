package org.example;

public class EstagioController {

    private final EstagioDAO estagioDAO;

    public EstagioController() {
        this.estagioDAO = new EstagioDAO();
    }

    public void adicionarEstagio(Estagio estagio, int alunoMatricula) {
        estagioDAO.inserirEstagio(estagio, alunoMatricula);
    }

    public Estagio buscarEstagioPorId(int id) {
        return estagioDAO.obterEstagioPorId(id);
    }

    public void atualizarEstagio(Estagio estagio) {
        estagioDAO.atualizarEstagio(estagio);
    }

    public void removerEstagio(int id) {
        estagioDAO.apagarEstagio(id);
    }

    public void close() {
        estagioDAO.close();
    }
}

