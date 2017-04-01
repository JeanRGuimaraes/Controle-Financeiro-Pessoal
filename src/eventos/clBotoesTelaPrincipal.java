package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.TelaPrincipal;

public class clBotoesTelaPrincipal implements ActionListener {

    TelaPrincipal telaPrincipal;
    
    public clBotoesTelaPrincipal(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("cadastro_pessoa".equals(e.getActionCommand())) {
            telaPrincipal.abrirJanelaCadastroPessoa();
        }

        if ("cadastro_renda".equals(e.getActionCommand())) {
            telaPrincipal.abrirJanelaRenda();
        }

        if ("cadastro_dividas".equals(e.getActionCommand())) {
            telaPrincipal.abrirJanelaCadastroDivida();
        }

        if ("sobre".equals(e.getActionCommand())) {
            telaPrincipal.abrirJanelaSobre();
        }
    }







}
