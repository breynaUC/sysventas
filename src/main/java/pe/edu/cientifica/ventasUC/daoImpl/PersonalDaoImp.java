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
import pe.edu.cientifica.ventasUC.dao.PersonaDao;
import pe.edu.cientifica.ventasUC.model.Persona;



/**
 *
 * @author alum.fial1
 */
public class PersonalDaoImp implements PersonaDao{
    private CallableStatement cst;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona read(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> readAll(String dni) {
        List<Persona> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cst = cx.prepareCall("{call listarPersona2(?)}");
            cst.setString(1, dni);
            rs = cst.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setIdpersona(rs.getInt("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setDni(rs.getString("dni"));
                p.setTelefono(rs.getString("telefono"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }

    @Override
    public List<Persona> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
