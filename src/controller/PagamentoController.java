package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Pagamento;
import utils.Utils;


/**
 *
 * @author pris
 */
public class PagamentoController {

  public boolean inserir(Pagamento cli) {
    //Montar o comando a ser executado
    //os ? são variáveis que são preenchidas mais adiante
    String sql = "INSERT INTO pacotes(titulo, descricao, destino, preco, data_inicio, data_fim, guia_id) "
            + " VALUES (?,?,?,?,?,?,?)";

    //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    //Declara as variáveis como nulas antes do try para poder usar no finally
    PreparedStatement comando = null;
    try {
      //prepara o sql, analisando o formato e as váriaveis
      comando = gerenciador.prepararComando(sql);

      //define o valor de cada variável(?) pela posição em que aparece no sql
      comando.setString(1, cli.getTitulo());
      comando.setString(2, cli.getDescricao());
      comando.setString(3,cli.getDestino());
      comando.setDouble(4, cli.getValor());
      comando.setDate(5, new java.sql.Date(cli.getDataInicio().getTime()));
      comando.setDate(6, new java.sql.Date(cli.getDataFim().getTime()));
      comando.setInt(1, cli.getGuia_id());

      //Executa o insert
      comando.executeUpdate();

      return true;
    } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de dados
      JOptionPane.showMessageDialog(null, e.getMessage());//exibe popup com o erro
    } finally {//depois de executar o try, dando erro ou não executa o finally
      gerenciador.fecharConexao(comando);
    }
    return false;
  }

  public boolean alterar(Pagamento c) {
    String sql = "UPDATE pacote SET tiutlo = ?, "
            + " descricao = ?, destino = ?, preco = ? , data_inicio = ?, data_fim = ? WHERE id = ?";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;

    try {
      comando = gerenciador.prepararComando(sql);

      comando.setString(1, c.getTitulo());
      comando.setString(2, c.getDescricao());
      comando.setString(3, c.getDestino());
      comando.setDouble(4, c.getValor());
      comando.setDate(5, new java.sql.Date(c.getDataInicio().getTime()));
      comando.setDate(6, new java.sql.Date(c.getDataInicio().getTime()));
      
      comando.setInt(7, c.getpkPagamento());

      comando.executeUpdate();

      return true;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
    } finally {
      gerenciador.fecharConexao(comando);
    }
    return false;
  }

  public Pagamento buscarPorPk(int Cliente_pk) {
    //Guarda o sql
    String sql = "SELECT * FROM pacotes "
            + " WHERE id = ? ";

    //Cria um gerenciador de conexão
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    //Cria as variáveis vazias antes do try pois vão ser usadas no finally
    PreparedStatement comando = null;
    ResultSet resultado = null;

    //Crio um usuário vazio
    Pagamento cli = new Pagamento();

    try {
      //Preparo do comando sql
      comando = gerenciador.prepararComando(sql);

      comando.setInt(1, Cliente_pk);
        

      //Executo o comando e guardo o resultado
      resultado = comando.executeQuery();

      //Irá percorrer os registros do resultado do sql
      //A cada next() a variavel resultado aponta para o próximo registro 
      //enquanto next() == true quer dizer que tem registros
      if (resultado.next()) {

        //Leio as informações da variável resultado e guardo no usuário
        cli.setpkPagamento(resultado.getInt("id"));
        cli.setTitulo(resultado.getString("titulo"));
        cli.setDescricao(resultado.getString("descricao"));
        cli.setDestino(resultado.getString("destino"));
        cli.setValor(resultado.getDouble("preco"));
        cli.setDataInicio(resultado.getDate("data_inicio"));
        cli.setDataFim(resultado.getDate("data_fim"));
      }

    } catch (SQLException ex) {
      Logger.getLogger(PagamentoController.class.getName()).log(
              Level.SEVERE, null, ex);
    } finally {
      gerenciador.fecharConexao(comando, resultado);
    }
    //retorno o usuário
    return cli;
  }

  public List<Pagamento> consultar() {
    //Guarda o sql
    String sql = "SELECT * FROM  pacote";
    
    //Cria um gerenciador de conexão
    GerenciadorConexao gerenciador = new GerenciadorConexao();
    //Cria as variáveis vazias antes do try pois vão ser usadas no finally
    PreparedStatement comando = null;
    ResultSet resultado = null;
    
    //Crio a lista de usuários vazia
    List<Pagamento> listaClientes = new ArrayList<>();
    try {
      //Preparo do comando sql
      comando = gerenciador.prepararComando(sql);

      //Como não há parâmetros já executo direto
      resultado = comando.executeQuery();

      //Irá percorrer os registros do resultado do sql
      //A cada next() a variavel resultado aponta para o próximo registro 
      //enquanto next() == true quer dizer que tem registros
      while (resultado.next()) {

        //Crio um novo usuário vazio
        Pagamento cli = new Pagamento();

        //Leio as informações da variável resultado e guardo no usuário
        cli.setpkPagamento(resultado.getInt("id"));
        cli.setTitulo(resultado.getString("nome"));
        cli.setDescricao(resultado.getString("descricao"));
        cli.setDestino(resultado.getString("destino_id"));
        cli.setValor(resultado.getDouble("valor"));
        cli.setDataInicio(resultado.getDate("data_inicio"));
        cli.setDataFim(resultado.getDate("data_fim"));

        //adiciono o usuário na lista
        listaClientes.add(cli);
      }

    } catch (SQLException ex) {
      Logger.getLogger(PagamentoController.class.getName()).log(
              Level.SEVERE, null, ex);
    } finally {
      gerenciador.fecharConexao(comando, resultado);
    }

    //retorno a lista de usuários
    return listaClientes;
  }
  
  public boolean deletar(int Cliente_pk) {
    String sql = "DELETE FROM pacote "
               + "WHERE id = ?";

    GerenciadorConexao gerenciador = new GerenciadorConexao();
    PreparedStatement comando = null;

    try {
      comando = gerenciador.prepararComando(sql);
      comando.setInt(1, Cliente_pk);

      comando.executeUpdate();

      return true;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao excluir: "
              + ex);
    } finally {
      gerenciador.fecharConexao(comando);
    }
    return false;
  }
}
