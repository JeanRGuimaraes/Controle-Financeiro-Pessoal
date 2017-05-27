package br.com.cfp.classes;

import javax.swing.JOptionPane;

public class clRenda {
    //cod_renda, nome, renda, periodo, observação

    private int iCodigoRenda = 0;
    private float fRenda = -1;
    private String strNome = "", strPeriodoInicial = "", strPeriodoFinal = "", strDescricao = "";

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

    public String getStrDescricao() {
        return strDescricao;
    }

    public void setStrDescricao(String strDescricao) {
        this.strDescricao = strDescricao;
    }

}
