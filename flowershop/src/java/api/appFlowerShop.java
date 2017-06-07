/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author gama
 */
@WebService(serviceName = "appFlowerShop")
public class appFlowerShop {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        System.out.println("hola " + txt);
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "update")
    public String update(@WebParam(name = "pedido") String pedido, @WebParam(name = "coor") String coor) {
        return "pedido_num:"  + pedido + " en la posicion: " + coor;
    }
}
