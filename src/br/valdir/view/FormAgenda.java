/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.valdir.view;

import br.valdir.modelBeans.BeansAgenda;
import br.valdir.modelBeans.BeansMedico;
import br.valdir.modelBeans.BeansPaciente;
import br.valdir.modelBeans.ModeloTabela;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelConection.ConexaoBD;
import modelDao.DaoAgenda;
import modelDao.DaoMedico;
import modelDao.DaoPaciente;

/**
 *
 * @author Valdir
 */
public class FormAgenda extends javax.swing.JFrame {

    //ConexaoBD conexMed = new ConexaoBD();
    ConexaoBD conex = new ConexaoBD(); 
    //
    //BeansMedico med = new BeansMedico();
   // DaoMedico daoMed = new DaoMedico();
    //
    FormPaciente telaPas = new FormPaciente();
    BeansAgenda agenda = new BeansAgenda();
   
    
    public FormAgenda() {
        initComponents();
        preencherMedicos();
        preencherTabela("select * from pacientes order by pac_nome");
    }

    
    public void preencherMedicos() {
        conex.conexao();
        conex.executaSql("Select * from medicos order by nome");
        try {
            conex.rs.first();
            jcMedico.removeAllItems();
            do {
                String med =  conex.rs.getString("nome");
                String esp =  conex.rs.getString("especialidade");      
                jcMedico.addItem(med);
            } while (conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Medicos" + ex);
        }
        conex.desconecta();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcTurno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultado = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jcMedico = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jtMotivo = new javax.swing.JTextField();
        jbtFinalizar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Agendamento de Pacientes");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(203, 0, 324, 29);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Paciente: ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/valdir/img/procurar.png"))); // NOI18N
        jLabel3.setToolTipText("Pesquisar");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setText("Turno: ");

        jcTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde" }));
        jcTurno.setEnabled(false);

        jTableResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResultadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableResultado);

        jLabel5.setText("Médico: ");

        jcMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcMedico.setEnabled(false);
        jcMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMedicoActionPerformed(evt);
            }
        });

        jLabel6.setText("Data: ");

        jDate.setEnabled(false);

        jLabel7.setText("Motivo da Consulta: ");

        jtMotivo.setEnabled(false);

        jbtFinalizar.setText("Finalizar Agendamento");
        jbtFinalizar.setEnabled(false);
        jbtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFinalizarActionPerformed(evt);
            }
        });

        jbtCancelar.setText("Cancelar Agendamento");
        jbtCancelar.setEnabled(false);
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtMotivo)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jbtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jcTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jcMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jbtFinalizar.getAccessibleContext().setAccessibleDescription("");
        jbtCancelar.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 47, 729, 526);

        setSize(new java.awt.Dimension(765, 623));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFinalizarActionPerformed
       agenda.setNomePac(jtPaciente.getText());
       agenda.setTurno((String) jcTurno.getSelectedItem());
       agenda.setNomeMed((String) jcMedico.getSelectedItem());
       agenda.setData(jDate.getDate());
       agenda.setMotivo(jtMotivo.getText());
       agenda.setEstatus("Aberto");
       DaoAgenda daoAge =new DaoAgenda();
       daoAge.Salvar(agenda);
       dispose();
       jtPaciente.setText("");
       jDate.setDate(null);
       jtMotivo.setText("");
       jbtFinalizar.setEnabled(!true);
        jbtCancelar.setEnabled(!true);
        jDate.setEnabled(!true);
        jtMotivo.setEnabled(!true);
        jcMedico.setEnabled(!true);
        jcTurno.setEnabled(!true);
       
    }//GEN-LAST:event_jbtFinalizarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        BeansPaciente mod = new BeansPaciente();
        DaoPaciente daoPac = new DaoPaciente();
        mod.setPesquisar(jtPaciente.getText());
        BeansPaciente mod2 = daoPac.buscarPas(mod);
        preencherTabela("select *from pacientes where pac_nome ~*'" + mod.getPesquisar() + "'");
//        jbtFinalizar.setEnabled(true);
//        jbtCancelar.setEnabled(true);
//        jtMotivo.setEnabled(true);
//        jcMedico.setEnabled(true);
//        jcTurno.setEnabled(true);
//        jDate.setEnabled(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTableResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultadoMouseClicked
        String nome_paciente = "" + jTableResultado.getValueAt(jTableResultado.getSelectedRow(), 1);
        conex.conexao();
        conex.executaSql("SELECT * FROM pacientes where pac_nome='" + nome_paciente + "'");
        try {
            conex.rs.first();
            jtPaciente.setText(conex.rs.getString("pac_nome"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao selecionar os dados" + ex);
        }
        conex.desconecta();
        jbtFinalizar.setEnabled(true);
        jbtCancelar.setEnabled(true);
        jDate.setEnabled(true);
        jtMotivo.setEnabled(true);
        jcMedico.setEnabled(true);
        jcTurno.setEnabled(true);
    }//GEN-LAST:event_jTableResultadoMouseClicked

    private void jcMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcMedicoActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        dispose();
        jtPaciente.setText("");
        jDate.setDate(null);
        jtMotivo.setText("");
        jbtFinalizar.setEnabled(!true);
        jbtCancelar.setEnabled(!true);
        jDate.setEnabled(!true);
        jtMotivo.setEnabled(!true);
        jcMedico.setEnabled(!true);
        jcTurno.setEnabled(!true);
    }//GEN-LAST:event_jbtCancelarActionPerformed

    public void preencherTabela(String Sql) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Data Nascimento","RG", "Celular"};
        conex.conexao();
        conex.executaSql(Sql);
        try {
            conex.rs.first();
            do {
                dados.add(new Object[]{conex.rs.getInt("cod_paciente"), conex.rs.getString("pac_nome"), conex.rs.getString("pac_nasc"),conex.rs.getString("pac_rg"), conex.rs.getString("pac_celular")});
            } while (conex.rs.next());
        } catch (SQLException ex) {
            int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Usuario não cadastrado.\n Deseja cadastrar agora?");
        if (resposta == JOptionPane.YES_OPTION) {
            if (telaPas == null) {
                    telaPas = new FormPaciente();
                    telaPas.setVisible(true);
                }else{
                    telaPas.setVisible(true);
                }
        }
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);

        jTableResultado.setModel(modelo);
        jTableResultado.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableResultado.getColumnModel().getColumn(0).setResizable(false);
        jTableResultado.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableResultado.getColumnModel().getColumn(1).setResizable(false);
        jTableResultado.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTableResultado.getColumnModel().getColumn(2).setResizable(false);
        jTableResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableResultado.getColumnModel().getColumn(3).setResizable(false);
        jTableResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableResultado.getColumnModel().getColumn(4).setResizable(false);
        jTableResultado.getTableHeader().setReorderingAllowed(false);
        jTableResultado.setAutoResizeMode(jTableResultado.AUTO_RESIZE_OFF);
        jTableResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
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
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultado;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JComboBox<String> jcMedico;
    private javax.swing.JComboBox<String> jcTurno;
    private javax.swing.JTextField jtMotivo;
    private javax.swing.JTextField jtPaciente;
    // End of variables declaration//GEN-END:variables
}
