package br.com.cfp.eventos;

import br.com.cfp.views.CadastroDivida;
import br.com.cfp.views.CadastroPessoa;
import br.com.cfp.views.CadastroRenda;
import br.com.cfp.views.CadastroUsuario;
import br.com.cfp.views.Sobre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.cfp.views.TelaPrincipal;

public class clBotoesTelaPrincipal implements ActionListener {

   private TelaPrincipal telaPrincipal;
   private CadastroPessoa pessoa;
   private CadastroRenda renda;
   private Sobre sobre;
   private CadastroDivida divida;
   private CadastroUsuario usuario;
    
    public clBotoesTelaPrincipal(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("cadastro_pessoa".equals(e.getActionCommand())) {
            if (pessoa != null) {
                if (!pessoa.isVisible()) {
                    pessoa = telaPrincipal.abrirJanelaCadastroPessoa();
                }
            }else
            {
                pessoa = telaPrincipal.abrirJanelaCadastroPessoa();
            }

        }

        if ("cadastro_renda".equals(e.getActionCommand())) {
            if(renda != null)
            {
                if(!renda.isVisible())
                {
                     renda = telaPrincipal.abrirJanelaRenda();
                }
                
            }else
            {
                renda = telaPrincipal.abrirJanelaRenda();
            }
        }

        if ("cadastro_dividas".equals(e.getActionCommand())) {
            if(divida != null)
            {
                if(!divida.isVisible())
                {
                    divida = telaPrincipal.abrirJanelaCadastroDivida();
                }
            }else
            {
                divida = telaPrincipal.abrirJanelaCadastroDivida();
            }
        }
             if ("cadastro_usuario".equals(e.getActionCommand())) {
            if(usuario != null)
            {
                if(!usuario.isVisible())
                {
                    usuario = telaPrincipal.abrirJanelaCadastroUsuario();
                }
            }else
            {
                usuario = telaPrincipal.abrirJanelaCadastroUsuario();
            }
            
            
        }
           if ("sair".equals(e.getActionCommand())) {
            System.exit(0);
           }   

        if ("sobre".equals(e.getActionCommand())) {
            if(sobre != null)
            {
                if(!sobre.isVisible())
                {
                    sobre =  telaPrincipal.abrirJanelaSobre();
                }
                
            }else
            {
               sobre =  telaPrincipal.abrirJanelaSobre();
            }
            
        }
    }







}
