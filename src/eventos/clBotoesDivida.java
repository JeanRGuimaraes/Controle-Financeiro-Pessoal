
package eventos;

import classes.clDivida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.CadastroDivida;


public class clBotoesDivida implements ActionListener{
    
    private clDivida divida;
    
    private CadastroDivida cadastroDivida;
    
    public clBotoesDivida(CadastroDivida cadastroDivida) {
        this.cadastroDivida = cadastroDivida;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("cadastrar".equals(e.getActionCommand())) {
            clDivida divida = cadastroDivida.getDivida();
            System.out.println(divida.toString());
            
            //new DividaDao().insert(divida);
            
        }
        
       
    }
    
    
}
