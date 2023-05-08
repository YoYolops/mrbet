package models;

public class Aposta {
    private String idTime;
    private String nomeCampeonato;
    private int colocacao;
    private int valor;

    public Aposta(String time, String campeonato, int colocacao, int valor) {
        this.idTime = time;
        this.nomeCampeonato = campeonato;
        this.colocacao = colocacao;
        this.valor = valor;
    }
}
