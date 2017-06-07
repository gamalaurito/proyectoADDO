/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerShop;

import bean.Carrito;
import bean.Cliente;
import bean.Producto;
import dao.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gama
 */
public class agregaProducto extends HttpServlet {

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
        DecimalFormat df = new DecimalFormat("#.##");
        Carrito carrito =  (Carrito)session.getAttribute("carrito");
        ProductoDAO prodDAO = new ProductoDAO();
        Producto producto = new Producto();
        producto.setProdNum(request.getParameter("item"));
        producto = prodDAO.getProducto(producto);
        producto.setPiezas(Integer.parseInt(request.getParameter("pzs")));
        producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
        producto.setIva(.16);
        carrito.agregarProducto(producto);
        session.removeAttribute("carrito");
        session.setAttribute("carrito", carrito);
        session.removeAttribute("totalC");
        session.setAttribute("totalC", df.format(carrito.getTotal() + carrito.getIva()));
        session.removeAttribute("totalP");
        session.setAttribute("totalP", carrito.getTotalProd());
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(df.format(carrito.getTotal() + carrito.getIva())+","+carrito.getTotalProd());
            out.close();
        }
        prodDAO.Destroy();
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
