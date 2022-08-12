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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import supermercado1.pkg0.Model.Bean.userBean;

/**
 *
 * @author gildo
 */
public class userDAO 
{
    private Connection bd;
    private userBean ub;
    public userDAO() 
    {
        this.bd=new ConnectionBD().getConnection();
        this.ub=null;
    }
    
    public userBean getUser(userBean bean)
    {
        String query="Select*from tbusuario where id=? or nome=?";
        boolean cont=false;
        try {
            PreparedStatement stm=this.bd.prepareStatement(query);
            stm.setInt(1, bean.getID());
            stm.setString(2, bean.getNome());
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
            System.err.println("get user error->"+e.getMessage());
        }
        return ub;
    }
    
    
    public boolean getCategoria(JTable table)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbcategoria order by id desc";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                controleCategoria(table, rs.getInt(1), rs.getString(2),rs.getBoolean(3));
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar categoria->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean getCategoria(JTable table,String pesq)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbcategoria where id like ? or nome like ?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, "%"+pesq+"%");
            stm.setString(2, "%"+pesq+"%");
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                controleCategoria(table, rs.getInt(1), rs.getString(2),rs.getBoolean(3));
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar categoria->"+e.getMessage());
        }
        
        return cont;
    }
    
    private void remove(JTable table)
    {
        DefaultTableModel dt= (DefaultTableModel) table.getModel();
        int size=table.getRowCount()-1;
        while(size>-1)
        {
            dt.removeRow(size);size--;
        }
    }
    
    private void controleCategoria(JTable table,int ID,String nome,boolean status )
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        Object[] dados={ID,nome,status};
        dt.addRow(dados);
    }
}
