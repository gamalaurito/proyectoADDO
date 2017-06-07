/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Catalogo;
import bean.Categoria;
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
public class CatalogoDAO {
    
    private Connection con;
    
    public CatalogoDAO(ConexionDAO con) {
        this.con = con.getCon();
    }
    
    public CatalogoDAO() {
        this.con = new ConexionDAO().getCon();
    }
    
    public boolean crearCatalogo(Catalogo cata) {
        PreparedStatement pstmt = null;
        boolean ban = true;
        StringBuilder sqlCate = new StringBuilder();
        sqlCate.append("insert into categoria ");
        sqlCate.append("(cate_num, nombre, dsc, estatus, fecha_creacion) ");
        sqlCate.append("values (?, ?, ?, 'A', curdate())");
        StringBuilder sqlProd = new StringBuilder();
        sqlProd.append("insert into catalogo ");
        sqlProd.append("(cate_num, prod_num) ");
        sqlProd.append("values (?, ?) ");
        try {
            pstmt = con.prepareStatement(sqlCate.toString());
            Categoria cate = cata.getCategoria();
            pstmt.setString(1, cate.getCateNum());
            pstmt.setString(2, cate.getNombre());
            pstmt.setString(3, cate.getDesc());
            if(pstmt.executeUpdate() != 0) {
                pstmt.close();
                ArrayList<Producto> productos = cata.getProductos();
                pstmt = con.prepareStatement(sqlProd.toString());
                for(Producto p: productos) {
                    pstmt.clearParameters();
                    pstmt.setString(1, cate.getCateNum());
                    pstmt.setString(2, p.getProdNum());
                    if(pstmt.executeUpdate() == 0) {
                        ban = false;
                    }
                }
            } else {
                ban = false;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            ban = false;
        } finally {
            try {
                if(pstmt != null)pstmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return ban;
    }
    
    public boolean addProdCata(Catalogo cata) {
        PreparedStatement pstmt = null;
        boolean ban = true;
        StringBuilder sqlProd = new StringBuilder();
        sqlProd.append("insert into catalogo ");
        sqlProd.append("(cate_num, prod_num) ");
        sqlProd.append("values (?, ?) ");
        try {
            Categoria cate = cata.getCategoria();
            ArrayList<Producto> productos = cata.getProductos();
            pstmt = con.prepareStatement(sqlProd.toString());
            for(Producto p: productos) {
                pstmt.clearParameters();
                pstmt.setString(1, cate.getCateNum());
                pstmt.setString(2, p.getProdNum());
                if(pstmt.executeUpdate() == 0) {
                    ban = false;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
            ban = false;
        } finally {
            try {
                if(pstmt != null)pstmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return ban;
    }
    
    public Catalogo getCatalogo(Categoria cate) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Catalogo cata = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select prod.prod_num,  prod.nombre, prod.dsc, ");
        sql.append("prod.precio, prod.iva, prod.piezas, img.url ");
        sql.append("from catalogo cata ");
        sql.append("inner join  categoria cate ");
        sql.append("on (cata.cate_num = cate.cate_num) ");
        sql.append("inner join producto prod ");
        sql.append("on (cata.prod_num = prod.prod_num) ");
        sql.append("inner join imagen img ");
        sql.append("on (cate.prod_num = img.prod_num ");
        sql.append("and img_num = 1) ");
        sql.append("where cata.cate_num = ? ");
        sql.append("and prod.estatus = 'A' ");
        try {
            cata = new Catalogo();
            ArrayList<Producto> productos = null;
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, cate.getCateNum());
            rs = pstmt.executeQuery();
            productos = new ArrayList<>();
            while(rs.next()) {
                Producto prod = new Producto();
                prod.setProdNum(rs.getString("prod_num"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDesc(rs.getString("dsc"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setIva(rs.getDouble("iva"));
                prod.setPiezas(rs.getInt("piezas"));
                ArrayList<Imagen> imgs = new ArrayList<>();
                Imagen img = new Imagen();
                img.setUrl(rs.getBlob("url"));
                imgs.add(img);
                prod.setImagenes(imgs);
                productos.add(prod);
            }
            cata.setCategoria(cate);
            cata.setProductos(productos);
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
        return cata;
    }
    
    public Catalogo getCatalogo(String busqueda) {
        Catalogo cata = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select prod.prod_num, prod.nombre, prod.dsc, ");
        sql.append("prod.precio, prod.iva, prod.piezas, img.url ");
        sql.append("from producto prod ");
        sql.append("inner join imagen img ");
        sql.append("on (img.prod_num = prod.prod_num) ");
        sql.append("where prod.estatus = 'A' ");
        sql.append("and img.img_num = 1 ");
        sql.append("and ( prod.nombre like ? ");
        sql.append("or prod.prod_num like ? " );
        sql.append("or prod.dsc like ? )");
        System.out.println(sql.toString());
        try {
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, "%"+busqueda+"%");
            pstmt.setString(2, "%"+busqueda+"%");
            pstmt.setString(3, "%"+busqueda+"%");
            rs = pstmt.executeQuery();
            ArrayList<Producto> productos = new ArrayList<>();
            ArrayList<Imagen> imgs = null;
            Producto prod = null;
            Imagen img = null;
            while(rs.next()) {
                prod = new Producto();
                prod.setProdNum(rs.getString("prod_num"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDesc(rs.getString("dsc"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setIva(rs.getDouble("iva"));
                prod.setPiezas(rs.getInt("piezas"));
                imgs = new ArrayList<>();
                img = new Imagen();
                img.setUrl(rs.getBlob("url"));
                imgs.add(img);
                prod.setImagenes(imgs);
                productos.add(prod);
            }
            Categoria cate = new Categoria();
            cate.setCateNum("busqueda");
            cate.setNombre(busqueda);
            cate.setDesc("busqueda de usuario");
            cata = new Catalogo();
            cata.setCategoria(cate);
            cata.setProductos(productos);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return cata;
    }
    
    public ArrayList<Categoria> getCatalogos() {
        ArrayList<Categoria> cata = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from categoria ");
        sql.append("where estatus = 'A' ");
        sql.append("order by nombre ");
        try{
            pstmt = this.con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            cata = new ArrayList<>();
            Categoria cate;
            while(rs.next()) {
                cate = new Categoria();
                cate.setCateNum(rs.getString("cate_num"));
                cate.setNombre(rs.getString("nombre"));
                cate.setDesc(rs.getString("dsc"));
                cate.setEstatus(rs.getString("estatus"));
                cata.add(cate);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return cata;
    }
    
    public boolean desactivarCatalogo(Categoria cate) {
        boolean ban = false;
        StringBuilder sql = new StringBuilder();
        sql.append("update categoria ");
        sql.append("set estatus = 'I' ");
        sql.append("where cate_num = ? ");
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, cate.getCateNum());
            if(pstmt.executeUpdate() != 0)
                ban = true;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return ban;
    }
    
    public void Destroy() {
        try {
            this.con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
