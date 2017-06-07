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
public class Carrito {
    private int clienteNum;                 //Numero del cliente
    private int dirNum;                     //Direccion a la que se enviara el pedido 
    private String tipo;                    //Tipo de pedido
    private String fecha;                   //fecha en la que se levanto el pedido
    private String fechaEntrega;            //fecha en la que se desea la entrega opcional
    private ArrayList<Producto> productos;  //Lista de los productos en el carrito
    private double total;                   //total del costo del carrito sin iva
    private double iva;                     //iva total del pedido
    private int totalProd;                  //total de productos en el carrito
    
    //Carrito No logueado
    public Carrito() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
        this.iva = 0.0;
        this.totalProd = 0;
    }
    
    //Carrito Logueado
    public Carrito(int clienteNum) {
        this.clienteNum = clienteNum;
        this.productos = new ArrayList<>();
        this.total = 0.0;
        this.iva = 0.0;
        this.totalProd = 0;
    }
    
    public void agregarProducto(Producto producto) {
        this.total += producto.getPrecio() * producto.getPiezas();
        this.iva += producto.getPrecio() * producto.getPiezas() * producto.getIva();
        this.productos.add(producto);
        this.totalProd++;
    }
    
    public void quitarProducto(int index) {
        if(index >= this.totalProd)
            return;
        Producto producto = this.productos.remove(index);
        this.total -= producto.getPrecio() * producto.getPiezas();
        this.iva -= producto.getPrecio() * producto.getPiezas() * producto.getIva();
        this.totalProd--;
    }
    
    public void modificarPiezasProducto(int index, int piezas) {
        if(index >= this.totalProd)
            return;
        Producto producto = this.productos.remove(index);
        this.total -= producto.getPrecio() * producto.getPiezas();
        this.iva -= producto.getPrecio() * producto.getPiezas() * producto.getIva();
        producto.setPiezas(piezas);
        this.total += producto.getPrecio() * producto.getPiezas();
        this.iva += producto.getPrecio() * producto.getPiezas() * producto.getIva();
        this.productos.add(index, producto);
    }
    
    public int getClienteNum() {
        return clienteNum;
    }

    public void setClienteNum(int clienteNum) {
        this.clienteNum = clienteNum;
    }

    public int getDirNum() {
        return dirNum;
    }

    public void setDirNum(int dirNum) {
        this.dirNum = dirNum;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    public int getTotalProd() {
        return this.totalProd;
    }
    
    public double getTotal() {
        return this.total;
    }
    
    public double getIva() {
        return this.iva;
    }
    
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }
    
    public void cleanCarrito() {
        this.productos.clear();
        this.total = 0;
        this.iva = 0;
        this.totalProd = 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Carrito de compras\n");
        s.append("total: ");
        s.append(this.total + this.iva);
        s.append("\n");
        s.append("numero de productos: ");
        s.append(this.totalProd);
        s.append("\n");
        return s.toString();
    }
}
