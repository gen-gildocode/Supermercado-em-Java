
package supermercado1.pkg0.View;

import javax.swing.JTable;
import supermercado1.pkg0.Controller.Message;
import supermercado1.pkg0.Controller.getImageBack;
import supermercado1.pkg0.Model.Bean.produtoBean;
import supermercado1.pkg0.Model.DAO.categDAO;
import supermercado1.pkg0.Model.DAO.marcaDAO;
import supermercado1.pkg0.Model.DAO.produtoDAO;
import supermercado1.pkg0.Model.DAO.unidadeDAO;

/**
 *
 * @author gildo
 */
public class novoProduto extends javax.swing.JFrame {

    /**
     * Creates new form novoProduto
     */
    private String situacao="SALVAR";
    private JTable table;
    private produtoBean pb=null;
    
    public novoProduto() 
    {
        initComponents();
        setIconImage(new getImageBack().getImage());
        new categDAO().inserirListaCat(categoria);
        new marcaDAO().inserirListaMarca(marca);
        new unidadeDAO().inserirListaMarca(unidade);
        leitor.requestFocus();
    }
    
    public novoProduto(JTable table) 
    {
        initComponents();
        setIconImage(new getImageBack().getImage());
        new categDAO().inserirListaCat(categoria);
        new marcaDAO().inserirListaMarca(marca);
        new unidadeDAO().inserirListaMarca(unidade);
        this.table=table;
        situacao="CONTROLE";leitor.requestFocus();
    }
    
    public novoProduto(JTable table,produtoBean pb) 
    {
        initComponents();
        setIconImage(new getImageBack().getImage());
        new categDAO().inserirListaCat(categoria);
        new marcaDAO().inserirListaMarca(marca);
        new unidadeDAO().inserirListaMarca(unidade);
        categoria.setSelectedItem(pb.getNomecateg());
        marca.setSelectedItem(pb.getNomemar());
        unidade.setSelectedItem(pb.getNomeun());
        nome.setText(pb.getNome());
        leitor.setText(pb.getCodigobarra());
        descricao.setText(pb.getDiscricao());
        preco.setText(pb.getPreco()+"");
        custo.setText(pb.getCusto()+"");
        estoque.setText(pb.getEstoqueDisponivel()+"");
        pesobruto.setText(pb.getPesobruto()+"");
        pliquido.setText(pb.getPesoliquido()+"");
        this.table=table;
        this.pb=pb;
        situacao="ACTUALIZAR";
        leitor.requestFocus();
    }

    public void novoProduto()
    {
        if(nome.getText().trim().isEmpty() || this.preco.getText().trim().isEmpty() || 
                custo.getText().trim().isEmpty()||estoque.getText().trim().isEmpty())
        {
            new Message().messageAlerta("preencha o(s) campo(s) em branco(s)!");
        }else
        {
            pb=new produtoBean();
            pb.setID(0);
            pb.setCodigobarra(leitor.getText());
            pb.setNome(nome.getText());
            pb.setDiscricao(descricao.getText());
            pb.setPreco(Double.valueOf(preco.getText()));
            pb.setCusto(Double.valueOf(custo.getText()));
            pb.setPesoliquido(Double.valueOf(pliquido.getText()));
            pb.setPesobruto(Double.valueOf(pesobruto.getText()));
            pb.setEstoque(Integer.valueOf(estoque.getText()));
            pb.setEstoqueDisponivel(Integer.valueOf(estoque.getText()));
            pb.setCustoTotal(pb.getEstoque()*pb.getCusto());
            pb.setPreco(Double.valueOf(preco.getText()));
            pb.setNomecateg(categoria.getSelectedItem().toString());
            pb.setNomemar(marca.getSelectedItem().toString());
            pb.setNomeun(unidade.getSelectedItem().toString());
            if(new produtoDAO().novoProduto(pb))
            {
                new Message().messageSucesso("Produto cadastrado com sucesso!!");
            }else
            {
                new Message().messageError("Verifique se o produto não está cadastrado!");
            }
        }
    }
    
    public void updateProduto()
    {
        if(nome.getText().trim().isEmpty() || this.preco.getText().trim().isEmpty() || 
                custo.getText().trim().isEmpty()||estoque.getText().trim().isEmpty())
        {
            new Message().messageAlerta("preencha o(s) campo(s) em branco(s)!");
        }else
        {
            int actual=new produtoDAO().getEstoque(pb.getID());
            int estoq=new produtoDAO().getEstoqueStart(pb.getID());
            int novo=Integer.valueOf(estoque.getText());
            if((novo)>estoq){pb.setEstoque(novo);pb.setEstoqueDisponivel(novo-actual);}
            else if((novo)<estoq){pb.setEstoque(novo);pb.setEstoqueDisponivel(novo-actual);}
            else if((novo)==estoq)pb.setEstoque(novo);pb.setEstoqueDisponivel(novo);
            pb.setCodigobarra(leitor.getText());
            pb.setNome(nome.getText());
            pb.setDiscricao(descricao.getText());
            pb.setPreco(Double.valueOf(preco.getText()));
            pb.setCusto(Double.valueOf(custo.getText()));
            pb.setPesoliquido(Double.valueOf(pliquido.getText()));
            pb.setPesobruto(Double.valueOf(pesobruto.getText()));
            pb.setCustoTotal(pb.getEstoque()*pb.getCusto());
            pb.setPreco(Double.valueOf(preco.getText()));
            pb.setNomecateg(categoria.getSelectedItem().toString());
            pb.setNomemar(marca.getSelectedItem().toString());
            pb.setNomeun(unidade.getSelectedItem().toString());
            
            if(new produtoDAO().updateProduto(pb))
            {
                new Message().messageSucesso("Produto actualizado com sucesso!!");
                new produtoDAO().getControleProduto(table);dispose(); 
            }else
            {
                new Message().messageError("Ocorreu um erro ao actualizar os dados!!");
            }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        leitor = new javax.swing.JTextField();
        categoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        marca = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        unidade = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        preco = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        custo = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        estoque = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        rSButton2 = new rojeru_san.RSButton();
        rSButton1 = new rojeru_san.RSButton();
        jLabel11 = new javax.swing.JLabel();
        pliquido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pesobruto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Produto");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Código de Barra:");

        leitor.setBackground(new java.awt.Color(255, 204, 102));
        leitor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        leitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leitorActionPerformed(evt);
            }
        });

        categoria.setBackground(new java.awt.Color(255, 204, 102));
        categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoriaMouseClicked(evt);
            }
        });
        categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Categoria:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Marca:");

        marca.setBackground(new java.awt.Color(255, 204, 102));
        marca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marcaMouseClicked(evt);
            }
        });
        marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Unidade Medida:");

        unidade.setBackground(new java.awt.Color(255, 204, 102));
        unidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unidadeMouseClicked(evt);
            }
        });
        unidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cash_60px.png"))); // NOI18N
        jLabel8.setText("Preço de Venda:");

        preco.setBackground(new java.awt.Color(255, 204, 102));
        preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        preco.setText("0.00");
        preco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Preço do Custo:");

        custo.setBackground(new java.awt.Color(255, 204, 102));
        custo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        custo.setText("0.00");
        custo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        custo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/sell_stock_48px.png"))); // NOI18N
        jLabel10.setText("Estoque do Produto:");

        estoque.setBackground(new java.awt.Color(255, 204, 102));
        estoque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        estoque.setToolTipText("");
        estoque.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoqueActionPerformed(evt);
            }
        });

        descricao.setBackground(new java.awt.Color(255, 204, 102));
        descricao.setColumns(20);
        descricao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        descricao.setRows(5);
        jScrollPane2.setViewportView(descricao);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Descricao:");

        nome.setBackground(new java.awt.Color(255, 204, 102));
        nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        rSButton2.setBackground(new java.awt.Color(0, 153, 0));
        rSButton2.setForeground(new java.awt.Color(0, 0, 0));
        rSButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/save.png"))); // NOI18N
        rSButton2.setText("SALVAR");
        rSButton2.setToolTipText("Confirmar...");
        rSButton2.setColorHover(new java.awt.Color(51, 255, 0));
        rSButton2.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        rSButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton2ActionPerformed(evt);
            }
        });

        rSButton1.setBackground(new java.awt.Color(153, 153, 153));
        rSButton1.setForeground(new java.awt.Color(0, 0, 0));
        rSButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel_48px.png"))); // NOI18N
        rSButton1.setText("CANCELAR");
        rSButton1.setColorHover(new java.awt.Color(255, 0, 0));
        rSButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Peso Liquido:");

        pliquido.setBackground(new java.awt.Color(255, 204, 102));
        pliquido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pliquido.setText("0.0");
        pliquido.setToolTipText("Digite o peso liquido");
        pliquido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pliquidoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Peso Bruto:");

        pesobruto.setBackground(new java.awt.Color(255, 204, 102));
        pesobruto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pesobruto.setText("0.0");
        pesobruto.setToolTipText("Digite o peso bruto...");
        pesobruto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesobrutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nome, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rSButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(categoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leitor, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pliquido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(pesobruto))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leitor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pesobruto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pliquido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(custo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaActionPerformed

        marca.requestFocus();
    }//GEN-LAST:event_categoriaActionPerformed

    private void categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoriaMouseClicked
        if(categoria.getItemCount()==0)
        {
            new novacategoria(categoria).setVisible(true);
        }else
        {
            System.err.println(categoria.getItemCount());
        }        
// TODO add your handling code here:
    }//GEN-LAST:event_categoriaMouseClicked

    private void marcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marcaMouseClicked

        if(marca.getItemCount()==0)
        {
            new novamarca(marca).setVisible(true);
        }else
        {
            System.err.println(marca.getItemCount());
        } 
    }//GEN-LAST:event_marcaMouseClicked

    private void unidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unidadeMouseClicked

        if(unidade.getItemCount()==0)
        {
            new novaunidade(unidade).setVisible(true);
        }else
        {
            System.err.println(unidade.getItemCount());
        } 
    }//GEN-LAST:event_unidadeMouseClicked

    private void rSButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton1ActionPerformed

        new controleproduto().setVisible(true); dispose();
    }//GEN-LAST:event_rSButton1ActionPerformed

    private void rSButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton2ActionPerformed
        if(situacao.equals("SALVAR"))
        {
            novoProduto();
        }else if(situacao.equals("CONTROLE")){
            novoProduto();
        }else if(situacao.equals("ACTUALIZAR")){
            updateProduto();
        }
        limpo();
    }//GEN-LAST:event_rSButton2ActionPerformed

    public void limpo()
    {
        nome.setText("");
        preco.setText("0.00");
        custo.setText("0.00");
        descricao.setText("");
        leitor.setText("");
        estoque.setText("");
        pesobruto.setText("0.0");
        pliquido.setText("0.0");
    }
    
    private void leitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leitorActionPerformed
        pliquido.requestFocus();
    }//GEN-LAST:event_leitorActionPerformed

    private void pliquidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pliquidoActionPerformed

        pesobruto.requestFocus();
    }//GEN-LAST:event_pliquidoActionPerformed

    private void pesobrutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesobrutoActionPerformed

        nome.requestFocus();
    }//GEN-LAST:event_pesobrutoActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed

        categoria.requestFocus();
    }//GEN-LAST:event_nomeActionPerformed

    private void marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaActionPerformed

        unidade.requestFocus();
    }//GEN-LAST:event_marcaActionPerformed

    private void unidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadeActionPerformed

        preco.requestFocus();
    }//GEN-LAST:event_unidadeActionPerformed

    private void precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoActionPerformed

        custo.requestFocus();
    }//GEN-LAST:event_precoActionPerformed

    private void estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoqueActionPerformed

        descricao.requestFocus();
    }//GEN-LAST:event_estoqueActionPerformed

    private void custoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custoActionPerformed

        estoque.requestFocus();
    }//GEN-LAST:event_custoActionPerformed

    
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
            java.util.logging.Logger.getLogger(novoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(novoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(novoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(novoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new novoProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JFormattedTextField custo;
    private javax.swing.JTextArea descricao;
    private javax.swing.JFormattedTextField estoque;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField leitor;
    private javax.swing.JComboBox<String> marca;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField pesobruto;
    private javax.swing.JTextField pliquido;
    private javax.swing.JFormattedTextField preco;
    private rojeru_san.RSButton rSButton1;
    private rojeru_san.RSButton rSButton2;
    private javax.swing.JComboBox<String> unidade;
    // End of variables declaration//GEN-END:variables
}
