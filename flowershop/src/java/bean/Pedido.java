/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;

/**
 *
 * @author gama
 */
public class Pedido {
    
    private int pedidoNum;
    private Direccion direccion;
    private String estatus;
    private String estatusEnvio;
    private String fechaPed;
    private String fechaEntre;
    private String pedidoTipo;
    private double total;
    private double iva;
    private ArrayList<PedidoDetalle> detalle;

    public int getPedidoNum() {
        return pedidoNum;
    }

    public void setPedidoNum(int pedidoNum) {
        this.pedidoNum = pedidoNum;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getEstatusEnvio() {
        return estatusEnvio;
    }

    public void setEstatusEnvio(String estatusEnvio) {
        this.estatusEnvio = estatusEnvio;
    }

    public String getFechaPed() {
        return fechaPed;
    }

    public void setFechaPed(String fechaPed) {
        this.fechaPed = fechaPed;
    }

    public String getFechaEntre() {
        return fechaEntre;
    }

    public void setFechaEntre(String fechaEntre) {
        this.fechaEntre = fechaEntre;
    }

    public String getPedidoTipo() {
        return pedidoTipo;
    }

    public void setPedidoTipo(String pedidoTipo) {
        this.pedidoTipo = pedidoTipo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public ArrayList<PedidoDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<PedidoDetalle> detalle) {
        this.detalle = detalle;
    }
    
}
