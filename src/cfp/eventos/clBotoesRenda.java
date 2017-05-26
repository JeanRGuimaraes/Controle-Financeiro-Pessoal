
package cfp.eventos;

import cfp.classes.clRenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cfp.views.CadastroRenda;

public class clBotoesRenda implements ActionListener{

    private CadastroRenda cadastroRenda;
    private clRenda renda;
    
    public clBotoesRenda(CadastroRenda cadastroRenda)
    {
        this.cadastroRenda = cadastroRenda;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("cadastrar".equals(e.getActionCommand())) 
        {
           this.renda = this.cadastroRenda.getRenda();
           this.renda.salvarRenda();
        }
        
        if("cancelar".equals(e.getActionCommand()))
        {
           this.cadastroRenda.fecharJanela();
        }
        
        if("limpar".equals(e.getActionCommand()))
        {
            renda = cadastroRenda.limparCampos();
        }
        
        if("excluir".equals(e.getActionCommand()))
        {
            if(renda != null)
            {
                renda = cadastroRenda.apagarRenda(renda);
            }
        }
    }
    
}
