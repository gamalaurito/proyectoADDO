/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gama
 */
public class ConexionDAO {
    private static final String url = "jdbc:mysql://localhost/jamaica";
    private static final String user = "root";
    private static final String pass = "root";
    private Connection con;
	
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
	
    public ConexionDAO(String url, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ConexionDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(ConexionDAO.url, ConexionDAO.user, ConexionDAO.pass);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection conectar(String url, String user, String pass) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void destroy() {
        try {
                con.close();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    }
    
}
