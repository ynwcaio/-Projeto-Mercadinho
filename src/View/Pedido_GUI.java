/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.Funcoes_DAO.password;
import static Controller.Funcoes_DAO.url;
import static Controller.Funcoes_DAO.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruna
 */
public class Pedido_GUI extends javax.swing.JFrame {

   
    public Pedido_GUI() {
        initComponents();
    }
    
    public static DefaultTableModel  cliente(ResultSet rs) {
        try {
           ResultSetMetaData metaData = rs.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
       // AS LINHAS ABAIXO SÃO REFERENTES AOS CAMPOS DA TABELA CLIENTE
            columnNames.addElement("Codigo");
            columnNames.addElement("Data");
            columnNames.addElement("Nome");
            columnNames.addElement("Contato");
            columnNames.addElement("Cpf");
            columnNames.addElement("Produto");
            columnNames.addElement("Quantidade");
         
            Vector rows = new Vector();
            while (rs.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }
                rows.addElement(newRow);
            }
           return new DefaultTableModel(rows, columnNames);
       } catch (Exception e) {

           return null;
        }
        }

    
    //Fim
    
    //Inicio
    
    //Inicio Preenchimento da Tabela
    
      public void refresh(){
    
    try{
       Connection conn;
              conn = (Connection) DriverManager.getConnection(url, username, password);
        Controller.Conecta_DAO.carregaDriver();


        System.out.println("realizado");
                String sql = "SELECT * FROM pedido;";
    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    tabela.setModel(cliente(rs));
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }    
        } 

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {                                          
                     refresh();
        } 

    
    //Fim

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("MERCADO?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        pedidoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Pedido p");
        pedidoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : pedidoQuery.getResultList();
        produtoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Produto p");
        produtoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : produtoQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cod2_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        data_txt2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nome_txt2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        produto_txt2 = new javax.swing.JTextField();
        cpf_txt2 = new javax.swing.JTextField();
        contato_txt2 = new javax.swing.JTextField();
        qtd_txt2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fechar_btn = new javax.swing.JButton();
        fechar_btn1 = new javax.swing.JButton();
        salvar_btn2 = new javax.swing.JButton();
        editar_BTN2 = new javax.swing.JButton();
        apagar_btn2 = new javax.swing.JButton();
        consultar_btn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Fundo.png"))); // NOI18N
        panelImage1.setLayout(null);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtoList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codProduto}"));
        columnBinding.setColumnName("Produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeProduto}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precoProduto}"));
        columnBinding.setColumnName("Preco");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        panelImage1.add(jScrollPane1);
        jScrollPane1.setBounds(450, 250, 260, 120);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pedidoList, tabela);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoPedido}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataPedido}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomePedido}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contatoPedido}"));
        columnBinding.setColumnName("Contato ");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpfPedido}"));
        columnBinding.setColumnName("Cpf");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codProduto}"));
        columnBinding.setColumnName(" Produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidade}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tabela);

        panelImage1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 250, 452, 120);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CÓDIGO:");
        panelImage1.add(jLabel2);
        jLabel2.setBounds(30, 50, 70, 20);

        cod2_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod2_txtActionPerformed(evt);
            }
        });
        panelImage1.add(cod2_txt);
        cod2_txt.setBounds(100, 50, 150, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATA:");
        panelImage1.add(jLabel3);
        jLabel3.setBounds(50, 90, 50, 20);

        data_txt2.setText("Ex: 2024-11-25 14:00:00");
        data_txt2.setToolTipText("");
        data_txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_txt2ActionPerformed(evt);
            }
        });
        panelImage1.add(data_txt2);
        data_txt2.setBounds(100, 90, 150, 30);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOME:");
        panelImage1.add(jLabel4);
        jLabel4.setBounds(30, 130, 80, 20);

        nome_txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_txt2ActionPerformed(evt);
            }
        });
        panelImage1.add(nome_txt2);
        nome_txt2.setBounds(100, 130, 150, 30);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FAZER PEDIDO");
        panelImage1.add(jLabel6);
        jLabel6.setBounds(260, 10, 120, 18);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CONTATO:");
        panelImage1.add(jLabel5);
        jLabel5.setBounds(330, 50, 80, 20);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CPF:");
        panelImage1.add(jLabel7);
        jLabel7.setBounds(350, 90, 60, 20);

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PRODUTO:");
        panelImage1.add(jLabel8);
        jLabel8.setBounds(320, 130, 80, 20);

        produto_txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produto_txt2ActionPerformed(evt);
            }
        });
        panelImage1.add(produto_txt2);
        produto_txt2.setBounds(410, 130, 160, 30);

        cpf_txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf_txt2ActionPerformed(evt);
            }
        });
        panelImage1.add(cpf_txt2);
        cpf_txt2.setBounds(410, 90, 160, 30);

        contato_txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contato_txt2ActionPerformed(evt);
            }
        });
        panelImage1.add(contato_txt2);
        contato_txt2.setBounds(410, 50, 160, 30);

        qtd_txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtd_txt2ActionPerformed(evt);
            }
        });
        panelImage1.add(qtd_txt2);
        qtd_txt2.setBounds(610, 130, 70, 30);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUANTIDADE:");
        panelImage1.add(jLabel1);
        jLabel1.setBounds(590, 100, 110, 20);

        fechar_btn.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        fechar_btn.setText("X");
        fechar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar_btnActionPerformed(evt);
            }
        });
        panelImage1.add(fechar_btn);
        fechar_btn.setBounds(649, 0, 50, 40);

        fechar_btn1.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        fechar_btn1.setText("X");
        fechar_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar_btn1ActionPerformed(evt);
            }
        });
        panelImage1.add(fechar_btn1);
        fechar_btn1.setBounds(649, 0, 50, 40);

        salvar_btn2.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        salvar_btn2.setText("SALVAR");
        salvar_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_btn2ActionPerformed(evt);
            }
        });
        panelImage1.add(salvar_btn2);
        salvar_btn2.setBounds(10, 190, 130, 25);

        editar_BTN2.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        editar_BTN2.setText("ALTERAR");
        editar_BTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_BTN2ActionPerformed(evt);
            }
        });
        panelImage1.add(editar_BTN2);
        editar_BTN2.setBounds(170, 190, 130, 25);

        apagar_btn2.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        apagar_btn2.setText("EXCLUIR");
        apagar_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagar_btn2ActionPerformed(evt);
            }
        });
        panelImage1.add(apagar_btn2);
        apagar_btn2.setBounds(330, 190, 140, 25);

        consultar_btn2.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        consultar_btn2.setText("CONSULTAR");
        consultar_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_btn2ActionPerformed(evt);
            }
        });
        panelImage1.add(consultar_btn2);
        consultar_btn2.setBounds(510, 190, 150, 25);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
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

        bindingGroup.bind();

        setSize(new java.awt.Dimension(710, 370));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cod2_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod2_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod2_txtActionPerformed

    private void data_txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_txt2ActionPerformed

    private void nome_txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_txt2ActionPerformed

    private void cpf_txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpf_txt2ActionPerformed

    private void contato_txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contato_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contato_txt2ActionPerformed

    private void qtd_txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtd_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtd_txt2ActionPerformed

    private void fechar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechar_btnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fechar_btnActionPerformed

    private void fechar_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechar_btn1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fechar_btn1ActionPerformed

    private void salvar_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_btn2ActionPerformed
        Controller.Funcoes_DAO.salvar2();
        refresh();
    }//GEN-LAST:event_salvar_btn2ActionPerformed

    private void editar_BTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_BTN2ActionPerformed
        Controller.Funcoes_DAO.alterar2();
        refresh();
    }//GEN-LAST:event_editar_BTN2ActionPerformed

    private void apagar_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagar_btn2ActionPerformed
        Controller.Funcoes_DAO.excluir2();
        refresh();
    }//GEN-LAST:event_apagar_btn2ActionPerformed

    private void consultar_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_btn2ActionPerformed
        Controller.Funcoes_DAO.consultar2();
    }//GEN-LAST:event_consultar_btn2ActionPerformed

    private void produto_txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produto_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produto_txt2ActionPerformed

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
            java.util.logging.Logger.getLogger(Pedido_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedido_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedido_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedido_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedido_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton apagar_btn2;
    public static javax.swing.JTextField cod2_txt;
    public static javax.swing.JButton consultar_btn2;
    public static javax.swing.JTextField contato_txt2;
    public static javax.swing.JTextField cpf_txt2;
    public static javax.swing.JTextField data_txt2;
    public static javax.swing.JButton editar_BTN2;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton fechar_btn;
    private javax.swing.JButton fechar_btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTextField nome_txt2;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private java.util.List<View.Pedido> pedidoList;
    private javax.persistence.Query pedidoQuery;
    private java.util.List<View.Produto> produtoList;
    private javax.persistence.Query produtoQuery;
    public static javax.swing.JTextField produto_txt2;
    public static javax.swing.JTextField qtd_txt2;
    public static javax.swing.JButton salvar_btn2;
    public static javax.swing.JTable tabela;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
