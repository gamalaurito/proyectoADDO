/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author gama
 */
public class Empleado {
    private String empleadoNum;
    private String nombre;
    private String email;
    private String password;
    private String fechaIngreso;
    private String telefono;
    private String mobile;
    private String estatus;
    private String rol;

    public void setEmpleadoNum(String empleadoNum) {
            this.empleadoNum = empleadoNum;
    }
    
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }
    
    public void setEmail(String email) {
            this.email = email;
    }
    
    public void setPassword(String password) {
            this.password = password;
    }
    
    public void setFechaIngreso(String fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
    }
    
    public void setTelefono(String telefono) {
            this.telefono = telefono;
    }
    
    public void setMobile(String mobile) {
            this.mobile = mobile;
    }
    
    public void setEstatus(String estatus) {
            this.estatus = estatus;
    }
    
    public void setRol(String rol) {
            this.rol = rol;
    }

    public String getEmpleadoNum() {
            return this.empleadoNum;
    }
    
    public String getNombre() {
            return this.nombre;
    }
    
    public String getEmail() {
            return this.email;
    }
    
    public String getPassword() {
            return this.password;
    }
    
    public String getFechaIngreso() {
            return this.fechaIngreso;
    }
    
    public String getTelefono() {
            return this.telefono;
    }
    
    public String getMobile() {
            return this.mobile;
    }
    
    public String getEstatus() {
            return this.estatus;
    }
    
    public String getRol() {
            return this.rol;
    }
}
