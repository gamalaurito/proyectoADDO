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
public class PedidoDetalle {
    
    private int pedidoNum;
    private Producto producto;
    private double total;

    public int getPedidoNum() {
        return pedidoNum;
    }

    public void setPedidoNum(int pedidoNum) {
        this.pedidoNum = pedidoNum;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
