/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BReyna
 */
public class Conexion {
    /*
    private static final String URL = "jdbc:mysql://bdventas.cpmnvlkneh1k.us-east-2.rds.amazonaws.com:3306/bdventas2021";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "admin";
    private static final String PASS = "Sistemas2021";*/
    private static final String URL = "jdbc:mysql://localhost:3306/bdventas2021?serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static Connection cx = null;
    public static Connection getConexion(){
        try {
            Class.forName(DRIVER);
            if(cx == null){
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        }
        return cx;
    }
   public static void cerrar() throws SQLException {
      if (cx != null) {
         cx.close();
      }
   } 
}
