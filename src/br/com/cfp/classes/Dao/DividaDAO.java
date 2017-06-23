
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
            String sql = "insert into DIVIDAS (CODIGO,DESCRICAO,VALOR,DTINICIAL,DTFINAL,STATUS) values(?,?,?,?,?,?)";
          
            ps = conn.prepareStatement(sql);
            ps.setInt(1, divida.getiCod_divida());
            ps.setString(2, divida.getStrDescricao());
            ps.setFloat(3, divida.getfValor());
            ps.setString(4, divida.getStrPeriodoInicial());
            ps.setString(5, divida.getStrPeriodoFinal());
            ps.setString(6, divida.getStrStatus());
            ps.execute();
            conn.commit();

            

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
            String sql = "update DIVIDAS set CODIGO=?, DESCRICAO=?, VALOR=?, DTINICIAL=?, DTFINAL=? ,STATUS=?  where CODIGO = " + divida.getiCod_divida() + "";
            
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, divida.getiCod_divida());
            ps.setString(2, divida.getStrDescricao());
            ps.setFloat(3, divida.getfValor());
            ps.setString(4, divida.getStrPeriodoInicial());
            ps.setString(5, divida.getStrPeriodoFinal());
            ps.setString(6, divida.getStrStatus());
            ps.execute();
            conn.commit();
            
              
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
     
     //return true se existe, return false se não existe
      public boolean verificaDivida(int iCodigo)
      {
          Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;
        
        try {
            conn = ConexaoDAO.getConnection();
            String sql = " select CODIGO,DESCRICAO,VALOR,DTINICIAL,DTFINAL,STATUS from DIVIDAS where CODIGO=?";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, iCodigo);
            ResultSet rs = ps.executeQuery();
           if(rs.next())
           {
               resultado = true;
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
        return resultado;
      }
    
    public clDivida getclDivida(clDivida retorno) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoDAO.getConnection();
            String sql = " select CODIGO,DESCRICAO,VALOR,DTINICIAL,DTFINAL,STATUS from DIVIDAS where CODIGO=?";
            
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
      
