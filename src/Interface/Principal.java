/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class Principal extends javax.swing.JFrame {
    private Controlador controlador;
    private boolean tipoNum;    //True = inteiros, False = reais
    private CardLayout panelAtual;
    private DefaultTableModel table;
    private int contLinhasTabela;
    private Object[] linha; //Guarda a ultima linha da tabela
    
    public Principal() {
        initComponents();
        this.controlador = new Controlador();
        
        //Inicializando o cardlayout, para trocar entre os JPanels
        this.tipoNum = true;
        this.panelAtual = (CardLayout) this.jPanel_valores_ops_principal.getLayout();
        this.panelAtual.show(this.jPanel_valores_ops_principal, "Jpanel_inteiros");
        
        //Inicializa primeira linha da tabela
        this.table = (DefaultTableModel) this.jTable_regs.getModel();
        this.linha = new Object[5];
        linha[0] = "Inicio";    //Operação
        linha[1] = "n/a";       //Reg A
        linha[2] = "n/a";       //Reg B
        linha[3] = "n/a";       //Reg C
        linha[4] = "n/a";       //Reg D
        this.table.addRow(linha);   //Adiciona a linha na tabela
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_valores_ops_principal = new javax.swing.JPanel();
        jPanel_inteiros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_valor_int = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_sinal_int = new javax.swing.JTextField();
        jPanel_reais = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_valor_reais = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_sinal_reais = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_divisor = new javax.swing.JTextField();
        jPanel_regs_princiapal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_regs = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton_atri_A = new javax.swing.JButton();
        jButton_atri_B = new javax.swing.JButton();
        jButton_somaAB = new javax.swing.JButton();
        jButton_somaABC = new javax.swing.JButton();
        jButton_multAB = new javax.swing.JButton();
        jButton_primo = new javax.swing.JButton();
        jButton_restoAB = new javax.swing.JButton();
        jButton_fatorial = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        inteiros_MN = new javax.swing.JMenuItem();
        reais_MN = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_valores_ops_principal.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Valor do Registrador");

        jLabel7.setText("Sinal do Valor");

        jTextField_sinal_int.setText("0");

        javax.swing.GroupLayout jPanel_inteirosLayout = new javax.swing.GroupLayout(jPanel_inteiros);
        jPanel_inteiros.setLayout(jPanel_inteirosLayout);
        jPanel_inteirosLayout.setHorizontalGroup(
            jPanel_inteirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_inteirosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_inteirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel_inteirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_valor_int)
                    .addComponent(jTextField_sinal_int, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_inteirosLayout.setVerticalGroup(
            jPanel_inteirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_inteirosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_inteirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_valor_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_inteirosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_sinal_int, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel_valores_ops_principal.add(jPanel_inteiros, "card_inteiros");

        jLabel3.setText("Valor do Registrador");

        jLabel5.setText("Sinal do Valor");

        jTextField_sinal_reais.setText("0");
        jTextField_sinal_reais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_sinal_reaisActionPerformed(evt);
            }
        });

        jLabel6.setText("Divisor");

        jTextField_divisor.setText("1");

        javax.swing.GroupLayout jPanel_reaisLayout = new javax.swing.GroupLayout(jPanel_reais);
        jPanel_reais.setLayout(jPanel_reaisLayout);
        jPanel_reaisLayout.setHorizontalGroup(
            jPanel_reaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_reaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_reaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel_reaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_valor_reais)
                    .addComponent(jTextField_sinal_reais, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jTextField_divisor))
                .addContainerGap())
        );
        jPanel_reaisLayout.setVerticalGroup(
            jPanel_reaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_reaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_reaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_valor_reais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_reaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_sinal_reais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_reaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_divisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_valores_ops_principal.add(jPanel_reais, "card_reais");

        jTable_regs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operação", "Registrador A", "Registrador B", "Registrador C", "Registrador D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(jTable_regs);
        if (jTable_regs.getColumnModel().getColumnCount() > 0) {
            jTable_regs.getColumnModel().getColumn(0).setResizable(false);
            jTable_regs.getColumnModel().getColumn(1).setResizable(false);
            jTable_regs.getColumnModel().getColumn(2).setResizable(false);
            jTable_regs.getColumnModel().getColumn(3).setResizable(false);
            jTable_regs.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel_regs_princiapalLayout = new javax.swing.GroupLayout(jPanel_regs_princiapal);
        jPanel_regs_princiapal.setLayout(jPanel_regs_princiapalLayout);
        jPanel_regs_princiapalLayout.setHorizontalGroup(
            jPanel_regs_princiapalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );
        jPanel_regs_princiapalLayout.setVerticalGroup(
            jPanel_regs_princiapalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLabel8.setText("Operações");

        jButton_atri_A.setText("Atribuir à A");
        jButton_atri_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_atri_AActionPerformed(evt);
            }
        });

        jButton_atri_B.setText("Atribuir à B");
        jButton_atri_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_atri_BActionPerformed(evt);
            }
        });

        jButton_somaAB.setText("A + B");
        jButton_somaAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_somaABActionPerformed(evt);
            }
        });

        jButton_somaABC.setText("A + B Usando C");
        jButton_somaABC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_somaABCActionPerformed(evt);
            }
        });

        jButton_multAB.setText("A x B");
        jButton_multAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_multABActionPerformed(evt);
            }
        });

        jButton_primo.setText("A é Primo");
        jButton_primo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_primoActionPerformed(evt);
            }
        });

        jButton_restoAB.setText("Resto de A / B");
        jButton_restoAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_restoABActionPerformed(evt);
            }
        });

        jButton_fatorial.setText("Fatorial de A = 5");
        jButton_fatorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_fatorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton_atri_A, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton_atri_B, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton_somaAB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton_somaABC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton_multAB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton_primo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton_restoAB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton_fatorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_atri_A)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_atri_B)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_somaAB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_somaABC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_multAB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_primo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_restoAB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_fatorial)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jMenu1.setText("Números");

        inteiros_MN.setText("Inteiros");
        inteiros_MN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inteiros_MNActionPerformed(evt);
            }
        });
        jMenu1.add(inteiros_MN);

        reais_MN.setText("Reais");
        reais_MN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reais_MNActionPerformed(evt);
            }
        });
        jMenu1.add(reais_MN);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_valores_ops_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_regs_princiapal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_regs_princiapal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_valores_ops_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_atri_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_atri_AActionPerformed
        // TODO add your handling code here:
        int valor, sinal, divisor;
        
        //Se estiver trabalhando com números inteiros
        if(this.tipoNum){
            valor = Integer.valueOf(this.jTextField_valor_int.getText());
            sinal = Integer.valueOf(this.jTextField_sinal_int.getText());
            divisor = 1;
        }//Se estiver trabalhando com números reais
        else{
            valor = Integer.valueOf(this.jTextField_valor_reais.getText());
            sinal = Integer.valueOf(this.jTextField_sinal_reais.getText());
            divisor = Integer.valueOf(this.jTextField_divisor.getText());
        }
        
        this.controlador.atribuirA(valor, sinal, divisor);
        int[] aux = this.controlador.getInfosReg(0); //Informações do Reg A para a tabela
        //"Forma" o valor do registrador a partir das informações dos 3 objetos Registradores
        float regA = (float)(aux[0] / aux[2]);
        if(aux[1] == 1)
            regA *= -1;
        
        //Adicona a linha na tabela
        this.linha[0] = "Atribuição A"; //Operação
        this.linha[1] = regA;
        this.table.addRow(linha);
    }//GEN-LAST:event_jButton_atri_AActionPerformed

    private void jButton_somaABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_somaABActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_somaABActionPerformed

    private void jButton_atri_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_atri_BActionPerformed
        // TODO add your handling code here:
        int valor, sinal, divisor;
        
        //Se estiver trabalhando com números inteiros
        if(this.tipoNum){
            valor = Integer.valueOf(this.jTextField_valor_int.getText());
            sinal = Integer.valueOf(this.jTextField_sinal_int.getText());
            divisor = 1;
        }//Se estiver trabalhando com números reais
        else{
            valor = Integer.valueOf(this.jTextField_valor_reais.getText());
            sinal = Integer.valueOf(this.jTextField_sinal_reais.getText());
            divisor = Integer.valueOf(this.jTextField_divisor.getText());
        }
        
        this.controlador.atribuirB(valor, sinal, divisor);
        int[] aux = this.controlador.getInfosReg(1); //Informações do Reg A para a tabela
        //"Forma" o valor do registrador a partir das informações dos 3 objetos Registradores
        float regA = (float)(aux[0] / aux[2]);
        if(aux[1] == 1)
            regA *= -1;
        
        //Adicona a linha na tabela
        this.linha[0] = "Atribuição B"; //Operação
        this.linha[2] = regA;
        this.table.addRow(linha);
    }//GEN-LAST:event_jButton_atri_BActionPerformed

    private void jButton_somaABCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_somaABCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_somaABCActionPerformed

    private void jButton_multABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_multABActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_multABActionPerformed

    private void jButton_primoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_primoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_primoActionPerformed

    private void jButton_restoABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_restoABActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_restoABActionPerformed

    private void jButton_fatorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_fatorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_fatorialActionPerformed

    private void inteiros_MNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inteiros_MNActionPerformed
        // TODO add your handling code here:
        this.tipoNum = true;
        this.panelAtual.show(this.jPanel_valores_ops_principal, "card_inteiros");
    }//GEN-LAST:event_inteiros_MNActionPerformed

    private void reais_MNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reais_MNActionPerformed
        // TODO add your handling code here:
        this.tipoNum = false;
        this.panelAtual.show(this.jPanel_valores_ops_principal, "card_reais");
    }//GEN-LAST:event_reais_MNActionPerformed

    private void jTextField_sinal_reaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_sinal_reaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_sinal_reaisActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem inteiros_MN;
    private javax.swing.JButton jButton_atri_A;
    private javax.swing.JButton jButton_atri_B;
    private javax.swing.JButton jButton_fatorial;
    private javax.swing.JButton jButton_multAB;
    private javax.swing.JButton jButton_primo;
    private javax.swing.JButton jButton_restoAB;
    private javax.swing.JButton jButton_somaAB;
    private javax.swing.JButton jButton_somaABC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_inteiros;
    private javax.swing.JPanel jPanel_reais;
    private javax.swing.JPanel jPanel_regs_princiapal;
    private javax.swing.JPanel jPanel_valores_ops_principal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_regs;
    private javax.swing.JTextField jTextField_divisor;
    private javax.swing.JTextField jTextField_sinal_int;
    private javax.swing.JTextField jTextField_sinal_reais;
    private javax.swing.JTextField jTextField_valor_int;
    private javax.swing.JTextField jTextField_valor_reais;
    private javax.swing.JMenuItem reais_MN;
    // End of variables declaration//GEN-END:variables
}
