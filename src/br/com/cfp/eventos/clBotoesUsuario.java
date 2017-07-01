package br.com.cfp.eventos;

import br.com.cfp.classes.clLogin;
import br.com.cfp.views.CadastroUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author comp8
 */
public class clBotoesUsuario implements ActionListener {

    private clLogin login;
    private CadastroUsuario cadastroUsuario;

    public clBotoesUsuario(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;

    }

    public void actionPerformed(ActionEvent e) {

    }

}
