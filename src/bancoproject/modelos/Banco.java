package bancoproject.modelos;

import java.io.*;
import java.util.ArrayList;


public class Banco {
    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(String id) {
        for (Conta c : contas) {
            if (c.getId().equals(id)) {
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

    public void salvarTudo(){
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter("contas.txt"));

            for(Conta c : contas){
                String s = c.formatarParaSalvar();
                escritor.write(s);
                escritor.newLine();
            }

            escritor.close();
            System.out.println("Dados salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar:" + e.getMessage());
        }

    }

    public void carregarDados(){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("contas.txt"));
            String linha;

            while((linha = leitor.readLine()) != null){
                String[] dados = linha.split(";");
                double novoDado = Double.parseDouble(dados[2]);
                String[] partes = dados[3].split("#");
                Conta conta = new Conta(dados[0], dados[1], novoDado, partes[0]);
                adicionarConta(conta);

                for (int i = 1; i < partes.length; i++){
                    String[] dadosTransacao = partes[i].split(",");
                    double novaTransacao = Double.parseDouble(dadosTransacao[1]);
                    Transacao t = new Transacao(dadosTransacao[0], novaTransacao);
                    conta.getExtrato().add(t);
                }

            }
            leitor.close();
            System.out.println("Dados carregados com sucesso!");


        } catch (IOException e){
            System.out.println("Erro ao carregar: " + e.getMessage());
        }

    }
}