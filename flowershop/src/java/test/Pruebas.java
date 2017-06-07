/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bean.Carrito;
import bean.Cliente;
import bean.Direccion;
import bean.Imagen;
import bean.Pedido;
import bean.Producto;
import dao.ClienteDAO;
import dao.ConexionDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import java.util.ArrayList;

/**
 *
 * @author gama
 */
public class Pruebas {
    
    private static ConexionDAO con;
    
    private static Cliente pruebaCliente() {
        ClienteDAO clienteDAO = new ClienteDAO(con);
        Cliente cliente = new Cliente();
        cliente.setNombre("Erick Javier Sánchez Gama");
        cliente.setEmail("ejsanchezg96@gmail.com");
        cliente.setPassword("$0yB4tmaN");
        cliente.setMobile("5564464915");
        cliente.setTelefono("6767676767");
        cliente = clienteDAO.registraCliente(cliente);
        System.out.println("cliente datos: ");
        System.out.println(cliente.toString());
        cliente = clienteDAO.inicioSesion("ejsanchezg96@gmail.com", "$0yB4tmaN");
        System.out.println(cliente.toString());
        return cliente;
    }
    
    private static void  pruebaProducto() {
        //lalal
    }
    
    private static Carrito pruebaCarrito() {
        Carrito carrito = new Carrito();
        Producto producto = new Producto();
        producto.setProdNum("CHO-HER-919");
        producto.setPiezas(10);
        producto.setIva(.16);
        producto.setPrecio(25);
        carrito.agregarProducto(producto);
        producto = new Producto();
        producto.setProdNum("CHO-HER-910");
        producto.setPiezas(12);
        producto.setIva(.16);
        producto.setPrecio(42);
        carrito.agregarProducto(producto);
        System.out.println(carrito.toString());
        carrito.quitarProducto(0);
        System.out.println(carrito.toString());
        producto = new Producto();
        producto.setProdNum("CHO-HER-919");
        producto.setPiezas(14);
        producto.setIva(.16);
        producto.setPrecio(1);
        carrito.agregarProducto(producto);
        producto = new Producto();
        producto.setProdNum("CHO-HER-710");
        producto.setPiezas(14);
        producto.setIva(.16);
        producto.setPrecio(1);
        carrito.agregarProducto(producto);
        carrito.setFechaEntrega("2017-05-28");
        carrito.setTipo("N");
        System.out.println(carrito.toString());
       return carrito;
    }
    
    public static Direccion pruebaDireccion(Cliente cliente) {
        Direccion dir = new Direccion();
        dir.setCliente(cliente);
        dir.setCalle("Los pinos");
        dir.setColonia("La roma");
        dir.setCiudad("Gustavo A. Madero");
        dir.setEstado("Ciudad de Mexico");
        dir.setCodPos("09090");
        dir.setContacto("Fulanito 1");
        dir.setTelefono("5576879809");
        dir.setObservaciones("fachada azul, con jardin enfrente");
        ClienteDAO clienteDAO = new ClienteDAO(con);
        dir = clienteDAO.registraDireccion(dir);
        return dir;  
    }
    
    public static Pedido pruebaPedido(Carrito carrito) {
        PedidoDAO pedDAO = new PedidoDAO(con);
        Pedido ped = new Pedido();
        ped.setPedidoNum(pedDAO.hacerPedido(carrito));
        return ped;
    }
    
    public static void main(String[] args) {
        con = new ConexionDAO("jdbc:mysql://localhost/jamaica", "root", "root");
        Cliente cliente = pruebaCliente();
        pruebaProducto();
        Carrito carrito = pruebaCarrito();
        Direccion direccion = pruebaDireccion(cliente); 
        carrito.setClienteNum(direccion.getCliente().getNumCliente());
        carrito.setDirNum(direccion.getDirNum());
        Pedido ped = pruebaPedido(carrito);
        System.out.println(ped.getPedidoNum());
    } 
}
