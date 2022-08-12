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
import supermercado1.pkg0.Model.Bean.categBean;

/**
 *
 * @author gildo
 */
public class categDAO 
{
    private Connection bd=null;
    private JComboBox listacat=null;

    public categDAO() 
    {
        this.bd=new ConnectionBD().getConnection();
    }
    
    public boolean novaCategoria(categBean bean)
    {
        boolean cont=false;
        String sql="insert into tbcategoria values(?,?,?)";
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
            System.out.println("Categoria nova error->"+e.getMessage());
        }
        return cont;
    }
    
    public boolean uptadeCategoria(categBean bean)
    {
        boolean cont=false;
        String sql="update tbcategoria set nome=?, status=? where id=?";
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
            System.out.println("Categoria update error->"+e.getMessage());
        }
        return cont;
    }
    
    public boolean deleteCategoria(int ID)
    {
        boolean cont=false;
        int actual=0;
        String sql="delete from tbcategoria where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, ID);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Erro ao apagar categoria->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean jaExiste(categBean bean)
    {
        boolean cont=false;
        String sql="select nome from tbcategoria where nome=?";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            stm.setString(1, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next()) cont=true;
        } catch (Exception e) 
        {
            System.out.println("Categoria nova error->"+e.getMessage());
        }
        return cont;
    }
    
    public void inserirListaCat(JComboBox lista)
    {
        this.listacat=lista;
        String sql="select nome from tbcategoria";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                this.listacat.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Categoria Combox error->"+e.getMessage());
        }
    }
    
    public categBean get(categBean bean)
    {
        boolean cont=false;
        String sql="select nome,id from tbcategoria where id=? or nome=?";
        try {
            PreparedStatement stm=this.bd.prepareStatement(sql);
            stm.setInt(1, bean.getID());
            stm.setString(2, bean.getNome());
            ResultSet rs=stm.executeQuery();
            categBean cb=new categBean();
            if(rs.next()) {
                cb.setNome(rs.getString(1));
                cb.setID(rs.getInt(2));
            }
            return cb;
        } catch (Exception e) 
        {
            System.out.println("get Categoria error->"+e.getMessage());
        }
        return null;
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
