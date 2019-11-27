/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ifg
 */
public class Post extends javax.swing.JPanel {

    private Usuario user;
    private PostUser pu;
    private Conexao conn;

    public Post() {
        initComponents();
    }

    public Post(Usuario user, PostUser pu) {
        initComponents();
        this.user = user;
        this.pu = pu;
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        data.setText(sp.format(this.pu.getData()));
        //jLabel1.setText(arquivo.getName());

        this.nome.setText(this.user.getNome());
        this.post.setText(this.pu.getTexto());
        this.likes.setText(Integer.toString(pu.getLikes()));
        if (pu.getImagem() != null) {
            try {
                InputStream entradaBytes = new ByteArrayInputStream(this.pu.getImagem());

                BufferedImage imagem = ImageIO.read(entradaBytes);

                ImageIcon imagem1 = new ImageIcon(imagem);

                this.lImagem.setIcon(imagem1);

            } catch (Exception e) {
                // e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Algo deu errado!");

            }

        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomedousuario = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        likes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        post = new javax.swing.JTextPane();
        lImagem = new javax.swing.JLabel();
        botonLike = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setToolTipText("");

        post.setEditable(false);
        post.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(post);

        botonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/like.png"))); // NOI18N
        botonLike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonLikeMouseClicked(evt);
            }
        });
        botonLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLikeActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário:");

        jLabel2.setText("Data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nomedousuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lImagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nome)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(likes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(botonLike)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(likes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonLike, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nome)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomedousuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLikeActionPerformed


    }//GEN-LAST:event_botonLikeActionPerformed

    private void botonLikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonLikeMouseClicked
        Conexao conn = new Conexao();
        conn.connectar();
        try {
            conn.like(pu.getId(), user.getId());
            int totalLike = conn.contarlike(pu.getId());

            likes.setText(Integer.toString(totalLike));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Já existe like neste post!");
        }
    }//GEN-LAST:event_botonLikeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLike;
    private javax.swing.JLabel data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lImagem;
    private javax.swing.JLabel likes;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nomedousuario;
    private javax.swing.JTextPane post;
    // End of variables declaration//GEN-END:variables
}
