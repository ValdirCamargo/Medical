/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import br.valdir.modelBeans.BeansAgenda;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelConection.ConexaoBD;

/**
 *
 * @author Valdir
 */
public class DaoAgenda {
    
    BeansAgenda agenda   = new BeansAgenda();
    ConexaoBD   conex    = new ConexaoBD()  ;
    ConexaoBD   conexPac = new ConexaoBD()  ;
    ConexaoBD   conexMed = new ConexaoBD()  ;
    
    int codMed;
    int codPac;   
    
    public void Salvar(BeansAgenda agenda){
        BuscaMed(agenda.getNomeMed());
        BuscaPac(agenda.getNomePac());
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into agenda(agenda_cod_pac,agenda_turno,agenda_cod_medico,agenda_data,agenda_motivo,agenda_estatus)"
                    + "values(?,?,?,?,?,?)");
            pst.setInt(1, codPac);
            pst.setString(2,agenda.getTurno());
            pst.setInt(3, codMed);
            pst.setDate(4, new java.sql.Date(agenda.getData().getTime()));
            pst.setString(5,agenda.getMotivo());
            pst.setString(6,agenda.getEstatus());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Paciente agendado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problemas ao agendar paciente"+ex);
        }
        conex.desconecta();
    }
    
    public void BuscaMed(String nomeMed){
        conexMed.conexao();
        conexMed.executaSql("select * from medicos where nome ='"+nomeMed+"'");
        try {
            conexMed.rs.first();
            codMed = conexMed.rs.getInt("cod_medicos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não econtrado"+ex);
        }
        conexMed.desconecta();        
    }
    
    public void BuscaPac(String nomePac){
       conexPac.conexao();
       conexPac.executaSql("select * from pacientes where pac_nome ='"+nomePac+"'");
       try {
            conexPac.rs.first();
            codPac = conexPac.rs.getInt("cod_paciente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Paciente não econtrado"+ex);
        }
       
       conexPac.desconecta();
    }
    
      public int BuscaMedico(String nomeMed){
        conexMed.conexao();
        conexMed.executaSql("select * from medicos where nome ='"+nomeMed+"'");
        try {
            conexMed.rs.first();
            codMed = conexMed.rs.getInt("cod_medicos");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não econtrado"+ex);
        }
        conexMed.desconecta();    
        return codMed;
    }
    
    
    
    public void Alterar(BeansAgenda agenda){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE agenda SET agenda_estatus=? WHERE agenda_cod=?");
            pst.setString(1,agenda.getEstatus());
            pst.setInt(2, agenda.getAgendacod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Paciente em atendimento");            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar atendimento :" + ex);
        }
        conex.desconecta();       
    }
    
    public BeansAgenda BuscaAgendaPorCod(int cod){
       BeansAgenda agen = new BeansAgenda();
       conex.conexao();
       conex.executaSql("select * from agenda inner join pacientes on agenda_cod_pac = cod_paciente inner join medicos on agenda_cod_medico=cod_medicos where agenda_cod ='"+cod+"'");
       try {
            conex.rs.first();
            agen.setNomePac(conex.rs.getString("pac_nome"));
            agen.setPacienteNasc(conex.rs.getString("pac_nasc"));
            agen.setMotivo(conex.rs.getString("agenda_motivo"));
            agen.setNomeMed(conex.rs.getString("nome"));
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar Agendamento por codigo  "+ex);
        }
       
       conex.desconecta();
       return agen;
    }
    
}
