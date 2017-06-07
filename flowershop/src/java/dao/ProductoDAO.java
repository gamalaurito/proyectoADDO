/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Imagen;
import bean.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gama
 */
public class ProductoDAO {
    
    private Connection con;
    
    public ProductoDAO(ConexionDAO con) {
        this.con = con.getCon();
    }
    
    public ProductoDAO() {
        this.con = new ConexionDAO().getCon();
    }
    
    public boolean registraProducto(Producto producto) {
        boolean ban = true;
        PreparedStatement pstmt = null;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into producto ");
        sql.append("(prod_num, nombre, dsc, fecha_creacion, piezas, estatus, precio, iva)");
        sql.append("values(?,?,?,CURDATE(),?,?,?,?)");
        try {
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, producto.getProdNum());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getDesc());
            pstmt.setInt(4, producto.getPiezas());
            pstmt.setString(5, producto.getEstatus());
            pstmt.setDouble(6, producto.getPrecio());
            pstmt.setDouble(7, producto.getIva());            
            if(pstmt.executeUpdate() != 1) {
                ban = false;
            } else {
                this.agregaImagenes(producto);
            }
        } catch(SQLException e) {
            ban = false;
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null)pstmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return ban;
    }
    
    private void agregaImagenes(Producto producto) {
        PreparedStatement pstmt = null;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into imagen ");
        sql.append("(prod_num, img_num, url) ");
        sql.append("values(?, ?, ?)");
        try{
            pstmt = con.prepareStatement(sql.toString());
            ArrayList<Imagen> imagenes = producto.getImagenes();
            for(int i = 0; i < imagenes.size(); i++) {
                pstmt.clearParameters();
                pstmt.setString(1, producto.getProdNum());
                pstmt.setInt(2, i+1);
                pstmt.setBlob(3, imagenes.get(i).getUrl());
                //subir imagenes a carpeta o codificar en base 64
                pstmt.executeUpdate();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try{ 
                if(pstmt != null)pstmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Producto getProducto(Producto producto) {
        //prod_num, nombre, dsc, fecha_creacion, piezas, estatus, precio, iva
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from producto ");
        sql.append("where prod_num = ? ");
        try {
            pstmt = this.con.prepareStatement(sql.toString());
            pstmt.setString(1, producto.getProdNum());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                producto.setProdNum(rs.getString("prod_num"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDesc(rs.getString("dsc"));
                producto.setPiezas(rs.getInt("piezas"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setIva(rs.getDouble("iva"));
                producto.setImagenes(getImagenes(producto));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return producto;
    }
    
    public ArrayList<Imagen> getImagenes(Producto producto) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select url ");
        sql.append("from imagen ");
        sql.append("where prod_num = ? ");
        ArrayList<Imagen> imgs = null;
        try {
            pstmt = this.con.prepareStatement(sql.toString());
            pstmt.setString(1, producto.getProdNum());
            rs = pstmt.executeQuery();
            imgs = new ArrayList();
            Imagen img = null;
            while(rs.next()) {
                img = new Imagen();
                img.setUrl(rs.getBlob("url"));
                imgs.add(img);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null)pstmt.close();
                if(rs != null)rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return imgs;
    }
    
    public void Destroy() {
        try {
            this.con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
