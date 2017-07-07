package br.com.cfp.classes;

public class clPessoa {

    private int iCodPessoa = 0, iRg = -1, iCodUsuario = 0;
    private String strNome = "", strGenero = "", strEmail = "", strProfissao = "", strTelefone = "", strCpf = "";
   
    public int getiCodPessoa() {
        return iCodPessoa;
    }

    public void setiCodPessoa(int iCodPessoa) {
        this.iCodPessoa = iCodPessoa;
    }

    public String getStrCpf() {
        return strCpf;
    }

    public void setStrCpf(String strCpf) {
        this.strCpf = strCpf;
    }

    public int getiRg() {
        return iRg;
    }

    public void setiRg(int iRg) {
        this.iRg = iRg;
    }

    public String getStrTelefone() {
        return strTelefone;
    }

    public void setStrTelefone(String strTelefone) {
        this.strTelefone = strTelefone;
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

    public int getiCodUsuario() {
        return iCodUsuario;
    }

    public void setiCodUsuario(int iCodUsuario) {
        this.iCodUsuario = iCodUsuario;
    }
    
    

}
