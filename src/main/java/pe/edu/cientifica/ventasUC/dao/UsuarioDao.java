/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.cientifica.ventasUC.model.Usuario;


/**
 *
 * @author alum.fial1
 */
public interface UsuarioDao {
    HashMap<String,Object> validar(String x, String y);
    int create(Usuario u);
    int update(Usuario u);
    int delete(int key);
    Usuario read(int key);
    boolean search(String user);
    List<Map<String, Object>> readAll();
}
