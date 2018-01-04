/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import br.valdir.modelBeans.BeansUsuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelConection.ConexaoBD;

/**
 *
 * @author Valdir
 */
public class DaoUsuario {
    
    ConexaoBD conex = new ConexaoBD();
    BeansUsuario mod = new BeansUsuario();
    
    public void salvar (BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO usuarios(uso_nome,uso_usuario,uso_senha,uso_tipo) values(?,?,?,?)");
            pst.setString(1,mod.getUsoNome());
            pst.setString(2,mod.getUsoUsuario());
            pst.setString(3,mod.getUsoSenha());
            pst.setString(4,mod.getUsoTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Usuário cadastrado com suscesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar usuário"+ex);
        }
        
        conex.desconecta();
    }   
    
    
    public void Editar(BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE usuarios SET uso_nome=?,uso_usuario=?,uso_senha=?, uso_tipo=? WHERE cod_usuario=?");
            pst.setString(1, mod.getUsoNome());
            pst.setString(2, mod.getUsoUsuario());
            pst.setString(3, mod.getUsoSenha());
            pst.setString(4, mod.getUsoTipo());
            pst.setInt(5, mod.getUsoCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com Sucesso");            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados:\n" + ex);
        }
        conex.desconecta();
    }
    
    public void Excluir (BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE FROM usuarios where cod_usuario =?");
            pst.setInt(1, mod.getUsoCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário");
        }
        conex.desconecta();
    }
    public BeansUsuario buscaUsuario(BeansUsuario mod) {
        conex.conexao();
        conex.executaSql("select *from usuarios where uso_nome ~*'" + mod.getPesquisa() + "'");
        try {
            conex.rs.first();
            mod.setUsoCod(conex.rs.getInt("cod_usuario"));
            mod.setUsoNome(conex.rs.getString("uso_nome"));
            mod.setUsoUsuario(conex.rs.getString("uso_usuario"));
            mod.setUsoSenha(conex.rs.getString("uso_senha"));            
            mod.setUsoTipo(conex.rs.getString("uso_tipo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario  não cadastrado");
        }
        conex.desconecta();
        return mod;
    }
}
