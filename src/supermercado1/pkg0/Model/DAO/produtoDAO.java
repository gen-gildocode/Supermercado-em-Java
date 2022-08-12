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
import supermercado1.pkg0.Model.Bean.categBean;
import supermercado1.pkg0.Model.Bean.itensvenda;
import supermercado1.pkg0.Model.Bean.marcaBean;
import supermercado1.pkg0.Model.Bean.produtoBean;
import supermercado1.pkg0.Model.Bean.unidadeBean;

/**
 *
 * @author gildo
 */
public class produtoDAO 
{
    private Connection bd;
    private produtoBean pb=null;
    public produtoDAO() 
    {
        this.bd=new ConnectionBD().getConnection();
    }
    
    public boolean novoProduto(produtoBean bean)
    {
        boolean cont=false;
        String sql="insert into tbproduto values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(!jaExiste(bean))
        {
            try {
                PreparedStatement stm=bd.prepareStatement(sql);
                stm.setInt(1, bean.getID());
                stm.setString(2, bean.getCodigobarra());
                stm.setString(3, bean.getNome());
                stm.setInt(4, bean.getCatID());
                stm.setInt(5, bean.getMarcaID());
                stm.setInt(6, bean.getUnidadeID());
                stm.setDouble(7, bean.getPesoliquido());
                stm.setDouble(8, bean.getPesobruto());
                stm.setDouble(9, bean.getCusto());
                stm.setDouble(10, bean.getCustoTotal());
                stm.setDouble(11, bean.getPreco());
                stm.setInt(12, bean.getEstoque());
                stm.setInt(13, bean.getEstoqueDisponivel());
                stm.setString(14, bean.getDiscricao());
                stm.setDate(15, bean.dataInserido());
                stm.setBoolean(16, true);
                stm.execute();
                cont=true;
            } catch (SQLException ex) {
                System.err.println("Erro novo produto->"+ex);
            }
        }
        return cont;
    }
    
    
    public boolean updateProduto(produtoBean bean)
    {
        boolean cont=false;
        String sql="update tbproduto set codigoBarra=?,nome=?,categoria=?,marca=?,unidade=?,pesoLiquido=?,pesoBruto=?"
                + ",custo=?,custoTotal=?,preco=?,estoque=?,estoqueDisponivel=?,discricao=? where id=?";
        try {
                PreparedStatement stm=bd.prepareStatement(sql);
                stm.setInt(14, bean.getID());
                stm.setString(1, bean.getCodigobarra());
                stm.setString(2, bean.getNome());
                stm.setInt(3, bean.getCatID());
                stm.setInt(4, bean.getMarcaID());
                stm.setInt(5, bean.getUnidadeID());
                stm.setDouble(6, bean.getPesoliquido());
                stm.setDouble(7, bean.getPesobruto());
                stm.setDouble(8, bean.getCusto());
                stm.setDouble(9, bean.getCustoTotal());
                stm.setDouble(10, bean.getPreco());
                stm.setInt(11, bean.getEstoque());
                stm.setInt(12, bean.getEstoqueDisponivel());
                stm.setString(13, bean.getDiscricao());
                stm.execute();
                cont=true;
            } catch (SQLException ex) {
                System.err.println("Erro update produto->"+ex);
            }
        return cont;
    }
    
    private boolean jaExiste(produtoBean bean)
    {
        boolean cont=false;
        String sql="select codigoBarra,nome from tbproduto where codigoBarra=? or nome=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, bean.getCodigobarra());
            stm.setString(2, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next()) cont=true;
        } catch (Exception e) {
            System.out.println("Erro ao verificar novo produto->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean getEstoque(itensvenda bean)
    {
        boolean cont=false;
        int actual=0;
        String sql="select estoqueDisponivel from tbproduto where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, bean.getIdprod());
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                actual=rs.getInt(1);
                ActualEstoque(bean.getIdprod(),(actual-bean.getQuant()));
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar estoque do produto->"+e.getMessage());
        }
        
        return cont;
    }
    
    public int getEstoque(int id)
    {
        boolean cont=false;
        int actual=0;
        String sql="select estoqueDisponivel from tbproduto where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                actual=rs.getInt(1);cont=true;
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao verificar estoque do produto->"+e.getMessage());
        }
        return actual;
    }
    
    public int getEstoqueStart(int id)
    {
        boolean cont=false;
        int actual=0;
        String sql="select estoque from tbproduto where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                actual=rs.getInt(1);cont=true;
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao verificar estoque do produto->"+e.getMessage());
        }
        return actual;
    }
    
    public boolean deleteProduto(int ID)
    {
        boolean cont=false;
        int actual=0;
        String sql="delete from tbproduto where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, ID);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Erro ao apagar produto->"+e.getMessage());
        }
        
        return cont;
    }
    
    private boolean ActualEstoque(int ID,int quant)
    {
        boolean cont=false;
        String sql="update tbproduto set estoqueDisponivel=? where id=?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setInt(1, quant);
            stm.setInt(2, ID);
            stm.execute();
            
        } catch (Exception e) {
            System.out.println("Erro ao verificar estoque->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean getControleProduto(JTable table)
    {
        boolean cont=false;
        String sql="select *from tbproduto";
        remove(table);
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            categBean cb=new categBean();
            marcaBean mb=new marcaBean();
            unidadeBean ub=new unidadeBean();
            produtoBean pd=new produtoBean();
            String data;
            while(rs.next())
            {
                pd.setID(rs.getInt(1));
                pd.setCodigobarra(rs.getString(2));
                pd.setNome(rs.getString(3));
                cb.setID(rs.getInt(4));
                mb.setID(rs.getInt(5));
                ub.setID(rs.getInt(6));
                pd.setPesoliquido(rs.getDouble(7));
                pd.setPesobruto(rs.getDouble(8));
                pd.setCusto(rs.getDouble(9));
                pd.setCustoTotal(rs.getDouble(10));
                pd.setPreco(rs.getDouble(11));
                pd.setEstoque(rs.getInt(12));
                pd.setEstoqueDisponivel(rs.getInt(13));
                pd.setDiscricao(rs.getString(14));
                data=rs.getString(15);
                pd.setStatus(rs.getBoolean(16));
                controleProduto(table, pd.getID(), pd.getNome(), pd.getDiscricao(),
                        pd.getCodigobarra(), new categDAO().get(cb).getNome(),
                        new marcaDAO().get(mb).getNome(),new unidadeDAO().get(ub).getNome()
                        , pd.getEstoque(), pd.getEstoqueDisponivel(), pd.getPesoliquido(), pd.getPesobruto()
                        , pd.getCusto(), pd.getCustoTotal(), pd.getPreco(), data, pd.isStatus());
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar produto->"+e.getMessage());
        }
        
        return cont;
    }
    
    public produtoBean getvendaitem(String pesq)
    {
        String sql="select *from tbproduto where id=? or codigoBarra = ?";
        produtoBean pd=new produtoBean();
        categBean cb=new categBean();
        marcaBean mb=new marcaBean();
        unidadeBean ub=new unidadeBean();
        
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, pesq);
            stm.setString(2, pesq);
            //stm.setString(3, "%"+pesq+"%");
            ResultSet rs=stm.executeQuery();
            while(rs.next())
            {
                pd.setID(rs.getInt(1));
                pd.setCodigobarra(rs.getString(2));
                pd.setNome(rs.getString(3));
                cb.setID(rs.getInt(4));
                mb.setID(rs.getInt(5));
                ub.setID(rs.getInt(6));
                pd.setPreco(rs.getDouble(11));
                pd.setEstoqueDisponivel(rs.getInt(13));
                pd.setNomecateg(new categDAO().get(cb).getNome());
                pd.setNomemar(new marcaDAO().get(mb).getNome());
                pd.setNomeun(new unidadeDAO().get(ub).getNome());
                return pd;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar produto->"+e.getMessage());
        }
        
        return pd;
    
    }
    
    public boolean getvendaProduto(JTable table,String pesq)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbproduto where id like ? or codigoBarra like ? or nome like ?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, "%"+pesq);
            stm.setString(2, "%"+pesq);
            stm.setString(3, "%"+pesq+"%");
            ResultSet rs=stm.executeQuery();
            categBean cb=new categBean();
            marcaBean mb=new marcaBean();
            unidadeBean ub=new unidadeBean();
            produtoBean pd=new produtoBean();
            while(rs.next())
            {
                pd.setID(rs.getInt(1));
                pd.setCodigobarra(rs.getString(2));
                pd.setNome(rs.getString(3));
                cb.setID(rs.getInt(4));
                mb.setID(rs.getInt(5));
                ub.setID(rs.getInt(6));
                pd.setPreco(rs.getDouble(11));
                pd.setEstoqueDisponivel(rs.getInt(13));
                vendaProduto(table, pd.getID(), pd.getNome(),
                        pd.getCodigobarra(), new categDAO().get(cb).getNome(),
                        new marcaDAO().get(mb).getNome(),new unidadeDAO().get(ub).getNome()
                        , pd.getEstoqueDisponivel(), pd.getPreco());
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar produto->"+e.getMessage());
        }
        
        return cont;
    }
    
    public boolean getcontroleProduto(JTable table,String pesq)
    {
        boolean cont=false;
        remove(table);
        String sql="select *from tbproduto where id like ? or codigoBarra like ? or nome like ?";
        try {
            PreparedStatement stm=bd.prepareStatement(sql);
            stm.setString(1, "%"+pesq+"%");
            stm.setString(2, "%"+pesq+"%");
            stm.setString(3, "%"+pesq+"%");
            ResultSet rs=stm.executeQuery();
            categBean cb=new categBean();
            marcaBean mb=new marcaBean();
            unidadeBean ub=new unidadeBean();
            produtoBean pd=new produtoBean();
            while(rs.next())
            {
                pd.setID(rs.getInt(1));
                pd.setCodigobarra(rs.getString(2));
                pd.setNome(rs.getString(3));
                cb.setID(rs.getInt(4));
                mb.setID(rs.getInt(5));
                ub.setID(rs.getInt(6));
                pd.setPesoliquido(rs.getDouble(7));
                pd.setPesobruto(rs.getDouble(8));
                pd.setCusto(rs.getDouble(9));
                pd.setCustoTotal(rs.getDouble(10));
                pd.setPreco(rs.getDouble(11));
                pd.setEstoque(rs.getInt(12));
                pd.setEstoqueDisponivel(rs.getInt(13));
                pd.setDiscricao(rs.getString(14));
                String data=rs.getString(15);
                pd.setStatus(rs.getBoolean(16));
                controleProduto(table, pd.getID(), pd.getNome(), pd.getDiscricao(),
                        pd.getCodigobarra(), new categDAO().get(cb).getNome(),
                        new marcaDAO().get(mb).getNome(),new unidadeDAO().get(ub).getNome()
                        , pd.getEstoque(), pd.getEstoqueDisponivel(), pd.getPesoliquido(), pd.getPesobruto()
                        , pd.getCusto(), pd.getCustoTotal(), pd.getPreco(), data, pd.isStatus());
                cont=true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar produto->"+e.getMessage());
        }
        
        return cont;
    }
    
    public produtoBean getProduto(produtoBean bean)
    {
        String query="Select id,nome from tbproduto where id=? or nome=?";
        boolean cont=false;
        try {
            PreparedStatement stm=this.bd.prepareStatement(query);
            stm.setInt(1, bean.getID());
            stm.setString(2, bean.getNome());
            ResultSet rs=stm.executeQuery();
            if(rs.next())
            {
                this.pb=new produtoBean(rs.getString(2), rs.getInt(1));
                return pb;
            }
            rs.close();
            stm.close();
        } catch (SQLException e) 
        {
            System.err.println("get user error->"+e.getMessage());
        }
        return pb;
    }
    
    private void controleProduto(JTable table,int ID,String nome, String descricao, String codigobarra, 
            String nomecateg, String nomemar, String nomeun, 
            int estoque, int estoqueDisponivel, double pesoliquido, 
            double pesobruto, double custo, double custoTotal, double preco,String data,boolean status )
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        Object[] dados={data,ID,codigobarra,nome,descricao,nomecateg,nomemar,nomeun,custo,
            custoTotal,preco,pesoliquido,pesobruto,estoque,estoqueDisponivel,status};
        dt.addRow(dados);
    }
    private void vendaProduto(JTable table,int ID,String nome, String codigobarra, 
            String nomecateg, String nomemar, String nomeun,
            int estoqueDisponivel,double preco )
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        Object[] dados={ID,codigobarra,nome,estoqueDisponivel,preco,nomecateg,nomemar,nomeun};
        dt.addRow(dados);
    }
    
    private void remove(JTable table)
    {
        DefaultTableModel dt=(DefaultTableModel) table.getModel();
        dt.setRowCount(0);
    }
    
    
}
