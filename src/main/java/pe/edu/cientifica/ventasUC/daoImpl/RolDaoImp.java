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
import java.util.List;
import pe.edu.cientifica.ventasUC.config.Conexion;
import pe.edu.cientifica.ventasUC.dao.RolDao;
import pe.edu.cientifica.ventasUC.model.Rol;


/**
 *
 * @author alum.fial1
 */
public class RolDaoImp implements RolDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Rol r) {
        int x =0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call createRol(?)}");
            cst.setString(1, r.getNomrol());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }
    @Override
    public int update(Rol r) {
        boolean p = false;
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call editarRol(?,?)}");
            cst.setInt(1, r.getIdr());
            cst.setString(2, r.getNomrol());
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }
    @Override
    public int delete(int key) {//call eliminarRol(11)
        boolean p = false;
        int x = 0;
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call eliminarRol(?)}");
            cst.setInt(1, key);
            x = cst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;        
    }

    @Override
    public Rol read(int key) {
        Rol r = new Rol();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call searchId(?)}");
            cst.setInt(1, key);
            rs = cst.executeQuery();
            while(rs.next()){
               r.setIdr(rs.getInt("idrol"));
               r.setNomrol(rs.getString("nom_rol"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+ e);
        }
        //call searchId(4);
        return r;        
    }

    @Override
    public List<Rol> readAll() {
        List<Rol> datos = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarRol()}");
            rs = cst.executeQuery();
            while(rs.next()){
                Rol r = new Rol();
                r.setIdr(rs.getInt("idrol"));
                r.setNomrol(rs.getString("nom_rol"));
                datos.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return datos;
    }

    @Override
    public boolean search(String rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
