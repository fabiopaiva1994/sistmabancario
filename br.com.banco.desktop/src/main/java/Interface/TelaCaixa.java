/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author U S E R
 */
public class TelaCaixa extends javax.swing.JFrame {
    int hh, mm, ss, h;
    int dia, mes, ano;
    Calendar CalendarHora;
    DecimalFormat formato;

    public class Hora {

        public Hora() {

            ActionListener tarefa = (new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    HORAS();
                }
            });

            javax.swing.Timer time = new javax.swing.Timer(1000, tarefa);
            time.start();
            varPainel.add(varHoras);
        }

        private void HORAS() {
            
            CalendarHora = Calendar.getInstance();
       
            dia = CalendarHora.get(Calendar.DAY_OF_MONTH);
            mes = CalendarHora.get(Calendar.MONTH) + 1;
            ano = CalendarHora.get(Calendar.YEAR);
            hh = CalendarHora.get(Calendar.HOUR_OF_DAY);
            mm = CalendarHora.get(Calendar.MINUTE);
            ss = CalendarHora.get(Calendar.SECOND);
            formato = new DecimalFormat("00");
            String m = "";
            if(mes < 10) {
                m = "0" + mes;
            } else {
                m = "" + mes;
            }
            
            
            varData.setText("Data: " + dia + "/" + m + "/" + ano);
            varHoras.setText("Hora: " + formatar(hh) + ":" + formatar(mm) + ":" + formatar(ss));
        }

        private String formatar(int num) {
            formato = new DecimalFormat("00");
            return formato.format(num);
        }
    }

    /**
     * Creates new form TelaCaixa
     */
    public TelaCaixa() {
        initComponents();
        Hora h = new Hora();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        varPainel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        varDeposito = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        varHoras = new javax.swing.JLabel();
        varData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        varPainel.setBackground(new java.awt.Color(204, 204, 0));
        varPainel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                varPainelKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 51, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Saques e Informações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        varDeposito.setBackground(new java.awt.Color(0, 51, 153));
        varDeposito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        varDeposito.setForeground(new java.awt.Color(255, 255, 255));
        varDeposito.setText("Depósitos");
        varDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varDepositoActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Conta Corrente e Consulta");

        jButton4.setBackground(new java.awt.Color(0, 51, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Poupança");

        jButton5.setBackground(new java.awt.Color(0, 51, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Pagamentos");

        jButton6.setBackground(new java.awt.Color(0, 51, 153));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Transferências");

        jButton7.setBackground(new java.awt.Color(0, 51, 153));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Cartões");

        jButton8.setBackground(new java.awt.Color(0, 51, 153));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Próxima");

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("B&Z Inc. ");

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Banco da Zoeira ");

        varHoras.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        varHoras.setForeground(new java.awt.Color(254, 254, 254));
        varHoras.setText(": :");

        varData.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        varData.setForeground(new java.awt.Color(254, 254, 254));
        varData.setText("/ /");

        javax.swing.GroupLayout varPainelLayout = new javax.swing.GroupLayout(varPainel);
        varPainel.setLayout(varPainelLayout);
        varPainelLayout.setHorizontalGroup(
            varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varPainelLayout.createSequentialGroup()
                .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(varPainelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                        .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, varPainelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(varHoras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(varData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(varPainelLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2)
                    .addContainerGap(300, Short.MAX_VALUE)))
        );
        varPainelLayout.setVerticalGroup(
            varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varPainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(varHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(varPainelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(varPainelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(varData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(varPainelLayout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(varPainelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
            .addGroup(varPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(varPainelLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(467, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(varPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(varPainel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void varPainelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_varPainelKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_1) {
            JOptionPane.showMessageDialog(null, "OKK");
            
            
        }// TODO add your handling code here:
    }//GEN-LAST:event_varPainelKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            new TelaSaque().setEnabled(true);
            new TelaSaque().setVisible(true);// TODO add your handling code here:
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void varDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varDepositoActionPerformed
        new TelaDeposito().setVisible(true);
    }//GEN-LAST:event_varDepositoActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCaixa().setVisible(true);
                
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel varData;
    private javax.swing.JButton varDeposito;
    private javax.swing.JLabel varHoras;
    private javax.swing.JPanel varPainel;
    // End of variables declaration//GEN-END:variables
}
