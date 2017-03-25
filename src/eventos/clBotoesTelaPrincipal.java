
package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class clBotoesTelaPrincipal implements ActionListener{

    private JMenuItem JMIcadastroPessoa, JMIcadastroRenda, JMIcadastroDivida;
    private JMenu JMsobre;
    
    public clBotoesTelaPrincipal(JMenuItem JMIcadastroPessoa, JMenuItem JMIcadastroRenda, JMenuItem JMIcadastroDivida, JMenu JMsobre)
    {
        this.JMIcadastroPessoa = JMIcadastroPessoa;
        this.JMIcadastroDivida = JMIcadastroDivida;
        this.JMIcadastroRenda = JMIcadastroRenda;
        this.JMsobre = JMsobre;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == JMIcadastroPessoa)
        {
            //action do botão cadastro Pessoa
        }
        
        if(e.getSource() == JMIcadastroRenda)
        {
            //action do botão cadastro renda
        }
        
        if(e.getSource() == JMIcadastroDivida)
        {
            //action do botão cadastro divida
        }
        
        if(e.getSource() == JMsobre)
        {
            //action do botão sobre
        }
    }
    
}
