/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author prisc
 */
public class FrCadCliente extends javax.swing.JDialog {

    public FrCadCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
    }

    ClienteController controller = new ClienteController();
    Cliente cl = new Cliente();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtDataNasc = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtCpf = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cadastro do Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 31, -1, -1));

        lblNome.setText("Nome");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 80, -1, -1));

        lblEmail.setText("E-mail");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 137, -1, -1));

        lblTelefone.setText("Telefone");
        jPanel1.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 185, -1, -1));

        lblDataNasc.setText("Data de Nascimento");
        jPanel1.add(lblDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 155, 146, -1));
        jPanel1.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 207, 114, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 102, 124, -1));

        txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascActionPerformed(evt);
            }
        });
        jPanel1.add(txtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 79, -1));

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
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 363, -1, -1));
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 114, -1));

        lblCpf.setText("Cpf");
        jPanel1.add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascActionPerformed

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

    public void gravar() {
        cl.setNome(txtNome.getText());
        cl.setEmail(txtEmail.getText());
        cl.setTelefone(txtTelefone.getText());
        cl.setCpf(txtCpf.getText());  // Ajustado para o CPF
        cl.setDataNascimento(utils.Utils.converterStringToDate(txtDataNasc.getText()));  // Certifique-se de que o método de conversão está adequado para o formato DATE

        if (controller.inserir(cl)) {
            JOptionPane.showMessageDialog(null, "Cliente Registrado com sucesso");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "O cadastro não foi gravado");
        }
    }
public boolean verificarCampos() {
    String nome = txtNome.getText().trim();
    String email = txtEmail.getText().trim();
    String telefone = txtTelefone.getText().trim();
    String dataNascimento = txtDataNasc.getText().trim();
    String cpf = txtCpf.getText().trim();

    if (txtNome.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "O campo 'Nome' está em branco");
        return false;
    }
    if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
        JOptionPane.showMessageDialog(null, "Nome inválido! Use apenas letras e espaços.");
        return false;
    }

    if (txtEmail.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "O campo 'Email' está em branco");
        return false;
    }
    if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(null, "E-mail inválido! Use o formato a@a.com.");
        return false;
    }

    if (txtTelefone.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "O campo 'Telefone' está vazio.");
        return false;
    }
    if (!telefone.matches("^[0-9]{10,15}$")) {  // Alterado para aceitar telefones com 10 a 15 dígitos
        JOptionPane.showMessageDialog(null, "Telefone inválido! Use apenas números (com ou sem o código do país) e de 10 a 15 dígitos.");
        return false;
    }

    // Validação do CPF
    if (cpf.isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo 'CPF' está em branco.");
        return false;
    }
    if (!cpf.matches("^[0-9]{11}$") && !cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {  // Alterado para verificar tanto CPF com ou sem máscara
        JOptionPane.showMessageDialog(null, "CPF inválido! Use o formato 000.000.000-00 ou apenas números.");
        return false;
    }

    // Validação da Data de Nascimento
    if (dataNascimento.isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo 'Data de Nascimento' está em branco.");
        return false;
    }
    if (!dataNascimento.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
        JOptionPane.showMessageDialog(null, "Data de nascimento inválida! Use o formato dd/mm/aaaa.");
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
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrCadCliente dialog = new FrCadCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
