/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import cineMarcus.Filme;
import cineMarcus.FilmeController;
import cineMarcus.SessaoController;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ruan
 */
public class PainelDoAdmin extends javax.swing.JFrame {

    private final FilmeController filmeController;
    private final SessaoController sessaoController;
    private final List<Filme> listaFilmes;
    
    /**
     * Creates new form PainelDoAdmin
     */
    public PainelDoAdmin() {
        initComponents();
        filmeController = FilmeController.getInstance();
        sessaoController = SessaoController.getInstance();
        listaFilmes = filmeController.getFilmes().parallelStream().collect(Collectors.toList());
        carregarFilmes();
    }

    
    public void carregarFilmes(){
        pnlFilmes.removeAll();
        
        for (int i = 0; i < listaFilmes.size(); i++) {          
            Filme filme = listaFilmes.get(i);

            int x = 25 + (167 * (i / 2));
            int y = 25 + (209 * (i % 2));
            
            JLabel labelFilme = new JLabel();
            PainelDoAdmin self = this;
            labelFilme.setIcon(new ImageIcon(filme.getPoster()));
            
            //labelFilme.addMouseListener(new java.awt.event.MouseAdapter() {
                //@Override
                //public void mouseClicked(java.awt.event.MouseEvent evt) {
                 //   new PainelDoAdmin(filme, self).setVisible(true);
                //}
            //});
            
            labelFilme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            labelFilme.setBounds(x, y, 117, 150);
            pnlFilmes.add(labelFilme);
            
            if (i == listaFilmes.size() - 1) {
                pnlFilmes.setPreferredSize(new Dimension(x + 132, 409));
            }
            
            pnlFilmes.revalidate();
            pnlFilmes.repaint();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrarFilme = new javax.swing.JButton();
        btnCadastrarSessao = new javax.swing.JButton();
        pnlFilmes = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCadastrarFilme.setText("Cadastrar Filme");
        btnCadastrarFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFilmeActionPerformed(evt);
            }
        });

        btnCadastrarSessao.setText("Cadastrar Sessao");
        btnCadastrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarSessaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnCadastrarFilme)
                .addGap(67, 67, 67)
                .addComponent(btnCadastrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFilmes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarFilme)
                    .addComponent(btnCadastrarSessao))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFilmeActionPerformed
        new CadastroDeFilme().setVisible(true);
    }//GEN-LAST:event_btnCadastrarFilmeActionPerformed

    private void btnCadastrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarSessaoActionPerformed
        new CadastroDeSessao().setVisible(true);
    }//GEN-LAST:event_btnCadastrarSessaoActionPerformed

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
            java.util.logging.Logger.getLogger(PainelDoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelDoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelDoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelDoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PainelDoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFilme;
    private javax.swing.JButton btnCadastrarSessao;
    private javax.swing.JScrollPane pnlFilmes;
    // End of variables declaration//GEN-END:variables
}
