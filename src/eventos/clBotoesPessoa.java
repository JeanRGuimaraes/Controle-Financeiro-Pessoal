
package eventos;

import classes.clPessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.CadastroPessoa;


public class clBotoesPessoa implements ActionListener{

    private CadastroPessoa cadastroPessoa;
    private clPessoa pessoa;
    
    public clBotoesPessoa(CadastroPessoa cadastroPessoa)
    {
        this.cadastroPessoa=cadastroPessoa;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if("cadastrar".equals(e.getActionCommand())){ 
            this.pessoa = cadastroPessoa.getiCodPessoa();
            this.pessoa.salvarPessoa();
                  
    }
         if("excluir".equals(e.getActionCommand())){  
            
    }
    if("cancelar".equals(e.getActionCommand())){  
     this.cadastroPessoa.dispose();      
          
    }
    if("limpar".equals(e.getActionCommand())){  
       this.pessoa = this.cadastroPessoa.limparCampos();    
          
    }
    
    
    } 
}
