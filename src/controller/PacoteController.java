package controller;

import model.Pacote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacoteController {

    private final Connection connection;

    public PacoteController(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir pacote
    public void adicionarPacote(Pacote pacote) throws SQLException {
        String sql = "INSERT INTO pacote (nome, descricao, preco, data_inicio, data_fim, destino_id, guia_id, cliente_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pacote.getNome());
            stmt.setString(2, pacote.getDescricao());
            stmt.setBigDecimal(3, pacote.getPreco());
            stmt.setDate(4, java.sql.Date.valueOf(pacote.getDataInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(pacote.getDataFim()));
            stmt.setInt(6, pacote.getDestinoId());
            stmt.setInt(7, pacote.getGuiaId());
            stmt.setInt(8, pacote.getClienteId());  // Adicionando cliente_id na inserção

            stmt.executeUpdate();
        }
    }

    // Método para atualizar pacote
    public void atualizarPacote(Pacote pacote) throws SQLException {
        String sql = "UPDATE pacote SET nome = ?, descricao = ?, preco = ?, data_inicio = ?, data_fim = ?, destino_id = ?, guia_id = ?, cliente_id = ? "
                + "WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pacote.getNome());
            stmt.setString(2, pacote.getDescricao());
            stmt.setBigDecimal(3, pacote.getPreco());
            stmt.setDate(4, java.sql.Date.valueOf(pacote.getDataInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(pacote.getDataFim()));
            stmt.setInt(6, pacote.getDestinoId());
            stmt.setInt(7, pacote.getGuiaId());
            stmt.setInt(8, pacote.getClienteId());  // Atualizando cliente_id
            stmt.setInt(9, pacote.getId());

            stmt.executeUpdate();
        }
    }

    public void deletarPacote(int id) throws SQLException {
        String sql = "DELETE FROM pacote WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<Pacote> listarTodos() throws SQLException {
        ArrayList<Pacote> lista = new ArrayList<>();

        String sql = "SELECT p.*, d.nome AS destino_nome, g.nome AS guia_nome, c.nome AS cliente_nome "
                + "FROM pacote p "
                + "JOIN destino d ON p.destino_id = d.id "
                + "JOIN guia g ON p.guia_id = g.id "
                + "JOIN cliente c ON p.cliente_id = c.id";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pacote pacote = new Pacote();
                pacote.setId(rs.getInt("id"));
                pacote.setNome(rs.getString("nome"));
                pacote.setDescricao(rs.getString("descricao"));
                pacote.setPreco(rs.getBigDecimal("preco"));
                pacote.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                pacote.setDataFim(rs.getDate("data_fim").toLocalDate());
                pacote.setDestinoId(rs.getInt("destino_id"));
                pacote.setGuiaId(rs.getInt("guia_id"));
                pacote.setClienteId(rs.getInt("cliente_id"));

                // Agora com os nomes
                pacote.setNomeDestino(rs.getString("destino_nome"));
                pacote.setNomeGuia(rs.getString("guia_nome"));
                pacote.setNomeCliente(rs.getString("cliente_nome"));

                lista.add(pacote);
            }
        }

        return lista;
    }

}
