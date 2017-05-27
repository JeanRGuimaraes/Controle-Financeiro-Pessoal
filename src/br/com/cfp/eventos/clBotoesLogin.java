
package br.com.cfp.eventos;

import br.com.cfp.classes.clLog;
import br.com.cfp.classes.clLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.com.cfp.views.TelaLogin;


public class clBotoesLogin implements ActionListener{

     private TelaLogin telaLogin;
     private clLogin login;
     
	
	public clBotoesLogin(TelaLogin telaLogin){
            this.telaLogin = telaLogin;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("ok".equals(e.getActionCommand()))
        {
            login = telaLogin.setaUsuario();
            
            
            if(telaLogin.verificaUsuario(login))
            {
                new clLog("Login Valido, Usuario: " + login.getStrUsuario() + " Liberando Acesso ao sistema.");
                telaLogin.dispose();
            }else
            {
                new clLog("Login Inválido");
                JOptionPane.showMessageDialog(null, "Login Inválido");
            }
        }
        
        if("cancelar".equals(e.getActionCommand()))
        {
            new clLog("Encerrando Programa");
            telaLogin.encerrarPrograma();
        }
    }
    
}
