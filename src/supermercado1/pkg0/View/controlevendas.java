/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.View;

import javax.swing.table.DefaultTableModel;
import supermercado1.pkg0.Controller.Message;
import supermercado1.pkg0.Controller.getImageBack;
import supermercado1.pkg0.Model.Bean.userBean;
import supermercado1.pkg0.Model.DAO.vendaDAO;

/**
 *
 * @author gildo
 */
public class controlevendas extends javax.swing.JFrame {

    /**
     * Creates new form controlevendas
     */
    private final userBean user;
    
    public controlevendas() {
        initComponents();
        setIconImage(new getImageBack().getImage());
        new vendaDAO().controlevenda(table);
        linhatable.setVisible(false);
        this.user=null;
    }
    public controlevendas(userBean user) {
        initComponents();
        setIconImage(new getImageBack().getImage());
        new vendaDAO().controlevenda(table);
        linhatable.setVisible(false);
        this.user=user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        rSButton10 = new rojeru_san.RSButton();
        rSButton11 = new rojeru_san.RSButton();
        rSButton13 = new rojeru_san.RSButton();
        jPanel8 = new javax.swing.JPanel();
        exibir = new rojerusan.RSComboMetro();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rSComboMetro2 = new rojerusan.RSComboMetro();
        rSButton16 = new rojeru_san.RSButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        linhatable = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        taxa = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();
        sub = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Vendas e Serviços");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rSButton10.setBackground(new java.awt.Color(255, 255, 255));
        rSButton10.setBorder(null);
        rSButton10.setForeground(new java.awt.Color(0, 0, 0));
        rSButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cash_register_48px.png"))); // NOI18N
        rSButton10.setText("Nova Venda");
        rSButton10.setToolTipText("");
        rSButton10.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton10.setColorText(new java.awt.Color(0, 0, 0));
        rSButton10.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton10ActionPerformed(evt);
            }
        });

        rSButton11.setBackground(new java.awt.Color(255, 255, 255));
        rSButton11.setBorder(null);
        rSButton11.setForeground(new java.awt.Color(0, 0, 0));
        rSButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/edit_property_48px.png"))); // NOI18N
        rSButton11.setText("Editar Venda");
        rSButton11.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton11.setColorText(new java.awt.Color(0, 0, 0));
        rSButton11.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton11ActionPerformed(evt);
            }
        });

        rSButton13.setBackground(new java.awt.Color(255, 255, 255));
        rSButton13.setBorder(null);
        rSButton13.setForeground(new java.awt.Color(0, 0, 0));
        rSButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancel_48px.png"))); // NOI18N
        rSButton13.setText("Cancelar Venda");
        rSButton13.setToolTipText("");
        rSButton13.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton13.setColorText(new java.awt.Color(0, 0, 0));
        rSButton13.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rSButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addComponent(rSButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(rSButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        exibir.setBackground(new java.awt.Color(0, 0, 0));
        exibir.setForeground(new java.awt.Color(0, 102, 255));
        exibir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas as vendas", "Exibir por data" }));
        exibir.setToolTipText("exibir vendas...");
        exibir.setColorArrow(new java.awt.Color(153, 153, 0));
        exibir.setColorBorde(new java.awt.Color(51, 51, 51));
        exibir.setColorFondo(new java.awt.Color(204, 204, 204));
        exibir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Exibir:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Ordenar por:");

        rSComboMetro2.setBackground(new java.awt.Color(0, 0, 0));
        rSComboMetro2.setForeground(new java.awt.Color(0, 102, 255));
        rSComboMetro2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "situacao" }));
        rSComboMetro2.setToolTipText("exibir vendas...");
        rSComboMetro2.setColorArrow(new java.awt.Color(153, 153, 0));
        rSComboMetro2.setColorBorde(new java.awt.Color(51, 51, 51));
        rSComboMetro2.setColorFondo(new java.awt.Color(204, 204, 204));
        rSComboMetro2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rSButton16.setBackground(new java.awt.Color(255, 255, 255));
        rSButton16.setBorder(null);
        rSButton16.setForeground(new java.awt.Color(0, 0, 0));
        rSButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/imprimir.png"))); // NOI18N
        rSButton16.setToolTipText("");
        rSButton16.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton16.setColorText(new java.awt.Color(0, 0, 0));
        rSButton16.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exibir, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSComboMetro2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exibir, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSComboMetro2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(rSButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Status", "Data", "Hora", "Cliente", "Meio de Pagamento", "Subtotal", "Desconto", "Tributacao", "Total", "Troco", "Vendedor", "Caixa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
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
        table.setGridColor(new java.awt.Color(255, 204, 153));
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(255, 204, 153));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(0).setMaxWidth(150);
            table.getColumnModel().getColumn(1).setMinWidth(150);
            table.getColumnModel().getColumn(1).setMaxWidth(250);
            table.getColumnModel().getColumn(2).setMinWidth(150);
            table.getColumnModel().getColumn(2).setMaxWidth(250);
            table.getColumnModel().getColumn(3).setMinWidth(150);
            table.getColumnModel().getColumn(3).setMaxWidth(250);
            table.getColumnModel().getColumn(4).setMinWidth(200);
            table.getColumnModel().getColumn(4).setMaxWidth(250);
            table.getColumnModel().getColumn(5).setMinWidth(150);
            table.getColumnModel().getColumn(5).setMaxWidth(250);
            table.getColumnModel().getColumn(6).setMinWidth(150);
            table.getColumnModel().getColumn(6).setMaxWidth(250);
            table.getColumnModel().getColumn(7).setMinWidth(150);
            table.getColumnModel().getColumn(7).setMaxWidth(250);
            table.getColumnModel().getColumn(8).setMinWidth(150);
            table.getColumnModel().getColumn(8).setMaxWidth(250);
            table.getColumnModel().getColumn(9).setMinWidth(150);
            table.getColumnModel().getColumn(9).setMaxWidth(250);
            table.getColumnModel().getColumn(10).setMinWidth(150);
            table.getColumnModel().getColumn(10).setMaxWidth(250);
            table.getColumnModel().getColumn(11).setMinWidth(200);
            table.getColumnModel().getColumn(11).setMaxWidth(250);
            table.getColumnModel().getColumn(12).setMinWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        linhatable.setBackground(new java.awt.Color(255, 255, 255));
        linhatable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/push_pin_48px.png"))); // NOI18N
        jLabel2.setText("Pagamento");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Subtotal:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Desconto:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Taxa:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("Total :");

        total.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        total.setForeground(new java.awt.Color(0, 153, 0));

        taxa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        sub.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ver itens");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout linhatableLayout = new javax.swing.GroupLayout(linhatable);
        linhatable.setLayout(linhatableLayout);
        linhatableLayout.setHorizontalGroup(
            linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(linhatableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(linhatableLayout.createSequentialGroup()
                        .addGroup(linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(taxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, linhatableLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        linhatableLayout.setVerticalGroup(
            linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(linhatableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(taxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(linhatableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(linhatable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(linhatable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1214, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton10ActionPerformed

        new novaVenda(this.user).setVisible(true);
        dispose();
    }//GEN-LAST:event_rSButton10ActionPerformed

    private void rSButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton11ActionPerformed
        if(table.isRowSelected(table.getSelectedRow()))
        {
            new promocao().setVisible(true);
        }else
        {
            new Message().messageAlerta("Selecione o produto que deseja editar/alterar");
        }
    }//GEN-LAST:event_rSButton11ActionPerformed

    private void rSButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButton13ActionPerformed

    private void exibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirActionPerformed
        if(exibir.getSelectedIndex()==1)
        {
            new filtrodata(table).setVisible(true);
        }else if(exibir.getSelectedIndex()==0)
        {
            new vendaDAO().controlevenda(table);
        }
        
    }//GEN-LAST:event_exibirActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        
        if(table.isRowSelected(table.getSelectedRow())) {
            double subtotal=(double)table.getValueAt(table.getSelectedRow(), 6);
            this.sub.setText("$"+subtotal);
            double desconto=(double)table.getValueAt(table.getSelectedRow(), 7);
            this.desc.setText("$"+desconto);
            double taxa=(double)table.getValueAt(table.getSelectedRow(), 8);
            this.taxa.setText("$"+taxa);
            double total=(double)table.getValueAt(table.getSelectedRow(), 9);
            this.total.setText("$"+total);
            linhatable.setVisible(true);
        }else
        {
            linhatable.setVisible(false);
            new Message().messageAlerta("Nenhuma venda foi selecionada,por favor selecione a venda!");
        }
        
    }//GEN-LAST:event_tableMouseClicked

    public void remove()
    {
        DefaultTableModel dt= (DefaultTableModel) table.getModel();
        int size=table.getRowCount()-1;
        while(size>-1)
        {
            dt.removeRow(size);size--;
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(table.isRowSelected(table.getSelectedRow())) {
            int ID=Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
            new itensvendidos(ID).setVisible(true);
            linhatable.setVisible(false);
        }else{
            new Message().messageAlerta("Nenhuma venda foi selecionada,por favor selecione a venda!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rSButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButton16ActionPerformed

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
            java.util.logging.Logger.getLogger(controlevendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(controlevendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(controlevendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(controlevendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new controlevendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel desc;
    private rojerusan.RSComboMetro exibir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel linhatable;
    private rojeru_san.RSButton rSButton10;
    private rojeru_san.RSButton rSButton11;
    private rojeru_san.RSButton rSButton13;
    private rojeru_san.RSButton rSButton16;
    private rojerusan.RSComboMetro rSComboMetro2;
    private javax.swing.JLabel sub;
    private javax.swing.JTable table;
    private javax.swing.JLabel taxa;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
