
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


    
    public boolean verficarUsuario()
    {
        
        System.out.println("Usuario: " + strUsuario);
        System.out.println("Senha: " + strSenha);
        
        if(strUsuario.equals("admin") && strSenha.equals("123"))
        {
            new clLog("Login Valido, Usuario: " + strUsuario + " Encerrando tela de login");
            return true;
        }
        new clLog("Login Inválido");
        return false;
        /*
        quando existir uma validação retorna false mas antes deve retornar uma mensagem que não foi possivel fazer login
         JOptionPane.showMessageDialog(null, "Usuario ou Senha incorretos", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
        
        
        */
       
    }
}
