package br.com.cfp.eventos;

import br.com.cfp.classes.Dao.DividaDAO;
import br.com.cfp.classes.clDivida;
import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.cfp.views.CadastroDivida;
import javax.swing.JOptionPane;

public class clBotoesDivida implements ActionListener {

    private clDivida divida;
    private DividaDAO dividaDao = new DividaDAO();
    private CadastroDivida cadastroDivida;

    public clBotoesDivida(CadastroDivida cadastroDivida) {
        this.cadastroDivida = cadastroDivida;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("cadastrar".equals(e.getActionCommand())) {

            try {

                this.divida = this.cadastroDivida.getDivida();
                if (dividaDao.verificaDivida(this.divida.getiCod_divida())) {
                    dividaDao.atualizar(this.divida);
                    JOptionPane.showMessageDialog(null, "Divida Atualizada Com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Dívida Atualizada");

                } else {
                    dividaDao.insert(this.divida);
                    JOptionPane.showMessageDialog(null, "Divida Cadastrada Com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Dívida Cadastrada");
                }

            } catch (clExceptions mensagem) {
                mensagem.getMessage();
                String erro = mensagem.toString();
                JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            }

            //new DividaDao().insert(divida);       
        }

        if ("cancelar".equals(e.getActionCommand())) {

            new clLog("Saindo da tela de Dívida");
            this.cadastroDivida.fecharJanela();
        }

        if ("limpar".equals(e.getActionCommand())) {
            this.divida = this.cadastroDivida.limparCampos();
            new clLog("Dívida foi limpa");

        }

        if ("excluir".equals(e.getActionCommand())) {
            if(divida != null)
            {
            try {
                    dividaDao.delete(this.divida.getiCod_divida());
                    this.divida = this.cadastroDivida.apagarDivida(this.divida);
                    JOptionPane.showMessageDialog(null, "Divida Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Dívida Apagada");
                

            } catch (clExceptions mensagem) {

                mensagem.getMessage();
                String erro = mensagem.toString();
                JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Tentativa de apagar dividas, erro: " + mensagem);
            }
            }else
            {
                JOptionPane.showMessageDialog(null, "Não possuem dados para apagar", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Tentativa de apagar divida, porem não possui dados para apagar");
            }
        }

        if ("pesquisar".equals(e.getActionCommand())) {
            try {
                this.divida = dividaDao.getDivida(cadastroDivida.getCodDivida());
                cadastroDivida.setDivida(divida);
                JOptionPane.showMessageDialog(null, "Divida encontrada", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Divida encontrada no banco de dados");
            } catch (clExceptions mensagem) {
                mensagem.getMessage();
                String erro = mensagem.toString();
                new clLog("Erro na busca de divida: " + erro);
                JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            }

        }
    }

}
