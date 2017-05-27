package br.com.cfp.eventos;

import br.com.cfp.classes.clDivida;
import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.cfp.views.CadastroDivida;
import javax.swing.JOptionPane;

public class clBotoesDivida implements ActionListener {

    private clDivida divida;

    private CadastroDivida cadastroDivida;

    public clBotoesDivida(CadastroDivida cadastroDivida) {
        this.cadastroDivida = cadastroDivida;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("cadastrar".equals(e.getActionCommand())) {
         
            try{
//            
                this.divida = this.cadastroDivida.getDivida();
                 JOptionPane.showMessageDialog(null, "Divida Cadastrada Com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                 new clLog("Dívida Cadastrada");
                 
                 
            System.out.println("Código: " + this.divida.getiCod_divida() + 1);
            System.out.println("Valor: " + this.divida.getfValor());
            System.out.println("Descrição: " + this.divida.getStrDescricao());
            System.out.println("Periodo1: " + this.divida.getStrPeriodoInicial());
            System.out.println("Perido2" + this.divida.getStrPeriodoFinal());
            System.out.println("Status: " + this.divida.getStrStatus());
                 
                 
            }catch(clExceptions mensagem)
            {
                   mensagem.getMessage();
                   String erro = mensagem.toString();
                   JOptionPane.showMessageDialog(null, erro.replace("classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            }


            //new DividaDao().insert(divida);
            
            
         
        }

        if ("cancelar".equals(e.getActionCommand())) {
            
            this.cadastroDivida.fecharJanela();
        }

        if ("limpar".equals(e.getActionCommand())) {
            this.divida = this.cadastroDivida.limparCampos();
             new clLog("Dívida foi limpa");
            
        }

        if ("excluir".equals(e.getActionCommand())) {
            if (this.divida != null) {
                this.divida = this.cadastroDivida.apagarDivida(this.divida);
                JOptionPane.showMessageDialog(null, "Divida Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Dívida Apagada");
            }else
            {
            JOptionPane.showMessageDialog(null, "Não possuem dados para apagar", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Tentativa de apagar dividas, porem não possui dados para apagar");
            }
        }
    }

}
