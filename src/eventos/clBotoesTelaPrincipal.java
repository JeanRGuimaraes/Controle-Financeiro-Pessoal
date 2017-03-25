package eventos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import views.CadastroDivida;
import views.CadastroPessoa;
import views.CadastroRenda;
import views.Sobre;

public class clBotoesTelaPrincipal implements ActionListener {

    private JMenuItem JMIcadastroPessoa, JMIcadastroRenda, JMIcadastroDivida, jMISobre;
    private JDesktopPane JAreaDeTrabalho;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == JMIcadastroPessoa) {
            abrirJanelaCadastroPessoa();
        }

        if (e.getSource() == JMIcadastroRenda) {
            abrirJanelaRenda();
        }

        if (e.getSource() == JMIcadastroDivida) {
            abrirJanelaCadastroDivida();
        }

        if (e.getSource() == jMISobre) {
            abrirJanelaSobre();
        }
    }

    public clBotoesTelaPrincipal(JMenuItem JMIcadastroPessoa, JMenuItem JMIcadastroRenda, JMenuItem JMIcadastroDivida, JMenuItem jMISobre) {
        this.JMIcadastroPessoa = JMIcadastroPessoa;
        this.JMIcadastroDivida = JMIcadastroDivida;
        this.JMIcadastroRenda = JMIcadastroRenda;
        this.jMISobre = jMISobre;
    }

    public void setJAreaDeTrabalho(JDesktopPane JAreaDeTrabalho) {
        this.JAreaDeTrabalho = JAreaDeTrabalho;
    }

    private void abrirJanelaCadastroPessoa() {
        CadastroPessoa novo = new CadastroPessoa();
        JAreaDeTrabalho.add(novo);
        centralizaForm(novo);
        novo.setVisible(true);
    }

    private void abrirJanelaCadastroDivida() {
        CadastroDivida novo = new CadastroDivida();
        JAreaDeTrabalho.add(novo);
        centralizaForm(novo);
        novo.setVisible(true);
    }

    private void abrirJanelaRenda() {
        CadastroRenda novo = new CadastroRenda();
        JAreaDeTrabalho.add(novo);
        centralizaForm(novo);
        novo.setVisible(true);
    }

    private void abrirJanelaSobre() {
        Sobre novo = new Sobre();
        JAreaDeTrabalho.add(novo);
        centralizaForm(novo);
        novo.setVisible(true);
    }

    //Função que centraliza internaljframe
    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = JAreaDeTrabalho.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

}
