
package br.com.cfp.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class clArquivo {
    
    public clArquivo(){}
    
    public clArquivo(String usu) throws IOException{
        
        FileWriter fileWriter = null;

        BufferedWriter bufferedWriter = null;

            fileWriter = new FileWriter("Login.cfp", false);
            bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter pw = new PrintWriter(bufferedWriter);
            pw.println(usu);
            bufferedWriter.flush();
            bufferedWriter.close();
            pw.close();
     
    }

     public String getlogin() {
        String nomeArquivo = "Login.cfp";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(nomeArquivo);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());          
            }
            new clLog("Ultimo usuario encontrado.");
            return sb.toString();
        } catch (IOException ex) {
            new clLog("Erro ao abrir o arquivo: " + ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                   new clLog("Erro ao abrir o arquivo: " + ex.getMessage());
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                  new clLog("Erro ao abrir o arquivo: " + ex.getMessage());
                }
            }
        }
        return null;
    }
}
