package br.com.cfp.eventos;

import br.com.cfp.classes.Dao.RendaDAO;
import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLog;
import br.com.cfp.classes.clRenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.cfp.views.CadastroRenda;
import javax.swing.JOptionPane;

public class clBotoesRenda implements ActionListener {

    private CadastroRenda cadastroRenda;
    private RendaDAO rendaDAO = new RendaDAO();
    private clRenda renda;

    public clBotoesRenda(CadastroRenda cadastroRenda) {
        this.cadastroRenda = cadastroRenda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("cadastrar".equals(e.getActionCommand())) {
            try {
                this.renda = this.cadastroRenda.getRenda();
                if (rendaDAO.verificaRenda(this.renda.getiCodigoRenda(), this.renda.getiCodUsuario())) {
                    rendaDAO.atualizar(this.renda);
                    JOptionPane.showMessageDialog(null, "Renda atuaizada com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Cadastro atualizado com sucesso");
                } else {
                    if (!rendaDAO.verificaCodRenda(this.renda.getiCodigoRenda())) {
                        rendaDAO.insert(this.renda);
                        JOptionPane.showMessageDialog(null, "Renda Cadastrada com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                        new clLog("Cadastro de Renda feito com sucesso");
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Codigo da renda pertence a outro usuario", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                        new clLog("Permissão negada em cadastrar codigo de renda pois pertence a outro usuario");
                    }
                }
            } catch (clExceptions mensagem) {
                mensagem.getMessage();
                String erro = mensagem.toString();
                JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
                new clLog(erro.replace("br.com.cfp.classes.clExceptions: ", ""));
            }
        }

        if ("cancelar".equals(e.getActionCommand())) {
            new clLog("Saiu da tela de Renda");
            this.cadastroRenda.fecharJanela();
        }

        if ("limpar".equals(e.getActionCommand())) {
            renda = cadastroRenda.limparCampos();
            new clLog("Os campos de Renda foram limpos");
        }
        if ("excluir".equals(e.getActionCommand())) {
            if (this.renda != null) {

                try {
                    rendaDAO.delete(this.renda.getiCodigoRenda(), this.renda.getiCodUsuario());
                    this.renda = this.cadastroRenda.apagarRenda(this.renda);
                    JOptionPane.showMessageDialog(null, "Cadastro de Renda deletado com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Cadastro de Renda deletado");

                } catch (clExceptions mensagem) {
                    mensagem.getMessage();
                    String erro = mensagem.toString();
                    JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
                    new clLog(erro.replace("br.com.cfp.classes.clExceptions: ", ""));
                    //  Logger.getLogger(clBotoesRenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não possuem dados para apagar", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Tentativa de apagar cadastro de Renda, porem não possui dados para apagar");
            }
        }

        if ("pesquisar".equals(e.getActionCommand())) {
            try {
                this.renda = rendaDAO.getclRenda(cadastroRenda.getCodRenda(), cadastroRenda.getiCodUsuario());
                cadastroRenda.setRenda(this.renda);
                JOptionPane.showMessageDialog(null, "Renda encontrada", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Renda encontrada no banco de dados");
            } catch (clExceptions mensagem) {
                mensagem.getMessage();
                String erro = mensagem.toString();
                JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
                new clLog(erro.replace("br.com.cfp.classes.clExceptions: ", ""));
            }
        }
    }
}
