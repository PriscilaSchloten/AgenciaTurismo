/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.DestinoController;
import controller.GuiaController;
import controller.PacoteController;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Destino;
import model.Guia;
import utils.Utils;

/**
 *
 * @author prisc
 */
public class FrCadPacote extends javax.swing.JDialog {
    
    private int idCliente;
    private int idGuia;
    private int idDestino;

    public void setId(int idCliente) {
        this.idCliente = idCliente;
    }
    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }
    public void setIdDes(int idDestino) {
        this.idDestino = idDestino;
    }

    public FrCadPacote(java.awt.Frame parent, boolean modal, int idGuia, int idCliente, int idDestino) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        setId(idCliente);
        setIdGuia(idGuia);
        setIdDes(idDestino);
        carregarTudo();
    }
    
        public void carregarTudo() {
        // Busca os dados do cliente no banco de dados, utilizando o controlador
        ClienteController controllerC = new ClienteController();
        Cliente cliente = controllerC.buscarPorId(idCliente);
        GuiaController controllerG = new GuiaController();
        Guia guia = controllerG.buscarPorId(idGuia);
        DestinoController controllerD = new DestinoController();
        Destino destino = controllerD.buscarPorId(idDestino);// Busca o cliente pelo ID

        // Preenche os campos do formulário com os dados do cliente
         String codigo = String.valueOf(cliente.getId()); 
        String codigog = String.valueOf(guia.getId()); 
        String codigod = String.valueOf(destino.getId()); 

        txtClienteId.setText(codigo); // Campo para o código/ID
        txtDestinoId.setText(codigod);
        txtGuiaId.setText(codigog);// Nome do cliente
        
    }

    ClienteController controller = new ClienteController(); // para não dar erro
    Cliente cl = new Cliente();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblClienteId = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblDataEntrada = new javax.swing.JLabel();
        txtClienteId = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtDataEntrada = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblDataSaida = new javax.swing.JLabel();
        txtDataSaida = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        lblDestinoId = new javax.swing.JLabel();
        txtDestinoId = new javax.swing.JTextField();
        lblGuiaId = new javax.swing.JLabel();
        txtGuiaId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cadastro de Pacote");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 31, -1, -1));

        lblNome.setText("Nome");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 80, -1, -1));

        lblClienteId.setText("Cliente id");
        jPanel1.add(lblClienteId, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 137, -1, -1));

        lblDescricao.setText("Descricao");
        jPanel1.add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 185, -1, -1));

        lblDataEntrada.setText("Data de Entrada");
        jPanel1.add(lblDataEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 249, -1, -1));
        jPanel1.add(txtClienteId, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 155, 146, -1));
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 207, 90, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 102, 124, -1));

        txtDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtDataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(txtDataEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 277, 79, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 363, -1, -1));

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, -1));

        lblDataSaida.setText("Data de Saida");
        jPanel1.add(lblDataSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        txtDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtDataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataSaidaActionPerformed(evt);
            }
        });
        jPanel1.add(txtDataSaida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 79, -1));
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 90, -1));

        lblValor.setText("Valor");
        jPanel1.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        lblDestinoId.setText("Destino id");
        jPanel1.add(lblDestinoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));
        jPanel1.add(txtDestinoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 146, -1));

        lblGuiaId.setText("Guia id");
        jPanel1.add(lblGuiaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));
        jPanel1.add(txtGuiaId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 146, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataEntradaActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificarCampos()) {
            gravar();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtDataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataSaidaActionPerformed

    public void gravar() {

        cl.setNome(txtNome.getText());
        cl.setEmail(txtClienteId.getText());
        cl.setTelefone(txtDescricao.getText());
        cl.setDataNascimento(utils.Utils.converterStringToDate(txtDataEntrada.getText()));

        if (controller.inserir(cl)) {
            JOptionPane.showMessageDialog(null, "Cliente Registrado com sucesso");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "O cadastro não foi gravado");

        }
    }

    public boolean verificarCampos() {

        String nome = txtNome.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String dataEntrada = txtDataEntrada.getText().trim();
        String dataSaida = txtDataSaida.getText().trim();

        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'Nome' está em branco");
            return false;
        }
        if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
            JOptionPane.showMessageDialog(null, "Nome inválido! Use apenas letras e espaços.");
            return false;
        }

        if (txtDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'descrição' está vazio.");
            return false;
        }
        if (!descricao.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
            JOptionPane.showMessageDialog(null, "Descrição inválida! Use apenas letras e espaços.");
            return false;
        }

        if (dataEntrada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Data de entrada' está em branco.");
            return false;
        }
        if (!dataEntrada.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Data de entrada inválida! Use o formato dd/mm/aaaa.");
            return false;
        }

         if (dataSaida.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Data de Saida' está em branco.");
            return false;
        }
        if (!dataSaida.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Data de saida inválida! Use o formato dd/mm/aaaa.");
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrCadPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCadPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCadPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCadPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrCadPacote dialog = new FrCadPacote(new javax.swing.JFrame(), true,0,0,0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClienteId;
    private javax.swing.JLabel lblDataEntrada;
    private javax.swing.JLabel lblDataSaida;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDestinoId;
    private javax.swing.JLabel lblGuiaId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtClienteId;
    private javax.swing.JFormattedTextField txtDataEntrada;
    private javax.swing.JFormattedTextField txtDataSaida;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDestinoId;
    private javax.swing.JTextField txtGuiaId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
