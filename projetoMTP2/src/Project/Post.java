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

    public Post(Usuario user, PostUser pu){
        this.user = user;
        this.pu = pu;
        
        this.Nome.setText(this.user.getNome());
        this.Post.setText(this.pu.getTexto());
        this.Likes.setText(Integer.toString(this.pu.getLikes()));
        
        try {
            InputStream entradaBytes = new ByteArrayInputStream(this.pu.getImagem());
            
            BufferedImage imagem = ImageIO.read(entradaBytes);
            
            ImageIcon imagem1 = new ImageIcon(imagem);
            
            this.lImagem.setIcon(imagem1);
            
       }catch (Exception e) {
       
       
       
       }
            
        
        
        
        
        
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomedousuario = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        Likes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Post = new javax.swing.JTextPane();
        lImagem = new javax.swing.JLabel();

        setToolTipText("");

        Nome.setText("Usuario");

        Data.setText("data do ");

        Likes.setText("likes");

        jScrollPane1.setViewportView(Post);

        lImagem.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(nomedousuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(Nome)
                        .addGap(92, 92, 92)
                        .addComponent(Data)
                        .addGap(89, 89, 89)
                        .addComponent(Likes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(nomedousuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome)
                    .addComponent(Data)
                    .addComponent(Likes))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Likes;
    private javax.swing.JLabel Nome;
    private javax.swing.JTextPane Post;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lImagem;
    private javax.swing.JLabel nomedousuario;
    // End of variables declaration//GEN-END:variables
}
