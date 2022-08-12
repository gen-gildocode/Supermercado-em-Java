
package supermercado1.pkg0.View;

import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import supermercado1.pkg0.Controller.Message;
import supermercado1.pkg0.Controller.getImageBack;
import supermercado1.pkg0.Model.Bean.produtoBean;
import supermercado1.pkg0.Model.DAO.produtoDAO;

/**
 *
 * @author gildo
 */
public class controleproduto extends javax.swing.JFrame {

    /**
     * Creates new form controleproduto
     */
    public controleproduto() {
        initComponents();
        setIconImage(new getImageBack().getImage());
        new produtoDAO().getControleProduto(table);
        paneldetalhe.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        rSButton1 = new rojeru_san.RSButton();
        rSButton2 = new rojeru_san.RSButton();
        rSButton3 = new rojeru_san.RSButton();
        rSButton4 = new rojeru_san.RSButton();
        rSButton5 = new rojeru_san.RSButton();
        rSButton6 = new rojeru_san.RSButton();
        rSButton7 = new rojeru_san.RSButton();
        jPanel5 = new javax.swing.JPanel();
        pesq = new rojeru_san.RSMTextFull();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        paneldetalhe = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Lpreco = new javax.swing.JLabel();
        Lcusto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LcustoTotal = new javax.swing.JLabel();
        LestoqueA = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LestoqueE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Produtos e Servicos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rSButton1.setBackground(new java.awt.Color(255, 255, 255));
        rSButton1.setBorder(null);
        rSButton1.setForeground(new java.awt.Color(0, 0, 0));
        rSButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/inactive_state_48px.png"))); // NOI18N
        rSButton1.setText("Inativar Produto");
        rSButton1.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton1.setColorText(new java.awt.Color(0, 0, 0));
        rSButton1.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        rSButton2.setBackground(new java.awt.Color(255, 255, 255));
        rSButton2.setBorder(null);
        rSButton2.setForeground(new java.awt.Color(0, 0, 0));
        rSButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/sell_stock_48px.png"))); // NOI18N
        rSButton2.setText("Estoque");
        rSButton2.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton2.setColorText(new java.awt.Color(0, 0, 0));
        rSButton2.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        rSButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton2ActionPerformed(evt);
            }
        });

        rSButton3.setBackground(new java.awt.Color(255, 255, 255));
        rSButton3.setBorder(null);
        rSButton3.setForeground(new java.awt.Color(0, 0, 0));
        rSButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/push_pin_48px.png"))); // NOI18N
        rSButton3.setToolTipText("efectuar promoção...");
        rSButton3.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton3.setColorText(new java.awt.Color(0, 0, 0));
        rSButton3.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton3ActionPerformed(evt);
            }
        });

        rSButton4.setBackground(new java.awt.Color(255, 255, 255));
        rSButton4.setBorder(null);
        rSButton4.setForeground(new java.awt.Color(0, 0, 0));
        rSButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/calendar_plus_48px.png"))); // NOI18N
        rSButton4.setText("Adicionar Validade");
        rSButton4.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton4.setColorText(new java.awt.Color(0, 0, 0));
        rSButton4.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        rSButton5.setBackground(new java.awt.Color(255, 255, 255));
        rSButton5.setBorder(null);
        rSButton5.setForeground(new java.awt.Color(0, 0, 0));
        rSButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"))); // NOI18N
        rSButton5.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton5.setColorText(new java.awt.Color(0, 0, 0));
        rSButton5.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton5ActionPerformed(evt);
            }
        });

        rSButton6.setBackground(new java.awt.Color(255, 255, 255));
        rSButton6.setBorder(null);
        rSButton6.setForeground(new java.awt.Color(0, 0, 0));
        rSButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add_48px.png"))); // NOI18N
        rSButton6.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton6.setColorText(new java.awt.Color(0, 0, 0));
        rSButton6.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton6ActionPerformed(evt);
            }
        });

        rSButton7.setBackground(new java.awt.Color(255, 255, 255));
        rSButton7.setBorder(null);
        rSButton7.setForeground(new java.awt.Color(0, 0, 0));
        rSButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/edit_property_48px.png"))); // NOI18N
        rSButton7.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton7.setColorText(new java.awt.Color(0, 0, 0));
        rSButton7.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(rSButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(488, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(rSButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(rSButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pesq.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        pesq.setForeground(new java.awt.Color(0, 0, 0));
        pesq.setToolTipText("pesquisar produtos...");
        pesq.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        pesq.setBordeColorNoFocus(new java.awt.Color(204, 204, 0));
        pesq.setBotonColor(new java.awt.Color(255, 0, 0));
        pesq.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        pesq.setPlaceholder("pesquisar produto pelo código ou descrição...");
        pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/search_48px.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(pesq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Entrada", "ID", "Codigo de Barra", "Nome do produto", "Descrição", "Categoria", "Marca", "Unidade", "Custo ", "Custo Total", "Preco", "Peso Liquido", "Peso Bruto", "Estoque", "Estoque Disponivel", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        table.setFillsViewportHeight(true);
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(255, 153, 102));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(200);
            table.getColumnModel().getColumn(1).setMinWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(200);
            table.getColumnModel().getColumn(3).setMinWidth(500);
            table.getColumnModel().getColumn(4).setMinWidth(600);
            table.getColumnModel().getColumn(5).setMinWidth(200);
            table.getColumnModel().getColumn(6).setMinWidth(200);
            table.getColumnModel().getColumn(7).setMinWidth(200);
            table.getColumnModel().getColumn(8).setMinWidth(200);
            table.getColumnModel().getColumn(9).setMinWidth(200);
            table.getColumnModel().getColumn(10).setMinWidth(200);
            table.getColumnModel().getColumn(11).setMinWidth(150);
            table.getColumnModel().getColumn(11).setMaxWidth(200);
            table.getColumnModel().getColumn(12).setMinWidth(150);
            table.getColumnModel().getColumn(12).setMaxWidth(200);
            table.getColumnModel().getColumn(13).setMinWidth(200);
            table.getColumnModel().getColumn(14).setMinWidth(200);
            table.getColumnModel().getColumn(15).setMinWidth(100);
            table.getColumnModel().getColumn(15).setMaxWidth(150);
        }

        paneldetalhe.setBackground(new java.awt.Color(255, 255, 255));
        paneldetalhe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DETALHES DO PRODUTO");
        jLabel2.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("PREÇO:");

        Lpreco.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Lpreco.setForeground(new java.awt.Color(0, 153, 0));
        Lpreco.setText("0.00");

        Lcusto.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Lcusto.setForeground(new java.awt.Color(0, 51, 51));
        Lcusto.setText("0.00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Custo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Custo Total:");

        LcustoTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        LcustoTotal.setForeground(new java.awt.Color(0, 51, 51));
        LcustoTotal.setText("0.00");

        LestoqueA.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        LestoqueA.setForeground(new java.awt.Color(0, 51, 51));
        LestoqueA.setText("0.00");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Estoque Actual:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Estoque de Entrada:");

        LestoqueE.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        LestoqueE.setForeground(new java.awt.Color(0, 51, 51));
        LestoqueE.setText("0.00");

        javax.swing.GroupLayout paneldetalheLayout = new javax.swing.GroupLayout(paneldetalhe);
        paneldetalhe.setLayout(paneldetalheLayout);
        paneldetalheLayout.setHorizontalGroup(
            paneldetalheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldetalheLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldetalheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lpreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lcusto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LcustoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LestoqueE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(paneldetalheLayout.createSequentialGroup()
                        .addGroup(paneldetalheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LestoqueA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneldetalheLayout.setVerticalGroup(
            paneldetalheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldetalheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lcusto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LcustoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LestoqueE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LestoqueA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneldetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(paneldetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton2ActionPerformed
        if(table.isRowSelected(table.getSelectedRow()))
        {
            new estoqueLimite().setVisible(true);
        }else
        {
            new Message().messageAlerta("Selecione o produto que deseja estabelecer limites");
        }
    }//GEN-LAST:event_rSButton2ActionPerformed

    private void rSButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton3ActionPerformed
        if(table.isRowSelected(table.getSelectedRow()))
        {
            new promocao().setVisible(true);
        }else
        {
            new Message().messageAlerta("Selecione o produto que deseja efectuar a promoção");
        }
    }//GEN-LAST:event_rSButton3ActionPerformed

    private void rSButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton5ActionPerformed
        if(table.isRowSelected(table.getSelectedRow()))
        {
            int ID=(int)table.getValueAt(table.getSelectedRow(), 1);
            new produtoDAO().deleteProduto(ID);
            DefaultTableModel dt=(DefaultTableModel) table.getModel();
            dt.removeRow(table.getSelectedRow());
            new Message().messageSucesso("Produto eliminado com sucesso!!");
        }else
        {
            new Message().messageAlerta("Selecione o produto que deseja apagar");
        }
    }//GEN-LAST:event_rSButton5ActionPerformed

    private void rSButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton6ActionPerformed

        new novoProduto(table).setVisible(true);
        dispose();
    }//GEN-LAST:event_rSButton6ActionPerformed

    private void rSButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton7ActionPerformed
        if(table.isRowSelected(table.getSelectedRow()))
        {
            int ID=(int)table.getValueAt(table.getSelectedRow(), 1);
            int estoque=(int)table.getValueAt(table.getSelectedRow(), 13);
            int estoqueA=(int)table.getValueAt(table.getSelectedRow(), 12);
            String codigo=(String)table.getValueAt(table.getSelectedRow(), 2);
            String nome=(String)table.getValueAt(table.getSelectedRow(), 3);
            String descricao=(String)table.getValueAt(table.getSelectedRow(), 4);
            String nomcateg=(String)table.getValueAt(table.getSelectedRow(), 5);
            String nomemar=(String)table.getValueAt(table.getSelectedRow(), 6);
            String nomeuni=(String)table.getValueAt(table.getSelectedRow(), 7);
            double custo=(double)table.getValueAt(table.getSelectedRow(), 8);
            double custototal=(double)table.getValueAt(table.getSelectedRow(), 9);
            double preco=(double)table.getValueAt(table.getSelectedRow(), 10);
            double pesoLiquido=(double)table.getValueAt(table.getSelectedRow(), 11);
            double pesoBruto=(double)table.getValueAt(table.getSelectedRow(), 12);
            paneldetalhe.setVisible(true);
            Lcusto.setText("%"+custo);
            LcustoTotal.setText("%"+custototal);
            Lpreco.setText("%"+preco);
            LestoqueE.setText("%"+estoque);
            LestoqueA.setText("%"+estoqueA);
            
            produtoBean pb=new produtoBean(nome, descricao, codigo, nomcateg, nomemar, nomeuni, 
                    ID, estoque, pesoLiquido, pesoBruto, custo, preco);
            new novoProduto(table, pb).setVisible(true);
            
        }else
        {
            new Message().messageAlerta("Selecione o produto que deseja editar/alterar");
        }
    }//GEN-LAST:event_rSButton7ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        if(table.isRowSelected(table.getSelectedRow()))
        {
            int ID=(int)table.getValueAt(table.getSelectedRow(), 1);
            int estoque=(int)table.getValueAt(table.getSelectedRow(), 13);
            int estoqueA=(int)table.getValueAt(table.getSelectedRow(), 14);
            String codigo=(String)table.getValueAt(table.getSelectedRow(), 2);
            String nome=(String)table.getValueAt(table.getSelectedRow(), 3);
            String descricao=(String)table.getValueAt(table.getSelectedRow(), 4);
            String nomcateg=(String)table.getValueAt(table.getSelectedRow(), 5);
            String nomemar=(String)table.getValueAt(table.getSelectedRow(), 6);
            String nomeuni=(String)table.getValueAt(table.getSelectedRow(), 7);
            double custo=(double)table.getValueAt(table.getSelectedRow(), 8);
            double custototal=(double)table.getValueAt(table.getSelectedRow(), 9);
            double preco=(double)table.getValueAt(table.getSelectedRow(), 10);
            double pesoLiquido=(double)table.getValueAt(table.getSelectedRow(), 11);
            double pesoBruto=(double)table.getValueAt(table.getSelectedRow(), 12);
            paneldetalhe.setVisible(true);
            Lcusto.setText("$ "+custo);
            LcustoTotal.setText("$ "+custototal);
            Lpreco.setText("$ "+preco);
            LestoqueE.setText(""+estoque);
            LestoqueA.setText(""+estoqueA);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqKeyReleased

        if(!pesq.getText().trim().isEmpty())
        {
            new produtoDAO().getcontroleProduto(table, pesq.getText());
        }else
        {
            new produtoDAO().getControleProduto(table);
        }
    }//GEN-LAST:event_pesqKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new controleproduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lcusto;
    private javax.swing.JLabel LcustoTotal;
    private javax.swing.JLabel LestoqueA;
    private javax.swing.JLabel LestoqueE;
    private javax.swing.JLabel Lpreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel paneldetalhe;
    private rojeru_san.RSMTextFull pesq;
    private rojeru_san.RSButton rSButton1;
    private rojeru_san.RSButton rSButton2;
    private rojeru_san.RSButton rSButton3;
    private rojeru_san.RSButton rSButton4;
    private rojeru_san.RSButton rSButton5;
    private rojeru_san.RSButton rSButton6;
    private rojeru_san.RSButton rSButton7;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
