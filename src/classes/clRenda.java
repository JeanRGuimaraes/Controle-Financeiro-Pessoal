package classes;

import javax.swing.JOptionPane;

public class clRenda {
    //cod_renda, nome, renda, periodo, observação

    private int iCodigoRenda = 0;
    private float fRenda = -1;
    private String strNome = "", strPeriodo = "", strDescricao = "";

    public void salvarRenda() {
        System.out.println("Codigo: " + iCodigoRenda + 1);
        System.out.println("Renda: " + fRenda);
        System.out.println("Nome: " + strNome);
        System.out.println("Periodo: " + strPeriodo);
        System.out.println("Descrição: " + strDescricao);

    }

    public void apagarDivida() {
        iCodigoRenda = 0;
        fRenda = -1;
        strNome = "";
        strPeriodo = "";
        strDescricao = "";
        JOptionPane.showMessageDialog(null, "Renda Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean verificarDados() {
        String erro = "";

        if (fRenda == -1) {
            erro += "Campo de Renda";
        }

        if (strNome.equals("")) {
            erro += "Campo de Nome";
        }

        if (strPeriodo.equals("")) {
            erro += "Campo de Periodo";
        }

        if (strDescricao.equals("")) {
            erro += "Campo de Descrição";
        }

        if (erro.length() > 1) {
            JOptionPane.showMessageDialog(null, "Os seguintes Campos precisam ser preenchidos" + erro, "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GET'S E SET'S ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public int getiCodigoRenda() {
        return iCodigoRenda;
    }

    public void setiCodigoRenda(int iCodigoRenda) {
        this.iCodigoRenda = iCodigoRenda;
    }

    public float getfRenda() {
        return fRenda;
    }

    public void setfRenda(float fRenda) {
        this.fRenda = fRenda;
    }

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrPeriodo() {
        return strPeriodo;
    }

    public void setStrPeriodo(String strPeriodo) {
        this.strPeriodo = strPeriodo;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

}
