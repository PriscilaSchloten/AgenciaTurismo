package controller;

import model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReservaController {

    public List<Reserva> consultar() {
        List<Reserva> listaReservas = new ArrayList<>();
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        Connection conn = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM reserva";
            stmt = gerenciador.prepararComando(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setClienteId(rs.getInt("cliente_id"));
                reserva.setPacoteId(rs.getInt("pacote_id"));
                reserva.setDataReserva(rs.getDate("data_reserva"));
                reserva.setQuantidadePessoas(rs.getInt("quantidade_pessoas"));
                reserva.setStatus(rs.getString("status"));
                listaReservas.add(reserva);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            gerenciador.fecharConexao(stmt, rs);
        }
        return listaReservas;
    }

    public boolean excluir(int id) {
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        Connection conn = gerenciador.getConexao();
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM reserva WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int resultado = stmt.executeUpdate();

            return resultado > 0; // Retorna true se a exclusão for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            gerenciador.fecharConexao(stmt, null);
        }
    }

    public boolean atualizar(Reserva reserva) {
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        Connection conn = gerenciador.getConexao();
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE reserva SET status = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, reserva.getStatus());
            stmt.setInt(2, reserva.getId());
            int resultado = stmt.executeUpdate();

            return resultado > 0; // Retorna true se a atualização for bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            gerenciador.fecharConexao(stmt, null);
        }
    }
   
    public boolean inserir(Reserva reserva) {
        String sql = "INSERT INTO reserva (cliente_id, pacote_id, data_reserva, quantidade_pessoas, status) VALUES (?, ?, ?, ?, ?)";
        GerenciadorConexao conexao = new GerenciadorConexao();
        PreparedStatement comando = conexao.prepararComando(sql);

        try {
            comando.setInt(1, reserva.getClienteId());
            comando.setInt(2, reserva.getPacoteId());
            comando.setTimestamp(3, new Timestamp(reserva.getDataReserva().getTime()));
            comando.setInt(4, reserva.getQuantidadePessoas());
            comando.setString(5, reserva.getStatus());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            conexao.fecharConexao(comando);
        }
    }
}
