
package br.com.cfp.classes.Dao;

import br.com.cfp.classes.clRenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RendaDAO {
    
      public void delete(int codigo) {

        ConexaoDAO conex = new ConexaoDAO();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = conex.getConnection();
            String sql = "delete from Renda where Codigo = ?";
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
    public void insert(clRenda renda) {

         ConexaoDAO conex = new ConexaoDAO();
         Connection conn = null;
         PreparedStatement ps = null;

        try {

            conn = conex.getConnection();
            String sql = "insert into Renda (Codigo,Nome,Renda,PeriodoInicial,PeriodoFinal,Obervacoes) values(?,?,?,?,?,?)";
          
            ps = conn.prepareStatement(sql);
            ps.setInt(1, renda.getiCodigoRenda());
            ps.setString(2, renda.getStrNome());
            ps.setDouble(3, renda.getfRenda());
            ps.setString(4, renda.getStrPeriodoInicial());
            ps.setString(5, renda.getStrPeriodoInicial());
            ps.setString(6, renda.getStrDescricao());
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

    
     public void atualizar(clRenda renda) {
        Connection conn = null;
        ConexaoDAO conex = new ConexaoDAO();
        PreparedStatement ps = null;
        try {
            conn = conex.getConnection();
            String sql = "update Renda set Codigo=?,Nome=?, Renda=?,PeriodoInicial=?,PeriodoFinal=?,Observacoes=? where Codigo = " + renda.getiCodigoRenda() + "";
            JOptionPane.showMessageDialog(null, renda.getiCodigoRenda());
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, renda.getiCodigoRenda());
            ps.setString(2, renda.getStrNome());
            ps.setDouble(3, renda.getfRenda());
            ps.setString(4, renda.getStrPeriodoInicial());
            ps.setString(5, renda.getStrPeriodoFinal());
            ps.setString(6, renda.getStrDescricao());
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
    
    public clRenda getclPessoa(clRenda retorno, Object object) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoDAO.getConnection();
            String sql = " select Codigo,Nome,Renda,PeriodoInicial,PeriodoFinal,Obervacoes from Renda where Codigo=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, retorno.getiCodigoRenda());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                clRenda newp = new clRenda();
                newp.setiCodigoRenda(rs.getInt(1));
                newp.setStrNome(rs.getString(2));
                newp.setfRenda(rs.getFloat(3));
                newp.setStrPeriodoInicial(rs.getString(4));
                newp.setStrPeriodoFinal(rs.getString(5));
                newp.setStrDescricao(rs.getString(6));
              
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
