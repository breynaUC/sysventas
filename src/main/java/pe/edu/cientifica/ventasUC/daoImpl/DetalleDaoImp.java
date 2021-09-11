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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.cientifica.ventasUC.config.Conexion;
import pe.edu.cientifica.ventasUC.dao.DetalleDao;
import pe.edu.cientifica.ventasUC.model.Detalle;



/**
 *
 * @author alum.fial1
 */
public class DetalleDaoImp implements DetalleDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Detalle d) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call insertarDetalle(?,?,?,?)}");
            cst.setInt(1, d.getIdventas());
            cst.setInt(2, d.getIdproducto());
            cst.setDouble(3, d.getPrecio());
            cst.setInt(4, d.getCantidad());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public Detalle read(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Detalle d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int key) {
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call eliminarDetalleVenta(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

    @Override
    public List<Detalle> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Map<String, Object>> readAll2() {
            List<Map<String, Object>> datos = new ArrayList<>();
            try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarDetalle()}");
            rs = cst.executeQuery();
            while(rs.next()){
              Map<String, Object> map = new HashMap<>();
              map.put("idd",rs.getInt("iddetalle_venta"));
              map.put("prod",rs.getString("nom_prod"));
              map.put("precio", rs.getString("precio"));
              map.put("cant", rs.getInt("cantidad"));
              datos.add(map);
            }
        } catch (SQLException e) {
                System.out.println("Error:"+e);
        }
        return datos;
    }
    
}
