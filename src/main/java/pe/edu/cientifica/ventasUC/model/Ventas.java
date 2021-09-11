/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.model;

/**
 *
 * @author BReyna
 */
public class Ventas {
    private int idventas;
    private int idpersona;
    private int idcliente;

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Ventas(int idventas, int idpersona, int idcliente) {
        this.idventas = idventas;
        this.idpersona = idpersona;
        this.idcliente = idcliente;
    }

    public Ventas(int idpersona, int idcliente) {
        this.idpersona = idpersona;
        this.idcliente = idcliente;
    }

    public Ventas() {
    }
    
}
