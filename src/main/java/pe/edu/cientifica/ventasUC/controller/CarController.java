/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cientifica.ventasUC.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.cientifica.ventasUC.dao.DetalleDao;
import pe.edu.cientifica.ventasUC.dao.PersonaDao;
import pe.edu.cientifica.ventasUC.dao.ProductoDao;
import pe.edu.cientifica.ventasUC.dao.VentasDao;
import pe.edu.cientifica.ventasUC.daoImpl.DetalleDaoImp;
import pe.edu.cientifica.ventasUC.daoImpl.PersonalDaoImp;
import pe.edu.cientifica.ventasUC.daoImpl.ProductoDaoImp;
import pe.edu.cientifica.ventasUC.daoImpl.VentaslDaoImp;
import pe.edu.cientifica.ventasUC.model.Detalle;
import pe.edu.cientifica.ventasUC.model.Producto;
import pe.edu.cientifica.ventasUC.model.Ventas;


/**
 *
 * @author dreyna
 */
public class CarController extends HttpServlet {

    private final Gson g = new Gson();
    private final PersonaDao perd = new PersonalDaoImp();
    private final ProductoDao prod = new ProductoDaoImp();
    private final VentasDao vdd = new VentaslDaoImp();
    private final DetalleDao dd = new DetalleDaoImp();

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
        HttpSession sesion= request.getSession();
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        int op = Integer.parseInt(request.getParameter("opc"));
        if(sesion.getAttribute("iduser")!=null){
        switch(op){
            case 1://System.out.println(sesion.getAttribute("idp")); 
                  Producto p = prod.buscarProductoCodigo(Integer.parseInt(request.getParameter("cod")));
                  if(p.getNomprod()!=null){
                     out.println(g.toJson(prod.buscarProductoCodigo(Integer.parseInt(request.getParameter("cod")))));
                   }else{
                     out.println(0);
                   }                    
                    break;
            case 2:if (!perd.readAll(request.getParameter("dni")).isEmpty()) {
                    out.println(g.toJson(perd.readAll(request.getParameter("dni"))));
                   } else {
                    out.println(0);
                   }
                   break;
            case 3:String x = (String)sesion.getAttribute("idp"); int idv = 0;
                   idv = vdd.create(new Ventas(Integer.parseInt(x), Integer.parseInt(request.getParameter("idc"))));
                   if(idv>0){
                       out.println(idv);                       
                   }else{
                       out.println(0);
                   }
                   break;
            case 4:String dat = request.getParameter("carrito");
                   int r = 0;
                   //System.out.println(request.getParameter("id"));
                  // System.out.println(request.getParameter("id"));
                   int iddv = Integer.parseInt(request.getParameter("id"));
                   JsonParser parser = new JsonParser();
                   JsonArray gsonArr = parser.parse(dat).getAsJsonArray();
                   for (JsonElement obj : gsonArr) {
                       JsonObject gsonObj = obj.getAsJsonObject();
                       //idventas, idproducto,precio,cantidad
                       Detalle d = new Detalle(iddv, Integer.parseInt(gsonObj.get("idp").getAsString()), Double.parseDouble(gsonObj.get("pre").getAsString()), Integer.parseInt(gsonObj.get("cant").getAsString()));
                        r= dd.create(d);
                    
                   }
                   out.println(r);
                   break;            
        }
        }else{
             rd= request.getRequestDispatcher("home");
             rd.forward(request, response);           
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
