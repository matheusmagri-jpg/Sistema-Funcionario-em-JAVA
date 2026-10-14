package modelo;

import util.Formatador;

/**
 * Representa um funcionário da empresa.
 * Todo funcionário nasce ativo e deixa de estar ativo quando é demitido.
 */
public class Funcionario {

    private String nome;
    private String cpf;
    private String cargo;
    private double salario;
    private boolean ativo;

    public Funcionario(String nome, String cpf, String cargo, double salario) {
        validarSalario(salario);
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
        this.ativo = true;
    }

    // ---------- Getters e setters ----------

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }

    public void setSalario(double salario) {
        validarSalario(salario);
        this.salario = salario;
    }

    public boolean isAtivo() { return ativo; }

    // ---------- Regras de negócio ----------

    /**
     * Aumenta o salário em um percentual (ex.: 10 = +10%).
     * Só funciona para funcionário ativo e percentual maior que zero.
     *
     * @return true se o reajuste foi aplicado
     */
    public boolean reajustarSalario(double percentual) {
        if (!ativo || percentual <= 0) {
            return false;
        }
        salario += salario * percentual / 100.0;
        return true;
    }

    /**
     * Demite o funcionário (ele passa a ficar inativo).
     *
     * @return true se foi demitido agora; false se já estava demitido
     */
    public boolean demitir() {
        if (!ativo) {
            return false;
        }
        ativo = false;
        return true;
    }

    private static void validarSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salario nao pode ser negativo.");
        }
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome
                + " | CPF: " + cpf
                + " | Cargo: " + cargo
                + " | Salario: " + Formatador.moeda(salario)
                + " | Situacao: " + (ativo ? "Ativo" : "Demitido");
    }
}
