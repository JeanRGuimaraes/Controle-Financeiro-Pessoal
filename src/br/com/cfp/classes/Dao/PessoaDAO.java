package br.com.cfp.classes.Dao;

import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    public void delete(int codigo, int iCodUsuario) throws clExceptions {

        ConexaoDAO conex = new ConexaoDAO();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = conex.getConnection();
            String sql = "delete from PESSOAS where CODIGO = ? and COD_USUARIO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setInt(2, iCodUsuario);
            ps.execute();
            conn.commit();

        } catch (SQLException e) {

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new clExceptions("Pessoa não encontrada");
                }
            } else {
                throw new clExceptions("ERRO: " + e.getMessage());
            }
        } finally {

            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new clExceptions("Pessoa não encontrada");
                }
            }
            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("Pessoa Não encontrada");
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
            String sql = "insert into PESSOAS (CODIGO,NOME,CPF,RG,TELEFONE,PROFISSAO,EMAIL,GENERO,COD_USUARIO) values(?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getiCodPessoa());
            ps.setString(2, pessoa.getStrNome());
            ps.setString(3, pessoa.getStrCpf());
            ps.setInt(4, pessoa.getiRg());
            ps.setString(5, pessoa.getStrTelefone());
            ps.setString(6, pessoa.getStrProfissao());
            ps.setString(7, pessoa.getStrEmail());
            ps.setString(8, pessoa.getStrGenero());
            ps.setInt(9, pessoa.getiCodUsuario());
            ps.execute();
            conn.commit();

        } catch (SQLException e) {

            if (conn != null) {

                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO: " + e.getMessage());
                }
            } else {
                throw new clExceptions("ERRO: " + e.getMessage());
            }
        } finally {

            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new clExceptions("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void atualizar(clPessoa pessoa) throws clExceptions {
        Connection conn = null;
        ConexaoDAO conex = new ConexaoDAO();
        PreparedStatement ps = null;
        try {
            conn = conex.getConnection();
            String sql = "update PESSOAS set CODIGO=?,NOME=?, CPF=?,RG=?,TELEFONE=?,PROFISSAO=?,EMAIL=?,GENERO=?  where CODIGO = " + pessoa.getiCodPessoa() + " AND COD_USUARIO = " + pessoa.getiCodUsuario();

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

        } catch (SQLException e) {

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new clExceptions("erro ao atualizar" + e.getMessage());

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

    public clPessoa getPessoa(int codigo, int iCodUsuario) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConexaoDAO.getConnection();
            String sql = " select CODIGO,NOME,CPF,RG,TELEFONE,PROFISSAO,EMAIL,GENERO, COD_USUARIO from PESSOAS where CODIGO=? AND COD_USUARIO = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setInt(2, iCodUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clPessoa newp = new clPessoa();
                newp.setiCodPessoa(rs.getInt(1));
                newp.setStrNome(rs.getString(2));
                newp.setStrCpf(rs.getString(3));
                newp.setiRg(rs.getInt(4));
                newp.setStrTelefone(rs.getString(5));
                newp.setStrProfissao(rs.getString(6));
                newp.setStrEmail(rs.getString(7));
                newp.setStrGenero(rs.getString(8));
                newp.setiCodUsuario(rs.getInt(9));
                return newp;
 

            }
        } catch (SQLException e) {
            throw new clExceptions("erro " + e.getMessage());
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
        return null;
    }

    //return true se existe, return false se não existe
    public boolean verificaPessoa(int iCodigo, int iCodUsuario) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;

        try {
            conn = ConexaoDAO.getConnection();
            String sql = "select CODIGO,NOME,CPF,RG,TELEFONE,PROFISSAO,EMAIL,GENERO from PESSOAS where CODIGO=? AND COD_USUARIO = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, iCodigo);
            ps.setInt(2, iCodUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

            throw new clExceptions("erro " + e.getMessage());
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
        return resultado;
    }
    
        //return true se existe, return false se não existe
    public boolean verificaCodPessoa(int iCodigo) throws clExceptions {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean resultado = false;

        try {
            conn = ConexaoDAO.getConnection();
            String sql = "select CODIGO,NOME,CPF,RG,TELEFONE,PROFISSAO,EMAIL,GENERO from PESSOAS where CODIGO=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, iCodigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = true;
            }

        } catch (SQLException e) {

            throw new clExceptions("erro " + e.getMessage());
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
        return resultado;
    }

}
