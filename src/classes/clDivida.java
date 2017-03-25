package classes;

import javax.swing.JOptionPane;

public class clDivida {

    private int iCod_divida = 0;
    private float fValor = -1;
    private String strDescricao = "", strPeriodo = "", strStatus = "";

    public void salvarDivida() {
        if (verificaDados()) {
            System.out.println("Código: " + iCod_divida + 1);
            System.out.println("Valor: " + fValor);
            System.out.println("Descrição: " + strDescricao);
            System.out.println("Periodo: " + strPeriodo);
            System.out.println("Status: " + strStatus);
        }
    }

    public void apagarDivida() {
        iCod_divida = 0;
        fValor = -1;
        strDescricao = "";
        strPeriodo = "";
        strStatus = "";
        JOptionPane.showMessageDialog(null, "Divida Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean verificaDados() {
        String erro = "";

        if (fValor == -1) {
            erro += "Campo de Valor";
        }

        if (strDescricao.equals("")) {
            erro += "Campo de Descrição";
        }

        if (strPeriodo.equals("")) {
            erro += "Campo do Periodo";
        }

        if (strStatus.equals("")) {
            erro += "Campo de Status";
        }

        if (erro.length() > 1) {
            JOptionPane.showMessageDialog(null, "Os seguintes Campos precisam ser preenchidos" + erro, "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GET'S E SET'S ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
    public int getiCod_divida() {
        return iCod_divida;
    }

    public void setiCod_divida(int iCod_divida) {
        this.iCod_divida = iCod_divida;
    }

    public float getfValor() {
        return fValor;
    }

    public void setfValor(float fValor) {
        this.fValor = fValor;
    }

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

    public String getStrPeriodo() {
        return strPeriodo;
    }

    public void setStrPeriodo(String strPeriodo) {
        this.strPeriodo = strPeriodo;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }

}
