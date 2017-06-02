package br.com.cfp.classes;

public class clPessoa {

    private int iCodPessoa = 0, iRg = -1, iTelefone = -1;
    private double iCpf = -1;
    private String strNome = "", strGenero = "", strEmail = "", strProfissao = "";
   
    public int getiCodPessoa() {
        return iCodPessoa;
    }

    public void setiCodPessoa(int iCodPessoa) {
        this.iCodPessoa = iCodPessoa;
    }

    public double getiCpf() {
        return iCpf;
    }

    public void setiCpf(double iCpf) {
        this.iCpf = iCpf;
    }

    public int getiRg() {
        return iRg;
    }

    public void setiRg(int iRg) {
        this.iRg = iRg;
    }

    public int getiTelefone() {
        return iTelefone;
    }

    public void setiTelefone(int iTelefone) {
        this.iTelefone = iTelefone;
    }

    public String getStrNome() {
        return strNome;
    }

    public void setStrNome(String strNome) {
        this.strNome = strNome;
    }

    public String getStrGenero() {
        return strGenero;
    }

    public void setStrGenero(String strGenero) {
        this.strGenero = strGenero;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrProfissao() {
        return strProfissao;
    }

    public void setStrProfissao(String strProfissao) {
        this.strProfissao = strProfissao;
    }

}
