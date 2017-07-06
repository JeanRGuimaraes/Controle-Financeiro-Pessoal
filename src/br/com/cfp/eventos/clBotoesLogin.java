
package br.com.cfp.eventos;

import br.com.cfp.classes.Dao.UsuarioDAO;
import br.com.cfp.classes.clLog;
import br.com.cfp.classes.clLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.com.cfp.views.TelaLogin;
import br.com.cfp.classes.clArquivo;
import br.com.cfp.classes.clExceptions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clBotoesLogin implements ActionListener{

     private TelaLogin telaLogin;
     private clLogin login;
     private UsuarioDAO usuario;
     
     

	
	public clBotoesLogin(TelaLogin telaLogin){
            this.telaLogin = telaLogin;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("ok".equals(e.getActionCommand()))
        {
 
            login = telaLogin.setaUsuario();
            try {
                if(telaLogin.verificaUsuario(login))
                {
                    new clLog("Login Valido, Usuario: " + login.getStrUsuario() + ", Liberando Acesso ao sistema.");
                    try {
                        telaLogin.salvaUsuarioArquivo();
                    } catch (IOException ex) {
                        Logger.getLogger(clBotoesLogin.class.getName()).log(Level.SEVERE, null, ex);
                        new clLog("Erro na hora de ler o arquivo " + login.getStrUsuario());
                    }
                    telaLogin.dispose();
                }else
                {
                    new clLog("Login Inválido");
                    JOptionPane.showMessageDialog(null, "Login Inválido");
                }
            } catch (clExceptions ex) {
                Logger.getLogger(clBotoesLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if("cancelar".equals(e.getActionCommand()))
        {
            new clLog("Encerrando Programa");
            telaLogin.encerrarPrograma();
        }
    }
 
   
}
