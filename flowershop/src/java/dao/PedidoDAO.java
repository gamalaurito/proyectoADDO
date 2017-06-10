/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Carrito;
import bean.Cliente;
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
public class PedidoDAO {
    
    private Connection con;
    
    public PedidoDAO(ConexionDAO con) {
        this.con = con.getCon();
    }
    
    public PedidoDAO() {
        this.con = new ConexionDAO().getCon();
    }
    
    public int hacerPedido(Carrito carrito) {
        PreparedStatement pPed = null;
        PreparedStatement pDet = null;
        ResultSet rs = null;
        int pedidoNum = -1;
        StringBuilder sqlPedido = new StringBuilder();
        sqlPedido.append("insert into pedido ");
        sqlPedido.append("(cliente_num, dir_num, estatus, estatus_envio, fecha_pedido, fecha_entrega, tipo, total, iva)");
        sqlPedido.append("values(?, ?, 'F', 'A', CURDATE(), ?, ?, ?, ?)");
        StringBuilder sqlDetalle = new StringBuilder();
        sqlDetalle.append("insert into pedido_detalle ");
        sqlDetalle.append("(pedido_num, prod_num, piezas, precio, iva)");
        sqlDetalle.append("values(?, ?, ?, ?, ?)");
        StringBuilder sqlRuta = new StringBuilder();
        sqlRuta.append("insert into ruta ");
        sqlRuta.append("(empleado_num, pedido_num) ");
        sqlRuta.append("values (10, ?)");
        try {
            pPed = con.prepareStatement(sqlPedido.toString());
            pPed.setInt(1, carrito.getClienteNum());
            pPed.setInt(2, carrito.getDirNum());
            pPed.setString(3, carrito.getFechaEntrega());
            pPed.setString(4, carrito.getTipo());
            pPed.setDouble(5, carrito.getTotal());
            pPed.setDouble(6, carrito.getIva());
            if(pPed.executeUpdate() == 0) {
                System.out.println("Error");
            } else {
                pPed.close();
                sqlPedido.delete(0, sqlPedido.length());
                sqlPedido.append("select max(pedido_num) pedido_num ");
                sqlPedido.append("from pedido p ");
                sqlPedido.append("where p.cliente_num = ? ");
                sqlPedido.append("and p.dir_num = ? ");
                sqlPedido.append("and p.fecha_pedido = CURDATE()");
                sqlPedido.append("and p.fecha_entrega = ? ");
                sqlPedido.append("and p.tipo = ? ");
                sqlPedido.append("and p.total = round(?,2) ");
                sqlPedido.append("and p.iva = round(?,2) ");
                System.out.println(sqlPedido.toString());
                pPed = con.prepareStatement(sqlPedido.toString());
                pPed.setInt(1, carrito.getClienteNum());
                pPed.setInt(2, carrito.getDirNum());
                pPed.setString(3, carrito.getFechaEntrega());
                pPed.setString(4, carrito.getTipo());
                pPed.setDouble(5, carrito.getTotal());
                pPed.setDouble(6, carrito.getIva());
                System.out.println(carrito.getClienteNum() + " " + carrito.getDirNum());
                System.out.println(carrito.getFechaEntrega() + " " + carrito.getTipo());
                System.out.println(carrito.getTotal() + " " + carrito.getIva());
                rs = pPed.executeQuery();
                if(rs.next()) {
                    pedidoNum = rs.getInt("pedido_num");
                    if(pedidoNum == 0)System.out.println("00000");
                }
                System.out.println("Pedido Num: " + pedidoNum);
                ArrayList<Producto> productos = carrito.getProductos();
                pDet = con.prepareStatement(sqlDetalle.toString());
                for(Producto p: productos) {
                    pDet.clearParameters();
                    pDet.setInt(1, pedidoNum);
                    pDet.setString(2, p.getProdNum());
                    pDet.setInt(3, p.getPiezas());
                    pDet.setDouble(4, p.getPrecio());
                    pDet.setDouble(5, p.getIva());
                    if(pDet.executeUpdate() == 0) {
                        con.rollback();
                        break;
                    }
                }
                pDet.close();
                pDet = con.prepareStatement(sqlRuta.toString());
                pDet.setInt(1, pedidoNum);
                pDet.executeUpdate();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pPed != null)pPed.close();
                if(pDet != null)pDet.close();
                if(rs != null)rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return pedidoNum;
    }
    
    public boolean cancelarPedido(int pedidoNum) {
        boolean ban = false;
        PreparedStatement pstmt = null;
        StringBuilder sql = new StringBuilder();
        sql.append("update pedido ");
        sql.append("set estatus = 'C' ");
        sql.append("where pedido_num = ? ");
        try {
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, pedidoNum);
            if(pstmt.executeUpdate() != 0)
                ban = true;
        }   catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return ban;
    }
    
    public int getPedido(Cliente cliente) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int ans = 0;
        StringBuilder sqlPedido = new StringBuilder();
        sqlPedido.append("select min(pedido_num) pedido_num ");
        sqlPedido.append("from pedido p ");
        sqlPedido.append("where p.cliente_num = ? ");
        sqlPedido.append("and estatus = 'F' ");
        sqlPedido.append("and estatus_envio = 'R'");
        System.out.println(sqlPedido.toString());
        try{
            pstmt = con.prepareStatement(sqlPedido.toString());
            pstmt.setInt(1, cliente.getNumCliente());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                ans = rs.getInt(1);
            }
        }catch(SQLException e) {
           e.printStackTrace();
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return ans;
    }
    
    public String getCoorPed(int pedido) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String ans = null;
        StringBuilder sqlPedido = new StringBuilder();
        sqlPedido.append("select longitud, latitud ");
        sqlPedido.append("from ruta ");
        sqlPedido.append("where estatus = 'R' ");
        sqlPedido.append("and pedido_num = ? ");
        System.out.println(sqlPedido.toString());
        try{
            pstmt = con.prepareStatement(sqlPedido.toString());
            pstmt.setInt(1, pedido);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                ans = rs.getString(1) + "," + rs.getString(2);
            }
        }catch(SQLException e) {
           e.printStackTrace();
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return ans;
    }
    
    public void Destroy() {
        try {
            this.con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
