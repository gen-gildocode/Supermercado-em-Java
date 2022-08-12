/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import supermercado1.pkg0.Model.Bean.loginbean;
import supermercado1.pkg0.Model.Bean.userBean;

/**
 *
 * @author gildo
 */
public class loginDAO 
{
    private Connection bd;
    private userBean ub=null;
    public loginDAO() 
    {
        this.bd=new ConnectionBD().getConnection();
    }

    public userBean getUb() {
        return ub;
    }
    
    
    public boolean logar(loginbean bean)
    {
        String query="Select*from tbusuario where user=? and password=?";
        boolean cont=false;
        try {
            PreparedStatement stm=this.bd.prepareStatement(query);
            stm.setString(1, bean.getUser());
            stm.setString(2, bean.getSenha());
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                this.ub=new userBean(rs.getString(2), rs.getInt(1));
                cont=true;
            }
            rs.close();
            stm.close();
        } catch (SQLException e) 
        {
            System.err.println("Login error->"+e.getMessage());
        }
        
        return cont;
    }
    
    public loginbean getUser()
    {
        String query="Select user from tbusuario";
        boolean cont=false;
        try {
            PreparedStatement stm=this.bd.prepareStatement(query);
            ResultSet rs=stm.executeQuery();
            rs.next();
            loginbean bean =new loginbean(rs.getString(1),"");
            rs.close();
            stm.close();
            return bean;
        } catch (SQLException e) 
        {
            System.err.println("Login error->"+e.getMessage());
        }
        return null;
    }
}
