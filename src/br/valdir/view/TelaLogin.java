/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.valdir.view;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelConection.ConexaoBD;

/**
 *
 * @author Valdir
 */
public class TelaLogin extends javax.swing.JFrame {

    ConexaoBD conex = new ConexaoBD();
    
    public TelaLogin() {
        initComponents();
        setIcon();
        conex.conexao();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonAcessar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WS_Medical V:1.1.5");
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonAcessar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAcessar.setText("Acessar");
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        jButtonAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButtonAcessarKeyReleased(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(320, 210, 90, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Senha :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 170, 70, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Usuario :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(260, 130, 70, 30);

        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(320, 130, 160, 30);

        jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSenhaActionPerformed(evt);
            }
        });
        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(320, 170, 160, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("     Efetuar Login");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 60, 240, 80);

        jButtonFechar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonFechar.setText("Sair");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar);
        jButtonFechar.setBounds(420, 210, 60, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/valdir/img/LogoCentro.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-260, 0, 760, 550);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/valdir/img/fundotelaLogin.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, 0, 500, 290);

        setSize(new java.awt.Dimension(516, 324));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarActionPerformed
       
        try {
            conex.executaSql("Select * from usuarios where uso_usuario='"+jTextFieldUsuario.getText()+"'");
            conex.rs.first();
            if (conex.rs.getString("uso_senha").equals(jPasswordFieldSenha.getText())) {
               TelaPrincipal tela =new TelaPrincipal(jTextFieldUsuario.getText());
               tela.setVisible(true);
               dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Usuário incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
        }
        
    }//GEN-LAST:event_jButtonAcessarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jPasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldSenhaActionPerformed

    private void jButtonAcessarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonAcessarKeyReleased
         try {
            conex.executaSql("Select * from usuarios where uso_usuario='"+jTextFieldUsuario.getText()+"'");
            conex.rs.first();
            if (conex.rs.getString("uso_senha").equals(jPasswordFieldSenha.getText())) {
               TelaPrincipal tela =new TelaPrincipal(jTextFieldUsuario.getText());
               tela.setVisible(true);
               dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Usuário incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
        }
    }//GEN-LAST:event_jButtonAcessarKeyReleased

    private void jTextFieldUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyReleased
        try {
            conex.executaSql("Select * from usuarios where uso_usuario='"+jTextFieldUsuario.getText()+"'");
            conex.rs.first();
            if (conex.rs.getString("uso_senha").equals(jPasswordFieldSenha.getText())) {
               TelaPrincipal tela =new TelaPrincipal(jTextFieldUsuario.getText());
               tela.setVisible(true);
               dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Usuário incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldUsuarioKeyReleased

    private void jPasswordFieldSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyReleased
        try {
            conex.executaSql("Select * from usuarios where uso_usuario='"+jTextFieldUsuario.getText()+"'");
            conex.rs.first();
            if (conex.rs.getString("uso_senha").equals(jPasswordFieldSenha.getText())) {
               TelaPrincipal tela =new TelaPrincipal(jTextFieldUsuario.getText());
               tela.setVisible(true);
               dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Usuário incorreto");
                jTextFieldUsuario.setText("");
                jPasswordFieldSenha.setText("");
                jTextFieldUsuario.requestFocus();
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyReleased

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("LogoCentro.png"))); 
    }
}
