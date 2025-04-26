package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Guia;

public class GuiaController {

    // Método para inserir um guia no banco de dados
    public boolean inserir(Guia guia) {
        String sql = "INSERT INTO guia (nome, estado, email, telefone) VALUES (?, ?, ?, ?)";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, guia.getNome());
            comando.setString(2, guia.getEstado());
            comando.setString(3, guia.getEmail());
            comando.setString(4, guia.getTelefone());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para atualizar um guia
    public boolean atualizar(Guia guia) {
        String sql = "UPDATE guia SET nome = ?, estado = ?, email = ?, telefone = ? WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, guia.getNome());
            comando.setString(2, guia.getEstado());
            comando.setString(3, guia.getEmail());
            comando.setString(4, guia.getTelefone());
            comando.setInt(5, guia.getId());

            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para excluir um guia
    public boolean excluir(int id) {
        String sql = "DELETE FROM guia WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        try {
            comando.setInt(1, id);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    // Método para buscar um guia pelo ID
    public Guia buscarPorId(int id) {
        String sql = "SELECT * FROM guia WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Guia guia = new Guia(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("estado"),
                        resultado.getString("email"),
                        resultado.getString("telefone")
                );
                return guia;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return null;
    }

    // Método para listar todos os guias
    public ArrayList<Guia> listarTodos() {
        String sql = "SELECT * FROM guia";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Guia> lista = new ArrayList<>();

        try {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Guia guia = new Guia(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("estado"),
                        resultado.getString("email"),
                        resultado.getString("telefone")
                );
                lista.add(guia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }
}
