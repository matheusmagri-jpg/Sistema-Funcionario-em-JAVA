package util;

import java.util.Scanner;

/**
 * Centraliza toda a leitura do teclado.
 *
 * Existe um único Scanner para o programa inteiro (evita bugs de entrada ao usar
 * vários Scanners em System.in) e cada método repete a pergunta enquanto o
 * usuário digitar algo inválido, em vez de encerrar o programa com erro.
 */
public final class LeitorConsole {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LeitorConsole() {
        // Classe utilitária: não deve ser instanciada.
    }

    /** Lê um texto não vazio. */
    public static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = SCANNER.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Campo obrigatorio. Tente novamente.");
        }
    }

    /** Lê um número inteiro. */
    public static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero inteiro.");
            }
        }
    }

    /** Lê um número decimal (aceita vírgula ou ponto). */
    public static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(SCANNER.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero (ex.: 2500.50).");
            }
        }
    }

    /** Lê um número decimal maior ou igual a zero. */
    public static double lerDoubleNaoNegativo(String mensagem) {
        while (true) {
            double valor = lerDouble(mensagem);
            if (valor >= 0) {
                return valor;
            }
            System.out.println("O valor nao pode ser negativo.");
        }
    }
}
