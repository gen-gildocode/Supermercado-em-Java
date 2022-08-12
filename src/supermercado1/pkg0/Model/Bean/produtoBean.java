/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.Bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import supermercado1.pkg0.Model.DAO.categDAO;
import supermercado1.pkg0.Model.DAO.marcaDAO;
import supermercado1.pkg0.Model.DAO.produtoDAO;
import supermercado1.pkg0.Model.DAO.unidadeDAO;

/**
 *
 * @author gildo
 */
public class produtoBean 
{
    private String nome,discricao,codigobarra,nomecateg,nomemar,nomeun;
    private Date data;
    private int ID,estoque,estoqueDisponivel;
    private double pesoliquido,pesobruto,custo,custoTotal,preco;
    private boolean status;

    public produtoBean() 
    {
    }

    public produtoBean(String nome, int ID) {
        this.nome = nome;
        this.ID = ID;
    }

    public produtoBean(String nome, String discricao, String codigobarra,
            String nomecateg, String nomemar, String nomeun, int ID, 
            int estoque, double pesoliquido, double pesobruto, double custo, double preco) {
        this.nome = nome;
        this.discricao = discricao;
        this.codigobarra = codigobarra;
        this.nomecateg = nomecateg;
        this.nomemar = nomemar;
        this.nomeun = nomeun;
        this.ID = ID;
        this.estoque = estoque;
        this.pesoliquido = pesoliquido;
        this.pesobruto = pesobruto;
        this.custo = custo;
        this.preco = preco;
    }

    
    
    public produtoBean(String nome, String discricao, String codigobarra, 
            String nomecateg, String nomemar, String nomeun, int ID, 
            int estoque, int estoqueDisponivel, double pesoliquido, 
            double pesobruto, double custo, double custoTotal, double preco) {
        this.nome = nome;
        this.discricao = discricao;
        this.codigobarra = codigobarra;
        this.nomecateg = nomecateg;
        this.nomemar = nomemar;
        this.nomeun = nomeun;
        this.ID = ID;
        this.estoque = estoque;
        this.estoqueDisponivel = estoqueDisponivel;
        this.pesoliquido = pesoliquido;
        this.pesobruto = pesobruto;
        this.custo = custo;
        this.custoTotal = custoTotal;
        this.preco = preco;
    }

    public String getNomecateg() {
        return nomecateg;
    }

    public void setNomecateg(String nomecateg) {
        this.nomecateg = nomecateg;
    }

    public String getNomemar() {
        return nomemar;
    }

    public void setNomemar(String nomemar) {
        this.nomemar = nomemar;
    }

    public String getNomeun() {
        return nomeun;
    }

    public void setNomeun(String nomeun) {
        this.nomeun = nomeun;
    }

    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiscricao() {
        return discricao;
    }

    public void setDiscricao(String discricao) {
        this.discricao = discricao;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public void setEstoqueDisponivel(int estoqueDisponivel) {
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public double getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(double pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public double getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(double pesobruto) {
        this.pesobruto = pesobruto;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    

    public int getCatID()
    {
        categBean cb=new categBean(nomecateg, ID);
        categDAO cd=new categDAO();
        return cd.get(cb).getID();
    }
    
    public int getMarcaID()
    {
        System.out.println("Nome:"+nomemar);
        marcaBean mb=new marcaBean(nomemar, ID);
        marcaDAO md=new marcaDAO();
        return md.get(mb).getID();
    }
    public int getUnidadeID()
    {
        unidadeBean ub=new unidadeBean(ID,nomeun);
        unidadeDAO ud=new unidadeDAO();
        return ud.get(ub).getID();
    }
    
    public Date dataInserido()
    {
        data=new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        format.format(data);
        return data;
    }
    
    
}
