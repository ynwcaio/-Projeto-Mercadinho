
package View;

import static Controller.Funcoes_DAO.password;
import static Controller.Funcoes_DAO.url;
import static Controller.Funcoes_DAO.username;
import static View.Produto_GUI.tabela;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Produto_GUI extends javax.swing.JFrame {

   
    public Produto_GUI() {
        initComponents();
    }
    
    //Inicio
    
    public static DefaultTableModel  cliente(ResultSet rs) {
        try {
           ResultSetMetaData metaData = rs.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
       // AS LINHAS ABAIXO SÃO REFERENTES AOS CAMPOS DA TABELA CLIENTE
            columnNames.addElement("Código");
            columnNames.addElement("Nome");
            columnNames.addElement("Preço");
            columnNames.addElement("Categoria");
            columnNames.addElement("Descrição");
         
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
                String sql = "SELECT * FROM PRODUTO;";
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
        produtoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Produto p");
        produtoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : produtoQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel6 = new javax.swing.JLabel();
        cod_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nome_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        preco_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        categoria_txt = new javax.swing.JTextField();
        salvar_btn = new javax.swing.JButton();
        editar_BTN = new javax.swing.JButton();
        apagar_btn = new javax.swing.JButton();
        consultar_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc_txt = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        fechar_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Fundo.png"))); // NOI18N
        panelImage1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CÓDIGO:");
        panelImage1.add(jLabel6);
        jLabel6.setBounds(50, 20, 70, 20);
        panelImage1.add(cod_txt);
        cod_txt.setBounds(120, 20, 190, 30);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOME:");
        panelImage1.add(jLabel2);
        jLabel2.setBounds(60, 70, 50, 18);

        nome_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_txtActionPerformed(evt);
            }
        });
        panelImage1.add(nome_txt);
        nome_txt.setBounds(120, 70, 190, 30);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PREÇO:");
        panelImage1.add(jLabel3);
        jLabel3.setBounds(60, 120, 60, 18);
        panelImage1.add(preco_txt);
        preco_txt.setBounds(120, 110, 190, 30);

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CATEGORIA:");
        panelImage1.add(jLabel5);
        jLabel5.setBounds(20, 170, 100, 18);
        panelImage1.add(categoria_txt);
        categoria_txt.setBounds(120, 160, 190, 30);

        salvar_btn.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        salvar_btn.setText("SALVAR");
        salvar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_btnActionPerformed(evt);
            }
        });
        panelImage1.add(salvar_btn);
        salvar_btn.setBounds(30, 220, 130, 25);

        editar_BTN.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        editar_BTN.setText("ALTERAR");
        editar_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_BTNActionPerformed(evt);
            }
        });
        panelImage1.add(editar_BTN);
        editar_BTN.setBounds(190, 220, 130, 25);

        apagar_btn.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        apagar_btn.setText("EXCLUIR");
        apagar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagar_btnActionPerformed(evt);
            }
        });
        panelImage1.add(apagar_btn);
        apagar_btn.setBounds(370, 220, 140, 25);

        consultar_btn.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        consultar_btn.setText("CONSULTAR");
        consultar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_btnActionPerformed(evt);
            }
        });
        panelImage1.add(consultar_btn);
        consultar_btn.setBounds(550, 220, 150, 25);

        desc_txt.setColumns(20);
        desc_txt.setRows(5);
        jScrollPane2.setViewportView(desc_txt);

        panelImage1.add(jScrollPane2);
        jScrollPane2.setBounds(470, 50, 210, 130);

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESCRIÇÃO:");
        panelImage1.add(jLabel4);
        jLabel4.setBounds(370, 40, 100, 18);

        fechar_btn.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        fechar_btn.setText("X");
        fechar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar_btnActionPerformed(evt);
            }
        });
        panelImage1.add(fechar_btn);
        fechar_btn.setBounds(660, 0, 50, 40);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtoList, tabela);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codProduto}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeProduto}"));
        columnBinding.setColumnName("Nome ");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${precoProduto}"));
        columnBinding.setColumnName("Preço");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${categProduto}"));
        columnBinding.setColumnName("Categoria");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descProduto}"));
        columnBinding.setColumnName("Descrição");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabela);

        panelImage1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 260, 710, 110);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(710, 370));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nome_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_txtActionPerformed

    private void salvar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_btnActionPerformed
        Controller.Funcoes_DAO.salvar();
        refresh();
    }//GEN-LAST:event_salvar_btnActionPerformed

    private void editar_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_BTNActionPerformed
        Controller.Funcoes_DAO.alterar();
        refresh();
    }//GEN-LAST:event_editar_BTNActionPerformed

    private void apagar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagar_btnActionPerformed
        Controller.Funcoes_DAO.excluir();
        refresh();
    }//GEN-LAST:event_apagar_btnActionPerformed

    private void consultar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_btnActionPerformed
        Controller.Funcoes_DAO.consultar();
    }//GEN-LAST:event_consultar_btnActionPerformed

    private void fechar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechar_btnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fechar_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Produto_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produto_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produto_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produto_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produto_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apagar_btn;
    public static javax.swing.JTextField categoria_txt;
    public static javax.swing.JTextField cod_txt;
    private javax.swing.JButton consultar_btn;
    public static javax.swing.JTextArea desc_txt;
    private javax.swing.JButton editar_BTN;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton fechar_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField nome_txt;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public static javax.swing.JTextField preco_txt;
    private java.util.List<View.Produto> produtoList;
    private javax.persistence.Query produtoQuery;
    private javax.swing.JButton salvar_btn;
    public static javax.swing.JTable tabela;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
