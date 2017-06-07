/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerShop;

import bean.Carrito;
import bean.Categoria;
import dao.CatalogoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gama
 */
public class getMenu extends HttpServlet {

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
        String test = (String)session.getAttribute("divMenu");
        if(test == null) {
            CatalogoDAO cataDAO = new CatalogoDAO();
            ArrayList<Categoria> menu = cataDAO.getCatalogos();
            StringBuilder divMenu = new StringBuilder();
            if(menu == null) {
                divMenu.append("Error");
            } else {
                Carrito carrito = (Carrito)session.getAttribute("carrito");
                if(carrito == null) {
                    carrito = new Carrito();
                    carrito.setDirNum(0);
                }
                session.removeAttribute("carrito");
                session.setAttribute("carrito", carrito);
                divMenu.append("<ul class='memenu skyblue'>\n");
                divMenu.append("    <li class='active'>\n");
                divMenu.append("        <a href='index.jsp'>Home</a>\n");
                divMenu.append("    </li>\n");
                int i = 0;
                String temp;
                for(Categoria cate: menu) {
                    temp = "    <li class='grid' onclick = getArticulos("+i+",'"+cate.getCateNum()+"')>\n";
                    divMenu.append(temp);
                    divMenu.append("        <a>");
                    divMenu.append(cate.getNombre());
                    divMenu.append("</a>\n");
                    divMenu.append("    </li>\n");
                }
                divMenu.append("    <li class='grid' onclick = 'getArticulos(-100,\"rosa\")'>\n");
                divMenu.append("        <a>Rosas</a>");
                divMenu.append("    </li>");
                divMenu.append("    <li class='grid' onclick = 'getArticulos(-100,\"ramo\")'>\n");
                divMenu.append("        <a>Ramos</a>");
                divMenu.append("    </li>");
                divMenu.append("    <li class='grid' onclick = 'getArticulos(-100,\"figura\")'>\n");
                divMenu.append("        <a>Figuras</a>");
                divMenu.append("    </li>");
                divMenu.append("    <li class='grid' onclick = 'getArticulos(-100,\"corona\")'>\n");
                divMenu.append("        <a>Coronas</a>");
                divMenu.append("    </li>");
                divMenu.append("</ul>\n");
                divMenu.append("<div class=\"clearfix\"> </div>");
                test = divMenu.toString();
                session.setAttribute("divMenu", test);
                session.setAttribute("menu", menu);
            }
            cataDAO.Destroy();
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(test);
            out.close();
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
