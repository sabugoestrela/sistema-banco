package bancoproject.modelos;

public class Transacao {
    private String tipoOperacao;
    private double valorOperacao;

    public Transacao(String tipoOperacao, double valorOperacao) {
        this.tipoOperacao = tipoOperacao;
        this.valorOperacao = valorOperacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public String formatarParaSalvar() {
        return this.tipoOperacao + "," + this.valorOperacao;
    }

    @Override
    public String toString() {
        return tipoOperacao + " no valor de R$" + valorOperacao;
    }
}

