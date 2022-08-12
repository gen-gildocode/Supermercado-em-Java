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
import supermercado1.pkg0.Model.Bean.clienteBean;
import supermercado1.pkg0.Model.Bean.produtoBean;
import supermercado1.pkg0.Model.Bean.userBean;

/**
 *
 * @author gildo
 */
public class clienteDAO 
{
    private Connection bd;
    private clienteBean cb=null;

    public clienteDAO() {
        this.bd=new ConnectionBD().getConnection();
    }

    public clienteBean getCb() {
        return cb;
    }
    
    public clienteBean getCliente(clienteBean bean)
    {
        String query="Select*from tbcliente where id=? or nome=?";
        boolean cont=false;
        try {
            PreparedStatement stm=this.bd.prepareStatement(query);
            stm.setInt(1, bean.getID());
            stm.setString(2, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                this.cb=new clienteBean(rs.getString(2), rs.getInt(1));
                return cb;
            }
            rs.close();
            stm.close();
        } catch (SQLException e) 
        {
            System.err.println("get cliente error->"+e.getMessage());
        }
        return cb;
    }
    
    
    public clienteBean ClienteDefault()
    {
        String query="Select id,nome from tbcliente order by id desc limit 1";
        boolean cont=false;
        try {
            PreparedStatement stm=this.bd.prepareStatement(query);
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                this.cb=new clienteBean(rs.getString(2), rs.getInt(1));
                return cb;
            }
            rs.close();
            stm.close();
        } catch (SQLException e) 
        {
            System.err.println("cliente padrao error->"+e.getMessage());
        }
        return cb;
    }
    
    public boolean getCliente(JTable table,String pesq)
    {
        remove(table);
        boolean status=false;
        String sql="select id,nome from tbcliente where id like ? or nome like ?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, "%"+pesq+"%");
            stm.setString(2, "%"+pesq+"%");
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                clienteVenda(table, rs.getInt(1), rs.getString(2));
                status=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar cliente->"+e.getMessage());
        }
        
        return status;
    
    }
    
    public boolean getCliente(JTable table)
    {
        remove(table);
        boolean status=false;
        String sql="select id,nome from tbcliente order by id desc";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                clienteVenda(table, rs.getInt(1), rs.getString(2));
                status=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar cliente->"+e.getMessage());
        }
        
        return status;
    
    }
   
    
    
    private void clienteVenda(JTable table,int ID,String nome)
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        Object[] dados={ID,nome};
        dt.addRow(dados);
    }
    
    private void remove(JTable table)
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        int size=table.getRowCount()-1;
        while(size>-1)
        {
            dt.removeRow(size);size--;
        }
       
    }
    
            
}
