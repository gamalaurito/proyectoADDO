/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Blob;

/**
 *
 * @author gama
 */
public class Imagen {
    
    private String prodNum;
    private int imagenNum;
    private Blob url;

    public String getProdNum() {
        return prodNum;
    }

    public void setProdNum(String prodNum) {
        this.prodNum = prodNum;
    }

    public int getImagenNum() {
        return imagenNum;
    }

    public void setImagenNum(int imagenNum) {
        this.imagenNum = imagenNum;
    }

    public Blob getUrl() {
        return url;
    }

    public void setUrl(Blob url) {
        this.url = url;
    }
    
    
    
}
