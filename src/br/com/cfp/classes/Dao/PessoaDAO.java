package br.com.cfp.classes.Dao;

import br.com.cfp.classes.clPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PessoaDAO {
    
     public void delete(int codigo) {

        ConexaoDAO conex = new ConexaoDAO();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = conex.getConnection();
            String sql = "delete from Pessoa where Codigo = ?";
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
    public void insert(clPessoa pessoa) {

         ConexaoDAO conex = new ConexaoDAO();
         Connection conn = null;
         PreparedStatement ps = null;

        try {

            conn = conex.getConnection();
            String sql = "insert into Pessoa (Codigo,Nome,Cpf,Rg,Telefone,Profisao,Email,Genero) values(?,?,?,?,?,?,?,?)";
          
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getiCodPessoa());
            ps.setString(2, pessoa.getStrNome());
            ps.setDouble(3, pessoa.getiCpf());
            ps.setInt(4, pessoa.getiRg());
            ps.setInt(5, pessoa.getiTelefone());
            ps.setString(6, pessoa.getStrProfissao());
            ps.setString(7, pessoa.getStrEmail());
            ps.setString(8, pessoa.getStrGenero());
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

    
     public void atualizar(clPessoa pessoa) {
        Connection conn = null;
        ConexaoDAO conex = new ConexaoDAO();
        PreparedStatement ps = null;
        try {
            conn = conex.getConnection();
            String sql = "update Pessoa set Codigo=?,Nome=?, Cpf=?,Rg=?,Telefone=?,Profisao=?,Email=?,Genero=?  where Codigo = " + pessoa.getiCodPessoa() + "";
            JOptionPane.showMessageDialog(null, pessoa.getiCodPessoa());
            
             ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getiCodPessoa());
            ps.setString(2, pessoa.getStrNome());
            ps.setDouble(3, pessoa.getiCpf());
            ps.setInt(4, pessoa.getiRg());
            ps.setInt(5, pessoa.getiTelefone());
            ps.setString(6, pessoa.getStrProfissao());
            ps.setString(7, pessoa.getStrEmail());
            ps.setString(8, pessoa.getStrGenero());
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
    
    public clPessoa getclPessoa(clPessoa retorno, Object object) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoDAO.getConnection();
            String sql = " select Codigo,Nome,Cpf,Rg,Telefone,Profisao,Email,Genero from Pessoa where Codigo=?";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, retorno.getiCodPessoa());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                clPessoa newp = new clPessoa();
                newp.setiCodPessoa(rs.getInt(1));
                newp.setStrNome(rs.getString(2));
                newp.setiCpf(rs.getFloat(3));
                newp.setiRg(rs.getInt(4));
                newp.setiTelefone(rs.getInt(5));
                newp.setStrProfissao(rs.getString(6));
                newp.setStrEmail(rs.getString(7));
                newp.setStrGenero(rs.getString(8));
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
