package br.com.cfp.classes.Dao;

import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {
    
     public void delete(int codigo) throws clExceptions{

        ConexaoDAO conex = new ConexaoDAO();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = conex.getConnection();
            String sql = "delete from PESSOAwhere CODIGO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.execute();
            conn.commit();
            

        } catch(SQLException e) {

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                     throw new clExceptions("codigo não existe");
                }
            }else
            {
                throw new clExceptions("ERRO: " + e.getMessage());
            }
        } 
        finally {

            if( ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                     throw new clExceptions("codigo não existe");
                }
            }
            if(conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                     throw new clExceptions("codigo não existe");
                }
            }
        }
    }
    public void insert(clPessoa pessoa) throws clExceptions {

         ConexaoDAO conex = new ConexaoDAO();
         Connection conn = null;
         PreparedStatement ps = null;

        try {

            conn = conex.getConnection();
            String sql = "insert into PESSOA (CODIGO,NOME,CPF,RG,TELEFONE,PROFISSAO,EMAIL,GENERO) values(?,?,?,?,?,?,?,?)";
          
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getiCodPessoa());
            ps.setString(2, pessoa.getStrNome());
            ps.setString(3, pessoa.getStrCpf());
            ps.setInt(4, pessoa.getiRg());
            ps.setString(5, pessoa.getStrTelefone());
            ps.setString(6, pessoa.getStrProfissao());
            ps.setString(7, pessoa.getStrEmail());
            ps.setString(8, pessoa.getStrGenero());
            ps.execute();
            conn.commit();

        } catch(SQLException e) {

            if(conn != null){

                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO: " + e.getMessage());
                }
            }else
             {
                throw new clExceptions("ERRO: " + e.getMessage());
                 }
        } finally {

            if( ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    
     public void atualizar(clPessoa pessoa) throws clExceptions{
        Connection conn = null;
        ConexaoDAO conex = new ConexaoDAO();
        PreparedStatement ps = null;
        try {
            conn = conex.getConnection();
            String sql = "update PESSOA set CODIGO=?,NOME=?, CPF=?,RG=?,TELEFONE=?,PROFISSAO=?,EMAIL=?,GENERO=?  where CODIGO = " + pessoa.getiCodPessoa();
            
             ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getiCodPessoa());
            ps.setString(2, pessoa.getStrNome());
            ps.setString(3, pessoa.getStrCpf());
            ps.setInt(4, pessoa.getiRg());
            ps.setString(5, pessoa.getStrTelefone());
            ps.setString(6, pessoa.getStrProfissao());
            ps.setString(7, pessoa.getStrEmail());
            ps.setString(8, pessoa.getStrGenero());
            ps.execute();
            conn.commit();

            
              
        } catch(SQLException e) {
            
            

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new clExceptions("erro ao atualizar" + e.getMessage());
                    
                }
            }else
            {
               throw new clExceptions("erro ao atualizar" + e.getMessage());
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
    
    public clPessoa getclPessoa(clPessoa retorno) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoDAO.getConnection();
            String sql = " select CODIGO,NOME,CPF,RG,TELEFONE,PROFISSAO,EMAIL,GENERO from Pessoa where CODIGO=?";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, retorno.getiCodPessoa());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                clPessoa newp = new clPessoa();
                newp.setiCodPessoa(rs.getInt(1));
                newp.setStrNome(rs.getString(2));
                newp.setStrCpf(rs.getString(3));
                newp.setiRg(rs.getInt(4));
                newp.setStrTelefone(rs.getString(5));
                newp.setStrProfissao(rs.getString(6));
                newp.setStrEmail(rs.getString(7));
                newp.setStrGenero(rs.getString(8));
                return newp;
            }
        } catch(SQLException e) {
            throw new clExceptions("erro " + e.getMessage());
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
        return null;
    }
  
    
}
