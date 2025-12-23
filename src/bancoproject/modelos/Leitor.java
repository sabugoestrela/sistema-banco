package bancoproject.modelos;

import java.util.Scanner;

public class Leitor {
    private Scanner scanner = new Scanner(System.in);

    public String lerTexto(String frase) {
        System.out.println(frase);
        return scanner.nextLine();
    }


    public double lerValor(String frase) {
        String texto = "";

        while (true) {
            try {
                System.out.println(frase);
                texto = scanner.nextLine();
                return Double.parseDouble(texto);

            } catch (Exception e) {
                System.out.println("Parâmetro incorreto");
            }

        }
    }
}