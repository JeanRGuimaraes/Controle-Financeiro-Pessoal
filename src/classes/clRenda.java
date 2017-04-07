package classes;

import javax.swing.JOptionPane;

public class clRenda {
    //cod_renda, nome, renda, periodo, observação

    private int iCodigoRenda = 0;
    private float fRenda = -1;
    private String strNome = "", strPeriodoInicial = "", strPeriodoFinal = "", strDescricao = "";

    public void salvarRenda() {
         if (verificarDados()) {
        System.out.println("Codigo: " + iCodigoRenda + 1);
        System.out.println("Renda: " + fRenda);
        System.out.println("Nome: " + strNome);
        System.out.println("Periodo Inicial: " + strPeriodoInicial);
        System.out.println("Periodo Final: " + strPeriodoFinal);
        System.out.println("Observação: " + strDescricao);
          JOptionPane.showMessageDialog(null, "Renda Cadastrada Com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
         }

    }

    public void apagarRenda() {
        iCodigoRenda = 0;
        fRenda = -1;
        strNome = "";
        strPeriodoInicial = "";
        strPeriodoFinal = "";
        strDescricao = "";
        JOptionPane.showMessageDialog(null, "Renda Apagada com Sucesso", "CFP - Informa", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean verificarDados() {
        String erro = "";

        if (fRenda == -1) {
            erro += "Campo de Renda";
        }

        if (strNome.equals("")) {
            erro += "Campo de Nome";
        }

        if (strPeriodoInicial.equals("")) {
            erro += "Campo de Periodo Inicial";
        }
        
        if (strPeriodoFinal.equals("")) {
            erro += "Campo de Periodo Final";
        }

        if (strDescricao.equals("")) {
            erro += "Campo de Observação";
        }

        if (erro.length() > 1) {
           // JOptionPane.showMessageDialog(null, "Os seguintes Campos precisam ser preenchidos" + erro, "CFP - Informa", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

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
