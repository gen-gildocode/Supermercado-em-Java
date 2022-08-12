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
public class loginbean 
{
    private String user,senha;
    private int ID;

    public loginbean() {
    }
    
    public loginbean(int ID,String user, String senha) {
        this.user = user;
        this.senha = senha;
        this.ID=ID;
    }
    public loginbean(String user, String senha) {
        this.user = user;
        this.senha = senha;
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
    
}
