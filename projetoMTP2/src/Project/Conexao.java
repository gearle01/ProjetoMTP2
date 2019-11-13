package Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private String url = "jdbc:postgresql://localhost/mtpproject";
    /**
     * endereço do banco de dados
     */

    private String usuario = "postgres";
    /**
     * usuario do bano de dados
     */

    private String senha = "ifg";

    private Connection conn;

    /**
     * variavel global do tipo connection. Onde guarda a conexao com o banco de
     * dados
     */
    public Conexao() {
        connectar();
    }

    public void connectar() {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        Properties props = new Properties();
        props.setProperty("user", this.usuario);
        props.setProperty("password", this.senha);

        try {
            this.conn = DriverManager.getConnection(this.url, props);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Usuario login(String email, String senha) {
        try {
            PreparedStatement ps = this.conn
                    .prepareStatement("SELECT * FROM pessoa WHERE email = ? AND senha= ?;");
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario user = new Usuario();

                user.setId(rs.getInt(1));
                user.setNome(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setSenha(rs.getString(4));
                user.setCidadeEstado(rs.getString(5));

                return user; // 2 coluna
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public void inserir(String nome, String email, String senha, String cidade) throws SQLException {
        PreparedStatement st = this.conn.prepareStatement("INSERT INTO pessoa (nome, email, senha ,cidade_estado ) VALUES (?,?,?,?)");
        st.setString(1, nome);
        st.setString(2, email);
        st.setString(3, senha);
        st.setString(4, cidade);
        st.executeUpdate();
        st.close();

    }

    public Usuario atualizar(String nome, String senha, String cidade, Usuario novoUsuario) {
        try {
            PreparedStatement st = this.conn.prepareStatement("UPDATE pessoa SET nome = ?, senha = ?, cidade_estado = ? where id = ?");
            st.setString(1, nome);
            st.setString(2, senha);
            st.setString(3, cidade);
            st.setInt(4, novoUsuario.getId());
            st.executeUpdate();
            st.close();

            Usuario newuser = new Usuario();
            newuser.setNome(nome);
            newuser.setSenha(senha);
            newuser.setCidadeEstado(cidade);
            newuser.setEmail(novoUsuario.getEmail());
            newuser.setId(novoUsuario.getId());

            return newuser;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return novoUsuario;
    }

    public void salvarArquivoNoBd(String texto, File arquivo, Integer id) {
        try {

            // cria a consulta
            PreparedStatement ps;
            
            ps = this.conn.prepareStatement("INSERT INTO post (texto, imagem, pessoa_id, data) VALUES (?, ?, ?, now() )");
            FileInputStream fis = new FileInputStream(arquivo);
            
            ps.setString(1, texto);
            ps.setBinaryStream(2, fis, (int) arquivo.length());
            ps.setInt(3, id);

            // salva no banco de dados
            ps.executeUpdate();

            // fecha a consulta e o inputStream para agilizar a liberação de
            // recursos do computador
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarTexto(String texto, Integer id) {
        try {

            // cria a consulta
            PreparedStatement ps;
            ps = this.conn.prepareStatement("INSERT INTO post (texto, pessoa_id, data) VALUES (?, ?, now())");

            ps.setString(1, texto);
            ps.setInt(2, id);

            // salva no banco de dados
            ps.executeUpdate();

            // fecha a consulta e o inputStream para agilizar a liberação de
            // recursos do computador
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PostUser> buscarPost() {
        PreparedStatement bp;
        ArrayList<PostUser> lista = new ArrayList<PostUser>();

        try {
            bp = this.conn.prepareStatement("select texto, imagem, post.id, pessoa.nome, data from post \n"
                    + "	join pessoa on post.pessoa_id = pessoa.id order by post.data desc\n"
                    + "	limit 3 ");
            ResultSet result = bp.executeQuery();
            while (result.next()) {
                PostUser user = new PostUser();
                user.setTexto(result.getString(1));
                user.setImagem(result.getBytes(2));
                user.setId(result.getInt(3));
                user.setPessoaId(result.getString(4));
                user.setData(result.getTimestamp(5));
                lista.add(user);
            }

        } catch (SQLException ex) {

        }
        return lista;
    }

}
