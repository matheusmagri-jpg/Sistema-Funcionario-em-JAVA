package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Um departamento da empresa. Guarda os funcionários (até um limite) e
 * calcula a folha salarial.
 */
public class Departamento {

    public static final int CAPACIDADE_MAXIMA = 5;

    private final String nome;
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeFuncionarios() {
        return funcionarios.size();
    }

    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    public boolean estaLotado() {
        return funcionarios.size() >= CAPACIDADE_MAXIMA;
    }

    /**
     * Adiciona um funcionário ao departamento.
     *
     * @return true se foi adicionado; false se o departamento está lotado
     */
    public boolean adicionarFuncionario(Funcionario funcionario) {
        if (funcionario == null || estaLotado()) {
            return false;
        }
        funcionarios.add(funcionario);
        return true;
    }

    /**
     * Busca um funcionário pela posição mostrada na listagem (começa em 1).
     *
     * @return o funcionário, ou null se a posição não existir
     */
    public Funcionario getFuncionario(int posicao) {
        if (posicao < 1 || posicao > funcionarios.size()) {
            return null;
        }
        return funcionarios.get(posicao - 1);
    }

    /** Soma o salário apenas dos funcionários ativos. */
    public double calcularFolhaSalarial() {
        double total = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.isAtivo()) {
                total += funcionario.getSalario();
            }
        }
        return total;
    }

    /** Mostra na tela os funcionários numerados. */
    public void listarFuncionarios() {
        System.out.println(nome + ":");
        if (funcionarios.isEmpty()) {
            System.out.println("  nenhum funcionario cadastrado");
            return;
        }
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + funcionarios.get(i));
        }
    }
}
