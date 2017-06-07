/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminShop;

import bean.Imagen;
import bean.Producto;
import dao.ProductoDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author gama
 */
public class registraProducto extends HttpServlet {

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
        String message = "Error";
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items;
            HashMap hm = new HashMap();
            ArrayList<Imagen> imgs = new ArrayList<>();
            Producto prod = new Producto();
            Imagen img = null;
            try {
                items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while(iter.hasNext()) {
                    FileItem item = iter.next();
                    if(item.isFormField()) {
                        String name = item.getFieldName();
                        String value = item.getString();
                        hm.put(name, value);
                    } else {
                        img = new Imagen();
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String contentType = item.getContentType();
                        boolean isInMemory = item.isInMemory();
                        long sizeBytes = item.getSize();
                        File file = new File("/home/gama/Escritorio/adoo/"+fileName+".jpg");
                        item.write(file);
                        Path path = Paths.get("/home/gama/Escritorio/adoo/"+fileName+".jpg");
                        byte[] data = Files.readAllBytes(path);
                        byte[] encode = org.apache.commons.codec.binary.Base64.encodeBase64(data);
                        img.setUrl(new javax.sql.rowset.serial.SerialBlob(encode));
                        imgs.add(img);
                        //file.delete();
                    }
                }
                prod.setNombre((String)hm.get("nombre"));
                prod.setProdNum((String)hm.get("prodNum"));
                prod.setDesc((String)hm.get("desc"));
                prod.setIva(Double.parseDouble((String)hm.get("iva")));
                prod.setPrecio(Double.parseDouble((String)hm.get("precio")));
                prod.setPiezas(Integer.parseInt((String)hm.get("piezas")));
                prod.setEstatus("A");
                prod.setImagenes(imgs);
                ProductoDAO prodDAO = new ProductoDAO();
                if(prodDAO.registraProducto(prod)) {
                    message = "Exito";      
                }
            } catch(FileUploadException e) {
                e.printStackTrace();
            } catch( Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("index.jsp");
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
