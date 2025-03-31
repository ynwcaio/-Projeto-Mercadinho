/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.Funcoes_DAO.password;
import static Controller.Funcoes_DAO.url;
import static Controller.Funcoes_DAO.username;
import static View.Pedido_GUI.tabela;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruna
 */
public class Caixa_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Caixa_GUI
     */
    public Caixa_GUI() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        qtd_txt3 = new javax.swing.JTextField();
        preco_txt3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cod_txt3 = new javax.swing.JTextField();
        excluir_btn3 = new javax.swing.JButton();
        total_btn3 = new javax.swing.JButton();
        relatorio_btn3 = new javax.swing.JButton();
        limpar_btn3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        fechar_btn3 = new javax.swing.JButton();
        res_txt3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Fundo.png"))); // NOI18N
        panelImage1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PREÇO:");
        panelImage1.add(jLabel3);
        jLabel3.setBounds(80, 20, 60, 18);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUANTIDADE:");
        panelImage1.add(jLabel1);
        jLabel1.setBounds(40, 80, 120, 18);
        panelImage1.add(qtd_txt3);
        qtd_txt3.setBounds(150, 80, 140, 30);
        panelImage1.add(preco_txt3);
        preco_txt3.setBounds(150, 20, 140, 30);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PEDIDO:");
        panelImage1.add(jLabel2);
        jLabel2.setBounds(370, 30, 70, 18);

        cod_txt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod_txt3ActionPerformed(evt);
            }
        });
        panelImage1.add(cod_txt3);
        cod_txt3.setBounds(440, 30, 140, 30);

        excluir_btn3.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        excluir_btn3.setText("EXCLUIR");
        excluir_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluir_btn3ActionPerformed(evt);
            }
        });
        panelImage1.add(excluir_btn3);
        excluir_btn3.setBounds(450, 80, 120, 25);

        total_btn3.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        total_btn3.setText("TOTAL");
        total_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_btn3ActionPerformed(evt);
            }
        });
        panelImage1.add(total_btn3);
        total_btn3.setBounds(10, 130, 120, 25);

        relatorio_btn3.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        relatorio_btn3.setText("RELATÓRIO");
        relatorio_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorio_btn3ActionPerformed(evt);
            }
        });
        panelImage1.add(relatorio_btn3);
        relatorio_btn3.setBounds(10, 170, 120, 25);

        limpar_btn3.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        limpar_btn3.setText("LIMPAR");
        limpar_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar_btn3ActionPerformed(evt);
            }
        });
        panelImage1.add(limpar_btn3);
        limpar_btn3.setBounds(150, 170, 120, 25);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pedidoList, tabela);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoPedido}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataPedido}"));
        columnBinding.setColumnName("Data ");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomePedido}"));
        columnBinding.setColumnName("Nome ");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contatoPedido}"));
        columnBinding.setColumnName("Contato");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpfPedido}"));
        columnBinding.setColumnName("Cpf ");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codProduto}"));
        columnBinding.setColumnName("Produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantidade}"));
        columnBinding.setColumnName("Quantidade");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabela);

        panelImage1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 210, 490, 160);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtoList, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codProduto}"));
        columnBinding.setColumnName(" Produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeProduto}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precoProduto}"));
        columnBinding.setColumnName("Preco");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        panelImage1.add(jScrollPane2);
        jScrollPane2.setBounds(490, 210, 280, 160);

        fechar_btn3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        fechar_btn3.setText("X");
        fechar_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar_btn3ActionPerformed(evt);
            }
        });
        panelImage1.add(fechar_btn3);
        fechar_btn3.setBounds(720, 0, 50, 40);

        res_txt3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        res_txt3.setForeground(new java.awt.Color(255, 255, 255));
        panelImage1.add(res_txt3);
        res_txt3.setBounds(140, 130, 90, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(770, 370));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cod_txt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod_txt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_txt3ActionPerformed

    private void excluir_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluir_btn3ActionPerformed
        Controller.Funcoes_DAO.excluir3();
        refresh();
    }//GEN-LAST:event_excluir_btn3ActionPerformed

    private void total_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_btn3ActionPerformed
        Controller.Funcoes_DAO.total();
    }//GEN-LAST:event_total_btn3ActionPerformed

    private void relatorio_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorio_btn3ActionPerformed
        try {
            Controller.Relatorio_DAO.Relatorio();
        } catch (Exception ex) {
            Logger.getLogger(Caixa_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_relatorio_btn3ActionPerformed

    private void limpar_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar_btn3ActionPerformed
        Controller.Funcoes_DAO.limpa();
    }//GEN-LAST:event_limpar_btn3ActionPerformed

    private void fechar_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechar_btn3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fechar_btn3ActionPerformed

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
            java.util.logging.Logger.getLogger(Caixa_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caixa_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caixa_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caixa_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caixa_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField cod_txt3;
    private javax.persistence.EntityManager entityManager;
    public static javax.swing.JButton excluir_btn3;
    public static javax.swing.JButton fechar_btn3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable2;
    public static javax.swing.JButton limpar_btn3;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private java.util.List<View.Pedido> pedidoList;
    private javax.persistence.Query pedidoQuery;
    public static javax.swing.JTextField preco_txt3;
    private java.util.List<View.Produto> produtoList;
    private javax.persistence.Query produtoQuery;
    public static javax.swing.JTextField qtd_txt3;
    public static javax.swing.JButton relatorio_btn3;
    public static javax.swing.JLabel res_txt3;
    public static javax.swing.JTable tabela;
    public static javax.swing.JButton total_btn3;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
