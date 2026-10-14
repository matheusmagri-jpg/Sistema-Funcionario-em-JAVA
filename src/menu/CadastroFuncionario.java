package menu;

import modelo.Funcionario;
import util.LeitorConsole;

/**
 * Tela de cadastro: pergunta os dados e devolve o Funcionario criado.
 *
 * @author Matheus Magri
 */
public final class CadastroFuncionario {

    private CadastroFuncionario() {
    }

    public static Funcionario lerFuncionario() {
        System.out.println();
        System.out.println("++++++++++++++++++++");
        System.out.println("----- Cadastro -----");
        System.out.println("++++++++++++++++++++");

        String nome = LeitorConsole.lerTexto("Nome do funcionario: ");
        String cpf = LeitorConsole.lerTexto("CPF: ");
        String cargo = LeitorConsole.lerTexto("Cargo: ");
        double salario = LeitorConsole.lerDoubleNaoNegativo("Salario: ");

        return new Funcionario(nome, cpf, cargo, salario);
    }
}
