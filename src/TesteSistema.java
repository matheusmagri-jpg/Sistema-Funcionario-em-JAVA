import menu.CadastroFuncionario;
import menu.MenuDepartamento;
import menu.MenuFuncionario;
import modelo.Departamento;
import modelo.Funcionario;
import util.Formatador;
import util.LeitorConsole;

/**
 * Classe principal do sistema.
 *
 * Fluxo do programa:
 *   1. Menu do departamento: cadastrar, listar, ver folha salarial ou abrir o
 *      menu individual de um funcionário.
 *   2. Menu do funcionário: reajustar salário, demitir ou exibir os dados.
 *
 * @author Matheus Magri
 */
public class TesteSistema {

    public static void main(String[] args) {
        Departamento departamento = new Departamento("Departamento de TI");

        executarMenuDepartamento(departamento);

        System.out.println("Sistema encerrado.");
    }

    // ---------- Menu do departamento ----------

    private static void executarMenuDepartamento(Departamento departamento) {
        int opcao;
        do {
            MenuDepartamento.exibir(departamento.getNome());
            opcao = LeitorConsole.lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    cadastrarFuncionario(departamento);
                    break;
                case 2:
                    departamento.listarFuncionarios();
                    break;
                case 3:
                    System.out.println("Folha salarial: "
                            + Formatador.moeda(departamento.calcularFolhaSalarial()));
                    break;
                case 4:
                    executarMenuFuncionario(departamento);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarFuncionario(Departamento departamento) {
        if (departamento.estaLotado()) {
            System.out.println("Departamento lotado (maximo de "
                    + Departamento.CAPACIDADE_MAXIMA + " funcionarios).");
            return;
        }
        Funcionario funcionario = CadastroFuncionario.lerFuncionario();
        departamento.adicionarFuncionario(funcionario);
        System.out.println("-> " + funcionario.getNome() + " cadastrado com sucesso.");
    }

    // ---------- Menu do funcionário ----------

    private static void executarMenuFuncionario(Departamento departamento) {
        if (departamento.getQuantidadeFuncionarios() == 0) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        }

        departamento.listarFuncionarios();
        int posicao = LeitorConsole.lerInt("Numero do funcionario: ");
        Funcionario funcionario = departamento.getFuncionario(posicao);

        if (funcionario == null) {
            System.out.println("Funcionario nao encontrado.");
            return;
        }

        System.out.println("Funcionario selecionado: " + funcionario.getNome());

        int opcao;
        do {
            MenuFuncionario.exibir();
            opcao = LeitorConsole.lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    reajustarSalario(funcionario);
                    break;
                case 2:
                    demitirFuncionario(funcionario);
                    break;
                case 3:
                    System.out.println(funcionario);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    private static void reajustarSalario(Funcionario funcionario) {
        double percentual = LeitorConsole.lerDouble("Digite o percentual de reajuste: ");
        if (funcionario.reajustarSalario(percentual)) {
            System.out.println(funcionario.getNome() + " -> novo salario: "
                    + Formatador.moeda(funcionario.getSalario())
                    + " (reajuste de " + percentual + "%)");
        } else {
            System.out.println("Reajuste nao realizado "
                    + "(funcionario demitido ou percentual invalido).");
        }
    }

    private static void demitirFuncionario(Funcionario funcionario) {
        if (funcionario.demitir()) {
            System.out.println(funcionario.getNome() + " foi demitido.");
        } else {
            System.out.println(funcionario.getNome() + " ja estava demitido.");
        }
    }
}
