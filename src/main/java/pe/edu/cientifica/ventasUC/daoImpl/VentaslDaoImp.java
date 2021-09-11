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
import pe.edu.cientifica.ventasUC.dao.VentasDao;
import pe.edu.cientifica.ventasUC.model.Ventas;


/**
 *
 * @author alum.fial1
 */
public class VentaslDaoImp implements VentasDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Ventas v) {
        int id=0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call insertarVenta(?,?,?)}");
            cst.setInt(1, v.getIdpersona());
            cst.setInt(2, v.getIdcliente());
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.executeUpdate();
            id = cst.getInt(3);
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return id;
    }
    
}
