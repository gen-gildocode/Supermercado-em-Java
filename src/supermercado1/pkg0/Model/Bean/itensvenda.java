/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.Bean;

import java.util.ArrayList;

/**
 *
 * @author gildo
 */
public class itensvenda 
{
    private int idprod,quant,numvenda;
    private double preco,total;
    private String produto;

    public itensvenda() 
    {
    }

    public itensvenda(int idprod, int quant, double preco, double total, String produto,int numvenda) 
    {
        this.idprod = idprod;
        this.quant = quant;
        this.preco = preco;
        this.total = total;
        this.produto = produto;
        this.numvenda=numvenda;
    }

    public int getNumvenda() {
        return numvenda;
    }

    public void setNumvenda(int numvenda) {
        this.numvenda = numvenda;
    }

    
    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

   
    
}
