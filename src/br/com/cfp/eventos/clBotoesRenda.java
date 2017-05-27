
package br.com.cfp.eventos;

import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLog;
import br.com.cfp.classes.clRenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.cfp.views.CadastroRenda;
import javax.swing.JOptionPane;

public class clBotoesRenda implements ActionListener{

    private CadastroRenda cadastroRenda;
    private clRenda renda;
    
    public clBotoesRenda(CadastroRenda cadastroRenda)
    {
        this.cadastroRenda = cadastroRenda;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("cadastrar".equals(e.getActionCommand())) 
        {
            try{
                    this.renda = this.cadastroRenda.getRenda();

                    
                    System.out.println("Codigo: " + renda.getiCodigoRenda() + 1);
                    System.out.println("Renda: " + renda.getfRenda());
                    System.out.println("Nome: " + renda.getStrNome());
                    System.out.println("Periodo Inicial: " + renda.getStrPeriodoInicial());
                    System.out.println("Periodo Final: " + renda.getStrPeriodoFinal());
                    System.out.println("Observação: " + renda.getStrDescricao());
                    
                    JOptionPane.showMessageDialog(null, "Renda Cadastrada Com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Renda Cadastrada");
            }
            catch(clExceptions mensagem)
            {
                mensagem.getMessage();
                String erro = mensagem.toString();
                JOptionPane.showMessageDialog(null, erro.replace("classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
                
            }

        }
        
        if("cancelar".equals(e.getActionCommand()))
        {
            new clLog("Saiu da tela de Renda");
           this.cadastroRenda.fecharJanela();
        }
        
        if("limpar".equals(e.getActionCommand()))
        {
            renda = cadastroRenda.limparCampos();
            new clLog("Os campos de Renda foram limpos");
        }
        
        if("excluir".equals(e.getActionCommand()))
        {
            if(renda != null)
            {
                renda = cadastroRenda.apagarRenda();
                JOptionPane.showMessageDialog(null, "Renda Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Renda Apagada");
            }else
            {
                JOptionPane.showMessageDialog(null, "Não possuem dados para apagar", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                 new clLog("Tentativa de apagar renda, porem não possui dados para apagar");
            }
        }
    }
    
}
