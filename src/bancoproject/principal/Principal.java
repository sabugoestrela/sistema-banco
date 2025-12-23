package bancoproject.principal;

import bancoproject.modelos.*;

public class Principal {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Leitor leitor = new Leitor();

        boolean sistemaAtivo = true;
        banco.carregarDados();

        String menuPrincipal = """
                =========================
                BOAS VINDAS AO BANCO!
                =========================
                1. Logar na sua conta
                2. Criar nova conta
                0. Sair
                """;

        while (sistemaAtivo) {
            double opcaoDouble = leitor.lerValor(menuPrincipal);
            int opcao = (int) opcaoDouble;

            if (opcao == 0) {
                System.out.println("Encerrando o sistema...");
                sistemaAtivo = false;
                banco.salvarTudo();
            } else if (opcao == 1) {
                Conta contaLogada = null;

                String loginDigitado = leitor.lerTexto("Digite seu login (ID): ");
                String senhaDigitada = leitor.lerTexto("Digite sua senha: ");

                contaLogada = banco.buscarConta(loginDigitado);
                if (contaLogada != null) {
                    contaLogada = banco.validarSenha(senhaDigitada, contaLogada);
                }

                if (contaLogada != null) {
                    System.out.println("Login realizado com sucesso! Bem-vindo, " + contaLogada.getNome());

                    boolean logado = true;
                    String menuConta = """
                            -----------------------
                            MENU DA CONTA
                            -----------------------
                            1. Consultar saldo
                            2. Sacar dinheiro
                            3. Depositar dinheiro
                            4. Exibir Extrato
                            0. Deslogar (Voltar)
                            """;

                    while (logado) {
                        double opContaDouble = leitor.lerValor(menuConta);
                        int opConta = (int) opContaDouble;

                        if (opConta == 0) {
                            System.out.println("Deslogando...");
                            logado = false;
                        } else if (opConta == 1) {
                            System.out.println("Saldo atual: R$ " + contaLogada.getSaldo());
                        } else if (opConta == 2) {
                            double valorSaque = leitor.lerValor("Quanto deseja sacar?");
                            if (contaLogada.sacar(valorSaque)) {
                                System.out.println("Saque realizado!");
                            } else {
                                System.out.println("Saldo insuficiente.");
                            }
                        } else if (opConta == 3) {
                            double valorDeposito = leitor.lerValor("Quanto deseja depositar?");
                            contaLogada.depositar(valorDeposito);
                            System.out.println("Depósito realizado!");
                        } else if (opConta == 4) {
                            contaLogada.exibirExtrato();
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }

                } else {
                    System.out.println("ERRO: Login ou senha incorretos (ou conta inexistente).");
                }
            } else if (opcao == 2) {

                System.out.println("--- CRIANDO NOVA CONTA ---");
                String nome = leitor.lerTexto("Digite seu nome completo:");
                String senha = leitor.lerTexto("Crie uma senha:");
                double valorConta = leitor.lerValor("Qual o depósito inicial?");

                Conta novaConta = new Conta(nome, valorConta, senha);
                banco.adicionarConta(novaConta);
                System.out.println("Conta criada com sucesso! Agora você pode logar. Seu ID é: " + novaConta.getId());
            } else {
                System.out.println("Opção inválida no menu principal.");
            }
        }
    }
}