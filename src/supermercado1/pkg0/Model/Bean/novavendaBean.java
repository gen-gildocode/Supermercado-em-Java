/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.Model.Bean;

/**
 *
 * @author gildo
 */
public class novavendaBean 
{
    private String pagamento,situacao,nomecliente;
    private double desconto,taxa,subtotal,troco,total;
    private int ID,vendedor,cliente;

    public novavendaBean() {
    }

    public novavendaBean(double desconto, double taxa, double subtotal, double total
            , int ID, int vendedor, int cliente,String nomecliente) {
        this.desconto = desconto;
        this.taxa = taxa;
        this.subtotal = subtotal;
        this.total = total;
        this.ID = ID;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.nomecliente=nomecliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    
    

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return getNomecliente()+"\n"+getCliente()+"\n"
                +getVendedor(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
