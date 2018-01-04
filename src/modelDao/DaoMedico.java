/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import modelConection.ConexaoBD;
import br.valdir.modelBeans.BeansMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoMedico {

    ConexaoBD conex = new ConexaoBD();
//    BeansMedico mode = new BeansMedico();

    public void salvar(BeansMedico mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos(nome,especialidade,crm) values(?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCrm());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados:\n" + ex);
        }
        conex.desconecta();
    }

    public void Alterar(BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE medicos SET nome=?,especialidade=?,crm=? WHERE cod_medicos=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCrm());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso");            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados:\n" + ex);
        }
        conex.desconecta();
    }
    
    public void Excluir (BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM medicos where cod_medicos =?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Medico excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir medico");
        }
        conex.desconecta();
    }
    
    public BeansMedico buscaMedico(BeansMedico mod) {
        conex.conexao();
        conex.executaSql("select *from medicos where nome ~*'" + mod.getPesquisa() + "'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_medicos"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setEspecialidade(conex.rs.getString("especialidade"));
            mod.setCrm(conex.rs.getInt("crm"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico nao cadastrado");
        }
        conex.desconecta();
        return mod;
    }

}
