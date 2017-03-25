
package classes;

public class clLogin {
    
    
    private String strUsuario;
    private String strSenha;

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


    
    public void verficarUsuario()
    {
        System.out.println("Usuario: " + strUsuario);
        System.out.println("Senha: " + strSenha);
    }
}
