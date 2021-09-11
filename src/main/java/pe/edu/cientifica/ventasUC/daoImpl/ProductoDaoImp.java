/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.cientifica.ventasUC.config.Conexion;
import pe.edu.cientifica.ventasUC.dao.ProductoDao;
import pe.edu.cientifica.ventasUC.model.Producto;


/**
 *
 * @author alum.fial1
 */
public class ProductoDaoImp implements ProductoDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public Producto buscarProductoCodigo(int cod) {
        Producto p = new Producto();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call buscarPorductoCodigo(?)}");
            cst.setInt(1, cod);
            rs = cst.executeQuery();
            while(rs.next()){
                p.setIdprod(rs.getInt("idproducto"));
                p.setNomprod(rs.getString("nom_prod"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCod(rs.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return p;
    }
    
}
