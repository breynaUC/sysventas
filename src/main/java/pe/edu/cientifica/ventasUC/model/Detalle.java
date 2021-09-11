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
public class Detalle {
   private int iddetalle;
   private int idventas;
   private int idproducto;
   private double precio;
   private int cantidad;

    public Detalle() {
    }

    public Detalle(int idventas, int idproducto, double precio, int cantidad) {
        this.idventas = idventas;
        this.idproducto = idproducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Detalle(int iddetalle, int idventas, int idproducto, double precio, int cantidad) {
        this.iddetalle = iddetalle;
        this.idventas = idventas;
        this.idproducto = idproducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
}
