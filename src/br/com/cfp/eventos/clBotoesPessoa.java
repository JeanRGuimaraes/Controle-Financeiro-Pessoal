package br.com.cfp.eventos;

import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLog;
import br.com.cfp.classes.clPessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.cfp.views.CadastroPessoa;
import javax.swing.JOptionPane;

public class clBotoesPessoa implements ActionListener {

    private CadastroPessoa cadastroPessoa;
    private clPessoa pessoa;

    public clBotoesPessoa(CadastroPessoa cadastroPessoa) {
        this.cadastroPessoa = cadastroPessoa;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("cadastrar".equals(e.getActionCommand())) {    
             try{
           
                this.pessoa = this.cadastroPessoa.getPessoa();
                 JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                 new clLog("Cadastro feito com sucesso");
                 
            System.out.println("Codigo: " + this.pessoa.getiCodPessoa()+1);
            System.out.println("Nome: " + this.pessoa.getStrNome());
            System.out.println("Gênero: " + this.pessoa.getStrGenero());
            System.out.println("Email: " + this.pessoa.getStrEmail());
            System.out.println("Profissão: " + this.pessoa.getStrProfissao());
            System.out.println("Telefone: " + this.pessoa.getiTelefone());
            System.out.println("CPF: " + this.pessoa.getiCpf());
            System.out.println("RG: " + this.pessoa.getiRg());
                       
            }catch(clExceptions mensagem)
            {
                   mensagem.getMessage();
                   String erro = mensagem.toString();
                   JOptionPane.showMessageDialog(null, erro.replace("br.com.cfp.classes.clExceptions: ", ""), "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            }    
        }

        if ("excluir".equals(e.getActionCommand())) {

            if (this.pessoa != null) {
                this.pessoa = this.cadastroPessoa.apagarPessoa(this.pessoa);
                JOptionPane.showMessageDialog(null, "Cadastro apagado com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Cadastro apagado Apagada");
            }else
            {
            JOptionPane.showMessageDialog(null, "Não possuem dados para apagar", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                new clLog("Tentativa de apagar cadastro pessoa, porem não possui dados para apagar");
            }
        }
        if ("cancelar".equals(e.getActionCommand())) {
            new clLog("Saindo do Cadastro de Pessoa");
            this.cadastroPessoa.dispose();

        }
        if ("limpar".equals(e.getActionCommand())) {
            this.pessoa = this.cadastroPessoa.limparCampos();
            new clLog("Limpado Campos do Cadastro de Pessoas");

        }

    }
}
