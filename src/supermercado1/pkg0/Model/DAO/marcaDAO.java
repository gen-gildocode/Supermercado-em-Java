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
import supermercado1.pkg0.Model.Bean.marcaBean;

/**
 *
 * @author gildo
 */
public class marcaDAO 
{
    private Connection bd=null;
    private JComboBox listacat=null;

    public marcaDAO() {
        this.bd=new ConnectionBD().getConnection();
    }
    
    public boolean novaMarca(marcaBean bean)
    {
        boolean cont=false;
        String sql="insert into tbmarca values(?,?,?)";
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
            System.out.println("Marca nova error->"+e.getMessage());
        }
        return cont;
    }
    
    public boolean updateMarca(marcaBean bean)
    {
        boolean cont=false;
        String sql="update tbmarca set nome=?,status=? where id=?";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            stm.setInt(3, bean.getID());
            stm.setString(1, bean.getNome());
            stm.setBoolean(2, true);
            stm.execute();
            stm.close();
            cont=true;
        } catch (Exception e) 
        {
            System.out.println("Marca update error->"+e.getMessage());
        }
        return cont;
    }
    
    public boolean deleteMarca(int ID)
    {
        boolean cont=false;
        int actual=0;
        String sql="delete from tbmarca where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, ID);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Erro ao apagar marca->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean jaExiste(marcaBean bean)
    {
        boolean cont=false;
        String sql="select nome from tbmarca where nome=?";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            stm.setString(1, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next()) cont=true;
        } catch (Exception e) 
        {
            System.out.println("Marca nova error->"+e.getMessage());
        }
        return cont;
    }
    
    public marcaBean get(marcaBean bean)
    {
        boolean cont=false;
        String sql="select nome,id from tbmarca where id=? or nome=?";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            stm.setInt(1, bean.getID());
            stm.setString(2, bean.getNome());
            ResultSet rs=stm.executeQuery();
            marcaBean mb=new marcaBean();
            if(rs.next()){
                mb.setNome(rs.getString(1));
                mb.setID(rs.getInt(2)); 
            }return mb;
            
        } catch (Exception e) 
        {
            System.out.println("Marca get error->"+e.getMessage());
        }
        return null;
    }
    
    public void inserirListaMarca(JComboBox lista)
    {
        this.listacat=lista;
        String sql="select nome from tbmarca";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                this.listacat.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Marca Combox error->"+e.getMessage());
        }
    }
    
    public boolean getMarca(JTable table)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbmarca order by id desc";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                controleCategoria(table, rs.getInt(1), rs.getString(2),rs.getBoolean(3));
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar marca->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean getMarca(JTable table,String pesq)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbmarca where id like ? or nome like ?";
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
            System.out.println("Erro ao carregar Marca->"+e.getMessage());
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
