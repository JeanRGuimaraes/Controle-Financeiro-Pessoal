package eventos;

import classes.clLog;
import classes.clPessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.CadastroPessoa;

public class clBotoesPessoa implements ActionListener {

    private CadastroPessoa cadastroPessoa;
    private clPessoa pessoa;

    public clBotoesPessoa(CadastroPessoa cadastroPessoa) {
        this.cadastroPessoa = cadastroPessoa;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("cadastrar".equals(e.getActionCommand())) {
            this.pessoa = cadastroPessoa.getPessoa();
            this.pessoa.salvarPessoa();
        }

        if ("excluir".equals(e.getActionCommand())) {

            if (this.pessoa != null) {
                this.pessoa = this.cadastroPessoa.apagarPessoa(this.pessoa);
            }
        }
        if ("cancelar".equals(e.getActionCommand())) {
            new clLog("Saindo do Cadastro de Pessoa");
            this.cadastroPessoa.dispose();

        }
        if ("limpar".equals(e.getActionCommand())) {
            this.pessoa = this.cadastroPessoa.limparCampos();
            new clLog("Limpado Campos do Cadastro de Pessoas");

        }

    }
}
