// Autor: Victor Gabriel Purkott Coelho

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGerenciamentoFuncionarios {
    private ArrayList<Funcionario> funcionarios;
    private Scanner scanner;

    public SistemaGerenciamentoFuncionarios() {
        funcionarios = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void iniciarSistema() {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    buscarFuncionario();
                    break;
                case 5:
                    System.out.println("\nSaindo do sistema...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    public void mostrarMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Remover Funcionário");
        System.out.println("3. Listar Funcionários");
        System.out.println("4. Buscar Funcionário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void adicionarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do funcionário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 
    
        Funcionario funcionario = null;
    
        switch (tipo) {
            case 1:
                // Método para adicionar um novo Gerente
                System.out.print("\nDigite o bônus anual do gerente: ");
                double bonusAnual = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.print("\nDigite a equipe do gerente: ");
                String equipe = scanner.nextLine();
                funcionario = new Gerente(nome, matricula, bonusAnual, equipe);
                break;
            case 2:
                // Método para adicionar um novo Desenvolvedor
                System.out.print("\nDigite as tecnologias que o desenvolvedor domina (separadas por vírgula): ");
                String tecnologiasString = scanner.nextLine();
                String[] tecnologias = tecnologiasString.split(",\\s*");
                funcionario = new Desenvolvedor(nome, matricula, tecnologias);
                break;
            case 3:
                // Método para adicionar um novo Estagiário
                System.out.print("\nDigite as horas de trabalho do estagiário: ");
                int horasTrabalho = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.print("\nDigite o nome do supervisor do estagiário: ");
                String supervisor = scanner.nextLine();
                funcionario = new Estagiario(nome, matricula, horasTrabalho, supervisor);
                break;
            default:
                System.out.println("\nOpção inválida. Funcionário não adicionado.");
                return;
        }
    
        // Método que adiciona a funcionalidade da lista
        funcionarios.add(funcionario);
        System.out.println("\nFuncionário adicionado com sucesso!");
    }

    public void removerFuncionario() {
        System.out.print("\nDigite a matrícula do funcionário a ser removido: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula() == matricula) {
                funcionarios.remove(i);
                System.out.println("\nFuncionário removido com sucesso.");
                return;
            }
        }

        System.out.println("\nFuncionário não encontrado com essa matrícula.");
    }

    public void listarFuncionarios() {
        System.out.println("\n--- Lista de Funcionários ---\n");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.obterDetalhes());
        }
        System.out.println("-----------------------------");
    }

    public void buscarFuncionario() {
        System.out.print("\nDigite o nome ou matrícula do funcionário: ");
        String termoBusca = scanner.nextLine();
        
        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(termoBusca) || String.valueOf(funcionario.getMatricula()).equals(termoBusca)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.obterDetalhes());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\nFuncionário não encontrado.");
        }
    }
}