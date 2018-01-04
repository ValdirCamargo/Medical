/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import br.valdir.modelBeans.BeansPaciente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelConection.ConexaoBD;

/**
 *
 * @author Valdir
 */
public class DaoPaciente {
    
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexBai = new ConexaoBD();
    BeansPaciente mod = new BeansPaciente();
    String nomeBai;
    int codBairro;

    public void Salvar (BeansPaciente mod){
        buscaBaiCod(mod.getBairro());
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into pacientes(pac_nome,pac_rg,pac_telefone,pac_celular,pac_rua,pac_cep,pac_numero,pac_complemento,pac_cidade,pac_estado,pac_cod_bairro,pac_nasc) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getPac_nome());
            pst.setString(2,mod.getPac_rg());
            pst.setString(3,mod.getPac_telefone());
            pst.setString(4,mod.getPac_celular());
            pst.setString(5,mod.getPac_rua());
            pst.setString(6,mod.getPac_cep());
            pst.setString(7,mod.getPac_numero());
            pst.setString(8,mod.getPac_complemento());
            pst.setString(9,mod.getPac_cidade());
            pst.setString(10,mod.getPac_estado());
            pst.setInt(11,codBairro);
            pst.setString(12,mod.getPac_nasc());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Paciente cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Paciente cadastrado com sucesso"+ex);
        }
        conex.desconecta();
    }
    
    
    public void Alterar (BeansPaciente mod){
        buscaBaiCod(mod.getBairro());
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update pacientes set pac_nome=?,pac_rg=?,pac_telefone=?,pac_celular=?,pac_rua=?,pac_cep=?,pac_numero=?,pac_complemento=?,pac_cidade=?,pac_estado=?,pac_cod_bairro=?,pac_nasc=? "
                    + "where cod_paciente =?");
            pst.setString(1,mod.getPac_nome());
            pst.setString(2,mod.getPac_rg());
            pst.setString(3,mod.getPac_telefone());
            pst.setString(4,mod.getPac_celular());
            pst.setString(5,mod.getPac_rua());
            pst.setString(6,mod.getPac_cep());
            pst.setString(7,mod.getPac_numero());
            pst.setString(8,mod.getPac_complemento());
            pst.setString(9,mod.getPac_cidade());
            pst.setString(10,mod.getPac_estado());
            pst.setInt(11,codBairro);
            pst.setString(12,mod.getPac_nasc());
            pst.setInt(13,mod.getCod_paciente() );
            pst.execute();
            JOptionPane.showMessageDialog(null,"Paciente alterado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro na alteração do paciente"+ex);
        }
        conex.desconecta();
    }

    public void buscaBaiCod(String nome) 
    {
        conex.conexao();
        conex.executaSql("select * from bairro where bai_nome = '"+nome+"'");
        try {
            conex.rs.first();
            codBairro = conex.rs.getInt("cod_bairro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar Bairro"+ex);
        }
        conex.desconecta();
    }
    
    public BeansPaciente buscarPas(BeansPaciente pac){
        conex.conexao();
        try {
            conex.executaSql("select * from pacientes where pac_nome ~*'"+pac.getPesquisar()+"'");
            conex.rs.first();
            buscaNomeBairro(conex.rs.getInt("pac_cod_bairro"));
            pac.setCod_paciente(conex.rs.getInt("cod_paciente"));
            pac.setPac_nome(conex.rs.getString("pac_nome"));
            pac.setPac_rg(conex.rs.getString("pac_rg"));
            pac.setPac_telefone(conex.rs.getString("pac_telefone"));
            pac.setPac_celular(conex.rs.getString("pac_celular"));
            pac.setPac_rua(conex.rs.getString("pac_rua"));
            pac.setPac_cep(conex.rs.getString("pac_cep"));
            pac.setPac_numero(conex.rs.getString("pac_numero"));
            pac.setPac_complemento(conex.rs.getString("pac_complemento"));
            pac.setPac_cidade(conex.rs.getString("pac_cidade"));
            pac.setPac_estado(conex.rs.getString("pac_estado"));
            pac.setBairro(nomeBai);
            pac.setPac_nasc(conex.rs.getString("pac_nasc"));
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro ao buscar passiente"+ex);
        }
        conex.desconecta();
        return pac;
    }
    
    public void buscaNomeBairro(int cod){
        conexBai.conexao();
        try {
            conexBai.executaSql("select * from bairro where cod_bairro='"+cod+"'");
            conexBai.rs.first();
            nomeBai = conexBai.rs.getString("bai_nome");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar Bairro"+ex);
        }
        conexBai.desconecta();
    }
    
    public void Excluir(BeansPaciente pac){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from pacientes where cod_paciente=?");
            pst.setInt(1, pac.getCod_paciente());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Paciente excluido com sucesso");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao excluir paciente"+ex);
        }
        conex.desconecta();
    }
}
