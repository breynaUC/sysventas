/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.model;

/**
 *
 *@author BReyna
 */
public class Rol {
    private int idr;
    private String nomrol;

    public Rol() {
    }

    public Rol(String nomrol) {
        this.nomrol = nomrol;
    }

    public Rol(int idr, String nomrol) {
        this.idr = idr;
        this.nomrol = nomrol;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getNomrol() {
        return nomrol;
    }

    public void setNomrol(String nomrol) {
        this.nomrol = nomrol;
    }
    
}
