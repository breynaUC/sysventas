/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.dao;

import pe.edu.cientifica.ventasUC.model.Producto;



/**
 *
 * @author alum.fial1
 */
public interface ProductoDao {
    Producto buscarProductoCodigo(int cod);
}
