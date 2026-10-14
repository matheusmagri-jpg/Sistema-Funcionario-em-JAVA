package menu;

/**
 * Menu das ações possíveis sobre um funcionário já selecionado.
 *
 * @author Matheus Magri
 */
public final class MenuFuncionario {

    private MenuFuncionario() {
    }

    public static void exibir() {
        System.out.println();
        System.out.println("+++++++ MENU DO FUNCIONARIO +++++++");
        System.out.println("[1] Reajuste salarial");
        System.out.println("[2] Demitir");
        System.out.println("[3] Exibir dados");
        System.out.println("[0] Voltar ao menu do departamento");
    }
}
