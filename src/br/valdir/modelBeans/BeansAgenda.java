/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.valdir.modelBeans;

import java.util.Date;



/**
 *
 * @author Valdir
 */
public class BeansAgenda {
    
    private int agendacod; 
    private String nomeMed;
    private String nomePac;
    private String turno; 
    private Date data; 
    private String motivo; 
    private String estatus;
    private String pesquisar;
    private String PacienteNasc;

    public String getPacienteNasc() {
        return PacienteNasc;
    }

    public void setPacienteNasc(String PacienteNasc) {
        this.PacienteNasc = PacienteNasc;
    }

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    public int getAgendacod() {
        return agendacod;
    }

    public void setAgendacod(int agendacod) {
        this.agendacod = agendacod;
    }

    public String getNomeMed() {
        return nomeMed;
    }

    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    public String getNomePac() {
        return nomePac;
    }

    public void setNomePac(String nomePac) {
        this.nomePac = nomePac;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
