// Autor: Victor Gabriel Purkott Coelho

public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private String equipe;

    public Gerente(String nome, int matricula, double bonusAnual, String equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario() {
        return 5000 + bonusAnual;
    }

    @Override
    public String obterDetalhes() {
        return "Gerente: " + nome + ", Matrícula: " + matricula + ", Salário: " + calcularSalario() + ", Equipe: " + equipe;
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente " + nome + " está gerenciando a equipe " + equipe);
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Gerente " + nome + " está relatando o progresso da equipe " + equipe);
    }
}
