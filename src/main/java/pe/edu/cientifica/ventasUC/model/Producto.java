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
public class Producto {
    private int idprod;
    private String nomprod;
    private double precio;
    private int stock;
    private int cod;

    public Producto(String nomprod, double precio, int stock, int cod) {
        this.nomprod = nomprod;
        this.precio = precio;
        this.stock = stock;
        this.cod = cod;
    }

    public Producto(int idprod, String nomprod, double precio, int stock, int cod) {
        this.idprod = idprod;
        this.nomprod = nomprod;
        this.precio = precio;
        this.stock = stock;
        this.cod = cod;
    }

    public Producto() {
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
}
