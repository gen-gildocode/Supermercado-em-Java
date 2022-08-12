/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.Bean;

/**
 *
 * @author gildo
 */
public class caixaBean 
{
    private String nome;
    private int id;

    public caixaBean(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public caixaBean(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    
    
    
}
