package bancoproject.modelos;

import java.util.ArrayList;
import java.util.Random;

public class Conta {
    private String nome;
    private double saldo;
    private ArrayList<Transacao> extrato;
    private String senha;
    private String id;
    private static int totalContas = 0;
    private static ArrayList<String> idsUtilizados = new ArrayList<>();

    public Conta(String nome, double saldo, String senha) {
        this.nome = nome;
        this.saldo = saldo;
        this.extrato = new ArrayList<>();
        this.senha = senha;
        Conta.totalContas++;

        Random aleatorio = new Random();
        String idGerado = "";
        boolean idExiste = true;

        do {
            int numero = 1000 + aleatorio.nextInt(9000);
            idGerado = Integer.toString(numero);

            if (idsUtilizados.contains(idGerado)) {
                idExiste = true;
            } else {
                idExiste = false;
            }
        } while (idExiste);

        this.id = idGerado;
        idsUtilizados.add(this.id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transacao> getExtrato() {
        return extrato;
    }

    public boolean sacar(double valorSaque) {
        if (saqueValido(valorSaque)) {
            this.saldo = getSaldo() - valorSaque;
            Transacao t = new Transacao("Saque", valorSaque);
            this.extrato.add(t);
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double valorDeposito) {
        this.saldo = getSaldo() + valorDeposito;
        Transacao t = new Transacao("Depósito", valorDeposito);
        this.extrato.add(t);
    }

    public boolean saqueValido(double valorSaque) {
        if (valorSaque > getSaldo()) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirExtrato() {
        for (Transacao t : this.extrato) {
            System.out.println(t);
        }
    }
}