/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Empleado;
import bean.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gama
 */
public class EmpleadoDAO {
    
    private Connection con;
    
    public EmpleadoDAO(ConexionDAO con) {
        this.con = con.getCon();
    }
    
    public EmpleadoDAO() {
        this.con = new ConexionDAO().getCon();
    }

    public Empleado inicioSesion(String empleadoNum, String password) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select * ");
        sql.append("from empleado ");
        sql.append("where empleado_num = ? ");
        sql.append("and password = ? ");
        sql.append("and estatus = 'A' ");
        try {
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, empleadoNum);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                empleado = new Empleado();
                empleado.setNombre(rs.getString("nombre"));
                empleado.setEmail(rs.getString("email"));
                empleado.setEmpleadoNum(rs.getString("empleado_num"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setMobile(rs.getString("mobile"));
                empleado.setFechaIngreso(rs.getString("fecha_ingreso"));
                empleado.setRol(rs.getString("rol"));
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
        return empleado;
    }
    
    public void Destroy() {
        try {
            this.con.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
