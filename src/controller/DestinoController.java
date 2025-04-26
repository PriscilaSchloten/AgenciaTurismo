package controller;

import java.sql.*;
import java.util.ArrayList;
import model.Destino;

public class DestinoController {

    public boolean inserir(Destino destino) {
        String sql = "INSERT INTO destino (lugar, cidade) VALUES (?, ?)";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, destino.getNome());
            comando.setString(2, destino.getCidade());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public boolean atualizar(Destino destino) {
        String sql = "UPDATE destino SET lugar = ?, cidade = ? WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setString(1, destino.getNome());
            comando.setString(2, destino.getCidade());
            comando.setInt(3, destino.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM destino WHERE id = ?";
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

    public Destino buscarPorId(int id) {
        String sql = "SELECT * FROM destino WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Destino destino = new Destino();
                destino.setId(resultado.getInt("id"));
                destino.setNome(resultado.getString("lugar"));
                destino.setCidade(resultado.getString("cidade"));
                return destino;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return null;
    }

    public ArrayList<Destino> listarTodos() {
        String sql = "SELECT * FROM destino";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Destino> lista = new ArrayList<>();

        try {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Destino destino = new Destino();
                destino.setId(resultado.getInt("id"));
                destino.setNome(resultado.getString("lugar"));
                destino.setCidade(resultado.getString("cidade"));
                lista.add(destino);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }

    public ArrayList<Destino> buscarPorNome(String nome) {
        String sql = "SELECT * FROM destino WHERE lugar LIKE ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Destino> lista = new ArrayList<>();

        try {
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Destino destino = new Destino();
                destino.setId(resultado.getInt("id"));
                destino.setNome(resultado.getString("lugar"));
                destino.setCidade(resultado.getString("cidade"));
                lista.add(destino);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }
}
