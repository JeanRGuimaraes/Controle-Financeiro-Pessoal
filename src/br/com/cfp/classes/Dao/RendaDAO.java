
package br.com.cfp.classes.Dao;
import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clRenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RendaDAO {
    
      public void delete(int codigo, int iCodUsuario)throws clExceptions {

        ConexaoDAO conex = new ConexaoDAO();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = conex.getConnection();
            String sql = "delete from RENDA where CODIGO = ? and COD_USUARIO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.setInt(2, iCodUsuario);
            ps.execute();
            conn.commit();

        } catch(SQLException e) {
            
            if (conn != null) {
                try {
                    conn.rollback();
                    throw new clExceptions("erro ao deletar a renda  \nERRO: " + e.getMessage());
                } catch (SQLException ex) {
                    throw new clExceptions("Erro ao deletar a renda: " + ex.getMessage());
                }
            } else {
                throw new clExceptions("ERRO: " + e.getMessage());
            }
        } finally {

            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new clExceptions("Erro ao fechar a conexão com o banco \nERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("Erro ao fechar a conexão com o banco \nERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void insert(clRenda renda)throws clExceptions {

         ConexaoDAO conex = new ConexaoDAO();
         Connection conn = null;
         PreparedStatement ps = null;

        try {

            conn = conex.getConnection();
            String sql = "insert into RENDA (CODIGO,NOME,RENDA,PERIODOINICIAL,PERIODOFINAL,OBSERVACOES, COD_USUARIO) values(?,?,?,?,?,?,?)";
          
            ps = conn.prepareStatement(sql);
            ps.setInt(1, renda.getiCodigoRenda());
            ps.setString(2, renda.getStrNome());
            ps.setDouble(3, renda.getfRenda());
            ps.setString(4, renda.getStrPeriodoInicial());
            ps.setString(5, renda.getStrPeriodoFinal());
            ps.setString(6, renda.getStrDescricao());
            ps.setInt(7, renda.getiCodUsuario());
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

    
     public void atualizar(clRenda renda)throws clExceptions {
        Connection conn = null;
        ConexaoDAO conex = new ConexaoDAO();
        PreparedStatement ps = null;
        try {
            conn = conex.getConnection();
            String sql = "update RENDA set CODIGO=?,NOME=?, RENDA=?,PERIODOINICIAL=?,PERIODOFINAL=?,OBSERVACOES=? where CODIGO = " + renda.getiCodigoRenda() + " and COD_USUARIO = " + renda.getiCodUsuario();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, renda.getiCodigoRenda());
            ps.setString(2, renda.getStrNome());
            ps.setDouble(3, renda.getfRenda());
            ps.setString(4, renda.getStrPeriodoInicial());
            ps.setString(5, renda.getStrPeriodoFinal());
            ps.setString(6, renda.getStrDescricao());
            ps.execute();
            conn.commit();
            
         // JOptionPane.showMessageDialog(null,"atualizado com sucesso!" );
        } catch(SQLException e) {
           if (conn != null) {
                try {
                    conn.rollback();
                    throw new clExceptions("erro " + e.getMessage());
                } catch (SQLException ex) {
                    throw new clExceptions("erro ao atualizar" + ex.getMessage());

                }
            } else {
                throw new clExceptions("erro ao atualizar" + e.getMessage());
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new clExceptions("erro " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("erro " + ex.getMessage());
                }
            }
        }
    } 
    public clRenda getclRenda(int codigo, int iCodUsuario) throws clExceptions{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoDAO.getConnection();
            String sql = "select CODIGO,NOME,RENDA,PERIODOINICIAL,PERIODOFINAL,OBSERVACOES, COD_USUARIO from RENDA where CODIGO=? and COD_USUARIO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.setInt(2, iCodUsuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                clRenda newp = new clRenda();
                newp.setiCodigoRenda(rs.getInt(1));
                newp.setStrNome(rs.getString(2));
                newp.setfRenda(rs.getFloat(3));
                newp.setStrPeriodoInicial(rs.getString(4));
                newp.setStrPeriodoFinal(rs.getString(5));
                newp.setStrDescricao(rs.getString(6));
                newp.setiCodUsuario(rs.getInt(7));
              
                return newp;
            }
        } catch(SQLException e) {
            throw new clExceptions("erro ao atualizar" + e.getMessage());
        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new clExceptions("erro ao atualizar" + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("erro ao atualizar" + ex.getMessage());
                }
            }
        }
        return null;
    }
  
    //return true se existe, return false se não existe
    public boolean verificaRenda(int iCodigo, int iCodUsuario) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;

        try {
            conn = ConexaoDAO.getConnection();
            String sql = "select CODIGO,NOME,RENDA,PERIODOINICIAL,PERIODOFINAL,OBSERVACOES from RENDA where CODIGO=? and COD_USUARIO = ?"; 

            ps = conn.prepareStatement(sql);
            ps.setInt(1, iCodigo);
            ps.setInt(2, iCodUsuario);
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
    
        public boolean verificaCodRenda(int iCodigo) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;

        try {
            conn = ConexaoDAO.getConnection();
            String sql = "select CODIGO,NOME,RENDA,PERIODOINICIAL,PERIODOFINAL,OBSERVACOES from RENDA where CODIGO=?"; 

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
