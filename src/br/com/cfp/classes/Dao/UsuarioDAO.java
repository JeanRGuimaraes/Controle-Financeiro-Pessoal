package br.com.cfp.classes.Dao;

import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao Filipe
 */
public class UsuarioDAO {
    
    public void insertUsuario(clLogin login)throws clExceptions {

         ConexaoDAO conex = new ConexaoDAO();
         Connection conn = null;
         PreparedStatement ps = null;
                
        try {

            conn = conex.getConnection();          
            String sql = "insert into USUARIO (CODIGO,NOME,USUARIO,SENHA) values(?,?,?,?)";
          
            ps = conn.prepareStatement(sql);
            ps.setInt(1, login.getiCod_Usuario());
            ps.setString(2, login.getStrNome());
            ps.setString(3, login.getStrUsuario());
            ps.setString(4, login.getStrSenha());
            ps.execute();
            conn.commit();

           // JOptionPane.showMessageDialog(null, "Gravado com sucesso!");

         } catch(SQLException e) {

            if(conn != null){

                try {
                    conn.rollback();
                    throw new clExceptions("erro " + e.getMessage());
                } catch (SQLException ex) {
                    throw new clExceptions("erro " + ex.getMessage());
                }
            }
        } finally {

            if( ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new clExceptions("erro " + ex.getMessage());
                }
            }
            if(conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("erro " + ex.getMessage());
                }
            }
        }
    }

    


    public clLogin verificaLogin(String iUsuario,String iSenha) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoDAO.getConnection();
            String sql = "select CODIGO,NOME,USUARIO,SENHA from USUARIO where USUARIO=? AND SENHA=?"; 

            ps = conn.prepareStatement(sql);
            ps.setString(1, iUsuario);
            ps.setString(2, iSenha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clLogin login = new clLogin();
                login.setiCod_Usuario(rs.getInt(1));
                login.setStrNome(rs.getString(2));
                login.setStrUsuario(rs.getString(3));
                login.setStrSenha(rs.getString(4));
                
                return login;
            }

        } catch (SQLException ex) {
             throw new clExceptions("ERRO " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                      throw new clExceptions("ERRO " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO " + ex.getMessage());
                }
            }
        }
        return null;
    }
    
    public boolean verificaUsuario(int iCodigo) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;

        try {
            conn = ConexaoDAO.getConnection();
            String sql = "select CODIGO,NOME,USUARIO,SENHA from USUARIO where CODIGO=?"; 

            ps = conn.prepareStatement(sql);
            ps.setInt(1, iCodigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
             throw new clExceptions("ERRO " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                      throw new clExceptions("ERRO " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO " + ex.getMessage());
                }
            }
        }
        return resultado;
    
    }
    
}
    

