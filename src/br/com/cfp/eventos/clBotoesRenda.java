
package br.com.cfp.eventos;

import br.com.cfp.classes.Dao.RendaDAO;
import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLog;
import br.com.cfp.classes.clRenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.cfp.views.CadastroRenda;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class clBotoesRenda implements ActionListener{

    private CadastroRenda cadastroRenda;
    private RendaDAO rendaDAO=new RendaDAO();
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
                    if (rendaDAO.verificaRenda(this.renda.getiCodigoRenda())) {
                    rendaDAO.atualizar(this.renda);
                    JOptionPane.showMessageDialog(null, "Renda Cadastrada Com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Cadastro atualizado com sucesso");
                } else {
                    rendaDAO.insert(this.renda);
                    JOptionPane.showMessageDialog(null, "Renda Cadastro feito com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Cadastro de Renda feito com sucesso");
                }
            }
            catch(clExceptions mensagem)
            {
                mensagem.getMessage();
                String erro = mensagem.toString();
                System.out.println(erro);
                JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
                
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
            if (this.renda != null) {

                try {
                     rendaDAO.delete(this.renda.getiCodigoRenda());
                     this.renda = this.cadastroRenda.apagarRenda(this.renda);
                     JOptionPane.showMessageDialog(null, "Cadastro de Renda deletado com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                     new clLog("Cadastro de Renda deletado");
                     
                } catch (clExceptions mensagem) {
                     mensagem.getMessage();
                     String erro = mensagem.toString();
                     JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
                  //  Logger.getLogger(clBotoesRenda.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } else {
                JOptionPane.showMessageDialog(null, "Não possuem dados para apagar", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Tentativa de apagar cadastro de Renda, porem não possui dados para apagar");
             }
            }
         
              if ("pesquisar".equals(e.getActionCommand())) {
            try {
                this.renda = rendaDAO.getclRenda(cadastroRenda.getCodRenda());
                cadastroRenda.setRenda(this.renda);
                JOptionPane.showMessageDialog(null, "Renda encontrada", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Renda encontrada no banco de dados");
            } catch (clExceptions mensagem) {
                mensagem.getMessage();
                String erro = mensagem.toString();
                JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    }
    

