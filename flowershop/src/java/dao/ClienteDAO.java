/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import bean.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gama
 */
public class ClienteDAO {
    
    private Connection con;
    
    public ClienteDAO(ConexionDAO con) {
        this.con = con.getCon();
    }
    
    public ClienteDAO() {
        this.con = new ConexionDAO().getCon();
    }
   
    public Cliente registraCliente(Cliente cliente) {
        PreparedStatement pstmt = null;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into cliente ");
        sql.append("(nombre, email, password, fecha_ingreso, telefono, mobile) ");
        sql.append("values(?,?,?,CURDATE(),?,?)");
        try {
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getPassword());
            pstmt.setString(4, cliente.getTelefono());
            pstmt.setString(5, cliente.getMobile());
            if(0 != pstmt.executeUpdate()) {
                cliente = this.inicioSesion(cliente.getEmail(), cliente.getPassword());
            } else {
                cliente = null;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            cliente = null;
        } finally {
            try {
                if(pstmt != null) pstmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return cliente;
    }
    
    public Cliente inicioSesion(String email, String password) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from cliente ");
        sql.append("where email = ? ");
        sql.append("and password = ? ");
        try {
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                cliente = new Cliente();
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmail(rs.getString("email"));
                cliente.setNumCliente(rs.getInt("cliente_num"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setMobile(rs.getString("mobile"));
                cliente.setFechaIngreso(rs.getString("fecha_ingreso"));
            } 
        }   catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null) pstmt.close();
                if(rs != null) rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return cliente;
    }
    
    public Direccion registraDireccion(Direccion direccion) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sqlDirNum = new StringBuilder();
        sqlDirNum.append("select max(dir_num) as dir_num ");
        sqlDirNum.append("from direccion ");
        sqlDirNum.append("where cliente_num = ? ");
        StringBuilder sql = new StringBuilder();
        sql.append("insert into direccion ");
        sql.append("(cliente_num, dir_num, calle, colonia, cod_pos, ciudad, estado, contacto, telefono, dsc) ");
        sql.append("values(?,?,?,?,?,?,?,?,?,?)");
        try{
            //Obtenemos el numero de la direccion que continua
            pstmt = con.prepareStatement(sqlDirNum.toString());
            pstmt.setInt(1, direccion.getCliente().getNumCliente());
            rs = pstmt.executeQuery();
            int dirNum = 0;
            if(rs.next()) {
                dirNum = rs.getInt("dir_num");
            }
            dirNum++;
            //Insertamos direccion
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, direccion.getCliente().getNumCliente());
            pstmt.setInt(2, dirNum);
            pstmt.setString(3, direccion.getCalle());
            pstmt.setString(4, direccion.getColonia());
            pstmt.setString(5, direccion.getCodPos());
            pstmt.setString(6, direccion.getCiudad());
            pstmt.setString(7, direccion.getEstado());
            pstmt.setString(8, direccion.getContacto());
            pstmt.setString(9, direccion.getTelefono());
            pstmt.setString(10, direccion.getObservaciones());
            if(pstmt.executeUpdate() == 0) direccion = null;
            else direccion.setDirNum(dirNum);
        } catch(SQLException e) {
            direccion = null;
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null)pstmt.close();
                if(rs != null)rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return direccion;
    }
    
    public int checkDireccion(Cliente cli) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select max(dir_num) dir_num ");
        sql.append("from direccion ");
        sql.append("where cliente_num = ? ");
        int dir = 0;
        try {
            pstmt = this.con.prepareStatement(sql.toString());
            pstmt.setInt(1, cli.getNumCliente());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dir = rs.getInt("dir_num");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null)pstmt.close();
                if(rs != null)pstmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return dir;
    }
    
    public void Destroy() {
        try {
            this.con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
