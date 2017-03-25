
package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class clBotoesPessoa implements ActionListener{

    private JButton salvar, apagar, cancelar;
    
    public clBotoesPessoa(JButton salvar, JButton apagar, JButton cancelar)
    {
        this.salvar = salvar;
        this.cancelar = cancelar;
        this.apagar = apagar;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salvar)
        {
            //action do botão salvar
        }
        
        if(e.getSource() == apagar)
        {
            //action do botão apagar
        }
        
        if(e.getSource() == cancelar)
        {
            //action do botão cancelar
        }
    }
    
}
