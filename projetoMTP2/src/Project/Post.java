/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    public Post() {
        initComponents();
    }

    public Post(Usuario user, PostUser pu) {
        initComponents();
        this.user = user;
        this.pu = pu;

        this.nome.setText(this.user.getNome());
        this.post.setText(this.pu.getTexto());
        this.likes.setText(Integer.toString(this.pu.getLikes()));

        if (pu.getImagem() != null) {
            try {
                InputStream entradaBytes = new ByteArrayInputStream(this.pu.getImagem());

                BufferedImage imagem = ImageIO.read(entradaBytes);

                ImageIcon imagem1 = new ImageIcon(imagem);

                this.lImagem.setIcon(imagem1);

            } catch (Exception e) {
                e.printStackTrace();
                //JOptionPane.showMessageDialog(null, "Algo deu errado!");

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

        setToolTipText("");

        nome.setText("Usuario");

        data.setText("data do ");

        likes.setText("likes");

        post.setEditable(false);
        post.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(post);

        botonLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project/like.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nomedousuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nome)
                        .addGap(140, 140, 140)
                        .addComponent(data)
                        .addGap(201, 201, 201)
                        .addComponent(likes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(botonLike)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lImagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nome)
                                    .addComponent(data)
                                    .addComponent(likes))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonLike)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomedousuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLike;
    private javax.swing.JLabel data;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lImagem;
    private javax.swing.JLabel likes;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel nomedousuario;
    private javax.swing.JTextPane post;
    // End of variables declaration//GEN-END:variables
}
