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
public class Cliente {
    private int num;
    private String nombre;
    private String email;
    private String registro;
    private String primerC;
    private String ultimaC;
    private int numCs;
    private double totalC;
    private char clase;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getPrimerC() {
        return primerC;
    }

    public void setPrimerC(String primerC) {
        this.primerC = primerC;
    }

    public String getUltimaC() {
        return ultimaC;
    }

    public void setUltimaC(String ultimaC) {
        this.ultimaC = ultimaC;
    }

    public int getNumCs() {
        return numCs;
    }

    public void setNumCs(int numCs) {
        this.numCs = numCs;
    }

    public double getTotalC() {
        return totalC;
    }

    public void setTotalC(double totalC) {
        this.totalC = totalC;
    }

    public char getClase() {
        return clase;
    }

    public void setClase(char clase) {
        this.clase = clase;
    }
    
}
