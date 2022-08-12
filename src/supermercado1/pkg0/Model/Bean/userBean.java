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
public class userBean 
{
    private String nome,user,senha;
    private int ID;

    public userBean() {
    }

    public userBean(String nome, String user, String senha, int ID) {
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.ID = ID;
    }
    public userBean(String nome, int ID) {
        this.nome = nome;
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    

}
