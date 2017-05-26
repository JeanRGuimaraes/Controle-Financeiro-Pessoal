package cfp.classes;

import javax.swing.JOptionPane;

public class clDivida {

    private int iCod_divida = 0;
    private float fValor = -1;
    private String strDescricao = "", strPeriodoInicial = "", strPeriodoFinal = "", strStatus = "";

    public void salvarDivida() {
        if (verificaDados()) {
            System.out.println("Código: " + iCod_divida + 1);
            System.out.println("Valor: " + fValor);
            System.out.println("Descrição: " + strDescricao);
            System.out.println("Periodo1: " + strPeriodoInicial);
            System.out.println("Perido2" + strPeriodoFinal);
            System.out.println("Status: " + strStatus);
            
            JOptionPane.showMessageDialog(null, "Divida Cadastrada Com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
            new clLog("Dívida Cadastrada");
            
        }
    }

    public void apagarDivida() {
        iCod_divida = 0;
        fValor = -1;
        strDescricao = "";
        strPeriodoInicial = "";
        strPeriodoFinal = "";
        strStatus = "";
        JOptionPane.showMessageDialog(null, "Divida Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
        new clLog("Dívida Apagada");
    }

    public boolean verificaDados() {
        String erro = "";

        if (fValor == -1) {
            erro += "Campo de Valor";
        }

        if (strDescricao.equals("")) {
            erro += "Campo de Descrição";
        }

        if (strPeriodoInicial.equals("")) {
            erro += "Campo do Periodo Inicial";
        }
        
        if (strPeriodoFinal.equals("")) {
            erro += "Campo do Periodo Final";
        }

        if (strStatus.equals("")) {
            erro += "Campo de Status";
        }

        if (erro.length() > 1) {
           // JOptionPane.showMessageDialog(null, "Os seguintes Campos precisam ser preenchidos" + erro, "CFP - Informa", JOptionPane.WARNING_MESSAGE);
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

    public String getStrPeriodoInicial() {
        return strPeriodoInicial;
    }

    public void setStrPeriodoInicial(String strPeriodoInicial) {
        this.strPeriodoInicial = strPeriodoInicial;
    }
    
        public String getStrPeriodoFinal() {
        return strPeriodoFinal;
    }

    public void setStrPeriodoFinal(String strPeriodoFinal) {
        this.strPeriodoFinal = strPeriodoFinal;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }

}
