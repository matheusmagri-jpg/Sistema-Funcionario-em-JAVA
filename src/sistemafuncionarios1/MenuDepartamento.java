package menu;

/** Menu principal do sistema (somente exibe as opções). */
public final class MenuDepartamento {

    private MenuDepartamento() {
    }

    public static void exibir(String nomeDepartamento) {
        System.out.println();
        System.out.println("++++ SISTEMA DE GESTAO DE DEPARTAMENTO ++++");
        System.out.println(nomeDepartamento);
        System.out.println("[1] Cadastrar funcionario");
        System.out.println("[2] Listar funcionarios");
        System.out.println("[3] Folha salarial");
        System.out.println("[4] Menu individual de funcionario");
        System.out.println("[0] Sair");
    }
}
