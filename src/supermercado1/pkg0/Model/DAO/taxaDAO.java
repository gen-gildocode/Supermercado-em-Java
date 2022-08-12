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
import supermercado1.pkg0.Model.Bean.taxaBean;

/**
 *
 * @author gildo
 */
public class taxaDAO
{
    private Connection bd;
    private taxaBean tb;

    public taxaDAO() 
    {
        this.bd=new ConnectionBD().getConnection();
        this.tb=null;
    }
    
    public boolean novaTaxa(taxaBean bean)
    {
        boolean cont=false;
        String sql="insert into tbtaxa values(?,?,?,?)";
        if(!jaExiste(bean))
        {
            try {
                PreparedStatement stm=bd.prepareStatement(sql);
                stm.setInt(1, bean.getID());
                stm.setString(2, bean.getNome());
                stm.setDouble(3, bean.getTaxa());
                stm.setBoolean(4, bean.isStatus());
                stm.execute();
                cont=true;
            } catch (SQLException ex) {
                System.err.println("Erro nova taxa->"+ex);
            }
        }
        return cont;
    }
    
    
    public boolean updateTaxa(taxaBean bean)
    {
        boolean cont=false;
        String sql="update tbtaxa set nome=?, taxa=? where id=?";
        try {
                PreparedStatement stm=bd.prepareStatement(sql);
                stm.setInt(3, bean.getID());
                stm.setString(1, bean.getNome());
                stm.setDouble(2, bean.getTaxa());
                stm.setBoolean(3, true);
                stm.execute();
                cont=true;
            } catch (SQLException ex) {
                System.err.println("Erro nova taxa->"+ex);
            }
        return cont;
    }
    
    public boolean deleteTaxa(int ID)
    {
        boolean cont=false;
        int actual=0;
        String sql="delete from tbtaxa where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, ID);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Erro ao apagar taxa->"+e.getMessage());
        }
        
        return cont;
    }
    
    private boolean jaExiste(taxaBean bean)
    {
        boolean cont=false;
        String sql="select nome from tbtaxa where  nome=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next()) cont=true;
        } catch (SQLException e) {
            System.out.println("Erro ao verificar nova taxa->"+e.getMessage());
        }
        
        return cont;
    }
    
    public double getValorTaxa()
    {
        String sql="select sum(taxa) from tbtaxa where status=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setBoolean(1, true);
            ResultSet rs=stm.executeQuery();
            if(rs.next()) return rs.getDouble(1);
        } catch (SQLException e) {
            System.out.println("Erro ao carregar taxa->"+e.getMessage());
        }
        return 0.00;
    }
    
    public taxaBean getTaxa(taxaBean bean)
    {
        String sql="select id,nome from tbtaxa where id=? or nome=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(2, bean.getNome());
            stm.setInt(1, bean.getID());
            ResultSet rs=stm.executeQuery();
            if(rs.next()) return tb=new taxaBean(rs.getInt(1), rs.getString(2));
        } catch (SQLException e) {
            System.out.println("Erro ao carregar taxa->"+e.getMessage());
        }
        return tb;
    }
    
    public boolean getTaxa(JTable table)
    {
        boolean cont=false;
        //remove(table);
        String sql="select *from tbtaxa order by id desc";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                controleTaxa(table, rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getBoolean(4));
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar taxa->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean getTaxa(JTable table,String pesq)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbtaxa where id like ? or nome like ?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, "%"+pesq+"%");
            stm.setString(2, "%"+pesq+"%");
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                controleTaxa(table, rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getBoolean(4));
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar taxa->"+e.getMessage());
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
     
    private void controleTaxa(JTable table,int ID,String nome,double taxa,boolean status )
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        Object[] dados={ID,nome,taxa,status};
        dt.addRow(dados);
    }
    
    
    
}
