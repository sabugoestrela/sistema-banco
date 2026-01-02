# 🏦 Sistema Bancário (Java Console)

Este projeto é um sistema de gerenciamento bancário simples desenvolvido em Java, focado na aplicação de conceitos de Orientação a Objetos e persistência de dados via arquivos de texto.

A aplicação roda via console e permite a criação de usuários, movimentações financeiras e histórico de transações, mantendo os dados salvos mesmo após fechar o programa.

## 🚀 Funcionalidades

O sistema oferece as seguintes operações baseadas no menu interativo:

* **Gerenciamento de Contas:**
    * **Criação de Conta:** Gera automaticamente um ID único de 4 dígitos.
    * **Autenticação:** Sistema de login seguro exigindo ID e Senha.
* **Operações Financeiras:**
    * **Depósito:** Adiciona fundos à conta logada.
    * **Saque:** Valida se há saldo suficiente antes de efetuar a retirada.
    * **Extrato:** Exibe o histórico de todas as transações (Depósitos e Saques) realizadas.
* **Persistência de Dados:**
    * Salva automaticamente todas as contas, saldos e históricos no arquivo `contas.txt` ao encerrar o sistema.
    * Carrega os dados automaticamente ao iniciar o programa.
* **Tratamento de Erros:**
    * O sistema previne falhas caso o usuário digite texto onde deveria ser número (ex: valor do saque).

## 🛠️ Estrutura do Projeto

O código está organizado nos seguintes pacotes:

* `bancoproject.principal`: Contém a classe `Principal.java` com o método `main` e o menu de interação.
* `bancoproject.modelos`: Contém as classes de domínio:
    * `Banco`: Gerencia a lista de contas e a leitura/escrita de arquivos.
    * `Conta`: Representa o cliente, saldo e lógica de negócios.
    * `Transacao`: Registra os detalhes de cada operação para o extrato.
    * `Leitor`: Utilitário para facilitar a entrada de dados via `Scanner`.

## 💾 Persistência de Dados

O diferencial deste projeto é o sistema de salvamento manual implementado na classe `Banco`. Os dados são armazenados no seguinte formato textual para facilitar a leitura e debug:

 ⚙️ Como Executar
Pré-requisitos

    Java JDK instalado (versão 8 ou superior).

Passo a passo

    Clone este repositório:
    Bash

git clone [https://github.com/sabugoestrela/sistema-banco.git](https://github.com/sabugoestrela/sistema-banco.git)

Compile os arquivos Java:
Bash

javac -d . *.java

Execute a classe principal:
Bash

    java bancoproject.principal.Principal

Desenvolvido para fins de estudo em Programação Orientada a Objetos e manipulação de arquivos em Java.


---

