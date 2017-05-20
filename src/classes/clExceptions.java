package classes;


public class clExceptions extends Exception{
    
     
     public clExceptions()
     {
         super("Ops, algo deu errado no sistema.");
         
         new clLog("Aconteceu algum erro inesperado.");
     }
     
     public clExceptions(String mensagem)
     {
         super(mensagem);
         
         new clLog(mensagem);
     }
    
}
