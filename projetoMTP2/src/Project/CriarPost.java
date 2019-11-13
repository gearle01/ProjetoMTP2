package Project;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CriarPost extends javax.swing.JFrame {

    private Usuario user;
    private JFileChooser fc;
    private File arquivo;

    /**
     * Creates new form Post
     */
    public CriarPost(Usuario user) {
        initComponents();
        setLocationRelativeTo(null);
        this.user = user;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cancelar = new javax.swing.JButton();
        Enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        BotaoUP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Post");

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        BotaoUP.setText("Selecionar");
        BotaoUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoUPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoUP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Enviar)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancelar)
                        .addComponent(Enviar))
                    .addComponent(BotaoUP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        new Principal(this.user).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void BotaoUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoUPActionPerformed
        fc = new JFileChooser();
        int retorno = fc.showOpenDialog(this);
        File novoArquivo = fc.getSelectedFile();
        if (retorno == JFileChooser.APPROVE_OPTION) {
            // if (novoArquivo.getName().toLowerCase().endsWith(".jpg") || novoArquivo.getName().toLowerCase().endsWith(".png")) {
            arquivo = novoArquivo;
            jLabel1.setText(arquivo.getName());
            //}

        }


    }//GEN-LAST:event_BotaoUPActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        if (texto.getText().isEmpty() && arquivo == null) {
            JOptionPane.showMessageDialog(null, "O Post Não Pode Ser Vazio!");
        } else {
            if (texto.getText().length() > 140) {
                JOptionPane.showMessageDialog(null, "O Post Tem Mais De 140 Caracters!");
            } else {
                Conexao leia = new Conexao();
                try {
                    if (arquivo != null) {

                        leia.salvarArquivoNoBd(texto.getText(), arquivo, this.user.getId());
                        JOptionPane.showMessageDialog(null, "Sucesso!");

                        this.dispose();
                        new Principal(this.user).setVisible(true);

                    } else {
                        leia.salvarTexto(texto.getText(), this.user.getId());
                        JOptionPane.showMessageDialog(null, "Sucesso!");

                        this.dispose();
                        new Principal(this.user).setVisible(true);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Algo Deu Errado, Tente Novamente!");
                    //e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_EnviarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoUP;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
