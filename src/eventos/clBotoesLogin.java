
package eventos;

import classes.clLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.TelaLogin;


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
            login = telaLogin.verificarUsuario();
            
            if(login.verficarUsuario())
            {
                telaLogin.dispose();
            }
        }
        
        if("cancelar".equals(e.getActionCommand()))
        {
            telaLogin.encerrarPrograma();
        }
    }
    
}
