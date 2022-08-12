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
import supermercado1.pkg0.Model.Bean.caixaBean;
import supermercado1.pkg0.Model.Bean.clienteBean;

/**
 *
 * @author gildo
 */
public class caixaDAO
{
    private Connection bd;
    private caixaBean cb=null;

    public caixaDAO() {
        this.bd=new ConnectionBD().getConnection();
    }

    public caixaBean getCb() {
        return cb;
    }
    
    public caixaBean getCaixa(caixaBean bean)
    {
        String query="Select*from tbcaixa where id=? or nome=?";
        boolean cont=false;
        try {
            PreparedStatement stm=this.bd.prepareStatement(query);
            stm.setInt(1, bean.getId());
            stm.setString(2, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                this.cb=new caixaBean(rs.getString(2), rs.getInt(1));
                return cb;
            }
            rs.close();
            stm.close();
        } catch (SQLException e) 
        {
            System.err.println("get user error->"+e.getMessage());
        }
        return cb;
    }
    
}
