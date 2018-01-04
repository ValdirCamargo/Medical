/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.valdir.view;

import br.valdir.modelBeans.BeansAgenda;
import br.valdir.modelBeans.ModeloTabela;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelConection.ConexaoBD;
import modelDao.DaoAgenda;

/**
 *
 * @author Valdir
 */
public class FormAgendados extends javax.swing.JFrame {

    ConexaoBD conex =new ConexaoBD();
    BeansAgenda agenda = new BeansAgenda();
    BeansAgenda agen = new BeansAgenda();
    DaoAgenda daoAgenda = new DaoAgenda();
    
    String dtHoje;
    String dtHojeF;
    String status;
    
    public FormAgendados() {
        initComponents();
        
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.format(d);
        
        Calendar dataa = Calendar.getInstance();
        Date de = dataa.getTime();
        SimpleDateFormat dateFormate =new SimpleDateFormat("dd/MM/yyyy");
        dateFormate.format(de);
        
        dtHoje = dateFormat.format(d);
        dtHojeF = dateFormate.format(de);
        status = "Aberto";
        
        jLabelAge.setText("Agenda dia: "+dtHojeF);
        preencherTabela("select * from agenda inner join pacientes on agenda_cod_pac = cod_paciente inner join medicos on agenda_cod_medico=cod_medicos where agenda_data ='"+dtHoje+"' and agenda_estatus='"+status+"' order by agenda_turno ");
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jbtBaixar = new javax.swing.JButton();
        jLabelAge = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agenda do dia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgenda);

        jbtBaixar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtBaixar.setText("Baixar Paciente");
        jbtBaixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBaixarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtBaixar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtBaixar)
                .addGap(54, 54, 54))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(23, 46, 800, 280);

        jLabelAge.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelAge.setText("Agenda dia :");
        getContentPane().add(jLabelAge);
        jLabelAge.setBounds(240, 10, 360, 29);

        setSize(new java.awt.Dimension(855, 404));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendaMouseClicked
       String agendaCod= ""+jTableAgenda.getValueAt(jTableAgenda.getSelectedRow(),0);
        conex.conexao();
        conex.executaSql("SELECT * FROM agenda where agenda_cod='"+agendaCod+"'");
        try {
            conex.rs.first();
            agen.setEstatus("Atendimento");
            agen.setAgendacod(conex.rs.getInt("agenda_cod"));
            JOptionPane.showMessageDialog(rootPane, conex.rs.getInt("agenda_cod"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Erro ao selecionar os dados"+ex);
        }
        conex.desconecta();
    }//GEN-LAST:event_jTableAgendaMouseClicked

    private void jbtBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBaixarActionPerformed
        daoAgenda.Alterar(agen);
        preencherTabela("select * from agenda inner join pacientes on agenda_cod_pac = cod_paciente inner join medicos on agenda_cod_medico=cod_medicos where agenda_data ='"+dtHoje+"' and agenda_estatus='"+status+"' order by agenda_turno ");
    }//GEN-LAST:event_jbtBaixarActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgendados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendados().setVisible(true);
            }
        });
    }
    
     public void preencherTabela(String Sql){
        ArrayList dados = new ArrayList();
        String []colunas = new String[]{"ID","Paciente","Rg","Data","Perido","Estatus","Médico"};
        conex.conexao();
        conex.executaSql(Sql);
        try{
            conex.rs.first();
            do{
               dados.add(new Object[]{conex.rs.getInt("agenda_cod"),conex.rs.getString("pac_nome"),conex.rs.getString("pac_rg"),conex.rs.getString("agenda_data"),conex.rs.getString("agenda_turno"),conex.rs.getString("agenda_estatus"),conex.rs.getString("nome")});
            }while(conex.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Não a nenhum agendamento para hoje");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        
        jTableAgenda.setModel(modelo);
        jTableAgenda.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableAgenda.getColumnModel().getColumn(0).setResizable(false);
        jTableAgenda.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTableAgenda.getColumnModel().getColumn(1).setResizable(false);
        jTableAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableAgenda.getColumnModel().getColumn(2).setResizable(false);
        jTableAgenda.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTableAgenda.getColumnModel().getColumn(3).setResizable(false);
        jTableAgenda.getColumnModel().getColumn(4).setPreferredWidth(75);
        jTableAgenda.getColumnModel().getColumn(4).setResizable(false);
        jTableAgenda.getColumnModel().getColumn(5).setPreferredWidth(75);
        jTableAgenda.getColumnModel().getColumn(5).setResizable(false);
        jTableAgenda.getColumnModel().getColumn(6).setPreferredWidth(164);
        jTableAgenda.getColumnModel().getColumn(6).setResizable(false);
        jTableAgenda.getTableHeader().setReorderingAllowed(false);
        jTableAgenda.setAutoResizeMode(jTableAgenda.AUTO_RESIZE_OFF);
        jTableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgenda;
    private javax.swing.JButton jbtBaixar;
    // End of variables declaration//GEN-END:variables
}