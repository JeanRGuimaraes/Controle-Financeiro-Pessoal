package br.com.cfp.classes.Dao;


import br.com.cfp.classes.clExceptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoDAO {

     Connection conn = null;
    public Statement stm;//preparar e realizar pesquisas no banco de dados
    public ResultSet rs;//armasenar o rasultado de uma pesquisa pasada para o Statement

    public static Connection getConnection() throws clExceptions{
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/CFPBD", "sa", "");
        } catch (SQLException e) {
            throw new clExceptions("Problemas ao conectar no banco de dados \nERRO: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new clExceptions("O driver não foi configurado corretametne \nErro: " + e.getMessage());
        }

        return conn;
    }
     public void executaSQL(String sql) throws clExceptions {
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            throw new clExceptions("erro de execução no comando sql para o banco de dados \n ERRO: " + ex.getMessage());
        }
    }
}
