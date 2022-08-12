/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.View;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import supermercado1.pkg0.Controller.Message;
import supermercado1.pkg0.Controller.getImageBack;
import supermercado1.pkg0.Model.Bean.clienteBean;
import supermercado1.pkg0.Model.Bean.itensvenda;
import supermercado1.pkg0.Model.Bean.novavendaBean;
import supermercado1.pkg0.Model.Bean.produtoBean;
import supermercado1.pkg0.Model.Bean.userBean;
import supermercado1.pkg0.Model.DAO.clienteDAO;
import supermercado1.pkg0.Model.DAO.produtoDAO;
import supermercado1.pkg0.Model.DAO.taxaDAO;
import supermercado1.pkg0.Model.DAO.vendaDAO;

/**
 *
 * @author gildo
 */
public class novaVenda extends javax.swing.JFrame {

    /**
     * Creates new form novaVenda
     */
    private int quant=1,ID=0,estoq=0,prodestoque=0,vendanum=1,cliente=1;
    private final int vendedor;
    private double totalprod=0,prodpreco=0,subtotal=0,totalpagar=0,taxa=0,Taxa=0,desconto=0;
    private String prodnome="",prodleitor="",ref,tipo=" Venda";
    private ArrayList<itensvenda> listaprod;
    private produtoBean pd=null;
    private final userBean user;
    private clienteBean cb=new clienteDAO().ClienteDefault();
    
    public novaVenda() 
    {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(new getImageBack().getImage());
        listaprod=new ArrayList<itensvenda>();
        this.vendanum=new vendaDAO().getIDVenda();
        this.user=null;cliente=cb.getID();
        pesqcliente.setText(cb.getNome());
        Taxa=new taxaDAO().getValorTaxa();
        if(Taxa==0) ptaxa.setVisible(false);
        vendedor=1;
    }
    
    public novaVenda(userBean user) 
    {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(new getImageBack().getImage());
        listaprod=new ArrayList<itensvenda>();
        this.vendanum=new vendaDAO().getIDVenda();
        this.user=user;
        if(this.user==null){dispose();}
        this.vendedor=this.user.getID();
        Luser.setText(this.user.getNome());
        cliente=cb.getID();
        pesqcliente.setText(cb.getNome());
        Taxa=new taxaDAO().getValorTaxa();
        if(Taxa==0) ptaxa.setVisible(false);
    }

    public void addprod(itensvenda item)
    {
        listaprod.add(item);
    }
    
    public void remove(int ID)
    {
        subtotal=Double.valueOf(cpsubtotal.getText());
        subtotal-=listaprod.get(ID).getTotal();
        cpsubtotal.setText(subtotal+"");
        if(chtaxa.isSelected()){
            taxa=subtotal*Taxa/100;
            cptaxa.setText(""+taxa);
            this.totalpagar=subtotal+taxa-desconto;
            cptotal.setText(totalpagar+"");
        }else{
            this.totalpagar=subtotal-desconto;
            cptotal.setText(totalpagar+"");
        }
        listaprod.remove(ID);
    }
    
    public int verificarEstoque(String nome)
    {
        int size=0;
        while(listaprod.size()>size)
        {
            if(listaprod.get(size).getProduto().equals(nome))
            {
                return listaprod.get(size).getQuant();
            }
            size++;
        }
        return 0;
    }
    
    private boolean verificar(int size,String nome)
    {
        if(listaprod.get(size).getProduto().equals(nome))
        {
            int quant=(int) tableitens.getValueAt(size, 3);
            double total=(double) tableitens.getValueAt(size, 4);
            tableitens.setValueAt(quant+this.quant, size, 3);
            tableitens.setValueAt(total+this.totalprod, size, 4);
            listaprod.get(size).setQuant(quant+this.quant);
            listaprod.get(size).setTotal(total+this.totalprod);
            subtotal+=totalprod;
            cpsubtotal.setText(subtotal+"");
            if(chtaxa.isSelected())
            {
                taxa=subtotal*Taxa/100;
                cptaxa.setText(""+taxa);
                this.totalpagar=subtotal+taxa-desconto;
                cptotal.setText(totalpagar+"");
            }else
            {
                this.totalpagar=subtotal-desconto;
                cptotal.setText(totalpagar+"");
            }
            pesq.requestFocus();
            return true;
            
        }else return false;
    }
    
    
    public boolean Existe(String nome)
    {
        int size=listaprod.size();
        boolean status=false;
        if(size==0){addItens(); return true;}
        else if(size>0)
        {
            while(status==false && size>0)
            {
                size--;
                status=verificar(size, nome);
                
            }
        }
        return status;
    }
    
    public void Alterar(int linha)
    {
        int novaquant=0,quant=(int) tableitens.getValueAt(linha, 3);
        
        try 
        {
            novaquant=Integer.valueOf(JOptionPane.showInputDialog(null,"Actual="+quant+
                    "\nNova Quantidade", "Alterar a Quantidade", JOptionPane.QUESTION_MESSAGE));
            if(novaquant<quant)
            {
                double preco=(double) tableitens.getValueAt(linha, 2);
                tableitens.setValueAt((quant-novaquant), linha, 3);
                tableitens.setValueAt(preco*(quant-novaquant), linha, 4);
                listaprod.get(linha).setQuant((quant-novaquant));
                listaprod.get(linha).setTotal(preco*(quant-novaquant));
                subtotal-=(novaquant)*preco;
                cpsubtotal.setText(subtotal+"");
                if(chtaxa.isSelected())
                {
                    taxa=subtotal*Taxa/100;
                    cptaxa.setText(""+taxa);
                    this.totalpagar=subtotal+taxa-desconto;
                    cptotal.setText(totalpagar+"");
                }else
                {
                    this.totalpagar=subtotal-desconto;
                    cptotal.setText(totalpagar+"");
                }
            }else if(novaquant>quant)
            {
                double preco=(double) tableitens.getValueAt(linha, 2);
                tableitens.setValueAt((quant+novaquant), linha, 3);
                tableitens.setValueAt(preco*(quant+novaquant), linha, 4);
                listaprod.get(linha).setQuant((quant+novaquant));
                listaprod.get(linha).setTotal(preco*(quant+novaquant));
                subtotal+=(quant+novaquant)*preco;
                cpsubtotal.setText(subtotal+"");
                if(chtaxa.isSelected())
                {
                    taxa=subtotal*Taxa/100;
                    cptaxa.setText(""+taxa);
                    this.totalpagar=subtotal+taxa-desconto;
                    cptotal.setText(totalpagar+"");
                }else
                {
                    this.totalpagar=subtotal-desconto;
                    cptotal.setText(totalpagar+"");
                }
            }else if(novaquant<=0){novaquant=0;}
            
        } catch (Exception e) 
        {
            novaquant=0;
        }
        
    }
    
    
    public void filtro(String pesq)
    {
        int estoque=0;
        pd=new produtoDAO().getvendaitem(pesq);
        if(pd!=null)
        {
            if(pd.getNome()==null)
            {
                limparproduto();
            }else
            {
                estoque=verificarEstoque(pd.getNome());
                if(pd.getEstoqueDisponivel()<=0) {
                    pd=null; new Message().messageAlerta("Estoque Esgotado!!!");
                    pd=null;
                }
                else if(pd!=null &&(pd.getEstoqueDisponivel()-estoque)>0){
                    
                    prodpreco=pd.getPreco();
                    totalprod=prodpreco*quant;
                    ID=pd.getID();
                    prodleitor=pd.getCodigobarra();
                    prodestoque=pd.getEstoqueDisponivel();
                    prodnome=pd.getNome();
                    leitor.setText(prodleitor+"");
                    nome.setText(prodnome);
                    this.estoque.setText(prodestoque-estoque+"");
                    preco.setText("$ "+prodpreco);
                    total.setText("$ "+totalprod);
                    quan.setText(quant+"");
                    estoq=pd.getEstoqueDisponivel()-estoque;
                    try {
                    int numero=Integer.valueOf(this.pesq.getText());
                    quan.requestFocus();
                    } catch (Exception e) {
                    }
                }
                
            }
            
        }else limparproduto2();
    }
    
    public void addItens()
    {
        DefaultTableModel dt=(DefaultTableModel) tableitens.getModel();
        Object dado[]={ID,prodnome,prodpreco,quant,totalprod};
        dt.addRow(dado);
        if(pd!=null)
        {
            subtotal+=totalprod;
            cpsubtotal.setText(subtotal+"");
            if(chtaxa.isSelected())
            {
                taxa=subtotal*Taxa/100;
                cptaxa.setText(""+taxa);
                this.totalpagar=subtotal+taxa-desconto;
                cptotal.setText(totalpagar+"");
            }else
            {
                this.totalpagar=subtotal-desconto;
                cptotal.setText(totalpagar+"");
            }
            
            listaprod.add(new itensvenda(ID, quant, prodpreco, totalprod, prodnome,vendanum));
            pd=null;
            pesq.requestFocus();
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSButton5 = new rojeru_san.RSButton();
        jPanel2 = new javax.swing.JPanel();
        pesq = new rojeru_san.RSMTextFull();
        jLabel4 = new javax.swing.JLabel();
        quan = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JFormattedTextField();
        rSButton1 = new rojeru_san.RSButton();
        jPanel3 = new javax.swing.JPanel();
        prodvenda = new rojerusan.RSButtonPane();
        jLabel12 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        leitor = new javax.swing.JTextField();
        estoque = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        preco = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableitens = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Luser = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cpdesc = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        rSButton3 = new rojeru_san.RSButton();
        cpsubtotal = new javax.swing.JFormattedTextField();
        rSButton4 = new rojeru_san.RSButton();
        ptaxa = new javax.swing.JPanel();
        cptaxa = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        chtaxa = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pesqcliente = new rojeru_san.RSMTextFull();
        rSButton = new rojeru_san.RSButton();
        btdesc = new rojeru_san.RSButton();
        jPanel5 = new javax.swing.JPanel();
        cptotal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Venda");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        rSButton5.setBackground(new java.awt.Color(0, 51, 51));
        rSButton5.setText("Concluir");
        rSButton5.setToolTipText("Finalizar Venda...");
        rSButton5.setColorHover(new java.awt.Color(0, 153, 153));
        rSButton5.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pesq.setBackground(new java.awt.Color(255, 204, 102));
        pesq.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        pesq.setForeground(new java.awt.Color(0, 0, 0));
        pesq.setToolTipText("pesquisar produtos...");
        pesq.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        pesq.setBordeColorNoFocus(new java.awt.Color(204, 204, 0));
        pesq.setBotonColor(new java.awt.Color(255, 0, 0));
        pesq.setFocusCycleRoot(true);
        pesq.setFocusTraversalPolicyProvider(true);
        pesq.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        pesq.setPlaceholder("pesquisar produto pelo código ou descrição...");
        pesq.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                pesqInputMethodTextChanged(evt);
            }
        });
        pesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqActionPerformed(evt);
            }
        });
        pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Quant.");

        quan.setBackground(new java.awt.Color(255, 204, 102));
        quan.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        quan.setToolTipText("Digite a quantidade...");
        quan.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        quan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanActionPerformed(evt);
            }
        });
        quan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quanKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/search_48px.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total:");

        total.setEditable(false);
        total.setBackground(new java.awt.Color(255, 204, 153));
        total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        total.setToolTipText("Total...");
        total.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        rSButton1.setBackground(new java.awt.Color(255, 255, 255));
        rSButton1.setBorder(null);
        rSButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/enter_key_48px.png"))); // NOI18N
        rSButton1.setToolTipText("Adicionar produto ");
        rSButton1.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton1.setColorText(new java.awt.Color(0, 0, 0));
        rSButton1.setColorTextHover(new java.awt.Color(0, 0, 0));
        rSButton1.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        rSButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pesq, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quan, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        prodvenda.setBackground(new java.awt.Color(255, 255, 255));
        prodvenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        prodvenda.setColorHover(new java.awt.Color(255, 255, 255));
        prodvenda.setColorNormal(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Descrição:");

        nome.setEditable(false);
        nome.setBackground(new java.awt.Color(255, 204, 153));
        nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nome.setToolTipText("nome do produto...");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Código:");

        leitor.setEditable(false);
        leitor.setBackground(new java.awt.Color(255, 204, 153));
        leitor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        leitor.setToolTipText("codigo de barra...");

        estoque.setEditable(false);
        estoque.setBackground(new java.awt.Color(255, 204, 153));
        estoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        estoque.setToolTipText("ID do produto...");
        estoque.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("Estoque:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Preço:");

        preco.setEditable(false);
        preco.setBackground(new java.awt.Color(255, 204, 153));
        preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        preco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        preco.setToolTipText("preço do produto...");
        preco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout prodvendaLayout = new javax.swing.GroupLayout(prodvenda);
        prodvenda.setLayout(prodvendaLayout);
        prodvendaLayout.setHorizontalGroup(
            prodvendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodvendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prodvendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prodvendaLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leitor))
                    .addGroup(prodvendaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nome))
                .addContainerGap())
        );
        prodvendaLayout.setVerticalGroup(
            prodvendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodvendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prodvendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prodvendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(leitor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(prodvendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(preco, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableitens.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tableitens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preco", "Quantidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableitens.setFillsViewportHeight(true);
        tableitens.setGridColor(new java.awt.Color(0, 51, 51));
        tableitens.setRowHeight(45);
        tableitens.setSelectionBackground(new java.awt.Color(255, 204, 102));
        tableitens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableitensMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableitens);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setText("ITENS DE VENDA");
        jLabel15.setToolTipText("Subtotal...");
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prodvenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 913, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(prodvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Vendedor:");

        Luser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Luser.setText("Administrador");
        Luser.setToolTipText("Nome do vendedor...");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Subtotal:");
        jLabel6.setToolTipText("Subtotal...");
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        cpdesc.setEditable(false);
        cpdesc.setBackground(new java.awt.Color(255, 204, 153));
        cpdesc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        cpdesc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cpdesc.setText("0.00");
        cpdesc.setToolTipText("Subtotal ...");
        cpdesc.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        cpdesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpdescMouseClicked(evt);
            }
        });
        cpdesc.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cpdescInputMethodTextChanged(evt);
            }
        });
        cpdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpdescActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel9.setText("Desconto:");
        jLabel9.setToolTipText("Subtotal...");
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        rSButton3.setBackground(new java.awt.Color(0, 51, 51));
        rSButton3.setText("Apagar");
        rSButton3.setToolTipText("Apagar o item...");
        rSButton3.setColorHover(new java.awt.Color(0, 102, 102));
        rSButton3.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton3ActionPerformed(evt);
            }
        });

        cpsubtotal.setEditable(false);
        cpsubtotal.setBackground(new java.awt.Color(255, 204, 153));
        cpsubtotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        cpsubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cpsubtotal.setText("0.00");
        cpsubtotal.setToolTipText("Subtotal ...");
        cpsubtotal.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N

        rSButton4.setBackground(new java.awt.Color(0, 51, 51));
        rSButton4.setText("Alterar");
        rSButton4.setToolTipText("Alterar quantidade..");
        rSButton4.setColorHover(new java.awt.Color(0, 102, 102));
        rSButton4.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton4ActionPerformed(evt);
            }
        });

        ptaxa.setBackground(new java.awt.Color(255, 255, 255));

        cptaxa.setEditable(false);
        cptaxa.setBackground(new java.awt.Color(255, 204, 153));
        cptaxa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        cptaxa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cptaxa.setText("0.00");
        cptaxa.setToolTipText("Subtotal ...");
        cptaxa.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setText("Taxa:");
        jLabel10.setToolTipText("Subtotal...");
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        chtaxa.setBackground(new java.awt.Color(255, 255, 255));
        chtaxa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chtaxa.setSelected(true);
        chtaxa.setText("aplicar taxa de IVA");
        chtaxa.setToolTipText("aplicar o valor da taxa");
        chtaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chtaxaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ptaxaLayout = new javax.swing.GroupLayout(ptaxa);
        ptaxa.setLayout(ptaxaLayout);
        ptaxaLayout.setHorizontalGroup(
            ptaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ptaxaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ptaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cptaxa)
                    .addGroup(ptaxaLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chtaxa, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ptaxaLayout.setVerticalGroup(
            ptaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ptaxaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ptaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chtaxa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cptaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel16.setText("Cliente:");
        jLabel16.setToolTipText("Subtotal...");
        jLabel16.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        pesqcliente.setEditable(false);
        pesqcliente.setBackground(new java.awt.Color(255, 204, 102));
        pesqcliente.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        pesqcliente.setForeground(new java.awt.Color(0, 0, 0));
        pesqcliente.setText("CONSUMIDOR");
        pesqcliente.setToolTipText("cliente");
        pesqcliente.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        pesqcliente.setBordeColorNoFocus(new java.awt.Color(204, 204, 0));
        pesqcliente.setBotonColor(new java.awt.Color(255, 0, 0));
        pesqcliente.setFocusCycleRoot(true);
        pesqcliente.setFocusTraversalPolicyProvider(true);
        pesqcliente.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        pesqcliente.setPlaceholder("pesquisar cliente...");
        pesqcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqclienteActionPerformed(evt);
            }
        });
        pesqcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqclienteKeyReleased(evt);
            }
        });

        rSButton.setBackground(new java.awt.Color(0, 51, 51));
        rSButton.setBorder(null);
        rSButton.setForeground(new java.awt.Color(0, 0, 0));
        rSButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/find_user_male_48px.png"))); // NOI18N
        rSButton.setColorHover(new java.awt.Color(0, 153, 153));
        rSButton.setColorText(new java.awt.Color(0, 0, 0));
        rSButton.setColorTextHover(new java.awt.Color(0, 0, 0));
        rSButton.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(pesqcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pesqcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap())
        );

        btdesc.setBackground(new java.awt.Color(0, 51, 51));
        btdesc.setBorder(null);
        btdesc.setForeground(new java.awt.Color(0, 0, 0));
        btdesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/discount_48px.png"))); // NOI18N
        btdesc.setColorHover(new java.awt.Color(0, 153, 153));
        btdesc.setColorText(new java.awt.Color(0, 0, 0));
        btdesc.setColorTextHover(new java.awt.Color(0, 0, 0));
        btdesc.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btdesc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ptaxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpsubtotal)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rSButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rSButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Luser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cpdesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cpdesc)
                    .addComponent(btdesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ptaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Luser, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cptotal.setEditable(false);
        cptotal.setBackground(new java.awt.Color(255, 204, 153));
        cptotal.setForeground(new java.awt.Color(0, 51, 153));
        cptotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        cptotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cptotal.setText("0.00");
        cptotal.setToolTipText("Total a pagar");
        cptotal.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 255));
        jLabel7.setText("Total:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cptotal, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(cptotal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton5ActionPerformed

        desconto=Double.valueOf(cpdesc.getText()+" ");
        subtotal=Double.valueOf(cpsubtotal.getText()+" ");
        totalpagar=Double.valueOf(cptotal.getText()+" ");
        taxa=Double.valueOf(cptaxa.getText()+" ");
        novavendaBean nvb=new novavendaBean(desconto, taxa, subtotal,
                totalpagar, vendanum, vendedor, cliente,pesq.getText());
        if(tableitens.getRowCount()>0)
        {
            new vendaFinalizar(nvb, listaprod).setVisible(true);dispose();
        }else
        {
            new Message().messageAlerta("Sem produtos para vender!!");
        }
        
    }//GEN-LAST:event_rSButton5ActionPerformed

    private void chtaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chtaxaActionPerformed
        
        desconto=Double.valueOf(cpdesc.getText());
        if(chtaxa.isSelected())
        {
            taxa=(subtotal-desconto)*Taxa/100;
            cptaxa.setText(""+taxa); 
            this.totalpagar=subtotal+taxa;
            cptotal.setText(this.totalpagar+"");
        }else {
            this.cptaxa.setText("0.00");
            this.totalpagar=subtotal-desconto; 
            cptotal.setText(this.totalpagar+"");
            taxa=0;
        }
    }//GEN-LAST:event_chtaxaActionPerformed

    private void cpdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpdescActionPerformed

        
    }//GEN-LAST:event_cpdescActionPerformed

    private void cpdescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpdescMouseClicked
        
    }//GEN-LAST:event_cpdescMouseClicked

    private void pesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqActionPerformed
        if(pesq.getText().trim().isEmpty()){pesq.requestFocus();}
        else quan.requestFocus();
    }//GEN-LAST:event_pesqActionPerformed

    private void pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqKeyReleased
        
        if(!pesq.getText().trim().isEmpty())
        {
            filtro(pesq.getText());
        }else limparproduto2();
        
    }//GEN-LAST:event_pesqKeyReleased

    private void quanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanActionPerformed

        if(pd!=null ) {
            if(!Existe(prodnome)){addItens();}
        }
        limparproduto();
    }//GEN-LAST:event_quanActionPerformed

    private void quanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quanKeyReleased
        double preco=this.prodpreco,total=this.totalprod;
        int quant=this.quant;
        try 
        {
            quant=Integer.valueOf(quan.getText());
            if(estoq>=quant)
            {
               total=quant*preco;
               this.total.setText("$"+total);
               this.totalprod=total;
               this.quant=quant;
            }
            else new Message().messageError("Sem Estoque Disponível!!"); quan.requestFocus();
        } catch (Exception e) 
        {
            quant=this.quant;
            total=this.totalprod=quant*preco;
            quan.setText("");
            this.total.setText("");
        }
    }//GEN-LAST:event_quanKeyReleased

    private void rSButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton1ActionPerformed
        if(pd!=null) {
            if(!Existe(prodnome)){addItens();}
        } 
        limparproduto();
    }//GEN-LAST:event_rSButton1ActionPerformed

    private void cpdescInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cpdescInputMethodTextChanged

        new Message().messageSucesso("Texto");
                
    }//GEN-LAST:event_cpdescInputMethodTextChanged

    private void tableitensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableitensMouseClicked
        
    }//GEN-LAST:event_tableitensMouseClicked

    private void rSButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton3ActionPerformed

        if(tableitens.isRowSelected(tableitens.getSelectedRow()))
        {
            remove(tableitens.getSelectedRow());
            DefaultTableModel dt=(DefaultTableModel) tableitens.getModel();
            dt.removeRow(tableitens.getSelectedRow());
        }else new Message().messageAlerta("Selecione a linha que deseja remover!!");
    }//GEN-LAST:event_rSButton3ActionPerformed

    private void rSButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton4ActionPerformed
        if(tableitens.isRowSelected(tableitens.getSelectedRow()))
        {
            Alterar(tableitens.getSelectedRow());
        }else new Message().messageAlerta("Selecione a linha que deseja alterar!!");
    }//GEN-LAST:event_rSButton4ActionPerformed

    private void pesqclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqclienteActionPerformed

    private void pesqclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqclienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pesqclienteKeyReleased

    private void rSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonActionPerformed

    private void btdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdescActionPerformed
        float taxa=0;
        if(chtaxa.isSelected())
        {
            taxa=Float.valueOf(cptaxa.getText()); 
        }
        desconto desc =new desconto(cpsubtotal, taxa, cptotal, chtaxa.isSelected(),cpdesc,cptaxa);
        desc.setVisible(true);
    }//GEN-LAST:event_btdescActionPerformed

    private void pesqInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_pesqInputMethodTextChanged
        System.out.println("Sim");
    }//GEN-LAST:event_pesqInputMethodTextChanged

    public void limparproduto()
    {
        preco.setText("");
        total.setText("");
        quan.setText("");
        nome.setText("");
        leitor.setText("");
        estoque.setText("");
        pesq.setText("");
        quant=1;
    }
    
    public void limparproduto2()
    {
        preco.setText("");
        total.setText("");
        quan.setText("");
        nome.setText("");
        leitor.setText("");
        estoque.setText("");
        quant=1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(novaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(novaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(novaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(novaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new novaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Luser;
    private rojeru_san.RSButton btdesc;
    private javax.swing.JCheckBox chtaxa;
    private javax.swing.JFormattedTextField cpdesc;
    private javax.swing.JFormattedTextField cpsubtotal;
    private javax.swing.JFormattedTextField cptaxa;
    private javax.swing.JFormattedTextField cptotal;
    private javax.swing.JFormattedTextField estoque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField leitor;
    private javax.swing.JTextField nome;
    private rojeru_san.RSMTextFull pesq;
    private rojeru_san.RSMTextFull pesqcliente;
    private javax.swing.JFormattedTextField preco;
    private rojerusan.RSButtonPane prodvenda;
    private javax.swing.JPanel ptaxa;
    private javax.swing.JFormattedTextField quan;
    private rojeru_san.RSButton rSButton;
    private rojeru_san.RSButton rSButton1;
    private rojeru_san.RSButton rSButton3;
    private rojeru_san.RSButton rSButton4;
    private rojeru_san.RSButton rSButton5;
    private javax.swing.JTable tableitens;
    private javax.swing.JFormattedTextField total;
    // End of variables declaration//GEN-END:variables
}
