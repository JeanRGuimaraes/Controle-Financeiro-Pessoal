
package br.com.cfp.classes;


public class clLogin {
    
    
    private String strUsuario;
    private String strSenha;
    private String strNome;
    private int iCodigo=0;

    public String getStrUsuario() {
        return strUsuario;
    }

    public void setStrUsuario(String strUsuario) {
        this.strUsuario = strUsuario;
    }

    public String getStrSenha() {
        return strSenha;
    }

    public void setStrSenha(String strSenha) {
        this.strSenha = strSenha;
    }
    
    public String getStrNome() {
        return strNome;
    }
    
     public void setStrNome(String strNome) {
        this.strNome = strNome;
    }
     
     public void setiCod_Usuario(int iCodigo) {
        this.iCodigo = iCodigo;
    }
    public int getiCod_Usuario() {
        return iCodigo;
    }  

}
