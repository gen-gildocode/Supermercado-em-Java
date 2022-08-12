/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import supermercado1.pkg0.Model.Bean.unidadeBean;

/**
 *
 * @author gildo
 */
public class unidadeDAO 
{
    private Connection bd=null;
    private JComboBox listacat=null;

    public unidadeDAO() {
        this.bd=new ConnectionBD().getConnection();
    }
    
    public boolean novaUnidade(unidadeBean bean)
    {
        boolean cont=false;
        String sql="insert into tbunidade values(?,?,?)";
        try {
            if(!jaExiste(bean))
            {
                PreparedStatement stm=this.bd.prepareStatement(sql);
                stm.setInt(1, bean.getID());
                stm.setString(2, bean.getNome());
                stm.setBoolean(3, true);
                stm.execute();
                stm.close();
                cont=true;
            }
        } catch (Exception e) 
        {
            System.out.println("Unidade nova error->"+e.getMessage());
        }
        return cont;
    }
    
    public boolean uptadeUniddae(unidadeBean bean)
    {
        boolean cont=false;
        String sql="update tbunidade set nome=?, status=? where id=?";
        try {
            if(!jaExiste(bean))
            {
                PreparedStatement stm=this.bd.prepareStatement(sql);
                stm.setInt(3, bean.getID());
                stm.setString(1, bean.getNome());
                stm.setBoolean(2, true);
                stm.execute();
                stm.close();
                cont=true;
            }
        } catch (Exception e) 
        {
            System.out.println("Unidade update error->"+e.getMessage());
        }
        return cont;
    }
    
    public boolean deleteUnidade(int ID)
    {
        boolean cont=false;
        int actual=0;
        String sql="delete from tbunidade where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, ID);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Erro ao apagar unidade->"+e.getMessage());
        }
        
        return cont;
    }
    
    
    private boolean jaExiste(unidadeBean bean)
    {
        boolean cont=false;
        String sql="select nome from tbunidade where nome=?";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            stm.setString(1, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next()) cont=true;
        } catch (Exception e) 
        {
            System.out.println("Unidade nova error->"+e.getMessage());
        }
        return cont;
    }
    
    public void inserirListaMarca(JComboBox lista)
    {
        this.listacat=lista;
        String sql="select nome from tbunidade";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                this.listacat.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("unidade Combox error->"+e.getMessage());
        }
    }
    
    public unidadeBean get(unidadeBean bean)
    {
        boolean cont=false;
        String sql="select nome,id from tbunidade where id=? or nome=?";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            stm.setInt(1, bean.getID());
            stm.setString(2, bean.getNome());
            ResultSet rs=stm.executeQuery();
            unidadeBean ub=new unidadeBean();
            if(rs.next()){
                ub.setID(rs.getInt(2));
                ub.setNome(rs.getString(1));
            }return ub;
        } catch (Exception e) 
        {
            System.out.println("get unidade error->"+e.getMessage());
        }
        return null;
    }
    
    public boolean getUnidade(JTable table)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbunidade order by id desc";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                controleCategoria(table, rs.getInt(1), rs.getString(2),rs.getBoolean(3));
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar unidade->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean getUnidade(JTable table,String pesq)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbunidade where id like ? or nome like ?";
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
            System.out.println("Erro ao carregar unidade->"+e.getMessage());
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

