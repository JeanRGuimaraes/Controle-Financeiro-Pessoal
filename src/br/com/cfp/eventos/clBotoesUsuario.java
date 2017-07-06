package br.com.cfp.eventos;

import br.com.cfp.classes.Dao.UsuarioDAO;
import br.com.cfp.classes.clExceptions;
import br.com.cfp.classes.clLog;
import br.com.cfp.classes.clLogin;
import br.com.cfp.views.CadastroUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author comp8
 */
public class clBotoesUsuario implements ActionListener {

    private clLogin login;
    private UsuarioDAO UsuarioDAO=new UsuarioDAO();
    private CadastroUsuario cadastroUsuario;

    public clBotoesUsuario(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("cadastrar".equals(e.getActionCommand())) 
        {
            try{
                    this.login = this.cadastroUsuario.getUsuario();
                    UsuarioDAO.insertUsuario(this.login);
                    JOptionPane.showMessageDialog(null, "Login Cadastrado com sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
                    new clLog("Cadastro de Usuario feito com sucesso");
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
            new clLog("Saiu da tela de Cadastro de Usuario");
           this.cadastroUsuario.fecharJanela();
        }
        
        if("limpar".equals(e.getActionCommand()))
        {
            login = cadastroUsuario.limparCampos();
            new clLog("Os campos foram limpos");
        }

    }

}
