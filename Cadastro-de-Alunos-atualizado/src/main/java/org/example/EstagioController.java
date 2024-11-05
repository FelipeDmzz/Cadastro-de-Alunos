package org.example;

import java.util.List;

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

    //aqui a alteração foi adicionar esse metodo
    public List<Estagio> listarEstagios() {
        return estagioDAO.obterTodosEstagios();
    }

    public void close() {
        estagioDAO.close();
    }
}
