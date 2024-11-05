package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EstagioDAO implements AutoCloseable {

    private final Connection conexao;

    public EstagioDAO() {
        this.conexao = BancoDeDados.conectar();
    }

    public void inserirEstagio(Estagio estagio, int alunoMatricula) {
        String sql = "INSERT INTO Estagios (aluno_matricula, local, supervisor, horarios, instituicao, endereco, periodo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, alunoMatricula);
            pstmt.setString(2, estagio.getLocal());
            pstmt.setString(3, estagio.getSupervisor());
            pstmt.setString(4, estagio.getHorarios());
            pstmt.setString(5, estagio.getInstituicao());
            pstmt.setString(6, estagio.getEndereco());
            pstmt.setString(7, estagio.getPeriodo());

            pstmt.executeUpdate();
            System.out.println("Estágio inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir estágio: " + e.getMessage(), e);
        }
    }

    //aqui teve uma alteração na parte do 'return new estagio'
    public Estagio obterEstagioPorId(int id) {
        String sql = "SELECT * FROM Estagios WHERE id = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Estagio(
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar estágio por ID: " + e.getMessage(), e);
        }
        return null;
    }

    public void atualizarEstagio(Estagio estagio) {
        String sql = "UPDATE Estagios SET local = ?, supervisor = ?, horarios = ?, instituicao = ?, endereco = ?, periodo = ? WHERE id = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, estagio.getLocal());
            pstmt.setString(2, estagio.getSupervisor());
            pstmt.setString(3, estagio.getHorarios());
            pstmt.setString(4, estagio.getInstituicao());
            pstmt.setString(5, estagio.getEndereco());
            pstmt.setString(6, estagio.getPeriodo());
            pstmt.setInt(7, estagio.getId());

            pstmt.executeUpdate();
            System.out.println("Estágio atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar estágio: " + e.getMessage(), e);
        }
    }

    public void apagarEstagio(int id) {
        String sql = "DELETE FROM Estagios WHERE id = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Estágio apagado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar estágio: " + e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
//a alteração foi a criação desse metodo
    public List<Estagio> obterTodosEstagios() {
        return null;
    }
}