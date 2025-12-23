package bancoproject.modelos;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(String id) {
        for (Conta c : contas) {
            if (c.getId().equals(id)) {
                System.out.println("Conta encontrada");
                return c;
            }
        }
        return null;
    }
    public Conta validarSenha(String senha, Conta conta){
        if (senha.equals(conta.getSenha())){
            System.out.println("Autenticando...");
            return conta;
        }
        return null;
    }
}