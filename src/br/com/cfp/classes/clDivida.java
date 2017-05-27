package br.com.cfp.classes;

import javax.swing.JOptionPane;

public class clDivida {

    private int iCod_divida = 0;
    private float fValor = -1;
    private String strDescricao = "", strPeriodoInicial = "", strPeriodoFinal = "", strStatus = "";


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
