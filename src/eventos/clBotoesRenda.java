
package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class clBotoesRenda implements ActionListener{

    private JButton salvar, apagar, cancelar;
    
    public clBotoesRenda(JButton salvar, JButton apagar, JButton cancelar)
    {
        this.salvar = salvar;
        this.apagar = apagar;
        this.cancelar = cancelar;
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
