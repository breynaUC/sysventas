/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.cientifica.ventasUC.dao.UsuarioDao;
import pe.edu.cientifica.ventasUC.daoImpl.UsuarioDaoImp;


/**
 *
 * @author dreyna
 */
public class ValidarController extends HttpServlet {

    private UsuarioDao ud = new UsuarioDaoImp();
    private Gson g = new Gson();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int op = Integer.parseInt(request.getParameter("op"));
        HttpSession sesion = request.getSession();
        RequestDispatcher rd;
        ServletContext context= getServletContext();
        HashMap<String, Object> datos = new HashMap<>();
        
        System.out.println(request.getParameter("user")+" / "+ request.getParameter("pass"));
        datos = ud.validar(request.getParameter("user"), request.getParameter("pass"));
        //System.out.println("Error: "+datos.size());
        switch(op){
            case 1: 
                    if(datos.size()>0){
                        sesion.setAttribute("iduser", datos.get("idu"));
                        sesion.setAttribute("user", datos.get("user"));
                        String nombres = datos.get("nom")+" "+datos.get("apell");
                        sesion.setAttribute("nombres", nombres);
                        sesion.setAttribute("rol", datos.get("rol"));
                        sesion.setAttribute("idp", datos.get("idp"));
                        rd= request.getRequestDispatcher("bienvenido");
                        rd.forward(request, response);
                    }else{
                    	response.sendRedirect("inicio");
                    }
                    break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
