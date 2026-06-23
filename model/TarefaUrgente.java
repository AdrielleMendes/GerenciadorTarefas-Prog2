package model;

public class TarefaUrgente extends Tarefa {
    private String contatoAlerta;

    public TarefaUrgente(String titulo, String descricao, String prioridade, String dataPrazo, String contatoAlerta) {
        super(titulo, descricao, prioridade, dataPrazo);
        this.contatoAlerta = contatoAlerta;
    }

    @Override
    public String exibirResumo() {
        return "[URGÊNCIA] " + super.exibirResumo() + " - Avisar: " + contatoAlerta;
    }

    public String getContatoAlerta() {
        return contatoAlerta;
    }

    public void setContatoAlerta(String contatoAlerta) {
        this.contatoAlerta = contatoAlerta;
    }
}