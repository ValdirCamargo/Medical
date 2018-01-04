/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.valdir.modelBeans;


public class BeansUsuario {

    private int usoCod;
    private String usoNome;
    private String usoUsuario;
    private String usoSenha;
    private String usoTipo;  
    private String pesquisa;

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    
    public int getUsoCod() {
        return usoCod;
    }

    public void setUsoCod(int usoCod) {
        this.usoCod = usoCod;
    }

    public String getUsoNome() {
        return usoNome;
    }

    public void setUsoNome(String usoNome) {
        this.usoNome = usoNome;
    }

    public String getUsoUsuario() {
        return usoUsuario;
    }

    public void setUsoUsuario(String usoUsuario) {
        this.usoUsuario = usoUsuario;
    }

    public String getUsoSenha() {
        return usoSenha;
    }

    public void setUsoSenha(String usoSenha) {
        this.usoSenha = usoSenha;
    }

    public String getUsoTipo() {
        return usoTipo;
    }

    public void setUsoTipo(String usoTipo) {
        this.usoTipo = usoTipo;
    }
    
//   public String toString(){
//       String msg = usoNome+usoUsuario+usoSenha+usoTipo;
//       return msg;
//   }
        
}
