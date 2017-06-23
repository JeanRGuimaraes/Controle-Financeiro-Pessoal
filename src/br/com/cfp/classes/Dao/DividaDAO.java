
package br.com.cfp.classes.Dao;

import br.com.cfp.classes.clDivida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DividaDAO {
    
    public void delete(int codigo) {

        ConexaoDAO conex = new ConexaoDAO();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = conex.getConnection();
            String sql = "delete from DIVIDAS where CODIGO= ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch(SQLException e) {

            System.out.println("ERRO: " + e.getMessage());
            JOptionPane.showMessageDialog(null,"codigo não existe");

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"codigo não existe");
                }
            }
        } 
        finally {

            if( ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"codigo não existe");
                }
            }
            if(conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null,"codigo não existe");
                }
            }
        }
    }
    public void insert(clDivida divida) {

         ConexaoDAO conex = new ConexaoDAO();
         Connection conn = null;
         PreparedStatement ps = null;

        try {

            conn = conex.getConnection();
            String sql = "insert into Divida (Codigo,Descricao,Valor,PeriodoInicial,PeriodoFinal,Status) values(?,?,?,?,?,?)";
          
            ps = conn.prepareStatement(sql);
            ps.setInt(1, divida.getiCod_divida());
            ps.setString(2, divida.getStrDescricao());
            ps.setFloat(3, divida.getfValor());
            ps.setString(4, divida.getStrPeriodoInicial());
            ps.setString(5, divida.getStrPeriodoFinal());
            ps.setString(6, divida.getStrStatus());
            ps.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Gravado com sucesso!");

        } catch(SQLException e) {

            JOptionPane.showMessageDialog(null,"erro " + e.getMessage());

            if(conn != null){

                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERRO: " + ex.getMessage());
                }
            }
        } finally {

            if( ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERRO: " + ex.getMessage());
                }
            }
        }
    }

    
     public void atualizar(clDivida divida) {
        Connection conn = null;
        ConexaoDAO conex = new ConexaoDAO();
        PreparedStatement ps = null;
        try {
            conn = conex.getConnection();
            String sql = "update Divida set Codigo=?, Descricao=?, valor=?, PeriodoInicial=?, PeriodoFinal=? ,Status=?  where CODIGO = " + divida.getiCod_divida() + "";
            JOptionPane.showMessageDialog(null, divida.getiCod_divida());
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, divida.getiCod_divida());
            ps.setString(2, divida.getStrDescricao());
            ps.setFloat(3, divida.getfValor());
            ps.setString(4, divida.getStrPeriodoInicial());
            ps.setString(5, divida.getStrPeriodoFinal());
            ps.setString(6, divida.getStrStatus());
            ps.execute();
            conn.commit();
            
              JOptionPane.showMessageDialog(null,"atualizado com sucesso!" );
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao atualizar!" );

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERRO: " + ex.getMessage());
                }
            }


        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERRO: " + ex.getMessage());
                }
            }
        }
    } 
    
    public clDivida getclDivida(clDivida retorno) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoDAO.getConnection();
            String sql = " select Codigo,Descricao,Valor,PeriodoInicial,PeriodoFinal,Status from Divida where Codigo=?";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, retorno.getiCod_divida());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                clDivida newp = new clDivida();
                newp.setiCod_divida(rs.getInt(1));
                newp.setStrDescricao(rs.getString(2));
                newp.setfValor(rs.getFloat(3));
                newp.setStrPeriodoInicial(rs.getString(4));
                newp.setStrPeriodoFinal(rs.getString(5));
                newp.setStrStatus(rs.getString(6));
                return newp;
            }
        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return null;
    }
  
    }
      
