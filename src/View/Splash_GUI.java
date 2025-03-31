
package View;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Splash_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Splash_GUI
     */
    public Splash_GUI() {
        initComponents();
        
        new Thread(){
       
            public void run() {
        
     
        for (int i=0; i<101; i++){
                    try {
                        sleep(60);
                       
                        progress.setValue(i);
                       
                        if(progress.getValue() == 10){
                           
                           mess_txt.setText("Fazendo conexão com o banco de dados...");
                            sleep(2000);
                                                       
                       
                        }else if (progress.getValue() <=30){
                           mess_txt.setText("Carregando o sistema...");
                          sleep(100);  
                        } else if (progress.getValue() <=99){
                            mess_txt.setText("Quase lá...");
                           
                        }else{
                          mess_txt.setText("Carregamento completo... Seu sistema será iniciado...");
                            
                        sleep(3000);
                       
                        new Login_GUI().setVisible(true);
                        }
                       
                       
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Login_GUI.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
       
       
       
       
        }        
        }
       
        }.start();
       
   
       
       
   
        //---->fim código splash
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        progress = new javax.swing.JProgressBar();
        mess_txt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Splash Screen.png"))); // NOI18N
        panelImage1.setLayout(null);

        progress.setForeground(new java.awt.Color(102, 255, 102));
        progress.setStringPainted(true);
        panelImage1.add(progress);
        progress.setBounds(140, 290, 480, 17);

        mess_txt.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        mess_txt.setForeground(new java.awt.Color(255, 255, 255));
        mess_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelImage1.add(mess_txt);
        mess_txt.setBounds(190, 320, 380, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(740, 370));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel mess_txt;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public static javax.swing.JProgressBar progress;
    // End of variables declaration//GEN-END:variables
}
