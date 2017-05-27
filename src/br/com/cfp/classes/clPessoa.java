package br.com.cfp.classes;

import javax.swing.JOptionPane;

public class clPessoa {

    private int iCodPessoa = 0, iRg = -1, iTelefone = -1;
    private double iCpf = -1;
    private String strNome = "", strGenero = "", strEmail = "", strProfissao = "";

    public void salvarPessoa() {
        if (verificaDados()) {
            System.out.println("Codigo: " + iCodPessoa+1);
            System.out.println("Nome: " + strNome);
            System.out.println("Gênero: " + strGenero);
            System.out.println("Email: " + strEmail);
            System.out.println("Profissão: " + strProfissao);
            System.out.println("Telefone: " + iTelefone);
            System.out.println("CPF: " + iCpf);
            System.out.println("RG: " + iRg);
            
            JOptionPane.showMessageDialog(null, "Pessoa Cadastrada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
            new clLog("Pessoa Cadastrada");
        }
    }

    public void apagarPessoa() {
        this.iCodPessoa = 0;
        this.iCpf = -1;
        this.iRg = -1;
        this.iTelefone = -1;
        this.strNome = "";
        this.strGenero = "";
        this.strEmail = "";
        this.strProfissao = "";
        JOptionPane.showMessageDialog(null, "Pessoa Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
        new clLog("Pessoa Apagada");
    }

    public boolean verificaDados() {
        String erro = "";

        if (iCpf == -1) {
            erro += "\n- Campo de CPF";
        }

        if (iRg == -1) {
            erro += "\n- Campo de RG";
        }

        if (iTelefone == -1) {
            erro += "\n- Campo de Telefone";
        }

        if (strNome.equals("")) {
            erro += "\n- Campo de Nome";
        }

        if (strGenero.equals("")) {
            erro += "\n- Campo de Gênero";
        }

        if (strEmail.equals("")) {
            erro += "\n- Campo de Email";
        }

        if (strProfissao.equals("")) {
            erro += "\n- Campo de Profissão";
        }

        if (erro.length() > 1) {
           // JOptionPane.showMessageDialog(null, "Os seguintes Campos precisam ser preenchidos" + erro, "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;

    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GET'S E SET'S ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
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
