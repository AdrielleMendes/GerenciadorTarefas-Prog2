package view;

import java.util.Scanner;

import model.Tarefa;
import service.Gerenciador;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n============= TO-DO LIST =============");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Todas as Tarefas");
            System.out.println("3. Filtrar Tarefas Pendentes");
            System.out.println("4. Marcar Tarefa como Concluída");
            System.out.println("5. Remover Tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título da Tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    System.out.print("Prioridade (Alta/Média/Baixa): ");
                    String prioridade = scanner.nextLine();
                    System.out.print("Prazo (dd/mm/aaaa): ");
                    String prazo = scanner.nextLine();

                    Tarefa novaTarefa = new Tarefa(titulo, desc, prioridade, prazo);
                    gerenciador.adicionarTarefa(novaTarefa);
                    break;

                case 2:
                    gerenciador.listarTarefas();
                    break;

                case 3:
                    gerenciador.filtrarPendentes();
                    break;

                case 4:
                    gerenciador.listarTarefas();
                    System.out.print("Digite o número da tarefa que deseja concluir: ");
                    int indexConcluir = scanner.nextInt();
                    Tarefa tConcluir = gerenciador.getTarefa(indexConcluir);
                    if (tConcluir != null) {
                        tConcluir.marcarComoConcluida();
                        System.out.println("Status atualizado para Concluído!");
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;

                case 5:
                    gerenciador.listarTarefas();
                    System.out.print("Digite o número da tarefa que deseja remover: ");
                    int indexRemover = scanner.nextInt();
                    gerenciador.removerTarefa(indexRemover);
                    break;

                case 6:
                    System.out.println("Encerrando o programa... Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}