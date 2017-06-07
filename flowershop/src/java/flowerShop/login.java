/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerShop;

import bean.Carrito;
import bean.Cliente;
import dao.ClienteDAO;
import dao.ConexionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gama
 */
public class login extends HttpServlet {

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
        HttpSession session = request.getSession();
        boolean ban = session.getAttribute("active")!=null;
        if(ban) {
            response.sendRedirect("index.jsp");
        } else {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            ClienteDAO clienteDAO = new ClienteDAO();
            String message;
            Cliente cliente = clienteDAO.inicioSesion(user, pass);
            if(cliente == null) {
                message = "Error";
            } else {
                session.setAttribute("cliente", cliente);
                session.setAttribute("active", true);
                Carrito carrito = (Carrito)session.getAttribute("carrito");
                carrito.setClienteNum(cliente.getNumCliente());
                carrito.setDirNum(clienteDAO.checkDireccion(cliente));
                session.removeAttribute("carrito");
                session.setAttribute("carrito", carrito);
                message = "Exito";
            }
            clienteDAO.Destroy();
            response.sendRedirect("index.jsp");
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
        //processRequest(request, response);
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
