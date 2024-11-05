package org.example;

import java.sql.*;

public class AlunoDAO implements AutoCloseable {

    private final Connection conexao;

    public AlunoDAO() {
        this.conexao = BancoDeDados.conectar();
    }

    public void inserirAluno(Aluno aluno) {
        String sql = "INSERT INTO Alunos (nome, matricula, email, curso, telefone, data_nascimento, turno, instituicao, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, aluno.getNome());
            pstmt.setInt(2, aluno.getMatricula());
            pstmt.setString(3, aluno.getEmail());
            pstmt.setString(4, aluno.getCurso());
            pstmt.setString(5, aluno.getTelefone());
            pstmt.setString(6, aluno.getDataNascimento());
            pstmt.setString(7, aluno.getTurno());
            pstmt.setString(8, aluno.getInstituicao());
            pstmt.setString(9, aluno.getObservacao());

            pstmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aluno: " + e.getMessage(), e);
        }
    }
// nesse metodo abaixo teve uma alteração
    public Aluno obterAlunoPorMatricula(int matricula) {
        String sql = "SELECT * FROM Alunos WHERE matricula = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, matricula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Aluno(
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter aluno: " + e.getMessage(), e);
        }
        return null;
    }

    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE Alunos SET nome = ?, email = ?, curso = ?, telefone = ?, data_nascimento = ?, turno = ?, instituicao = ?, observacao = ? WHERE matricula = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getEmail());
            pstmt.setString(3, aluno.getCurso());
            pstmt.setString(4, aluno.getTelefone());
            pstmt.setString(5, aluno.getDataNascimento());
            pstmt.setString(6, aluno.getTurno());
            pstmt.setString(7, aluno.getInstituicao());
            pstmt.setString(8, aluno.getObservacao());
            pstmt.setInt(9, aluno.getMatricula());

            pstmt.executeUpdate();
            System.out.println("Aluno atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno: " + e.getMessage(), e);
        }
    }

    public void apagarAluno(int matricula) {
        String sql = "DELETE FROM Alunos WHERE matricula = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, matricula);
            pstmt.executeUpdate();
            System.out.println("Aluno apagado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar aluno: " + e.getMessage(), e);
        }
    }

    @Override
    public void close() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão com o banco de dados: " + e.getMessage());
        }
    }

}
