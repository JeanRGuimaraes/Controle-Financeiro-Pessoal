package br.com.cfp.classes.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {

     Connection conn = null;
    public Statement stm;//preparar e realizar pesquisas no banco de dados
    public ResultSet rs;//armasenar o rasultado de uma pesquisa pasada para o Statement

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            //conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/bancodb", "sa", "");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/agendadb", "sa", "");
        } catch (SQLException e) {
            System.out.println("Problemas ao conectar no banco de dados");
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi configurado corretametne");
        }

        return conn;
    }
     public void executaSQL(String sql) throws Exception {
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO DE EXECUÇÃO SQL! \n ERRO " + ex.getMessage());
        }
    }
}
