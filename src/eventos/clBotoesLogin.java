
package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class clBotoesLogin implements ActionListener{

     private JButton ok, cancela;
	
	public clBotoesLogin(JButton ok, JButton cancela){
		this.ok = ok;
		this.cancela = cancela;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == ok)
        {
            //evento do botão ok
        }
        
        if(e.getSource() == cancela)
        {
            //evento do botao cancelar
        }
    }
    
}
