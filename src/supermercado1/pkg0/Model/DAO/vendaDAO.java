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
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import supermercado1.pkg0.Model.Bean.DataHora;
import supermercado1.pkg0.Model.Bean.caixaBean;
import supermercado1.pkg0.Model.Bean.clienteBean;
import supermercado1.pkg0.Model.Bean.itensvenda;
import supermercado1.pkg0.Model.Bean.novavendaBean;
import supermercado1.pkg0.Model.Bean.produtoBean;
import supermercado1.pkg0.Model.Bean.userBean;

/**
 *
 * @author gildo
 */
public class vendaDAO 
{
    private Connection bd;
    private int ID=0;
    private clienteBean cb=null;
    private caixaBean cxb=null;
    private userBean ub=null;
    private produtoBean pb=null;
    public vendaDAO() {
        this.bd=new ConnectionBD().getConnection();
    }
    
    public int getIDVenda()
    {
        int ID=1;
        String sql="select count(id) from tbvenda";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            rs.next();
            ID=rs.getInt(1)+1;
           return ID;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return ID;
    }
    public int getIDPedido()
    {
        int ID=1;
        String sql="select count(id) from tbpedido";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            rs.next();
            ID=rs.getInt(1)+1;
           return ID;
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return ID;
    }
    
    public boolean vender(novavendaBean bean)
    {
        boolean status=false;
        String sql="insert into tbvenda values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, 0);
            stm.setString(2, bean.getSituacao());
            stm.setString(3, bean.getPagamento());
            stm.setInt(4, bean.getCliente());
            stm.setDouble(5, bean.getSubtotal());
            stm.setDouble(6, bean.getDesconto());
            stm.setDouble(7, bean.getTaxa());
            stm.setDouble(8, bean.getTotal());
            stm.setDouble(9, bean.getTroco());
            stm.setInt(10, bean.getVendedor());
            stm.setInt(11, 1);
            stm.setString(12, DataHora.dataActual());
            stm.setString(13, DataHora.Hora());
            stm.execute();
            status=true;
        } catch (SQLException e) 
        {
            System.err.println("Error vender->"+e.getMessage());
        }
        return status;
    }
    
    public boolean pedido(novavendaBean bean)
    {
        boolean status=false;
        String sql="insert into tbpedido values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, 0);
            stm.setString(2, bean.getSituacao());
            stm.setString(3, bean.getPagamento());
            stm.setInt(4, bean.getCliente());
            stm.setDouble(5, bean.getSubtotal());
            stm.setDouble(6, bean.getDesconto());
            stm.setDouble(7, bean.getTaxa());
            stm.setDouble(8, bean.getTotal());
            stm.setDouble(9, bean.getTroco());
            stm.setInt(10, bean.getVendedor());
            stm.setInt(11, 1);
            stm.setString(12, DataHora.dataActual());
            stm.setString(13, DataHora.Hora());
            stm.execute();
            status=true;
        } catch (SQLException e) 
        {
            System.err.println("Error vender->"+e.getMessage());
        }
        return status;
    }
    
    public boolean itensvender(ArrayList<itensvenda> lista)
    {
        boolean status=false;
        for(itensvenda item :lista)
        {
            String sql="insert into tbitemvenda values(?,?,?,?,?,?)";
            try {
                PreparedStatement stm=bd.prepareStatement(sql);
                stm.setInt(1, 0);
                stm.setInt(2, item.getIdprod());
                stm.setInt(3, item.getQuant());
                stm.setDouble(4, item.getPreco());
                stm.setDouble(5, item.getTotal());
                stm.setDouble(6, item.getNumvenda());
                stm.execute();
                new produtoDAO().getEstoque(item);
                status=true;
            } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        return status;
    }
    
    
    public boolean itenspedido(ArrayList<itensvenda> lista)
    {
        boolean status=false;
        for(itensvenda item :lista)
        {
            String sql="insert into tbitempedido values(?,?,?,?,?,?)";
            try {
                PreparedStatement stm=bd.prepareStatement(sql);
                stm.setInt(1, 0);
                stm.setInt(2, item.getIdprod());
                stm.setInt(3, item.getQuant());
                stm.setDouble(4, item.getPreco());
                stm.setDouble(5, item.getTotal());
                stm.setDouble(6, getIDPedido());
                stm.execute();
                status=true;
            } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        return status;
    }
    
    public boolean controlevenda(JTable table)
    {
        remove(table);
        boolean status=false;
        String sql="select*from tbvenda order by id desc";
        novavendaBean bean=new novavendaBean();
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                cb=new clienteBean("", rs.getInt(4));
                cb=new clienteDAO().getCliente(cb);
                ub=new userBean("", rs.getInt(10));
                ub=new userDAO().getUser(ub);
                cxb=new caixaBean("", rs.getInt(11));
                cxb=new caixaDAO().getCaixa(cxb);
                
                controletable(table,rs.getInt(1),rs.getString(2),rs.getString(3),cb.getNome(),
                        rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),
                        rs.getDouble(9),ub.getNome(),cxb.getNome(),rs.getString(12),rs.getString(13));
            }
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    
    //pesquisar vendas pela data
    public boolean controlevenda(JTable table,String data,String data2)
    {
        remove(table);
        boolean status=false;
        String sql="select*from tbvenda where data between ? and ? ";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, data);
            stm.setString(2, data2);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                cb=new clienteBean("", rs.getInt(4));
                cb=new clienteDAO().getCliente(cb);
                ub=new userBean("", rs.getInt(10));
                ub=new userDAO().getUser(ub);
                cxb=new caixaBean("", rs.getInt(11));
                cxb=new caixaDAO().getCaixa(cxb);
                
                controletable(table,rs.getInt(1),rs.getString(2),rs.getString(3),cb.getNome(),
                        rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),
                        rs.getDouble(9),ub.getNome(),cxb.getNome(),rs.getString(12),rs.getString(13));
            }
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
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
    public boolean controlevendaitens(JTable table,int venda)
    {
        boolean status=false;
        remove(table);
        String sql="select*from tbitemvenda where venda=? order by id desc";
        novavendaBean bean=new novavendaBean();
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, venda);
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                pb=new produtoBean("", rs.getInt(2));
                pb=new produtoDAO().getProduto(pb);
                controletableitens(table,rs.getInt(1),pb.getNome(),
                        rs.getInt(3),rs.getDouble(4),rs.getDouble(5));
            }
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    private void controletable(JTable table,int ID,String status,String pagamento,String cliente,double subtotal,
            double desc,double taxa,double total,double troco,String vendedor,String caixa,String data,String hora)
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        Object[] dado={ID,status,data,hora,cliente,pagamento,subtotal,desc,taxa,total,troco,vendedor,caixa};
        dt.addRow(dado);
    }
    private void controletableitens(JTable table,int ID,String produto,int quant,
            double preco,double total)
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        Object[] dado={ID,produto,quant,preco,total};
        dt.addRow(dado);
    }
}
