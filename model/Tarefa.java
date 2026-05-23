package model;

public class Tarefa {
    private String titulo;
    private String descricao;
    private String prioridade;
    private String dataPrazo;
    private boolean concluida;

    public Tarefa(String titulo, String descricao, String prioridade, String dataPrazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.dataPrazo = dataPrazo;
        this.concluida = false;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }

    public String exibirResumo() {
        String status = concluida ? "[Concluída]" : "[Pendente]";
        return status + " " + titulo + " (Prioridade: " + prioridade + ") - Prazo: " + dataPrazo;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(String dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public boolean isConcluida() {
        return this.concluida;
    }
}