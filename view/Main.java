package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Tarefa;
import model.TarefaUrgente;
import service.Gerenciador;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n============= TO-DO LIST =============");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Todas as Tarefas");
            System.out.println("3. Filtrar Tarefas Pendentes");
            System.out.println("4. Marcar Tarefa como Concluída");
            System.out.println("5. Editar Tarefa");
            System.out.println("6. Remover Tarefa");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.println("\nTipo de Tarefa:");
                        System.out.println("1. Tarefa Comum");
                        System.out.println("2. Tarefa Urgente");
                        System.out.print("Escolha o tipo: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        if (tipo != 1 && tipo != 2) {
                            throw new IllegalArgumentException("Tipo de tarefa inválido!");
                        }

                        System.out.print("Título da Tarefa: ");
                        String titulo = scanner.nextLine();
                        if (titulo.trim().isEmpty()) {
                            throw new IllegalArgumentException("O título não pode ficar em branco!");
                        }

                        System.out.print("Descrição: ");
                        String desc = scanner.nextLine();
                        System.out.print("Prioridade (Alta/Média/Baixa): ");
                        String prioridade = scanner.nextLine();
                        System.out.print("Prazo (dd/mm/aaaa): ");
                        String prazo = scanner.nextLine();

                        if (tipo == 2) {
                            System.out.print("Contato para Alerta: ");
                            String contato = scanner.nextLine();
                            TarefaUrgente novaUrgente = new TarefaUrgente(titulo, desc, prioridade, prazo, contato);
                            gerenciador.adicionarTarefa(novaUrgente);
                        } else {
                            Tarefa novaTarefa = new Tarefa(titulo, desc, prioridade, prazo);
                            gerenciador.adicionarTarefa(novaTarefa);
                        }
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
                            System.out.println("Status updated para Concluído!");
                        } else {
                            System.out.println("Posição inválida.");
                        }
                        break;

                    case 5:
                        gerenciador.listarTarefas();
                        System.out.print("Digite o número da tarefa que deseja editar: ");
                        int indexEditar = scanner.nextInt();
                        scanner.nextLine();

                        if (gerenciador.getTarefa(indexEditar) != null) {
                            System.out.print("Novo Título: ");
                            String nTitulo = scanner.nextLine();
                            System.out.print("Nova Descrição: ");
                            String nDesc = scanner.nextLine();
                            System.out.print("Nova Prioridade (Alta/Média/Baixa): ");
                            String nPrioridade = scanner.nextLine();
                            System.out.print("Novo Prazo (dd/mm/aaaa): ");
                            String nPrazo = scanner.nextLine();

                            gerenciador.editarTarefa(indexEditar, nTitulo, nDesc, nPrioridade, nPrazo);
                        } else {
                            System.out.println("Posição inválida.");
                        }
                        break;

                    case 6:
                        gerenciador.listarTarefas();
                        System.out.print("Digite o número da tarefa que deseja remover: ");
                        int indexRemover = scanner.nextInt();
                        gerenciador.removerTarefa(indexRemover);
                        break;

                    case 7:
                        System.out.println("Encerrando o programa... Até mais!");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n❌ Erro: Entrada inválida! Você deve digitar um número.");
                scanner.nextLine(); 
                opcao = 0; 
            } catch (IllegalArgumentException e) {
                System.out.println("\n❌ Erro de Regra de Negócio: " + e.getMessage());
                opcao = 0;
            }
        }
        scanner.close();
    }
}