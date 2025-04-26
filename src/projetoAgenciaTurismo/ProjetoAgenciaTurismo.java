package projetoAgenciaTurismo;

import controller.FinanceiroController;
import javax.swing.JOptionPane;
import model.Cliente;
import controller.ClienteController;
import utils.Utils;
import controller.GerenciadorConexao;
import model.Financeiro;
import view.FrDashboard;

/**
 *
 * @author gusta
 */
public class ProjetoAgenciaTurismo {

    public static void main(String[] args) {
       // Instancia o menu
        FrDashboard menu = new FrDashboard();
        menu.setVisible(true);
/*
        // Criação de um autor para cadastro
        Financeiro autor = new Financeiro();
        autor.setNome("J.K. Rowling");

        // Criação do controlador de autor e inserção no banco
        FinanceiroController autorController = new FinanceiroController();
        boolean sucesso = autorController.inserir(autor);

        // Exibe uma mensagem confirmando a inserção
        if (sucesso) {
            System.out.println("Financeiro cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar autor.");
        }
    }
*/

}
}
