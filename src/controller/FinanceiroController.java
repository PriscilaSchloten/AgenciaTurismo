package controller;

import java.sql.*;
import java.util.ArrayList;
import model.Financeiro;

public class FinanceiroController {

    public boolean inserir(Financeiro financeiro) {
        String sql = "INSERT INTO financeiro (reserva_id, valor, data_pagamento, status, metodo_pagamento) VALUES (?, ?, ?, ?, ?)";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, financeiro.getReservaId());
            comando.setDouble(2, financeiro.getValor());
            comando.setTimestamp(3, new Timestamp(financeiro.getDataPagamento().getTime()));
            comando.setString(4, financeiro.getStatus());
            comando.setString(5, financeiro.getMetodoPagamento());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }

    public boolean atualizar(Financeiro financeiro) {
        String sql = "UPDATE financeiro SET reserva_id = ?, valor = ?, data_pagamento = ?, status = ?, metodo_pagamento = ? WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, financeiro.getReservaId());
            comando.setDouble(2, financeiro.getValor());
            comando.setTimestamp(3, new Timestamp(financeiro.getDataPagamento().getTime()));
            comando.setString(4, financeiro.getStatus());
            comando.setString(5, financeiro.getMetodoPagamento());
            comando.setInt(6, financeiro.getId());
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
        String sql = "DELETE FROM financeiro WHERE id = ?";
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

    public Financeiro buscarPorId(int id) {
        String sql = "SELECT * FROM financeiro WHERE id = ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Financeiro financeiro = new Financeiro();
                financeiro.setId(resultado.getInt("id"));
                financeiro.setReservaId(resultado.getInt("reserva_id"));
                financeiro.setValor(resultado.getDouble("valor"));
                financeiro.setDataPagamento(resultado.getTimestamp("data_pagamento"));
                financeiro.setStatus(resultado.getString("status"));
                financeiro.setMetodoPagamento(resultado.getString("metodo_pagamento"));
                return financeiro;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return null;
    }

    public ArrayList<Financeiro> listarTodos() {
        String sql = "SELECT * FROM financeiro";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Financeiro> lista = new ArrayList<>();

        try {
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Financeiro financeiro = new Financeiro();
                financeiro.setId(resultado.getInt("id"));
                financeiro.setReservaId(resultado.getInt("reserva_id"));
                financeiro.setValor(resultado.getDouble("valor"));
                financeiro.setDataPagamento(resultado.getTimestamp("data_pagamento"));
                financeiro.setStatus(resultado.getString("status"));
                financeiro.setMetodoPagamento(resultado.getString("metodo_pagamento"));
                lista.add(financeiro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }

    public ArrayList<Financeiro> buscarPorStatus(String status) {
        String sql = "SELECT * FROM financeiro WHERE status LIKE ?";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);
        ArrayList<Financeiro> lista = new ArrayList<>();

        try {
            comando.setString(1, "%" + status + "%");
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Financeiro financeiro = new Financeiro();
                financeiro.setId(resultado.getInt("id"));
                financeiro.setReservaId(resultado.getInt("reserva_id"));
                financeiro.setValor(resultado.getDouble("valor"));
                financeiro.setDataPagamento(resultado.getTimestamp("data_pagamento"));
                financeiro.setStatus(resultado.getString("status"));
                financeiro.setMetodoPagamento(resultado.getString("metodo_pagamento"));
                lista.add(financeiro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexao.fecharConexao(comando);
        }
        return lista;
    }
}
