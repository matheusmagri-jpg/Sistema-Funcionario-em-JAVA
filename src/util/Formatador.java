package util;

import java.util.Locale;

/**
 * Funções de formatação usadas para exibir informações na tela.
 */
public final class Formatador {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    private Formatador() {
        // Classe utilitária: não deve ser instanciada.
    }

    /** Formata um valor em reais. Exemplo: 5500.0 vira "R$ 5.500,00". */
    public static String moeda(double valor) {
        return String.format(PT_BR, "R$ %,.2f", valor);
    }
}
