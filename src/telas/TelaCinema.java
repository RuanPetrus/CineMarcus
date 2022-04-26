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
import static java.time.format.SignStyle.ALWAYS;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ruan
 */
public class TelaCinema extends javax.swing.JFrame {
    private final FilmeController filmeController;
    private final SessaoController sessaoController;
    private final List<Filme> listaFilmes;
    /**
     * Creates new form TelaCinema
     */
    public TelaCinema() {
        
        initComponents();
        setLocationRelativeTo(null);
        filmeController = FilmeController.getInstance();
        sessaoController = SessaoController.getInstance();
        listaFilmes = filmeController.getFilmes().parallelStream().collect(Collectors.toList());
        carregarFilmes();
    }

    /**
     *  Função responsável por colocar todos os filmes armazenado no JSON
     *  em um Painel
     */
    public void carregarFilmes(){
        pnlFilmes.removeAll();
        
        for (int i = 0; i < listaFilmes.size(); i++) {          
            Filme filme = listaFilmes.get(i);

            // Calcula X e Y
            int x = 25 + (167 * (i / 2));
            int y = 25 + (209 * (i % 2));
            
            // Cria label para armazenar o poster do filme
            JLabel labelFilme = new JLabel();
            TelaCinema self = this;
            labelFilme.setIcon(new ImageIcon(filme.getPoster()));
            labelFilme.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    new TelaFilme(filme, self).setVisible(true);
                }
            });
            labelFilme.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            // Define o tamanho da label com o poster do filme e adiciona na classe PAI
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnMI = new javax.swing.JButton();
        COFimgLogo = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        pnlFilmes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CineMarcus - Filmes em Cartaz");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Filmes em Cartaz");

        BtnMI.setText("Minhas Informações");
        BtnMI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnMI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnMIMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnMIMouseExited(evt);
            }
        });
        BtnMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMIActionPerformed(evt);
            }
        });

        COFimgLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        COFimgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.png"))); // NOI18N

        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlFilmes.setBackground(new java.awt.Color(255, 255, 255));
        pnlFilmes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFilmes.setPreferredSize(new java.awt.Dimension(579, 428));

        javax.swing.GroupLayout pnlFilmesLayout = new javax.swing.GroupLayout(pnlFilmes);
        pnlFilmes.setLayout(pnlFilmesLayout);
        pnlFilmesLayout.setHorizontalGroup(
            pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
        pnlFilmesLayout.setVerticalGroup(
            pnlFilmesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(pnlFilmes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(COFimgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addComponent(BtnMI, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPane))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(COFimgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnMI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMIActionPerformed
        new TelaMinhaInfo().setVisible(true);
    }//GEN-LAST:event_BtnMIActionPerformed

    private void BtnMIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMIMouseEntered
        BtnMI.setBackground(new java.awt.Color(255, 0, 0));
    }//GEN-LAST:event_BtnMIMouseEntered

    private void BtnMIMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMIMouseExited
        BtnMI.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_BtnMIMouseExited

                         
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
            java.util.logging.Logger.getLogger(TelaCinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCinema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnMI;
    private javax.swing.JLabel COFimgLogo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlFilmes;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
