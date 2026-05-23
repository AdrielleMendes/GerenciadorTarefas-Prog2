package service;

import java.util.ArrayList;

import model.Tarefa;

public class Gerenciador {
    private ArrayList<Tarefa> listaTarefas;

    public Gerenciador() {
        this.listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa t) {
        listaTarefas.add(t);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("\n--- LISTA DE TAREFAS ---");
        for (int i = 0; i < listaTarefas.size(); i++) {
            System.out.println(i + " - " + listaTarefas.get(i).exibirResumo());
        }
    }

    public void filtrarPendentes() {
        boolean temPendente = false;
        System.out.println("\n--- TAREFAS PENDENTES ---");
        for (int i = 0; i < listaTarefas.size(); i++) {
            if (!listaTarefas.get(i).isConcluida()) {
                System.out.println(i + " - " + listaTarefas.get(i).exibirResumo());
                temPendente = true;
            }
        }
        if (!temPendente) {
            System.out.println("Nenhuma tarefa pendente!");
        }

    }

    public void editarTarefa(int index, String novoTitulo, String novaDesc, String novaPrioridade, String novoPrazo) {
        if (index >= 0 && index < listaTarefas.size()) {
            Tarefa t = listaTarefas.get(index);
            t.setTitulo(novoTitulo);
            t.setDescricao(novaDesc);
            t.setPrioridade(novaPrioridade);
            t.setDataPrazo(novoPrazo);
            System.out.println("Tarefa editada com sucesso!");
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public void removerTarefa(int index) {
        if (index >= 0 && index < listaTarefas.size()) {
            String tituloRemovido = listaTarefas.get(index).getTitulo();
            listaTarefas.remove(index);
            System.out.println("Tarefa '" + tituloRemovido + "' removida com sucesso!");
        } else {
            System.out.println("Posição inválida! Nenhuma tarefa foi removida.");
        }
    }

    public Tarefa getTarefa(int index) {
        if (index >= 0 && index < listaTarefas.size()) {
            return listaTarefas.get(index);
        }
        return null;
    }
}
